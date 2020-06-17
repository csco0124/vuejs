<template>
  <div>
    <Header></Header>
    <div class="container-fluid">
      <div class="row">
        <Left></Left>
        <router-view v-on:go-page="movePage" v-on:file-download="getFileDownload"></router-view>
      </div>
    </div>
  </div>
</template>

<script>
import Header from './components/Header.vue'
import Left from './components/Left.vue'
import 'es6-promise/auto'
import Router from './router/Router'
import store from './store/Store'
import I18n from './i18n/i18n'
import axios from 'axios'

export default {
  name: 'app',
  store: store,
  router: Router,
  i18n: I18n,
  data () {
    return {
      msg: ''
    }
  },
  methods: {
    movePage: function(path) {
      this.$router.push({path : path});
    },
    getFileDownload: function(downloadUrl, fileName){
      axios({
          url: downloadUrl,
          method: 'GET',
          responseType: 'blob',
      }).then((response) => {
            var fileURL = window.URL.createObjectURL(new Blob([response.data]));
            var fileLink = document.createElement('a');

            fileLink.href = fileURL;
            fileLink.setAttribute('download', fileName);
            document.body.appendChild(fileLink);

            fileLink.click();
      });
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
