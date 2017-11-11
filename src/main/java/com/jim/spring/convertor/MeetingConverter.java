package com.jim.spring.convertor;

import com.jim.spring.domain.Meeting;
import com.jim.spring.command.MeetingCommand;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * Created by jim on 10-11-17.
 */
@Component
public class MeetingConverter implements Converter<MeetingCommand, Meeting> {
    @Override
    public Meeting convert(MeetingCommand meetingCommand) {
        return new Meeting(meetingCommand.getGewicht(), meetingCommand.getOmvang(), LocalDateTime.now());
    }
}
