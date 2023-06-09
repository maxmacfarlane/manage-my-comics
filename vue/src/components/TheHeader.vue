<template>
  <div id=test>
    <div id="header">
      <div id="mobile-header">
        <div id="nav-bar-icon" @click="toggleNav" :class="{ open: isActive }">
          <span></span>
          <span></span>
          <span></span>
          <span></span>
        </div>
        <div id="logo-box">
          <router-link :to="{ name: 'home' }"><img id="logo" src="..\public\MMC-logo.png" alt="Manage My Comics logo" /></router-link>
        </div>
      </div>
      <nav id="nav-bar" v-show="isActive">
          <ul id="nav-bar-links" >
            <li id="browse" class="nav-link"><router-link :to="{ name: 'browse' }">Browse</router-link></li>
            <li id="new-comics" class="nav-link"><router-link :to="{ name: 'new-comics' }">New Comics</router-link></li>
            <li id="collections" class="nav-link"><router-link :to="{ name: 'collections' }">My Collections</router-link></li>
            <li id="home" class="nav-link"><router-link :to="{ name: 'home' }">Public Collections</router-link></li>
          </ul>
          <ul id="login-register">
            <li id="login" class="nav-link" v-if="signedIn"><router-link :to="{ name: 'login' }" tag="button">SIGN IN</router-link></li>
            <li id="register" class="nav-link" v-if="signedIn"><router-link :to="{ name: 'register' }" tag="button">REGISTER</router-link></li>
            <li id="logout" class="nav-link" v-show="!signedIn"><router-link :to="{ name: 'logout' }" tag="button">LOGOUT</router-link></li>
          </ul>
      </nav>
    </div>
    <div id="desktop-header">
      <div class="header">
        <div>
          <router-link v-bind:to="{ name: 'home' }"><img class="logo" src="..\public\MMC-logo.png" alt="Manage My Comcis!" /></router-link>
        </div>
        <nav>
          <ul class="nav-bar">
            <li><router-link :to="{ name: 'browse' }" style="text-decoration: none;">Browse</router-link></li>
            <li class="newcomics"><router-link :to="{ name: 'new-comics' }" style="text-decoration: none;">New Comics</router-link></li>
            <li class="collections"><router-link :to="{ name: 'collections' }" style="text-decoration: none;">Collections</router-link></li>
          </ul>
        </nav>
        <div>
          <ul class="login-register">
            <li class="login" ><router-link class="nav-link" :to="{ name: 'login' }" v-if="$store.state.token.length <= 0" tag="button">SIGN IN</router-link></li>
            <li class="register" ><router-link class="nav-link" :to="{ name: 'register' }" v-if="$store.state.token.length <= 0" tag="button">REGISTER</router-link></li>
            <li class="logout" ><router-link class="nav-link" v-bind:to="{ name: 'logout' }" v-if="$store.state.token != ''" tag="button">LOGOUT</router-link></li>
          </ul>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import store from '../store/index.js'

export default {
  name: 'the-header',
  data () {
    return {
      isActive: false
    }
  },
  computed: {
    signedIn () {
      if (store.state.token.length <= 0) {
        return true
      } return false
    }
  },
  methods: {
    toggleNav () {
      this.isActive = !this.isActive
    }
  }
}
</script>

<style scoped>

#header {
  background-color: white;
  padding-bottom: .5rem;
}

#mobile-header {
  display: flex;
  justify-content: space-evenly;
}

#logo-box {
  margin-top: .33rem;
}

ul {
  font-size: 1.3em;
  font-weight: 800;
  font-family: 'Montserrat', Helvetica, sans-serif;
}

.nav-link {
  list-style: none;
  text-decoration: none;
  margin-top: .5rem;
  margin-top: 1rem;
  margin-left: 1rem;
}

#nav-bar-links {
  align-items: center;
}

#login-register {
  display: flex;
  justify-content: flex-start;
  margin-top: .5rem;
  margin-bottom: 1rem;
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

a, a:hover, a:visited, a:active {
  color: inherit;
  text-decoration: none;
}

/* All the code below is for the nav-menu icon */

#nav-bar-icon {
  width: 60px;
  height: 45px;
  margin-top: 1rem;
  -webkit-transform: rotate(0deg);
  -moz-transform: rotate(0deg);
  -o-transform: rotate(0deg);
  transform: rotate(0deg);
  -webkit-transition: .5s ease-in-out;
  -moz-transition: .5s ease-in-out;
  -o-transition: .5s ease-in-out;
  transition: .5s ease-in-out;
  cursor: pointer;
}

#nav-bar-icon span {
  display: block;
  position: absolute;
  height: 9px;
  width: 100%;
  background: #000000;
  border-radius: 9px;
  opacity: 1;
  left: 0;
  -webkit-transform: rotate(0deg);
  -moz-transform: rotate(0deg);
  -o-transform: rotate(0deg);
  transform: rotate(0deg);
  -webkit-transition: .25s ease-in-out;
  -moz-transition: .25s ease-in-out;
  -o-transition: .25s ease-in-out;
  transition: .25s ease-in-out;
}

#nav-bar-icon span:nth-child(1) {
  top: 0px;
}

#nav-bar-icon span:nth-child(2),#nav-bar-icon span:nth-child(3) {
  top: 18px;
}

#nav-bar-icon span:nth-child(4) {
  top: 36px;
}

#nav-bar-icon.open span:nth-child(1) {
  top: 18px;
  width: 0%;
  left: 50%;
}

#nav-bar-icon.open span:nth-child(2) {
  -webkit-transform: rotate(45deg);
  -moz-transform: rotate(45deg);
  -o-transform: rotate(45deg);
  transform: rotate(45deg);
}

#nav-bar-icon.open span:nth-child(3) {
  -webkit-transform: rotate(-45deg);
  -moz-transform: rotate(-45deg);
  -o-transform: rotate(-45deg);
  transform: rotate(-45deg);
}

#nav-bar-icon.open span:nth-child(4) {
  top: 18px;
  width: 0%;
  left: 50%;
}

@media only screen and (max-width: 749px) {
  #desktop-header {
    display: none;
  }
}

@media only screen and (min-width: 750px) {
  .nav-bar {
    display: flex;
    justify-content: flex-start;
    font-size: 1rem;
    gap: 1rem;
  }

  #header {
    display: none;
  }

  div .header {
    display: grid;
    grid-template-columns: 1fr 3fr 1fr;
    grid-template-areas:
      "logo nav-bar login-register";
    align-items: center;
    background-color: white;
    margin: 0;
    padding: 0;
    box-sizing: border-box;
  }

  .logo {
    grid-area: logo;
    margin-left: 15%;
    width: 80%;
    margin-top: 4%;
    margin-bottom: 4%;
  }

  ul .login-register {
    grid-area: login-register;
  }

  ul {
    display: flex;
    list-style: none;
    font-family: 'Montserrat', Helvetica, sans-serif;
    font-weight: 800;
  }

  nav > ul {
    justify-content: space-evenly;
    text-transform: uppercase;
    grid-area: nav-bar;
  }

  .nav-bar > li:hover {
    color: #ED1D24;
    font-weight: 1000;
    transition: all .15s ease-in-out;
  }

  div > ul {
    justify-content: flex-end;
  }

  div > ul .login {
    margin-right: 5%;
  }

  div > ul .register {
    margin-right: 5%;
  }

  div > ul .logout {
    margin-right: 5%;
  }

  button {
    cursor: pointer;
    border: 0;
    border-radius: 4px;
    font-weight: 600;
    margin: 1 10px;
    width: 7rem;
    padding: .2rem;
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

  a, a:hover, a:visited, a:active {
    color: inherit;
    text-decoration: none;
  }
}

@media screen and (min-width: 800px) {
  .nav-bar {
    justify-content: center;
  }
}

@media screen and (min-width: 1240px) {
  .nav-bar {
    display: flex;
    gap: 2rem;
    font-size: 1.5rem;
  }
  button {
    padding: .5rem
  }
}

@media screen and (min-width: 1600px) {
  .nav-bar {
    font-size: 1.8rem;
    gap: 6rem;
  }
  button {
    padding: .75rem
  }
}

</style>
