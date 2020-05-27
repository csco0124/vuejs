<template>
  <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
    <h1 class="page-header">Dashboard - EditorDetail</h1>
    <h2 class="sub-header">EditorDetail</h2>

    <h4 class="sub-header"></h4>
    <h4><b>컨텐츠 (SEQ : {{seq}})</b></h4> 
    <div v-html="contentsDataList.contents"></div>
    <br>
    <h4 class="sub-header"></h4>
    <h4><b>파일 리스트</b></h4>
      {{contentsDataList.file1_name}} <button v-if="isFile1" v-on:click="getFileDownload(contentsDataList.file1_path, contentsDataList.file1_name)">다운로드</button><br>
      {{contentsDataList.file2_name}} <button v-if="isFile2" v-on:click="getFileDownload(contentsDataList.file2_path, contentsDataList.file2_name)">다운로드</button>
    <br>
    <h4 class="sub-header"></h4>
    <router-link tag="button" v-bind:to="{path: '/Editor/'}" class="btn btn-outline-info">뒤로</router-link>
  </div>
</template>

<script>
import axios from 'axios'

export default {
  props: {
      seq: Number
  },
  data(){
    return {
      contentsDataList : "",
      isFile1 : false,
      isFile2 : false
    }
  },
  computed: {
    
  },
  methods:{
    getFileDownload(downloadUrl, fileName){
      this.$emit('file-download', downloadUrl, fileName);
    }
  },
  created() {
    
  },
  mounted() {
    let form = new FormData();
    form.append('seq', this.seq);
    axios.post('/selectDbBbsFileDetailAsMap.json', form).then(response => {
        this.contentsDataList = response.data; 
        if(this.contentsDataList.file1_name != undefined){
          this.isFile1 = true;
        }
        if(this.contentsDataList.file2_name != undefined){
          this.isFile2 = true;
        }
      });
  }
}
</script>

<style scope>
</style>