package com.exist.rbank.service;

import com.exist.rbank.dto.TaskDto;

import java.util.List;

public interface CalendarScheduleService {

    List<TaskDto> getCalendarSchedule(List<TaskDto> taskDtos);
}
