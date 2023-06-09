import axios from 'axios'
import store from '../store/index.js'

/*
use https://manage-my-comics.herokuapp.com for live server
use http://localhost:9000 for local server
*/

const http = axios.create({
  baseURL: 'https://manage-my-comics.herokuapp.com/api/stats',
  headers: {
    Authorization: `Bearer ${store.state.token}`
  }
})

export default {

  getCharactersStats (collectionId) {
    return http.get(`/${collectionId}/character`)
  },
  getAuthorStats (collectionId) {
    return http.get(`/${collectionId}/author`)
  },
  getSeriesStats (collectionId) {
    return http.get(`/${collectionId}/series`)
  },

  getSiteStats () {
    return http.get('/')
  }
}
