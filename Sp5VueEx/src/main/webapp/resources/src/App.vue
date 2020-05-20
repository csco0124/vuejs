<template>
  <div id="app">
    <Header></Header>
    <div class="container-fluid">
      <div class="row">
        <Left></Left>
        <router-view></router-view>
      </div>
    </div>
  </div>
</template>

<script>
import Header from './components/Header.vue'
import Left from './components/Left.vue'
import Router from './router/Router'

export default {
  name: 'app',
  router: Router,
  data () {
    return {
      msg: 'Welcome to Your Vue.js App'
    }
  },
  components: {
    'Header': Header,
    'Left': Left
  }
}
</script>

<style>
</style>
