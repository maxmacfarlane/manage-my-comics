<template>
  <section class="main">
    <div class="container">
      <login-form />
    </div>
  </section>
</template>

<script>
import LoginForm from '../components/LoginForm.vue'

export default {
  name: 'LoginView',
  components: { LoginForm }
}
</script>

<style scoped>

.container {
  display: flex;
  align-items: center;
  justify-content: center;
}

@media screen and (min-width: 600px) {
  .container {
    display: flex;
    justify-content: center;
    align-items: center;
    background-image: url('/public/she-hulk-1.png');
    background-size: cover;
    background-position: bottom;
    height: 100vh;
  }
}

</style>
