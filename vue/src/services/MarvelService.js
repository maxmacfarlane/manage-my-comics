import axios from 'axios'
import store from '../store/index.js'

/*
use https://manage-my-comics.herokuapp.com/api/marvel/ for live server
use http://localhost:9000/api/marvel/ for local server
*/

const http = axios.create({
  baseURL: 'http://localhost:9000/api/marvel/',
  headers: {
    Authorization: `Bearer ${store.state.token}`
  }
})

export default {

  searchComicByUpc (upc) {
    return http.get(`upc/${upc}`)
  },

  searchComicBySeriesAndIssue (series, issueNo) {
    return http.get(`${series}/${issueNo}`)
  },

  getLatestReleases () {
    return http.get('latest/')
  }

}
