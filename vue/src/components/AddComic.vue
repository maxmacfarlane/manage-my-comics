<template>
  <div class="container">
    <div class="collection-box" v-if="showCollections === true">
      <h5>Which collection?</h5>
      <ul>
        <a v-for="collection in myCollections" v-bind:key="collection.collectionId" v-on:click="addComic(collection.collectionId)">
          <li>{{collection.collectionName}}</li>
        </a>
      </ul>
      <button id="cancel-button" v-on:click.prevent="showCollections = false">Cancel</button>
    </div>
    <button id="add-button" v-if="showCollections === false" v-on:click.prevent="showCollections = true">Add To Collection</button>
  </div>
</template>

<script>
import collectionService from '../services/CollectionsService.js'
import comicService from '../services/ComicService.js'

export default {
  data () {
    return {
      showCollections: false,
      myCollections: []
    }
  },
  props: {
    comic: Object
  },
  methods: {
    addComic (collectionId) {
      const comic = {
        comicId: this.comic.comicId,
        upc: this.comic.upc,
        seriesName: this.comic.seriesName,
        issueNumber: this.comic.issueNumber,
        artist: this.comic.artist,
        author: this.comic.author,
        publish_date: this.comic.publish_date,
        imageURL: this.comic.imageURL
      }
      comicService.addComicToCollection(collectionId, comic).then(response => {
        if (response.status === 200) {
          this.$router.push(this.$route.path)
          this.$router.go()
        }
      })
    }
  },
  created () {
    collectionService.getCollectionsByUserIdWithoutComicId(this.$store.state.user.id, this.comic.upc).then(response => {
      this.myCollections = response.data
    })
  }
}
</script>

<style scoped>

.container {
  display: flex;
  justify-content: flex-end;
  margin-top: 1rem;
  margin-bottom: 1rem;
}

.collection-box {
  background-color: white;
  border: 1px solid black;
  width: 100%;
  padding: 5px;
  font-size: 1.3rem;
}

ul {
  display: flex;
  flex-direction: column;
  text-align: left;
  list-style-type: none;
}

a {
  text-decoration: underline;
}

a:hover {
  font-weight: 500;
  letter-spacing: 0;
}

ul::before {
  font-weight: 500;
}

li {
  cursor: pointer;
  margin: .2rem;
}

button {
  cursor: pointer;
  border-radius: 4px;
  font-weight: 600;
  margin-top: .5rem;
  width: 5rem;
  box-shadow: 0 0 10px rgba(0, 0, 0, 0.15);
  transition: 0.4s;
  color: black;
  background-color: white;
  border: 1px solid black;
  font-family: 'Montserrat', Helvetica, sans-serif;
}

#add-button {
  width: 11.5rem;
  height: 2.5rem;
  font-size: 1.1rem;
}

button:hover {
  color: white;
  box-shadow: 0 0 20px rgba(0, 0, 0, 0.15);
  background-color: black;
}

h5 {
  margin: .2rem;
  text-align: left;
}

#cancel-button {
  width: 4.2rem;
  margin-bottom: .5rem;
}

</style>
