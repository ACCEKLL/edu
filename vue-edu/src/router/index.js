import Vue from 'vue'
import VueRouter from 'vue-router'
import HomeView from '../views/HomeView.vue'
import Cookies from "js-cookie";

Vue.use(VueRouter)

const whiteList = ['/login']

const routes = [
    {
        path: '/login',
        name: 'login',
        meta: {
            title: '登录'
        },
        component: () => import('@/views/login/index'),
    },
    {
        path: '/',
        redirect: 'users'
    },
    {
        path: '/users',
        name: 'users',
        meta: {
            title: '用户列表'
        },
        component: () => import('@/views/users/index.vue'),
    }
    // {
    //     path: '/',
    //     name: 'home',
    //     component: HomeView
    // },
    // {
    //     path: '/about',
    //     name: 'about',
    //     // route level code-splitting
    //     // this generates a separate chunk (about.[hash].js) for this route
    //     // which is lazy-loaded when the route is visited.
    //     component: () => import(/* webpackChunkName: "about" */ '../views/AboutView.vue')
    // }
]

const router = new VueRouter({
    mode: 'hash',
    base: process.env.BASE_URL,
    routes
})

router.beforeEach((to, from, next) => {
    // console.log(process.env.VUE_APP_BASE_API)
    let token = Cookies.get('my_token');
    // console.log(token)
    // console.log(to)
    // console.log(from)
    if (whiteList.indexOf(to.path) !== -1) {
        next()
    } else {
        if (token) {
            next()
        } else {
            next('/login')
        }
    }
})

export default router
