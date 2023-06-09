import axios from 'axios'
import store from '../store/index.js'

/*
use https://manage-my-comics.herokuapp.com for live server
use http://localhost:9000 for local server
*/

const http = axios.create({
  baseURL: 'https://manage-my-comics.herokuapp.com/api',
  headers: {
    Authorization: `Bearer ${store.state.token}`
  }
})

export default {

  getCharacterById (characterId) {
    return http.get(`/characters/${characterId}`)
  },

  getCharactersByCollectionId (collectionId) {
    return http.get(`/collections/${collectionId}/characters`)
  },

  getCharacterByAlias (characterAlias) {
    return http.get(`/characters/alias/${characterAlias}}`)
  },

  getCharactersByComicId (comicId) {
    return http.get(`/comics/${comicId}/characters`)
  },

  getAllCharacters () {
    return http.get('/characters')
  },

  addCharacter (characterToAdd) {
    return http.post('/characters/add', characterToAdd)
  },

  addCharacterToComic (comicId, characterId) {
    return http.post(`/comics/${comicId}/characters/${characterId}`)
  },

  updateCharacter (updatedCharacter) {
    return http.put(`/characters/${updatedCharacter.characterId}`, updatedCharacter)
  },

  deleteCharacter (characterId) {
    return http.delete(`/characters/delete/${characterId}`)
  }
}
