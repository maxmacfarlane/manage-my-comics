package com.maxwell.manage_my_comics.dao;

import com.maxwell.manage_my_comics.model.Statistics;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcStatsDao implements StatsDao{

    private JdbcTemplate jdbcTemplate;

    public JdbcStatsDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Statistics> collectionCharacterStats(int collectionId) {
        List<Statistics> statisticsList = new ArrayList<>();
        String sql = "select count(character_data.name) as num_comics_character, character_data.name\n" +
                "from comic_data\n" +
                "join character_comic ON character_comic.comic_id = comic_data.comic_id\n" +
                "join comic_collection ON comic_collection.comic_id = comic_data.comic_id\n" +
                "join character_data ON character_data.character_id = character_comic.character_id\n" +
                "join collection ON collection.collection_id = comic_collection.collection_id\n" +
                "where collection.collection_id = ?\n" +
                "group by character_data.name\n" +
                "order by 1 desc;";

        SqlRowSet results =  jdbcTemplate.queryForRowSet(sql, collectionId);

        while(results.next()){
            statisticsList.add(mapRowToStatistics(results, "character"));
        }
        return statisticsList;
    }

    @Override
    public List<Statistics> collectionAuthorStats(int collectionId) {
        List<Statistics> statisticsList = new ArrayList<>();


        String sql = "select count(comic_data.author) as num_comics_author, comic_data.author\n" +
                "from comic_data\n" +
                "join comic_collection ON comic_collection.comic_id = comic_data.comic_id\n" +
                "join collection ON collection.collection_id = comic_collection.collection_id\n" +
                "where collection.collection_id = ?\n" +
                "group by comic_data.author\n" +
                "order by 1 desc;";

        SqlRowSet results =  jdbcTemplate.queryForRowSet(sql, collectionId);
        while(results.next()){
            statisticsList.add(mapRowToStatistics(results, "author"));
        }
        return statisticsList;
    }

    @Override
    public List<Statistics> collectionSeriesStats(int collectionId) {
        List<Statistics> statisticsList = new ArrayList<>();
        String sql = "select count(comic_data.series) as num_comics_series, comic_data.series\n" +
                "from comic_data\n" +
                "join comic_collection ON comic_collection.comic_id = comic_data.comic_id\n" +
                "join collection ON collection.collection_id = comic_collection.collection_id\n" +
                "where collection.collection_id = ?\n" +
                "group by comic_data.series\n" +
                "order by 1 desc;";

        SqlRowSet results =  jdbcTemplate.queryForRowSet(sql, collectionId);

        while(results.next()){
            statisticsList.add(mapRowToStatistics(results, "series"));
        }
        return statisticsList;
    }

    @Override
    public Statistics siteStatistics() {
        Statistics statistics = null;
        String sql = "select count(comic_data.comic_id) as num_comics_siteWide, count(DISTINCT collection.collection_id) as num_collections_siteWide\n" +
                "from comic_data\n" +
                "join comic_collection ON comic_collection.comic_id = comic_data.comic_id\n" +
                "full join collection ON collection.collection_id = comic_collection.collection_id";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        while(results.next()){
            statistics = mapRowToStatistics(results, "site");
        }
        return statistics;

    }

    private Statistics mapRowToStatistics(SqlRowSet results, String type) {
        Statistics statistics = new Statistics();
        switch(type){
            case "character":
                statistics.setNum_comics_character(results.getInt(1));
                statistics.setName(results.getString(2));
                break;
            case "author":
                statistics.setNum_comics_author(results.getInt(1));
                statistics.setAuthor(results.getString(2));
                break;
            case "series":
                statistics.setNum_comics_series(results.getInt(1));
                statistics.setSeries(results.getString(2));
                break;
            case "site":
                statistics.setNum_comics_siteWide(results.getInt("num_comics_siteWide"));
                statistics.setNum_collections_siteWide(results.getInt("num_collections_siteWide"));
                break;
            default:
                break;
        }

        return statistics;
    }
}
