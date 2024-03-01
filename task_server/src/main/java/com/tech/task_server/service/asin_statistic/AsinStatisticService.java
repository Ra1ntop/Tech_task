package com.tech.task_server.service.asin_statistic;

import com.tech.task_server.entity.statistic.AsinStatistic;

import java.util.List;

public interface AsinStatisticService {
    List<AsinStatistic> findAllAsinStatistics();
    List<AsinStatistic> findStatisticsByAsin(String[] asin);
}
