package com.gihan.scheduleservice.controller;

import com.gihan.scheduleservice.model.Schedule;
import com.gihan.scheduleservice.service.ScheduleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

@Controller
public class ScheduleController {

    @Autowired
    ScheduleService scheduleService;

    private static final Logger LOGGER = LoggerFactory.getLogger(ScheduleController.class);

    @KafkaListener(topics = "scheduletopic",groupId = "fuelOrderGroup")
    public void listener(String message){
        LOGGER.info(String.format("New Schedule Request Message Received -> %s", message));

        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, +5);
        Date date = calendar.getTime();

        Schedule schedule = scheduleService.makeSchedule(message,dateFormat.format(date));
        if(schedule == null){
            System.out.println("Order did not Scheduled");
        }else {
            System.out.println("Order scheduled to "+dateFormat.format(date));
        }
    }
}
