<template>
  <section class="main">
    <div class="container">
      <registration-form />
    </div>
  </section>
</template>

<script>
import RegistrationForm from '../components/RegistrationForm.vue'

export default {
  name: 'RegisterView',
  components: { RegistrationForm }
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
    background-image: url('/public/x-men-1.png');
    background-size: cover;
    background-position: bottom;
    height: 100vh;
  }
}

</style>
