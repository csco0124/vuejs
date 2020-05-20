import Vue from 'vue'
import Vuex from 'vuex'
import axios from 'axios'

Vue.use(Vuex);

const store = new Vuex.Store({
  state: {
    server: ''
  },
  getters: {
    getServer: function (state) {
      axios.get('/getServerEnv.json')
							.then(function(response) {
                alert(response);
                state.server = response;
							});
      return state.server;
    }
  },
  mutations: {
    
  },
  actions: {
    
  }
})

export default store