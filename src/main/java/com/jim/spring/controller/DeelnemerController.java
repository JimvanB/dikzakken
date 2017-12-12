package com.jim.spring.controller;

import com.jim.spring.command.MeetingCommand;
import com.jim.spring.convertor.MeetingConverter;
import com.jim.spring.domain.Deelnemer;
import com.jim.spring.domain.Meeting;
import com.jim.spring.service.DeelnemerService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.time.LocalDate;

/**
 * Created by jim on 10-11-17.
 */
@Controller
public class DeelnemerController {

    private DeelnemerService deelnemerService;
    private MeetingConverter meetingConverter;
    private ChartController chartController;

    public DeelnemerController(DeelnemerService deelnemerService, MeetingConverter meetingConverter, ChartController chartController) {
        this.deelnemerService = deelnemerService;
        this.meetingConverter = meetingConverter;
        this.chartController = chartController;
    }

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("deelnemers", deelnemerService.getAllDeelnemers());
        model.addAttribute("newmeeting", new MeetingCommand(LocalDate.now()));
        model.addAttribute("chartData", chartController.getAllData());
        return "index";
    }

    @GetMapping("/errorss")
    public String error(Model model) {

        return "index";
    }

    @Transactional
    @PostMapping("/new/")
    public String newMeeting(@Valid @ModelAttribute MeetingCommand newmeeting, BindingResult bindingResult) {
        if (!bindingResult.hasErrors()) {
            Meeting meeting = meetingConverter.convert(newmeeting);
            Deelnemer deelnemer = deelnemerService.findDeelnemerByName(newmeeting.getName());
            deelnemer.addMeeting(meeting);
            return "redirect:/";
        }
        return "/errorss";
    }

    @Transactional
    @GetMapping("/page/")
    public String deelnemerPagination(Model model, Pageable pageable) {
        Page page = deelnemerService.findDeelnemersByPage(pageable);
        return "redirect:/";
    }
}
