<template>
  <div class="loginFormContainer">
    <div class="welcome">Welcome Back!</div>
    <div>
      <form @submit.prevent="login" autocomplete="off">
        <h1 class="login-text">LOGIN</h1>
        <div role="alert" v-if="invalidCredentials">Invalid username and password!</div>
        <div role="alert" v-if="this.$route.query.registration" class="thank-you">Thank you for registering, please sign in.</div>
        <div class="form-input-group">
          <input type="text" id="username" placeholder=" username" v-model="user.username" required autofocus />
        </div>
        <div class="form-input-group">
          <input type="password" id="password" placeholder=" password" v-model="user.password" required />
        </div>
        <button type="submit" class="submit-button">SIGN IN</button>
      </form>
    </div>
    <div class="new-user">
      <p id="not-a-member">Not a Member?</p>
      <router-link :to="{ name: 'RegisterView' }" tag="button" class="register">SIGN UP</router-link>
    </div>
  </div>
</template>

<script>
import authService from '../services/AuthService'

export default {
  data () {
    return {
      user: {
        username: '',
        password: ''
      },
      invalidCredentials: false
    }
  },
  methods: {
    login () {
      authService.login(this.user).then(response => {
        if (response.status === 200) {
          this.$store.commit('SET_AUTH_TOKEN', response.data.token)
          this.$store.commit('SET_USER', response.data.user)
          this.$router.push('/')
          this.$router.go()
        }
      }).catch(error => {
        const response = error.response
        if (response.status === 401) {
          this.invalidCredentials = true
        }
      })
    }
  }
}

</script>

<style scoped>

.loginFormContainer {
  display: flex;
  flex-direction: column;
  background-color: white;
  height: 600px;
  width: 400px;
  grid-area: loginForm;
  border: 1px solid black;
  justify-content: center;
  align-items: center;
  text-align: center;
  margin: 1rem 3rem 1rem 3rem;
  font-family: 'Montserrat', Helvetica, sans-serif;
}

.login-text {
  position: relative;
  top: -50px;
  font-size: 2.2rem;
}

.welcome {
  position: relative;
  top: -90px;
  font-size: 1.2rem;
}

.new-user {
  position: relative;
  bottom: -105px;
}

.new-user > p {
  margin-bottom: 1rem;
}

.submit-button {
  position: relative;
  bottom: -30px;
}

.form-input-group {
  margin-bottom: 1rem;
}

.form-input-group input {
  padding: .5rem;
}

input {
  height: 2rem;
  width: 15rem;
}

.thank-you {
  position: relative;
  top: -40px;
}

#not-a-member {
  font-size: 1.2rem;
}

button {
  cursor: pointer;
  border: 0;
  border-radius: 4px;
  font-weight: 600;
  margin: 1 10px;
  width: 7rem;
  padding: 10px 0;
  box-shadow: 0 0 10px rgba(0, 0, 0, 0.15);
  transition: 0.4s;
  color: rgb(236, 29, 36);
  background-color: rgba(255, 255, 255, 1);
  border: 1px solid rgba(236, 29, 36, 1);
  font-family: 'Montserrat', Helvetica, sans-serif;
  font-size: 1rem;
}

button:hover {
  color: white;
  box-shadow: 0 0 20px rgba(0, 0, 0, 0.15);
  background-color: rgba(236, 29, 36, 1);
}

</style>
