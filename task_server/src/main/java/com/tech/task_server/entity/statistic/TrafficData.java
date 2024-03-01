package com.tech.task_server.entity.statistic;

import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Setter
@Getter
public class TrafficData {
    private int browserSessionPercentage;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TrafficData that = (TrafficData) o;
        return browserSessionPercentage == that.browserSessionPercentage && browserSessions == that.browserSessions && mobileAppSessions == that.mobileAppSessions && sessions == that.sessions && mobileAppPageViews == that.mobileAppPageViews && pageViews == that.pageViews && browserPageViews == that.browserPageViews && mobileAppPageViewsB2B == that.mobileAppPageViewsB2B && pageViewsB2B == that.pageViewsB2B && browserPageViewsB2B == that.browserPageViewsB2B && sessionsB2B == that.sessionsB2B && mobileAppSessionsB2B == that.mobileAppSessionsB2B && feedbackReceived == that.feedbackReceived && Double.compare(buyBoxPercentage, that.buyBoxPercentage) == 0 && Double.compare(buyBoxPercentageB2B, that.buyBoxPercentageB2B) == 0 && negativeFeedbackReceived == that.negativeFeedbackReceived && Double.compare(receivedNegativeFeedbackRate, that.receivedNegativeFeedbackRate) == 0 && Double.compare(averageOfferCount, that.averageOfferCount) == 0 && orderItemSessionPercentage == that.orderItemSessionPercentage && orderItemSessionPercentageB2B == that.orderItemSessionPercentageB2B && Double.compare(unitSessionPercentage, that.unitSessionPercentage) == 0 && Double.compare(unitSessionPercentageB2B, that.unitSessionPercentageB2B) == 0 && averageParentItems == that.averageParentItems && browserSessionsB2B == that.browserSessionsB2B && browserSessionPercentageB2B == that.browserSessionPercentageB2B && mobileAppSessionPercentage == that.mobileAppSessionPercentage && mobileAppSessionPercentageB2B == that.mobileAppSessionPercentageB2B && sessionPercentage == that.sessionPercentage && sessionPercentageB2B == that.sessionPercentageB2B && browserPageViewsPercentage == that.browserPageViewsPercentage && browserPageViewsPercentageB2B == that.browserPageViewsPercentageB2B && mobileAppPageViewsPercentage == that.mobileAppPageViewsPercentage && mobileAppPageViewsPercentageB2B == that.mobileAppPageViewsPercentageB2B && pageViewsPercentage == that.pageViewsPercentage && pageViewsPercentageB2B == that.pageViewsPercentageB2B;
    }

    @Override
    public int hashCode() {
        return Objects.hash(browserSessionPercentage, browserSessions, mobileAppSessions, sessions, mobileAppPageViews, pageViews, browserPageViews, mobileAppPageViewsB2B, pageViewsB2B, browserPageViewsB2B, sessionsB2B, mobileAppSessionsB2B, feedbackReceived, buyBoxPercentage, buyBoxPercentageB2B, negativeFeedbackReceived, receivedNegativeFeedbackRate, averageOfferCount, orderItemSessionPercentage, orderItemSessionPercentageB2B, unitSessionPercentage, unitSessionPercentageB2B, averageParentItems, browserSessionsB2B, browserSessionPercentageB2B, mobileAppSessionPercentage, mobileAppSessionPercentageB2B, sessionPercentage, sessionPercentageB2B, browserPageViewsPercentage, browserPageViewsPercentageB2B, mobileAppPageViewsPercentage, mobileAppPageViewsPercentageB2B, pageViewsPercentage, pageViewsPercentageB2B);
    }

    private int browserSessions;
    private int mobileAppSessions;
    private int sessions;
    private int mobileAppPageViews;
    private int pageViews;
    private int browserPageViews;
    private int mobileAppPageViewsB2B;
    private int pageViewsB2B;
    private int browserPageViewsB2B;
    private int sessionsB2B;
    private int mobileAppSessionsB2B;
    private int feedbackReceived;
    private double buyBoxPercentage;
    private double buyBoxPercentageB2B;
    private int negativeFeedbackReceived;
    private double receivedNegativeFeedbackRate;
    private double averageOfferCount;
    private int orderItemSessionPercentage;
    private int orderItemSessionPercentageB2B;
    private double unitSessionPercentage;
    private double unitSessionPercentageB2B;
    private int averageParentItems;
    private int browserSessionsB2B;
    private int browserSessionPercentageB2B;
    private int mobileAppSessionPercentage;
    private int mobileAppSessionPercentageB2B;
    private int sessionPercentage;
    private int sessionPercentageB2B;
    private int browserPageViewsPercentage;
    private int browserPageViewsPercentageB2B;
    private int mobileAppPageViewsPercentage;
    private int mobileAppPageViewsPercentageB2B;
    private int pageViewsPercentage;
    private int pageViewsPercentageB2B;

}
