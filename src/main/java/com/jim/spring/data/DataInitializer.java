package com.jim.spring.data;

import com.jim.spring.domain.Deelnemer;
import com.jim.spring.domain.Meeting;
import com.jim.spring.repository.DeelnemerRepository;
import com.jim.spring.repository.MeetingReposity;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jim on 10-11-17.
 */
@Component
public class DataInitializer implements ApplicationListener<ContextRefreshedEvent> {

    private MeetingReposity meetingReposity;
    private DeelnemerRepository deelnemerRepository;

    public DataInitializer(MeetingReposity meetingReposity, DeelnemerRepository deelnemerRepository) {
        this.meetingReposity = meetingReposity;
        this.deelnemerRepository = deelnemerRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        Deelnemer deelnemer1 = new Deelnemer("Jim");
        Meeting meeting = new Meeting(64.2D, 77.5D);
        deelnemer1.addMeeting(meeting);
        Meeting tweedeMeeting = new Meeting(1D, 2D);
        deelnemer1.addMeeting(tweedeMeeting);

        Deelnemer deelnemer2 = new Deelnemer("Mireille");
        Meeting meeting2 = new Meeting(63.5D, 78D);
        meeting2.setDeelnemer(deelnemer2);
        deelnemer2.addMeeting(meeting2);
        deelnemer1 = deelnemerRepository.save(deelnemer1);
        deelnemer2 = deelnemerRepository.save(deelnemer2);
    }
}
