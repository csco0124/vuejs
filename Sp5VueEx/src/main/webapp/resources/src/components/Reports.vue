<template>
  <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
    <h1 class="page-header">Dashboard - Reports</h1>
    <button type="button" v-on:click="dataRegistPop" class="btn btn-primary pull-right">Regist</button>
    <button type="button" v-on:click="pageMove('/Overview')" class="btn btn-primary pull-right">go Home</button>
    <h2 class="sub-header">DATA LIST</h2>
    <div class="table-responsive">
      <table class="table table-striped" v-clock>
        <thead>
           <tr>
            <th>#seq</th>
            <th>TITLE</th>
            <th>CONTENTS</th>
            <th>INSERT DATE</th>
          </tr>
        </thead>
        <transition-group name="list" tag="tbody">
          <tr v-for="(item) in dataList" v-bind:key="item.seq">
            <td>{{item.seq}}</td>
            <td>{{item.title}}</td>
            <td>{{item.contents}}</td>
            <td>{{item.insert_date}}</td>
          </tr>
        </transition-group>
      </table>
    </div>
    <modal v-if="showModal" @close="showModal = false">
      <h4 slot="header" class="modal-title">Data Regist</h4>
      <div slot="contents">
        <form>
          <div class="form-group">
            <label for="title">Title</label>
            <input type="text" v-model="title" class="form-control" id="title" placeholder="Enter title">
            <small class="form-text text-muted">Enter title Text</small>  
          </div>
          <div class="form-group">
          <label for="contents">Contents</label>
            <input type="text" v-model="contents" class="form-control" id="contents" placeholder="Enter Contents">
            <small class="form-text text-muted">Enter Contents Text</small>
          </div>
        </form>
      </div>
      <button slot="footer" v-on:click="insertData" type="button" class="btn btn-primary">Save changes</button>
	  </modal>
  </div>
</template>

<script>
import Modal from './common/Modal.vue'
import axios from 'axios'

export default {
  data(){
    return {
      showModal : false,
      title : "",
      contents : "",
      dataList : []
    }
  },
  computed:{
    
  },
  methods:{
    dataRegistPop(){
      this.title = "";
      this.contents = "";
      this.showModal = true;
    },
    getDataList(){
      let form = new FormData();
      //form.append('title', '1');
      axios.post('/selectDbBbsListAsMap.json', form).then(response => {
        this.dataList = response.data; 
      });
    },
    insertData(){
      let form = new FormData();
      form.append('title', this.title);
      form.append('contents', this.contents);
      axios.post('/insertDbBbsList.json', form).then(response => {
        this.showModal = false;
        if(response.data.result != "S"){

        }else{
          this.getDataList();
        }
      });
    },
    pageMove(path){
      alert("현재 Path1 : " + this.$route.path);
      this.$emit('go-page', path);
    }
  },
  mounted() {
    this.getDataList();
  },
  components: {
    Modal: Modal
  }
}
</script>

<style scope>
.list-move {
  transition: 1s;
}
.list-enter-active, .list-leave-active {
  transition: all 1s;
}
.list-enter, .list-leave-to {
  opacity: 0;
  transform: translateY(30px);
}
</style>