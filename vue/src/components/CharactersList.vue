<template>
  <section>
    <h2 class="characters-text">Characters</h2>
    <div class="characters-list" >
      <character-card v-bind:character="character" v-for="character in characters" v-bind:key="character.characterId"/>
    </div>
  </section>
</template>

<script>
import CharacterCard from '../components/CharacterCard.vue'

export default {
  name: 'characters-list',
  computed: {
    characters () {
      return this.$store.state.characters
    }
  },
  components: { CharacterCard }
}
</script>

<style scoped>

.characters-text {
  text-align: center;
  font-size: 2.5rem;
  font-family: 'Montserrat', Helvetica, sans-serif;
}

.characters-list {
  display: flex;
  justify-content: center;
  flex-wrap: wrap;
  column-gap: 2.2%;
  margin-top: 2%;
}

</style>
