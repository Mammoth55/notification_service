package com.notification.service.root.controller;

import com.notification.service.root.entity.Statistic;
import com.notification.service.root.service.StatisticService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1")
public class StatisticController {
    private final StatisticService statisticService;

    @Autowired
    public StatisticController(StatisticService statisticService) {
        this.statisticService = statisticService;
    }

    @GetMapping("/statistics/{mailingId}")
    public ResponseEntity<Statistic> getStatisticByMailingId(@PathVariable Long mailingId) {
        Statistic statistic = statisticService.getStatisticByMailingId(mailingId);
        return new ResponseEntity<>(statistic, HttpStatus.OK);
    }

    @GetMapping("/statistics")
    public ResponseEntity<List<Statistic>> getStatisticForAllMailings() {
        List<Statistic> statistics = statisticService.getStatisticForAllMailings();
        return new ResponseEntity<>(statistics, HttpStatus.OK);
    }
}
