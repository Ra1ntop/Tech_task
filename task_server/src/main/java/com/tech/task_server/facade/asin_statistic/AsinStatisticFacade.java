package com.tech.task_server.facade.asin_statistic;

import com.tech.task_server.dto.request.asin.AsinDto;
import com.tech.task_server.entity.statistic.AsinStatistic;
import com.tech.task_server.facade.BaseFacade;

import java.util.List;

public interface AsinStatisticFacade extends BaseFacade {
    List<AsinStatistic> findAllAsinStatistics();
    List<AsinStatistic> findStatisticsByAsin(AsinDto asinDto);


}
