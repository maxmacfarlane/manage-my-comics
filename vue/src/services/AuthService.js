import axios from 'axios'
import store from '../store/index.js'

/*
use https://manage-my-comics.herokuapp.com for live server
use http://localhost:9000 for local server
*/

const http = axios.create({
  baseURL: 'http://localhost:9000',
  headers: {
    Authorization: `Bearer ${store.state.token}`
  }
})

export default {

  login (user) {
    return http.post('/login', user)
  },

  register (user) {
    return http.post('/register', user)
  }

}
