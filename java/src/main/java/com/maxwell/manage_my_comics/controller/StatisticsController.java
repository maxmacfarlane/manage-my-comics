package com.maxwell.manage_my_comics.controller;

import com.maxwell.manage_my_comics.dao.StatsDao;
import com.maxwell.manage_my_comics.model.Statistics;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/stats")
@PreAuthorize("isAuthenticated()")
@CrossOrigin
public class StatisticsController {

    StatsDao statsDao;

    public StatisticsController(StatsDao statsDao) {
        this.statsDao = statsDao;
    }

    @PreAuthorize("permitAll")
    @GetMapping("/{collectionId}/character")
    public List<Statistics> getCollectionCharacterStats(@PathVariable int collectionId) {
      List<Statistics> statisticsList = null;

      statisticsList = statsDao.collectionCharacterStats(collectionId);
        if(statisticsList == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Could not find statistics for collection");
        }
        else return statisticsList;
    }

    @PreAuthorize("permitAll")
    @GetMapping("/{collectionId}/author")
    public List<Statistics> getCollectionAuthorStats(@PathVariable int collectionId) {
        List<Statistics> statisticsList = null;

        statisticsList = statsDao.collectionAuthorStats(collectionId);
        if(statisticsList == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Could not find statistics for collection");
        }
        else return statisticsList;
    }

    @PreAuthorize("permitAll")
    @GetMapping("/{collectionId}/series")
    public List<Statistics> getCollectionSeriesStats(@PathVariable int collectionId) {
        List<Statistics> statisticsList = null;

        statisticsList = statsDao.collectionSeriesStats(collectionId);
        if(statisticsList == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Could not find statistics for collection");
        }
        else return statisticsList;
    }
    @PreAuthorize("permitAll")
    @GetMapping("/")
    public Statistics getSiteStats() {
        Statistics statistics = null;

        statistics = statsDao.siteStatistics();
        if(statistics == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Could not find statistics for site");
        }
        else return statistics;
    }
}


