import Vue from 'vue'
import VueRouter from 'vue-router'
import HomeView from '../views/HomeView.vue'
import LoginView from '../views/LoginView.vue'
import LogoutView from '../views/LogoutView.vue'
import RegisterView from '../views/RegisterView.vue'
import store from '../store/index'

Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    name: 'HomeView',
    component: HomeView,
    meta: {
      requiresAuth: true
    }
  },
  {
    path: '/login',
    name: 'LoginView',
    component: LoginView,
    meta: {
      requiresAuth: false
    }
  },
  {
    path: '/logout',
    name: 'LogoutView',
    component: LogoutView,
    meta: {
      requiresAuth: false
    }
  },
  {
    path: '/register',
    name: 'RegisterView',
    component: RegisterView,
    meta: {
      requiresAuth: false
    }
    // component: () => import(/* webpackChunkName: "register" */ '../views/RegisterView.vue') #lazy-loading
  }
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

router.beforeEach((to, from, next) => {
  // Determine if the route requires Authentication
  const requiresAuth = to.matched.some(x => x.meta.requiresAuth)

  // If it does and they are not logged in, send the user to "/login"
  if (requiresAuth && store.state.token === '') {
    next('/login')
  } else {
    // Else let them go to their next destination
    next()
  }
})

export default router
