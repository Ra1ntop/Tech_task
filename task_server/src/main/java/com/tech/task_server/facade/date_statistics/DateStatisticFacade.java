package com.tech.task_server.facade.date_statistics;

import com.tech.task_server.dto.request.date.DateDto;
import com.tech.task_server.entity.statistic.Statistic;

import java.util.List;

public interface DateStatisticFacade {
    List<Statistic> findAllStatistics();
    List<Statistic> findStatisticsByTime(DateDto dateDto);


}
