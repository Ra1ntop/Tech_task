package com.tech.task_server.service.update_statistic.impl;

import com.tech.task_server.entity.statistic.AsinStatistic;
import com.tech.task_server.entity.statistic.ReportData;
import com.tech.task_server.entity.statistic.Statistic;
import com.tech.task_server.repository.statistics.AsinStatisticRepository;
import com.tech.task_server.repository.statistics.StatisticRepository;
import com.tech.task_server.service.update_statistic.UpdateStatisticService;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class UpdateStatisticServiceImpl implements UpdateStatisticService {

    private final AsinStatisticRepository asinStatisticRepository;
    private final StatisticRepository statisticRepository;
    private final CacheManager cacheManager;

    @Override
    @Cacheable(value = "data")
    public void updateDateInDb(ReportData reportData) {
        List<Statistic> statistics = new ArrayList<>(reportData.getSalesAndTrafficByDate());
        statistics.forEach(statistic -> {
            LocalDate date = LocalDate.parse(statistic.getDate());
            statistic.setDateInSeconds(date.atStartOfDay().toEpochSecond(ZoneOffset.UTC) * 1000);
        });
        List<AsinStatistic> asinStatistics = new ArrayList<>(reportData.getSalesAndTrafficByAsin());
        statisticRepository.saveAll(statistics);
        asinStatisticRepository.saveAll(asinStatistics);
        try {
            cacheManager.getCache("data").clear();
        } catch (NullPointerException e) {
            throw new RuntimeException(e);
        }
    }
}
