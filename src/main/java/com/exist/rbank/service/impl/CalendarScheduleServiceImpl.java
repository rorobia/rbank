package com.exist.rbank.service.impl;

import com.exist.rbank.dto.SubTaskDto;
import com.exist.rbank.dto.TaskDto;
import com.exist.rbank.service.CalendarScheduleService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class CalendarScheduleServiceImpl implements CalendarScheduleService {

    @Override
    public List<TaskDto> getCalendarSchedule(List<TaskDto> taskDtos) {
        List<TaskDto> taskDtoList = new ArrayList<>();

        for (TaskDto taskDto : taskDtos) {
            TaskDto task = new TaskDto();
            List<SubTaskDto> subTaskDtos = new ArrayList<>();

            LocalDate startDate = LocalDate.now();

            if (taskDto.getSubTasks() != null) {
                for (SubTaskDto subTaskDto: taskDto.getSubTasks()) {
                    SubTaskDto subTask = new SubTaskDto();

                    subTask.setDuration(subTaskDto.getDuration());
                    subTask.setStartDate(startDate);
                    subTask.setEndDate(startDate.plusDays(subTaskDto.getDuration()));

                    startDate = subTask.getEndDate().plusDays(1L);

                    subTaskDtos.add(subTask);
                }

            }

            task.setDuration(taskDto.getDuration());
            task.setStartDate(startDate);
            task.setEndDate(startDate.plusDays(taskDto.getDuration()));
            task.setSubTasks(subTaskDtos);

            taskDtoList.add(task);
        }

        return taskDtoList;
    }
}
