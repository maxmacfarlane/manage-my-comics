package com.maxwell.manage_my_comics.dao;

import com.maxwell.manage_my_comics.model.ComicCollection;

import java.util.List;

public interface CollectionDao {
    ComicCollection createCollection(ComicCollection comicCollection);
    ComicCollection getCollectionByCollectionId(int id);
    List<ComicCollection> listAllCollections();
    List<ComicCollection> listCollectionsByUser(int id);
    List<ComicCollection> listCollectionsByUserWithoutSpecifiedComic(int userId, String comicId);
    ComicCollection updateCollectionName(int collectionId, ComicCollection comicCollectionName);
    void deleteCollection(int userId, int collectionId);

}