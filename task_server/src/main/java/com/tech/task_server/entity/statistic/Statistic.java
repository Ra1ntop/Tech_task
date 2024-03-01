package com.tech.task_server.entity.statistic;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;

import java.util.Objects;


@Getter
@Setter
@ToString
public class Statistic {
    @Id
    private String date;
    private Long dateInSeconds;
    @JsonProperty("salesByDate")
    private SalesData salesByDate;
    @JsonProperty("trafficByDate")
    private TrafficData trafficByDate;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Statistic statistic = (Statistic) o;
        return Objects.equals(date, statistic.date) && Objects.equals(salesByDate, statistic.salesByDate) && Objects.equals(trafficByDate, statistic.trafficByDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(date, salesByDate, trafficByDate);
    }

}
