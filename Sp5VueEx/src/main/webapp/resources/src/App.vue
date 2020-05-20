<template>
  <div id="app">
    <Header></Header>
    <div class="container-fluid">
      <div class="row">
        <Left></Left>
        <Contents></Contents>
      </div>
    </div>
  </div>
</template>

<script>
import Header from './components/Header.vue'
import Left from './components/Left.vue'
import Contents from './components/Contents.vue'

export default {
  name: 'app',
  data () {
    return {
      msg: 'Welcome to Your Vue.js App'
    }
  },
  components: {
    'Header': Header,
    'Left': Left,
    'Contents': Contents
  }
}
</script>

<style>
</style>
