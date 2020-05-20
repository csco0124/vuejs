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
import store from './store/Store'

export default {
  name: 'app',
  store: store,
  router: Router,
  data () {
    return {
      msg: 'Welcome to Your Vue.js App'
    }
  },
  methods:{

  },
  computed:{
    correntPagePath : function(){
      alert(this.$route.path);
      return this.$route.path;
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
