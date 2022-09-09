package com.gihan.scheduleservice.repository;

import com.gihan.scheduleservice.model.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScheduleRepository extends JpaRepository<Schedule,Integer> {
}
