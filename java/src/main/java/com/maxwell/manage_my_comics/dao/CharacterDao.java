package com.maxwell.manage_my_comics.dao;

import com.maxwell.manage_my_comics.model.ComicCharacter;

import java.util.List;

public interface CharacterDao {
    ComicCharacter getCharacterById(int characterId);
//    List<ComicCharacter> getCharacterByAlias(String characterName);
    List<ComicCharacter> getCharacterByRealName(String characterName);
    List<ComicCharacter> getAllCharacters();
    List<ComicCharacter> getCharactersByComicId(int comicId);
    List<ComicCharacter> getCharactersByCollectionId(int collectionId);
    ComicCharacter addCharacter(ComicCharacter character);
    void updateCharacter(int characterId, ComicCharacter character);
    void deleteCharacter(int characterId);
    void addCharacterToComic(int characterId, int comicId);

    //todo: is this needed?
    //boolean removeCharacterFromComic(int characterId, int comicId);

}
