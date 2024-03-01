package com.tech.task_server.repository.statistics;

import com.tech.task_server.entity.statistic.AsinStatistic;
import com.tech.task_server.repository.BaseRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AsinStatisticRepository extends BaseRepository<AsinStatistic> {
    List<AsinStatistic> findByParentAsinIn(String[] asin);
}
