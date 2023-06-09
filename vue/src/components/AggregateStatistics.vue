<template>
  <div id='aggregate-stats'>
    <p id="stats-banner">{{aggregateStats.num_comics_siteWide}} COMICS HAVE BEEN COLLECTED IN {{aggregateStats.num_collections_siteWide}} COLLECTIONS!</p>
    <p v-if="$store.state.token === ''">~~~ Register and make an account to start collecting today! ~~~</p>
  </div>
</template>

<script>
import StatsService from '../services/StatsService'

export default {
  data () {
    return {
      aggregateStats: {
        num_comics_siteWide: 0,
        num_collections_siteWide: 0
      }
    }
  },
  created () {
    StatsService.getSiteStats()
      .then(response => {
        this.aggregateStats = response.data
      })
  }
}
</script>

<style scoped>

#aggregate-stats {
  font-family: 'Montserrat', Helvetica, sans-serif;
  background-color: #a4e9d5;
  text-align: center;
  padding-top: .5rem;
}

p {
  padding-bottom: .5rem;
}

#stats-banner {
  font-weight: 1000;
  font-size: 1.3rem;
}

</style>
