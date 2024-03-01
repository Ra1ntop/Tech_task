package com.tech.task_server.entity.statistic;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

import java.util.Objects;

@Getter
@Setter
public class AsinStatistic {

    @Id
    private String parentAsin;

    private SalesData salesByAsin;
    private TrafficData trafficByAsin;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AsinStatistic that = (AsinStatistic) o;
        return Objects.equals(parentAsin, that.parentAsin) && Objects.equals(salesByAsin, that.salesByAsin) && Objects.equals(trafficByAsin, that.trafficByAsin);
    }

    @Override
    public int hashCode() {
        return Objects.hash(parentAsin, salesByAsin, trafficByAsin);
    }

}
