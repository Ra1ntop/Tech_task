package com.tech.task_server.repository.statistics;

import com.tech.task_server.entity.statistic.Statistic;
import com.tech.task_server.repository.BaseRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StatisticRepository extends BaseRepository<Statistic> {
    List<Statistic> findAllByDateInSecondsBetween(Long startTimestamp, Long endTimestamp);
}
