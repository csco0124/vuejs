<template>
  <div>
    <Header></Header>
    <div class="container-fluid">
      <div class="row">
        <Left></Left>
        <router-view v-on:go-page="movePage"></router-view>
      </div>
    </div>
  </div>
</template>

<script>
import Header from './components/Header.vue'
import Left from './components/Left.vue'
import Router from './router/Router'
import store from './store/Store'

export default {
  name: 'app',
  store: store,
  router: Router,
  data () {
    return {
      msg: ''
    }
  },
  methods: {
    movePage: function(path) {
      this.$router.push({path : path});
    }
  },
  computed:{
    
  },
  created: function () {
      this.$store.dispatch('getServerEnvData');
  },
  components: {
    'Header': Header,
    'Left': Left
  }
}
</script>

<style>
[v-clock] {
  display: none;
}
</style>
