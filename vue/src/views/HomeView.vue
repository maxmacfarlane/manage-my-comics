<template>
  <section class="main">
    <div class="container">
      <aggregate-statistics/>
      <div class="image-container"></div>
      <div class="components">
        <public-collections />
        <characters-list />
      </div>
    </div>
  </section>
</template>

<script>
import AggregateStatistics from '../components/AggregateStatistics.vue'
import PublicCollections from '../components/PublicCollections.vue'
import CharactersList from '../components/CharactersList.vue'

export default {
  name: 'HomeView',
  components: {
    AggregateStatistics,
    PublicCollections,
    CharactersList
  }
}

</script>

<style scoped>

.image-container {
  background-image: url('/public/home-banner-1.png');
  background-repeat: no-repeat;
  background-size: cover;
  background-position: 0%;
  height: 8rem;
}

.components {
  margin-left: 3rem;
  margin-right: 3rem;
}

@media screen and (min-width: 600px) {
  .image-container {
    height: 16rem;
  }
}

@media screen and (min-width: 1000px) {
  .image-container {
    height: 500px;
  }
}

</style>
