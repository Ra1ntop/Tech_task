package com.tech.task_server.entity.statistic;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Objects;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)

public class ReportData {

    private List<Statistic> salesAndTrafficByDate;
    private List<AsinStatistic> salesAndTrafficByAsin;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ReportData that = (ReportData) o;
        return Objects.equals(salesAndTrafficByDate, that.salesAndTrafficByDate) && Objects.equals(salesAndTrafficByAsin, that.salesAndTrafficByAsin);
    }

    @Override
    public int hashCode() {
        return Objects.hash(salesAndTrafficByDate, salesAndTrafficByAsin);
    }

}
