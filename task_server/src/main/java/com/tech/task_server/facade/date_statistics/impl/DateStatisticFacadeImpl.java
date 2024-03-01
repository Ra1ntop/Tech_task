package com.tech.task_server.facade.date_statistics.impl;

import com.tech.task_server.dto.request.date.DateDto;
import com.tech.task_server.entity.statistic.Statistic;
import com.tech.task_server.facade.date_statistics.DateStatisticFacade;
import com.tech.task_server.service.date_statistics.DateStatisticService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DateStatisticFacadeImpl implements DateStatisticFacade {

    private final DateStatisticService dateStatisticService;

    @Override
    public List<Statistic> findAllStatistics() {
        return dateStatisticService.findAllStatistics();
    }

    @Override
    public List<Statistic> findStatisticsByTime(DateDto dateDto) {
        return dateStatisticService.findAllStatisticsByTime(dateDto.getStartFromDate(), dateDto.getToDate());
    }

}
