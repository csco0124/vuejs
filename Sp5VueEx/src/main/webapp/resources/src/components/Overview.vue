<template>
  <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
    <h1 class="page-header">Dashboard - Overview</h1>
    <h2 class="sub-header">Overview</h2>
    <button v-on:click="getPath">현재 링크</button><br> 
    {{server}}
  </div>
</template>

<script>
export default {
  data(){
    return {
      server : ""
    }
  },
  computed: {
    
  },
  methods:{
    getPath() {
      this.server = this.$route.path;
    }
  },
  created: function () {
      
  }
}
</script>

<style scope>
</style>