<template>
  <section class="main">
    <div id="collection-banner"></div>
    <div class="container">
      <h2>{{collection.collectionName}}</h2>
      <edit-collection v-if="this.$route.name === 'collection'" />
      <div class="cards">
          <comic-card v-for="comic in this.comics" :key="comic.comicId" :comic="comic" />
      </div>
      <h2>Statistics</h2>
      <stats-collection-table id="stats" />
      <delete-collection v-if="this.$route.name === 'CollectionView'" />
    </div>
  </section>
</template>

<script>
import EditCollection from '../components/EditCollection.vue'
import ComicCard from '../components/ComicCard.vue'
import DeleteCollection from '../components/DeleteCollection.vue'
import comicService from '../services/ComicService.js'
import collectionService from '../services/CollectionsService.js'
import StatsCollectionTable from '../components/StatsCollectionTable.vue'

export default {
  name: 'CollectionView',
  components: {
    EditCollection,
    ComicCard,
    DeleteCollection,
    StatsCollectionTable
  },
  data () {
    return {
      comics: [],
      collection: []
    }
  },
  created () {
    comicService.getComicsByCollectionId(this.$route.params.id).then(response => {
      this.comics = response.data
    })

    collectionService.getCollectionByCollectionId(this.$route.params.id).then(response => {
      this.collection = response.data
    })
  }
}

</script>

<style scoped>

#collection-banner {
  background-image: url('/public/marvel-banner-2.jpg');
  background-repeat: no-repeat;
  background-size: cover;
  background-position: 0%;
  height: 8rem;
}

.cards {
  display: flex;
  align-items: center;
  justify-content: center;
  flex-wrap: wrap;
  column-gap: 2.2%;
  margin-top: 1.5rem;
}

h2 {
  text-align: center;
  margin: 1.5rem;
  font-size: 2.5rem;
  font-family: 'Montserrat', Helvetica, sans-serif;
}

#stats {
  margin-top: 0px;
}

@media screen and (min-width: 600px) {
  #collection-banner {
    height: 16rem;
  }
}

@media screen and (min-width: 1000px) {
  #collection-banner {
    height: 500px;
  }
}

</style>
