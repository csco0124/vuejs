<template>
  <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
    <h1 class="page-header">Dashboard - Overview</h1>
    <h2 class="sub-header">Overview</h2>
    <!-- <button v-on:click="pagePath">현재 링크</button><br> --> <!-- 중요!!! -> 없는 메서드 및 변수를 선언한 채로 진행하면 에러나면서 vuejs 작동 안됨-->
    <button v-on:click="getServerNameChange">서버 변경1</button><br>
    Server : <span >{{this.$store.getters.getServer}}</span> 
  </div>
</template>

<script>
export default {
  data(){
    return {
      message : ""
    }
  },
  computed: {
    
  },
  methods:{
    getServerNameChange() {
      
    }
  },
  created: function () {
      this.$store.dispatch('getServerEnvData');
  }
}
</script>

<style scope>
</style>