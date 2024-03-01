package com.tech.task_server.controller;

import com.tech.task_server.facade.update_statistic.UpdateStatisticFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UpdateDataController {

    private final UpdateStatisticFacade updateStatisticFacade;

    @Scheduled(fixedRate = 50000)
    public void update() {
        updateStatisticFacade.updateDateInDb();
    }
}
