package com.tech.task_server.controller;

import com.tech.task_server.dto.request.asin.AsinDto;
import com.tech.task_server.dto.request.date.DateDto;
import com.tech.task_server.entity.statistic.AsinStatistic;
import com.tech.task_server.entity.statistic.Statistic;
import com.tech.task_server.facade.asin_statistic.AsinStatisticFacade;
import com.tech.task_server.facade.date_statistics.DateStatisticFacade;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping("/api/customer")
public class MainController {

    private final UpdateDataController update;
    private final AsinStatisticFacade asinStatisticFacade;
    private final DateStatisticFacade dateStatisticFacade;

    @GetMapping("/find-all-date-statistics")
    public ResponseEntity<List<Statistic>> findAllStatisticsByDates() {
        List<Statistic> statistics = dateStatisticFacade.findAllStatistics();
        return ResponseEntity.ok(statistics);
    }

    @GetMapping("/find-all-asin-statistics")
    public ResponseEntity<List<AsinStatistic>> findAllStatisticsByASIN() {
        List<AsinStatistic> asinStatistics = asinStatisticFacade.findAllAsinStatistics();
        return ResponseEntity.ok(asinStatistics);
    }


    @GetMapping("/find-statistics-by-date")
    public ResponseEntity<List<Statistic>> findStatisticsByDate(@RequestBody DateDto dateDto) {
        List<Statistic> statistics = dateStatisticFacade.findStatisticsByTime(dateDto);
        return ResponseEntity.ok(statistics);
    }

    @GetMapping("/find-statistics-by-asin")
    public ResponseEntity<List<AsinStatistic>> findStatisticsByAsin(@RequestBody AsinDto asinDto) {
        List<AsinStatistic> asinStatistics = asinStatisticFacade.findStatisticsByAsin(asinDto);
        return ResponseEntity.ok(asinStatistics);
    }
    @PostConstruct
    public void updateStatisticOnStartup() {
        update.update();
    }
}
