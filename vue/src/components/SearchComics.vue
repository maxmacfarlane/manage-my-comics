<template>
  <div class="search-comics">
    <div class="options-bar" v-show="marvelApi">
      <label class="radio-box">
        <input type="radio" name="search-option" value="seriesAndIssue" v-model="selectedOptionApi">
        <span class="name">Series and Issue #</span>
      </label>
      <label class="radio-box">
        <input type="radio" name="search-option" value="upc" v-model="selectedOptionApi" />
        <span class="name">UPC</span>
      </label>
    </div>
    <div id="search-container">
      <form>
        <div>
          <input class="search-box" v-show="searchBarApiUpc" type="search" placeholder="UPC" v-on:keyup.enter="searchUpc" v-model="searchValue" required />
        </div>
        <div>
          <input class="search-box" v-if="searchBarApiIssueNo" type="search" placeholder="Series" v-on:keyup.enter="searchSeriesIssue" v-model="searchValueSeries" required autofocus/>
        </div>
        <div>
          <input class="search-boxTwo" v-if="searchBarApiIssueNo" type="search" placeholder="Issue Number" v-on:keyup.enter="searchSeriesIssue" v-model="searchValueIssue" required/>
        </div>
        <button class="submit" type="submit" v-if="searchBarApiUpc" @click.prevent="searchUpc">SEARCH</button>
        <button class="submit" type="submit" v-if="searchBarApiIssueNo" @click.prevent="searchSeriesIssue">SEARCH</button>
      </form>
    </div>
    <div class="new-comics-list">
      <comic-card-marvel-api :comic="comic" v-for="comic in searchResults" :key="comic.upc"/>
    </div>
  </div>
</template>

<script>
import ComicCardMarvelApi from './ComicCardMarvelApi.vue'
import marvelService from '../services/MarvelService.js'
import comicService from '../services/ComicService.js'

export default {
  name: 'search-comics',
  components: { ComicCardMarvelApi },
  data () {
    return {
      searchResults: [],
      searchValue: '',
      searchValueDb: '',
      searchValueSeries: '',
      searchValueIssue: '',
      selectedOption: 'seriesName',
      selectedOptionApi: 'seriesAndIssue',
      marvelApi: true
    }
  },
  computed: {
    comics () {
      return this.searchResults
    },
    searchBarApiUpc () {
      if (this.marvelApi === true && this.selectedOptionApi === 'upc') {
        return true
      } return false
    },
    searchBarApiIssueNo () {
      if (this.marvelApi === true && this.selectedOptionApi === 'seriesAndIssue') {
        return true
      } return false
    }
  },
  methods: {
    searchUpc (searchValue) {
      searchValue = this.searchValue
      marvelService.searchComicByUpc(searchValue).then(response => {
        this.searchResults = response.data
        comicService.addComic(response.data[0])
      })
    },
    searchSeriesIssue () {
      // this.searchValueSeries
      marvelService.searchComicBySeriesAndIssue(this.searchValueSeries, this.searchValueIssue).then(response => {
        this.searchResults = response.data
        response.data.forEach(element => {
          comicService.addComic(element)
        })
      })
    }
  }
}
</script>

<style scoped>

.search-comics {
  display: flex;
  flex-direction: column;
  justify-content: center;
  font-family: 'Montserrat', Helvetica, sans-serif;
}

#search-container {
  display: flex;
  flex-direction: column;
  align-items: center;
}

.new-comics-list {
  display: flex;
  justify-content: center;
  flex-wrap: wrap;
}

.options-bar {
  display: flex;
  border-radius: 0.5rem;
  background-color: #e1edff;
  box-shadow: 0 6px 10px 0 rgba(0, 0, 0, 0.2), 0 10px 30px 0 rgba(0, 0, 0, 0.19);
  padding: 0.25rem;
  font-size: 20px;
  margin-top: 1rem;
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
  align-items: center;
  justify-content: center;
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

.search-box {
  height: 4rem;
  border-radius: 0.5rem;
  border: 1px solid #ccc;
  padding: 10px 20px 10px 60px;
  font-size: 20px;
  box-shadow: 0 6px 10px 0 rgba(0, 0, 0, 0.2), 0 10px 30px 0 rgba(0, 0, 0, 0.19);
  background-image: url("/public/search-icon.png");
  background-repeat: no-repeat;
  background-size: 1.1em 1.1em;
  background-position: 3% 48%;
}

.search-boxTwo {
  height: 4rem;
  border-radius: 0.5rem;
  border: 1px solid #ccc;
  padding: 10px 20px 10px 60px;
  font-size: 20px;
  box-shadow: 0 6px 10px 0 rgba(0, 0, 0, 0.2), 0 10px 30px 0 rgba(0, 0, 0, 0.19);
  background-image: url("/public/search-icon.png");
  background-repeat: no-repeat;
  background-size: 1.1em 1.1em;
  background-position: 3% 48%;
  margin-top: .5rem;
}

button {
  cursor: pointer;
  border: 0;
  border-radius: 4px;
  font-weight: 600;
  width: 7rem;
  padding: 10px;
  box-shadow: 0 0 10px rgba(0, 0, 0, 0.15);
  transition: 0.4s;
  color: rgb(236, 29, 36);
  background-color: rgba(255, 255, 255, 1);
  border: 1px solid rgba(236, 29, 36, 1);
  font-family: 'Montserrat', Helvetica, sans-serif;
}

button:hover {
  color: white;
  box-shadow: 0 0 20px rgba(0, 0, 0, 0.15);
  background-color: rgba(236, 29, 36, 1);
}

form {
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
}

.submit {
  margin-top: 1rem;
}

@media screen and (min-width: 750px) {
  .search-comics {
    align-items: center;
  }

  .options-bar {
    width: 50%;
    justify-content: center;
  }
}

</style>
