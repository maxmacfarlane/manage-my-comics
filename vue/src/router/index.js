/* eslint-disable import/no-duplicates */
import Vue from 'vue'
import VueRouter from 'vue-router'
import HomeView from '../views/HomeView.vue'
import LoginView from '../views/LoginView.vue'
import LogoutView from '../views/LogoutView.vue'
import RegisterView from '../views/RegisterView.vue'
import Collections from '../views/CollectionsView.vue'
import MyCollection from '../views/MyCollectionView.vue'
import PublicCollection from '../views/MyCollectionView.vue'
import Browse from '../views/BrowseView.vue'
import NewComics from '../views/NewComics.vue'
import ComicDetails from '../views/ComicDetails.vue'
import NotFound from '../views/NotFound.vue'
import store from '../store/index'

Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    name: 'HomeView',
    component: HomeView,
    meta: {
      requiresAuth: false
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
  },
  {
    path: '/collections',
    name: 'CollectionsView',
    component: Collections,
    meta: {
      requiresAuth: true
    }
  },
  {
    path: '/collection/:id',
    name: 'CollectionView',
    component: MyCollection,
    meta: {
      requiresAuth: true
    }
  },
  {
    path: '/public-collection/:id',
    name: 'public-collection',
    component: PublicCollection,
    meta: {
      requiresAuth: false
    }
  },
  {
    path: '/browse',
    name: 'BrowseView',
    component: Browse,
    meta: {
      requiresAuth: false
    }
  },
  {
    path: '/new-comics',
    name: 'new-comics',
    component: NewComics,
    meta: {
      requiresAuth: false
    }
  },
  {
    path: '/comic/:id',
    name: 'comicdetails',
    component: ComicDetails,
    meta: {
      requiresAuth: false
    }
  },
  {
    path: '/:pathMatch(.*)*',
    name: 'NotFound',
    component: NotFound,
    meta: {
      requiresAuth: false
    }
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
