<template>
  <section class="main">
    <div class="card-container">
      <div class="comic-image-div">
        <img class="comic-image" v-bind:src="'http://i.annihil.us/u/prod/marvel/i/mg/' + comic.imageURL + '/detail.jpg'" >
      </div>
      <div class="comic-details">
        <h3 class="series-name">{{ comic.seriesName }} #{{ comic.issueNumber }}</h3>
        <p class="writer">Writer: <br>{{ comic.author }}</p>
        <p class="penciler">Penciler: <br>{{ comic.artist }}</p>
        <p class="penciler">UPC: <br>{{ comic.upc }}</p>
      </div>
    </div>
  </section>
</template>

<script>
import AddComic from '../components/AddComic.vue'
import comicService from '../services/ComicService.js'

export default {
  name: 'comic-details',
  comments: {
    AddComic
  },
  data () {
    return {
      comic: []
    }
  },
  created () {
    comicService.getComicByUpc(this.$route.params.id).then(response => {
      this.comic = response.data
    })
  }
}
</script>

<style scoped>

.comic-details {
  display: flex;
  flex-direction: column;
  justify-content: flex-start;
  align-items: left;
  font-size: 3vh;
  padding: 1rem;
  font-family: 'Montserrat', Helvetica, sans-serif;
}

.comic-image-div {
  margin-top: 1rem;
  margin-left: 1rem;
  margin-right: 1rem;
}

.comic-image {
  box-shadow: 0 6px 10px 0 rgba(0, 0, 0, 0.2), 0 10px 30px 0 rgba(0, 0, 0, 0.19);
  width: 100%;
}

.add-button {
  display: flex;
  margin-top: 1px;
  margin-bottom: 5%;
}

h3, p {
  margin: .7rem;
}

</style>
