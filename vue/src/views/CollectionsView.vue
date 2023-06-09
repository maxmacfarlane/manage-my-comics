<template>
  <section class="main">
    <div id="collection-banner"></div>
    <div class="container">
      <personal-collections />
    </div>
  </section>
</template>

<script>
import PersonalCollections from '../components/PersonalCollections.vue'

export default {
  name: 'CollectionsView',
  components: {
    PersonalCollections
  }
}
</script>

<style scoped>

.container {
  margin-left: 12%;
  margin-right: 12%;
}

#collection-banner {
  background-image: url('/public/marvel-banner-3.jpg');
  background-repeat: no-repeat;
  background-size: cover;
  background-position: 0%;
  height: 8rem;
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
