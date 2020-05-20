<template>
  <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
    <h1 class="page-header">Dashboard - Overview</h1>
    <h2 class="sub-header">Overview</h2>
    <button v-on:click="pagePath">현재 링크</button><br>
    <button v-on:click="getServerNameChange">변수 변경</button><br>
    <button v-on:click="getServerName">변수</button><br>
    Server : <input type="text" v-model="message"> {{message}}
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
    getComServerName : function() {
      this.message = this.$store.getters.getServer;
    }
  }, */
  methods:{
    getServerNameChange : function() {
      this.$store.dispatch('getServerEnvData');
      alert(this.message);
      this.message = "vvv";
    },
    getServerName : function() {
      alert(this.$store.state.serverName);
    }
  }
}
</script>

<style scope>

</style>