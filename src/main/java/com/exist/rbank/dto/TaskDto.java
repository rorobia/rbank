package com.exist.rbank.dto;

import java.time.LocalDate;
import java.util.List;

public class TaskDto {

    private Long duration;

    private LocalDate startDate;

    private LocalDate endDate;

    private List<SubTaskDto> subTasks;

    public Long getDuration() {
        return duration;
    }

    public void setDuration(Long duration) {
        this.duration = duration;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public List<SubTaskDto> getSubTasks() {
        return subTasks;
    }

    public void setSubTasks(List<SubTaskDto> subTasks) {
        this.subTasks = subTasks;
    }
}
