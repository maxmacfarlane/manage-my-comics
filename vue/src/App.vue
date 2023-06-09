<template>

  <div id="app">
    <the-header id="the-header" />
    <router-view id="main-content" />
    <the-footer id="footer" />
  </div>

</template>

<script>

import TheHeader from './components/TheHeader.vue'
import TheFooter from './components/TheFooter.vue'

export default {
  components: {
    TheHeader,
    TheFooter
  }
}

</script>

<style>

@import url('https://fonts.googleapis.com/css2?family=Montserrat:wght@300;400;500;600;800;900&display=swap');
@import url('https://fonts.googleapis.com/css2?family=Oswald&display=swap');

* {
  margin: 0;
  padding: 0;
  box-sizing: border-box;
}

body {
  background-color: #ECF4FF;
}

#main-content {
  min-height: 100vh;
}

</style>
