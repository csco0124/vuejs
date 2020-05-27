<template>
  <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
    <h1 class="page-header">Dashboard - Overview</h1>
    <h2 class="sub-header">Overview</h2>
    <button v-on:click="getPath">현재 링크</button><br> 
    {{server}}<br>

        언어 선택 : 
    <button v-on:click="$i18n.locale='ko'">한국어</button>
    <button v-on:click="$i18n.locale='en'">English</button>
    {{$t('message.hello')}} || Input 출력 : <input type="text" v-bind:placeholder="$t('message.hello')">
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
  created: function () {
      
  },
  mounted() {
  
  },
  methods:{
    getPath() {
      this.server = this.$route.path;
    }
  }
}
</script>

<style scope>
</style>