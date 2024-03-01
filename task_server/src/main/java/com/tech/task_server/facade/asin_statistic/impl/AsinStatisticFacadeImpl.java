package com.tech.task_server.facade.asin_statistic.impl;

import com.tech.task_server.dto.request.asin.AsinDto;
import com.tech.task_server.entity.statistic.AsinStatistic;
import com.tech.task_server.facade.asin_statistic.AsinStatisticFacade;
import com.tech.task_server.service.asin_statistic.AsinStatisticService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AsinStatisticFacadeImpl implements AsinStatisticFacade {

    private final AsinStatisticService asinStatisticService;

    @Override
    public List<AsinStatistic> findAllAsinStatistics() {
        return asinStatisticService.findAllAsinStatistics();
    }

    @Override
    public List<AsinStatistic> findStatisticsByAsin(AsinDto asinDto) {
        return asinStatisticService.findStatisticsByAsin(asinDto.getAsin());
    }

}
