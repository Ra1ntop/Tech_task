package com.tech.task_server.service.asin_statistic.impl;

import com.tech.task_server.entity.statistic.AsinStatistic;
import com.tech.task_server.repository.statistics.AsinStatisticRepository;
import com.tech.task_server.service.asin_statistic.AsinStatisticService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class AsinStatisticServiceImpl implements AsinStatisticService {

    private final AsinStatisticRepository asinStatisticRepository;


    @Override
    public List<AsinStatistic> findAllAsinStatistics() {
        return asinStatisticRepository.findAll();
    }


    @Override
    public  List<AsinStatistic> findStatisticsByAsin(String[] asin) {
        return asinStatisticRepository.findByParentAsinIn(asin);
    }


}
