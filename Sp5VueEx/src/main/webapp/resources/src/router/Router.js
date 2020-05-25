import Vue from 'vue'
import VueRouter from 'vue-router'
import Info from '../components/Info.vue'
import Overview from '../components/Overview.vue'
import Reports from '../components/Reports.vue'
import Editor from '../components/Editor.vue'

Vue.use(VueRouter);

const router = new VueRouter({
  //mode: 'history',
  routes: [
    { path: '/',          component: Overview },
    { path: '/Info',      component: Info },
    { path: '/Overview',  component: Overview },
    { path: '/Reports',   component: Reports },
    { path: '/Editor',    component: Editor }
  ]
})

export default router