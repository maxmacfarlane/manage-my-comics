<template>
  <section class="main">
    <div class="container">
      <div class="image-fit"></div>
      <div class="components">
        <new-comics-list />
      </div>
    </div>
  </section>
</template>

<script>

import NewComicsList from '../components/NewComicsList.vue'

export default {
  name: 'new-comics',
  components: { NewComicsList }
}

</script>

<style scoped>

.components {
  margin-left: 12%;
  margin-right: 12%;
}

.image-fit {
  background-image: url('/public/marvel-banner-8.jpg');
  background-repeat: no-repeat;
  background-size: cover;
  height: 8rem;
}

@media screen and (min-width: 600px) {
  .image-fit {
    height: 16rem;
  }
}

@media screen and (min-width: 1000px) {
  .image-fit {
    height: 500px;
  }
}

</style>
