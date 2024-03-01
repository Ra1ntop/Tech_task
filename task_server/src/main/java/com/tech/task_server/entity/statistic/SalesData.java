package com.tech.task_server.entity.statistic;


import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Setter
@Getter
public class SalesData {
    private Amount orderedProductSales;
    private Amount orderedProductSalesB2B;
    private int unitsOrdered;
    private int unitsOrderedB2B;
    private int totalOrderItems;
    private int totalOrderItemsB2B;
    private Amount averageSalesPerOrderItem;
    private Amount averageSalesPerOrderItemB2B;
    private double averageUnitsPerOrderItem;
    private double averageUnitsPerOrderItemB2B;
    private Amount averageSellingPrice;
    private Amount averageSellingPriceB2B;
    private int unitsRefunded;
    private double refundRate;
    private int claimsGranted;
    private Amount claimsAmount;
    private Amount shippedProductSales;
    private int unitsShipped;
    private int ordersShipped;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SalesData salesData = (SalesData) o;
        return unitsOrdered == salesData.unitsOrdered && unitsOrderedB2B == salesData.unitsOrderedB2B && totalOrderItems == salesData.totalOrderItems && totalOrderItemsB2B == salesData.totalOrderItemsB2B && Double.compare(averageUnitsPerOrderItem, salesData.averageUnitsPerOrderItem) == 0 && Double.compare(averageUnitsPerOrderItemB2B, salesData.averageUnitsPerOrderItemB2B) == 0 && unitsRefunded == salesData.unitsRefunded && Double.compare(refundRate, salesData.refundRate) == 0 && claimsGranted == salesData.claimsGranted && unitsShipped == salesData.unitsShipped && ordersShipped == salesData.ordersShipped && Objects.equals(orderedProductSales, salesData.orderedProductSales) && Objects.equals(orderedProductSalesB2B, salesData.orderedProductSalesB2B) && Objects.equals(averageSalesPerOrderItem, salesData.averageSalesPerOrderItem) && Objects.equals(averageSalesPerOrderItemB2B, salesData.averageSalesPerOrderItemB2B) && Objects.equals(averageSellingPrice, salesData.averageSellingPrice) && Objects.equals(averageSellingPriceB2B, salesData.averageSellingPriceB2B) && Objects.equals(claimsAmount, salesData.claimsAmount) && Objects.equals(shippedProductSales, salesData.shippedProductSales);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderedProductSales, orderedProductSalesB2B, unitsOrdered, unitsOrderedB2B, totalOrderItems, totalOrderItemsB2B, averageSalesPerOrderItem, averageSalesPerOrderItemB2B, averageUnitsPerOrderItem, averageUnitsPerOrderItemB2B, averageSellingPrice, averageSellingPriceB2B, unitsRefunded, refundRate, claimsGranted, claimsAmount, shippedProductSales, unitsShipped, ordersShipped);
    }
}
