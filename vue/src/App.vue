<template>
  <div id="app">
    <div id="nav">
      <router-link v-bind:to="{ name: 'HomeView' }">Home</router-link>&nbsp;|&nbsp;
      <router-link v-bind:to="{ name: 'LogoutView' }" v-if="$store.state.token != ''">Logout</router-link>
    </div>
    <router-view />
  </div>
</template>
