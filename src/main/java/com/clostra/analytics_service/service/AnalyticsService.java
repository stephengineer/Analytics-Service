package com.clostra.analytics_service.service;

import static com.clostra.analytics_service.utils.AnalyticsUtils.getToday;
import static com.clostra.analytics_service.utils.AnalyticsUtils.getMonth;

import redis.clients.jedis.Jedis;

import org.springframework.stereotype.Service;

@Service
public class AnalyticsService {
    private static final int SIXTY_DAYS_IN_SECONDS = 5184000;
    private Jedis client = new Jedis();

    /**
     * Save cid
     * 
     * @param cid unique client ID
     */
    public void saveClient(String cid) {
        client.pfadd(getToday(), cid);
        client.pfadd(getMonth(), cid);
        client.expire(getToday(), SIXTY_DAYS_IN_SECONDS);
        client.expire(getMonth(), SIXTY_DAYS_IN_SECONDS);
    }

    /**
     * Get the number of unique users seen for the given GMT day
     * 
     * @param isoDate ISO 8601 date, YYYY-MM-DD
     * @return the number of unique users seen for the given GMT day
     */
    public long getUniqueVisitorDaily(String isoDate) {
        return client.pfcount(isoDate);
    }

    /**
     * Get the number of unique users seen in the month prior to and including the given GMT day
     * 
     * @param isoDate ISO 8601 date, YYYY-MM-DD
     * @return the number of unique users seen in the month prior to and including the given GMT day
     */
    public long getUniqueVisitorMonthly(String isoDate) {
        return client.pfcount(isoDate.substring(0, 7));
    }
}
