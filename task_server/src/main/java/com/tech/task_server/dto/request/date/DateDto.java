package com.tech.task_server.dto.request.date;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;
import java.time.ZoneOffset;

@Getter
@Setter
@ToString
public class DateDto {
    private Long startFromDate;
    private Long toDate;

    public DateDto(String startFromDate, String toDate) {
        LocalDate startDate = LocalDate.parse(startFromDate);
        this.startFromDate = (startDate.atStartOfDay().toEpochSecond(ZoneOffset.UTC) * 1000);
        LocalDate endDate = LocalDate.parse(toDate);
        this.toDate = (endDate.atStartOfDay().toEpochSecond(ZoneOffset.UTC) * 1000);
    }
}
