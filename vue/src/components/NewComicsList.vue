<template>
  <section>
    <h2 class="new-comics-text">Latest Releases:</h2>
    <div class="new-comics-list" >
      <comic-card-marvel-api :comic="comic" v-for="comic in comics" :key="comic.upc"/>
    </div>
  </section>
</template>

<script>
import comicService from '../services/ComicService.js'
import marvelService from '../services/MarvelService.js'
import ComicCardMarvelApi from './ComicCardMarvelApi.vue'

export default {
  name: 'new-comics-list',
  components: { ComicCardMarvelApi },
  data () {
    return {
      comics: []
    }
  },
  created () {
    marvelService.getLatestReleases().then(response => {
      this.comics = response.data
      response.data.forEach(element => {
        comicService.addComic(element)
      })
    })
  }
}
</script>

<style scoped>

.new-comics-text {
  margin-top: 4%;
  font-family: 'Montserrat', Helvetica, sans-serif;
}

.new-comics-list {
  display: flex;
  justify-content: space-evenly;
  flex-wrap: wrap;
  column-gap: 2.2%;
  margin-top: 2%;
  margin-bottom: 2rem;
}

</style>
