package com.jim.spring.controller;

import com.jim.spring.convertor.MeetingKeyComparator;
import com.jim.spring.domain.DatumGroepering;
import com.jim.spring.domain.Deelnemer;
import com.jim.spring.domain.Meeting;
import com.jim.spring.service.DeelnemerService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.temporal.WeekFields;
import java.util.*;

/**
 * Created by jim on 17-11-17.
 */
@Controller
public class ChartController {

    private DeelnemerService deelnemerService;

    public ChartController(DeelnemerService deelnemerService) {
        this.deelnemerService = deelnemerService;
    }

    @ResponseBody
    @GetMapping(value = "/chart", produces = "application/json")
    public Object[][] getAllData() {

        List<Deelnemer> deelnemerList = deelnemerService.getAllDeelnemers();
        Iterator<Deelnemer> it = deelnemerList.iterator();
        deelnemerList = new ArrayList<>();
        int mostAmountOfMeetingen = 0;
        while (it.hasNext()) {
            Deelnemer deelnemer = it.next();
            if (deelnemer.getMetingen().size() == 0) {
                it.remove();
            } else {
                deelnemerList.add(deelnemer);
                if (deelnemer.getMetingen().size() > mostAmountOfMeetingen) {
                    mostAmountOfMeetingen = deelnemer.getMetingen().size();
                }
            }
        }




        Object[][] array = vulMeetingen(deelnemerList, DatumGroepering.DAY);
        return array;
    }

    @ResponseBody
    @GetMapping(value = "/chart/{name}/{groupBy}", produces = "application/json")
    public Object[][] getDeelnemerData(@PathVariable("name") String name, @PathVariable("groupBy") String groupBy) {
        Deelnemer deelnemer = deelnemerService.findDeelnemerByName(name);
        Object[][] array = vulMeetingen(new ArrayList() {{add(deelnemer);}}, getGroupering(groupBy));
        return array;
    }

    private DatumGroepering getGroupering(String groupBy) {
        return DatumGroepering.valueOf(groupBy.toUpperCase());
    }

    private Object[][] vulMeetingen(List<Deelnemer> deelnemerList, DatumGroepering groepering) {
        Map<String, Double[]> metingen = new HashMap<>();

        for (int i = 0; i < deelnemerList.size(); i++) {
            Deelnemer deelnemer = deelnemerList.get(i);
            List<Meeting> deelnemerMeetingen = deelnemer.getMetingen();

            Map<String, List<Double>> metingenPerDatumGroupering = new HashMap<>();

            for (Meeting meeting : deelnemerMeetingen) {
                String meetDatum = bepaalMeetDatum(meeting, groepering);

                if (metingenPerDatumGroupering.containsKey(meetDatum)) {
                    metingenPerDatumGroupering.get(meetDatum).add(meeting.getGewicht());
                } else {
                    metingenPerDatumGroupering.put(meetDatum, new ArrayList<Double>() {{
                        add(meeting.getGewicht());
                    }});
                }
            }

            for (Map.Entry entry : metingenPerDatumGroupering.entrySet()) {
                if (metingen.containsKey(entry.getKey())) {
                    Double[] metingenOpDatum = metingen.get(entry.getKey());
                    metingenOpDatum[i] = getGewichtOpDatumEenheid((List<Double>) entry.getValue());
                } else {
                    Double[] metingenOpDatum = new Double[deelnemerList.size()];
                    metingenOpDatum[i] = getGewichtOpDatumEenheid((List<Double>) entry.getValue());
                    metingen.put((String) entry.getKey(), metingenOpDatum);
                }
            }
        }


        SortedSet<String> keys = new TreeSet(new MeetingKeyComparator());
        keys.addAll(metingen.keySet());
        Object[][] array = new Object[keys.size()+1][deelnemerList.size() + 1];
        array[0][0] = groepering.name();
        for (int i = 0; i < deelnemerList.size(); i++) {
            Deelnemer deelnemer = deelnemerList.get(i);
            array[0][i + 1] = deelnemer.getName();
        }
        int counter = 1;
        for (String key : keys) {
            Double[] mtng = metingen.get(key);
            array[counter][0] = key;
            for (int i = 0; i < mtng.length; i++) {
                array[counter][i + 1] = mtng[i];
            }
            counter++;
        }
        return array;
    }

    private Double getGewichtOpDatumEenheid(List<Double> value) {
        Double[] total = {0D};
        value.forEach(meting -> total[0] += meting);
        return total[0] / value.size();
    }

    private String bepaalMeetDatum(Meeting meeting, DatumGroepering groepering) {
        switch (groepering) {
            case DAY:
                return meeting.getTime().getDayOfMonth() + "-" + meeting.getTime().getMonthValue() + "-" + meeting.getTime().getYear();
            case WEEK:
                return String.valueOf(meeting.getTime().get((WeekFields.of(Locale.UK).weekOfWeekBasedYear())));
            case MONTH:
                return String.valueOf(meeting.getTime().getMonthValue());
            case YEAR:
                return String.valueOf(meeting.getTime().getYear());
            default:
                return null;
        }
    }

}
