<template>
  <section class="main">
    <div class="container">
      <div class="image-container"></div>
      <div class="search-main">
        <search-comics />
      </div>
    </div>
  </section>
</template>

<script>
import SearchComics from '../components/SearchComics.vue'

export default {
  name: 'BrowseView',
  components: { SearchComics }
}
</script>

<style scoped>

.image-container {
  background-image: url('/public/star-wars-1.jpg');
  background-size: cover;
  height: 8rem;
}

@media screen and (min-width: 600px) {
  .image-container {
    height: 16rem;
  }
}

@media screen and (min-width: 1000px) {
  .image-container {
    height: 32rem;
  }
}

</style>
