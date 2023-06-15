package com.maxwell.manage_my_comics.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.maxwell.manage_my_comics.model.Comic;
import com.maxwell.manage_my_comics.services.RestMarvelService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@PreAuthorize("isAuthenticated")
@CrossOrigin
public class MarvelController {
    RestMarvelService restMarvelService;

    public MarvelController(RestMarvelService marvelService){
        this.restMarvelService = marvelService;
    }


    @PreAuthorize("permitAll")
    @GetMapping("/marvel/{series}/{issueNo}")
    public List<Comic> searchMarvelBySeriesAndIssueNo(@PathVariable String series, @PathVariable String issueNo) throws JsonProcessingException {
        return restMarvelService.searchComicsBySeriesAndIssueNo(series, issueNo);
    }

    @PreAuthorize("permitAll")
    @GetMapping("/marvel/upc/{upc}")
    public List<Comic> getMarvelComicByUpc(@PathVariable String upc) throws JsonProcessingException {
        return restMarvelService.getComicByUpc(upc);
    }

    @PreAuthorize("permitAll")
    @GetMapping("/marvel/latest")
    public List<Comic> getLatestReleases() throws JsonProcessingException {
        return restMarvelService.getLatestReleases();
    }
}
