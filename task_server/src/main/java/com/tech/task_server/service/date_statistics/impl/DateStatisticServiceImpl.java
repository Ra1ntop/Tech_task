package com.tech.task_server.service.date_statistics.impl;

import com.tech.task_server.entity.statistic.Statistic;
import com.tech.task_server.repository.statistics.StatisticRepository;
import com.tech.task_server.service.date_statistics.DateStatisticService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class DateStatisticServiceImpl implements DateStatisticService {
    private final StatisticRepository statisticRepository;

    @Override
    public List<Statistic> findAllStatistics() {
        return statisticRepository.findAll();
    }

    @Override
    public List<Statistic> findAllStatisticsByTime(Long startFromDate, Long toDate){
        return statisticRepository.findAllByDateInSecondsBetween(startFromDate-10L, toDate+10L);
    }

}
