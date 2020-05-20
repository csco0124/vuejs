<template>
  <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
    <h1 class="page-header">Dashboard - Overview</h1>
    <h2 class="sub-header">Overview</h2>
    <!-- <button v-on:click="pagePath">현재 링크</button><br> --> <!-- 중요!!! -> 없는 메서드 및 변수를 선언한 채로 진행하면 에러나면서 vuejs 작동 안됨-->
    <button v-on:click="getServerNameChange">변수 변경</button><br>
    <button v-on:click="getServerName">변수</button><br>
    Server : <input type="text" v-model="this.$store.getters.getServer" v-on:keypress.enter="getServerNameChange"> {{this.$store.getters.getServer}}
  </div>
</template>

<script>
export default {
  data(){
    return {
      message : "sssss"
    }
  },
  /* computed: {
    getComServerName() {
      this.message = this.$store.getters.getServer;
    }
  }, */
  methods:{
    getServerNameChange() {
      this.$store.dispatch('getServerEnvData');
      alert(this.message);
      this.message = "vvv";
    },
    getServerName() {
      alert(this.$store.state.serverName);
    }
  }
}
</script>

<style scope>

</style>