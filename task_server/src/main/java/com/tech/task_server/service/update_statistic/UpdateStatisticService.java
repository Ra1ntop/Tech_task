package com.tech.task_server.service.update_statistic;

import com.tech.task_server.entity.statistic.ReportData;
import com.tech.task_server.facade.BaseFacade;

public interface UpdateStatisticService extends BaseFacade {
    void updateDateInDb(ReportData reportData);


}
