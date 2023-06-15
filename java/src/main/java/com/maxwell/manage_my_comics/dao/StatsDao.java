package com.maxwell.manage_my_comics.dao;

import com.maxwell.manage_my_comics.model.Statistics;

import java.util.List;

public interface StatsDao {

    List<Statistics> collectionCharacterStats(int collectionId);
    List<Statistics> collectionAuthorStats(int collectionId);
    List<Statistics> collectionSeriesStats(int collectionId);

    Statistics siteStatistics();
}
