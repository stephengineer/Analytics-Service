package com.clostra.analytics_service.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.clostra.analytics_service.service.AnalyticsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

@RestController
public class AnalyticsController {

    @Autowired
    private AnalyticsService analyticsService;

    @GetMapping("/")
    public String index() {
        return "Analytics Service is running.";
    }

    /**
     * Get status of analytics report
     * 
     * @param cid unique client ID
     * @param d UNIX timestamp (optional)
     * @return httpstatus '200' OK with an empty body
     */
    @GetMapping("collect")
    public ResponseEntity getReports(@RequestParam String cid, @RequestParam(required = false) String d) {
        this.analyticsService.saveClient(cid);
        return new ResponseEntity(HttpStatus.OK);
    }

    /**
     * Get the number of unique users seen for the given GMT day
     * 
     * @param d ISO 8601 date, YYYY-MM-DD
     * @return the number of unique users seen for the given GMT day
     */
    @GetMapping("daily_uniques")
    public long getUniqueVisitorDaily(@RequestParam String d) {
        return this.analyticsService.getUniqueVisitorDaily(d);
    }

    /**
     * Get the number of unique users seen in the month prior to and including the given GMT day
     * 
     * @param d ISO 8601 date, YYYY-MM-DD
     * @return the number of unique users seen in the month prior to and including the given GMT day
     */
    @GetMapping("monthly_uniques")
    public long getUniqueVisitorMonthly(@RequestParam String d) {
        return this.analyticsService.getUniqueVisitorMonthly(d);
    }
}
