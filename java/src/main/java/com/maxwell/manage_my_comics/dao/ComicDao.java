package com.maxwell.manage_my_comics.dao;

import com.maxwell.manage_my_comics.model.Comic;

import java.util.List;

public interface ComicDao {
    List<Comic> listAllComicsOfCollection (int collectionId);
    Comic getComic (int comicId);
    Comic getComicByUpc (String upc);
    List<Comic> getComicsByAuthor(String author);
    List<Comic> getComicsByArtist(String artist);
    List<Comic> getComicsByCharacter(int characterId);
    List<Comic> getComicsBySeries(String series);
    Comic addComic (Comic comic);
    void addComicToCollection(int comicId, int collectionId);
    void removeComicFromCollection(int collectionId, int comicId);
    void updateComic (Comic comic);
    void deleteComic (int comicId);
    int countUniqueComicsOfUser(int userId);

}
