package com.tech.task_server.facade.update_statistic.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tech.task_server.entity.statistic.ReportData;
import com.tech.task_server.facade.update_statistic.UpdateStatisticFacade;
import com.tech.task_server.service.update_statistic.UpdateStatisticService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

@Service
@RequiredArgsConstructor
public class UpdateStatisticFacadeImpl implements UpdateStatisticFacade {
    private final UpdateStatisticService updateStatisticService;

    @Value("${absolute.path.to.json.file}")
    private String PATH_TO_JSON_FILE;
    @Override
    public void updateDateInDb() {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            File file = new File(PATH_TO_JSON_FILE);
            String jsonContent = FileCopyUtils.copyToString(new InputStreamReader(new FileInputStream(file), StandardCharsets.UTF_8));
            ReportData reportData = objectMapper.readValue(jsonContent, ReportData.class);
            updateStatisticService.updateDateInDb(reportData);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
