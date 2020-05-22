<template>
  <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
    <h1 class="page-header">Dashboard - Reports</h1>
    <button v-on:click="openPop">모달 실행</button>
    <h2 class="sub-header">Reports</h2>
    <div class="table-responsive">
      <table class="table table-striped">
        <thead>
          <tr>
            <th>#seq</th>
            <th>TITLE</th>
            <th>CONTENTS</th>
            <th>INSERT DATE</th>
          </tr>
        </thead>
        <tbody>
          <tr v-for="(item) in dataList" v-bind:key="item.seq">
            <td>{{item.seq}}</td>
            <td>{{item.title}}</td>
            <td>{{item.contents}}</td>
            <td>{{item.insert_date}}</td>
          </tr>
        </tbody>
      </table>
    </div>
    <modal v-if="showModal" @close="showModal = false">
      <h4 slot="header" class="modal-title">Test</h4>
      <div slot="contents">
        <form>
          <div class="form-group">
            <label for="title">Title</label>
            <input type="text" class="form-control" id="title" placeholder="Enter title">
            <small class="form-text text-muted">Enter title Text</small>  
          </div>
          <div class="form-group">
          <label for="title">Contents</label>
            <input type="text" class="form-control" id="Contents" placeholder="Enter Contents">
            <small class="form-text text-muted">Enter Contents Text</small>
          </div>
        </form>
      </div>
      <button slot="footer" type="button" class="btn btn-primary">Save changes</button>
	  </modal>
  </div>
</template>

<script>
import Modal from './common/Modal.vue'
import axios from 'axios'

export default {
  data(){
    return {
      showModal: false,
      dataList: []
    }
  },
  computed:{
    
  },
  methods:{
    openPop(){
      this.showModal = true;
      this.getDataList();
    },
    getDataList(){
       axios.post('/selectDbBbsListAsMap.json', {title: "1"}).then(response => {
        console.log(response.data);
        this.dataList = response.data; 
      });

    }
  },
  mounted() {
    //this.getDataList();
    
    /* this.dataList = [
      { seq: 1, title:'1111' , contents:'2221', insert_date:'3331'},
      { seq: 2, title:'1112' , contents:'2222', insert_date:'3332'},
      { seq: 3, title:'1113' , contents:'2223', insert_date:'3333'}
    ] */
  },
  components: {
    Modal: Modal
  }
}
</script>

<style scope>

</style>