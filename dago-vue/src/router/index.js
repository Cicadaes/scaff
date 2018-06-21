import Vue from 'vue'
import Router from 'vue-router'
import Login from '@/views/Login'
import Home from '@/views/Home'
import BusinessDetail from '@/views/service/businessDetail'
import DataDetail from '@/views/data/dataDetail'
import menuModule from '@/store/modules/menu'
Vue.use(Router)

const router = new Router({
  mode: 'history',
  scrollBehavior: () => ({ y: 0 }),
  routes: [
    {
      path: '/',
      name: 'Home',
      component: Home,
      redirect: '/integration/plugOperation',
      meta: {
        auth: true
      },
      children: [
        {
          path: '/service/detail',
          name: '业务详情',
          component: BusinessDetail,
          meta: {
            auth: true,
            tab: 'home/detail',
          },
        },
        {
          path: '/data/detail',
          name: '厂商详情',
          component: DataDetail,
          meta: {
            auth: true,
            tab: 'data/company/detail',
          },
        },
        ...generateRoutesFromMenu(menuModule.state.items),

      ]
    },
    {
      path: '/account/login',
      name: '登录',
      component: Login
    },

    {
      path: '*',
      redirect: '/service'
    }
  ]
});
function generateRoutesFromMenu(menu = [], routes = []){
  menu.forEach(item => {
    if (item.path) {
      routes.push(item)
    }
    if (!item.component) {
      generateRoutesFromMenu(item.children, routes)
    }
  })
  return routes;
}
router.beforeEach((to, from, next) => {

    if (to.matched.some(r => r.meta.auth)) {
      next()
        // if (store.state.token) {
        //     next();
        // }
        // else {
        //
        //     next({
        //         path: '/account/login',
        //         query: {redirect: to.fullPath}
        //     })
        // }
    }
    else {
        next();
    }
})

export default router;
