package com.gihan.scheduleservice.service;

import com.gihan.scheduleservice.model.Schedule;
import com.gihan.scheduleservice.repository.ScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class ScheduleService {

    @Autowired
    ScheduleRepository scheduleRepository;

    public Schedule makeSchedule(String message, String date){
        Schedule schedule = new Schedule();
        schedule.setMessage(message);
        schedule.setScheduledDate(date);
        return scheduleRepository.save(schedule);
    }

}
