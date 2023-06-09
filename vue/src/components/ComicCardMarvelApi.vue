<template>
  <div id="container">
    <div id="card">
      <h3 class="comic-series">{{ comic.seriesName }} #{{comic.issueNumber}}</h3>
      <div id="comic-image-div">
        <router-link v-bind:to="{ name: 'comicdetails', params: { id: comic.upc } }">
          <img class="comic-image" v-bind:src="'http://i.annihil.us/u/prod/marvel/i/mg/' + comic.imageURL + '/detail.jpg'" />
        </router-link>
      </div>
      <div id="card-info">
        <p class="comic-creator" v-if="comic.author != null" >Writer: {{ comic.author }}</p>
        <p class="comic-creator" v-if="comic.artist != null" >Penciler: {{ comic.artist }}</p>
        <p class="comic-publish-date" v-if="comic.publish_date != null" >Published: {{ comic.publish_date }}</p>
      </div>
    </div>
    <add-comic-marvel-api class="add-button" :comic="comic"  v-if="$store.state.token != ''" />
  </div>
</template>

<script>
import AddComicMarvelApi from '../components/AddComicFromApi.vue'

export default {
  name: 'comic-card',
  components: {
    AddComicMarvelApi
  },
  props: {
    comic: Object
  }
}

</script>

<style scoped>

#container {
  display: flex;
  flex-direction: column;
  width: 400px;
  align-items: flex-start;
  border: 2px solid black;
  border-radius: 25px;
  padding: 1rem;
  margin: 1rem;
  font-family: 'Montserrat', Helvetica, sans-serif;
}

#card {
  display: flex;
  flex-direction: column;
  width: 100%;
}

#card > #comic-image-div {
  display: flex;
  align-items: center;
  justify-content: center;
}

#card-info {
  display: flex;
  flex-direction: column;
  margin-left: .5rem;
}

.comic-image {
  margin-top: 1rem;
  width: 200px;
}

.comic-image:hover {
  transform: translateY(-10px);
}

.comic-series {
  font-weight: 600;
  font-size: 1.3rem;
}

.comic-creator {
  font-family: 'Oswald', Helvetica, sans-serif;
  font-size: 1.2rem;
  font-weight: 500;
  margin-top: .5rem;
}

.comic-publish-date {
  font-family: 'Oswald', Helvetica, sans-serif;
  font-size: 1rem;
  font-weight: 500;
  margin-top: .5rem;
}

</style>
