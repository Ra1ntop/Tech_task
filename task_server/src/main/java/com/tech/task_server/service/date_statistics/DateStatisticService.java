package com.tech.task_server.service.date_statistics;

import com.tech.task_server.entity.statistic.Statistic;
import com.tech.task_server.service.BaseService;

import java.util.List;

public interface DateStatisticService extends BaseService {
    List<Statistic> findAllStatistics();
    List<Statistic> findAllStatisticsByTime(Long startFromDate, Long toDate);



}
