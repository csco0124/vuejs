import Vue from 'vue'
import Vuex from 'vuex'
import axios from 'axios'

Vue.use(Vuex);

const store = new Vuex.Store({
  state: {
    serverName: "none"
  },
  getters: {
    getServer : function(state){
      console.log('33333 : ' + state.serverName);
      return state.serverName;
    }
  },
  mutations: {
    setServerEnv: function (state, payload) {
      console.log('222222 : ' + payload + ":" + state.serverName);
      state.serverName = "aaaa1";
    }
  },
  actions: {
    getServerEnvData: function (context) {
      console.log('111111');
      context.commit('setServerEnv', "aaaa");
     /* axios.get('/getServerEnv.json').then(function(response) {
        context.commit('setServerEnv', response);
      }); */
    }
  }
})

export default store