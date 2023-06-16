package com.maxwell.manage_my_comics.controller;

import com.maxwell.manage_my_comics.dao.CollectionDao;
import com.maxwell.manage_my_comics.model.ComicCollection;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api")
@PreAuthorize("isAuthenticated()")
@CrossOrigin
public class CollectionController {

    CollectionDao collectionDao;

    CollectionController(CollectionDao collectionDao){
        this.collectionDao = collectionDao;
    }

    @PreAuthorize("permitAll")
    @GetMapping("/collections")
    public List<ComicCollection> getPublicCollections(){
        List<ComicCollection> collection = collectionDao.listAllCollections();
        if(collection == null || collection.size() == 0){
            throw new ResponseStatusException(HttpStatus.NO_CONTENT, "No public collections available");
        } else return collection;
    }

    @PreAuthorize("hasAnyRole('USER','PREMIUM')")
    @GetMapping("/user/{userId}/collections")
    public List<ComicCollection> getCollectionsByUserId(@PathVariable int userId){
        List<ComicCollection> collection = collectionDao.listCollectionsByUser(userId);
        if (collection == null || collection.size() == 0) {
            throw new ResponseStatusException(HttpStatus.NO_CONTENT, "Collection not found");
        } else return collection;
    }

    @PreAuthorize("hasAnyRole('USER','PREMIUM')")
    @ResponseStatus(value = HttpStatus.CREATED)
    @PostMapping("/collections/add")
    public ComicCollection createCollection(@RequestBody ComicCollection newCollection){
        return collectionDao.createCollection(newCollection);
    }
    @PreAuthorize("hasAnyRole('USER','PREMIUM')")
    @ResponseStatus(value = HttpStatus.OK)
    @PutMapping("/collections/update/{collectionId}")
    public ComicCollection updateCollectionName(@PathVariable int collectionId, @RequestBody ComicCollection comicCollectionToUpdate){
        return collectionDao.updateCollectionName(collectionId, comicCollectionToUpdate);
    }
    @PreAuthorize("permitAll")
    @ResponseStatus(value = HttpStatus.OK)
    @GetMapping("/collections/{collectionId}")
    public ComicCollection getCollectionByCollectionId(@PathVariable int collectionId) {
        return collectionDao.getCollectionByCollectionId(collectionId);
    }

    @PreAuthorize("hasAnyRole('USER','PREMIUM')")
    @ResponseStatus(value = HttpStatus.OK)
    @DeleteMapping("/user/{userId}/collections/{collectionId}")
    public void deleteCollection(@PathVariable int userId, @PathVariable int collectionId){
        collectionDao.deleteCollection(userId, collectionId);
    }

    @PreAuthorize("hasAnyRole('USER','PREMIUM')")
    @GetMapping("/user/{userId}/collections/{comicId}")
    public List<ComicCollection> getCollectionsByUserIdWithoutComicId(@PathVariable int userId, @PathVariable String comicId){
        List<ComicCollection> collection = collectionDao.listCollectionsByUserWithoutSpecifiedComic(userId, comicId);
        if(collection == null || collection.size() == 0){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Collection not found");
        } else return collection;
    }

}