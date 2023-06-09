<template>
  <div class='stats-container'>
    <div class="options-bar">
      <label class="radio-box">
        <input type="radio" name="search-option" value="characters" v-model="selectedOption" v-on:click="characterStats()"/>
        <span class="name">Characters</span>
      </label>
      <label class="radio-box">
        <input type="radio" name="search-option" value="author" v-model="selectedOption" v-on:click="authorStats()"/>
        <span class="name">Authors</span>
      </label>
      <label class="radio-box">
        <input type="radio" name="search-option" value="series" v-model="selectedOption" v-on:click="seriesStats()"/>
        <span class="name">Series</span>
      </label>
    </div>
    <div id="stats-table">
      <div class='character-stats' v-if="selectedOption === 'characters'">
        <table class='stats'>
          <thead>
            <tr>
              <th>Comics ft. Character</th>
              <th>#</th>
            </tr>
          </thead>
          <tbody>
            <tr v-for="character in collectionStats" v-bind:key="character.name">
              <td>{{character.name}}</td>
              <td>{{character.num_comics_character}}</td>
            </tr>
          </tbody>
        </table>
      </div>
      <div class='author-stats' v-if="selectedOption === 'author'">
        <table class='stats'>
          <thead>
            <tr>
              <th>Comic by Author</th>
              <th>#</th>
            </tr>
          </thead>
          <tbody>
            <tr v-for="character in collectionStats" v-bind:key="character.author">
              <td>{{character.author}}</td>
              <td>{{character.num_comics_author}}</td>
            </tr>
          </tbody>
        </table>
      </div>
      <div class='series-stats' v-if="selectedOption === 'series'">
        <table class='stats'>
          <thead>
            <tr>
              <th>Comics by Series</th>
              <th>#</th>
            </tr>
          </thead>
          <tbody>
            <tr v-for="series in collectionStats" v-bind:key="series.series">
              <td>{{series.series}}</td>
              <td>{{series.num_comics_series}}</td>
            </tr>
          </tbody>
        </table>
      </div>
    </div>
  </div>
</template>

<script>
import statsService from '../services/StatsService'

export default {
  name: 'stats-collection-table',
  data () {
    return {
      collectionStats: [],
      selectedOption: 'characters'
    }
  },
  methods: {
    characterStats () {
      statsService.getCharactersStats(this.$route.params.id)
        .then(response => {
          this.collectionStats = response.data
        })
    },
    authorStats () {
      statsService.getAuthorStats(this.$route.params.id)
        .then(response => {
          this.collectionStats = response.data
        })
    },
    seriesStats () {
      statsService.getSeriesStats(this.$route.params.id)
        .then(response => {
          this.collectionStats = response.data
        })
    }
  },
  created () {
    statsService.getCharactersStats(this.$route.params.id)
      .then(response => {
        this.collectionStats = response.data
      })
  }
}
</script>

<style scoped>

.stats-container {
  display: flex;
  flex-direction: column;
  align-items: center;
  margin: 2rem;
}

table.stats {
  font-family: "Oswald", Helvetica, sans-serif;
  border: 1px solid#ed1d24;
  background-color: #EEEEEE;
  text-align: left;
  border-collapse: collapse;
}

table.stats td, table.stats th {
  border: 1px solid #AAAAAA;
  padding: 5px 10px;
}

table.stats tbody td {
  color: #333333;
}

table.stats tr:nth-child(even) {
  background: #F5F5F5;
}

table.stats thead {
  background: #ed1d24;
  font-weight: bold;
  color: #FFFFFF;
  border-bottom: 2px solid #444444;
}

.options-bar {
  display: flex;
  border-radius: 0.5rem;
  width: 20rem;
  background-color: #e1edff;
  box-shadow: 0 6px 10px 0 rgba(0, 0, 0, 0.2), 0 10px 30px 0 rgba(0, 0, 0, 0.19);
  padding: 0.5rem;
  margin-bottom: 1rem;
}

.options-bar .radio-box {
  flex: 1 1 auto;
  text-align: center;
}

.options-bar .radio-box input {
  display: none;
}

.options-bar .radio-box .name {
  display: flex;
  cursor: pointer;
  align-items: space-evenly;
  justify-content: space-evenly;
  border-radius: 0.5rem;
  border: none;
  padding: 0.5rem 0;
  color: rgba(51, 65, 85, 1);
  font-weight: 600;
  transition: all .15s ease-in-out;
}

.options-bar .radio-box input:checked + .name {
  background-color: #ed1d24;
  font-weight: 600;
  color: white;
}

</style>
