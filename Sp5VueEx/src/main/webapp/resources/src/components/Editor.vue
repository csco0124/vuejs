<template>
  <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
    <h1 class="page-header">Dashboard - Editor</h1>
    <h2 class="sub-header">Editor</h2>
    <button v-on:click="getAlert">안내창</button><br>
      <div class="container" style="width:90%;">
        <textarea class="summernote" id="summernote"><p>Seasons <b>coming up</b></p></textarea>
      </div>
      <div id="fileTemplate"></div>

      <button type="button" v-on:click="addFile" class="btn btn-outline-info">파일추가</button>
      <br><br>
      <button type="button" v-on:click="registContents" class="btn btn-primary pull-left">저장</button>
    <alert v-if="showAlert" v-on:close="showAlert = false">
      <div slot="contents">
        111w
      </div>
      <button slot="footer" type="button" class="btn btn-primary pull-right">저장</button>
	  </alert> 
  </div>
</template>

<script>
import Alert from './common/Alert.vue'
import axios from 'axios'

export default {
  data(){
    return {
      showAlert : false
    }
  },
  computed: {
    
  },
  methods:{
    getAlert() {
      this.showAlert = true;
    },
    addFile(){
      let fileObj = document.createElement("input");
      fileObj.setAttribute('type', "file");
      fileObj.setAttribute('name', "files");
      document.getElementById("fileTemplate").appendChild(fileObj);
    },
    registContents(){
      const formData = new FormData();
      formData.append("contents", $('.summernote').summernote('code'));

      for(var i=0; i<document.getElementsByName("files").length; i++){
        formData.append('files', document.getElementsByName("files")[i].files[0]);
      }

      axios.post( '/editorUpload',
        formData,
          {
            headers: {
                'Content-Type': 'multipart/form-data'
            }
          }
      ).then(function(){
        console.log('SUCCESS!!');
      })
      .catch(function(){
        console.log('FAILURE!!');
      });
    }
  },
  mounted() {
    /* 에디터 */
    $('.summernote').summernote({
      height: 200,
      tabsize: 2,
      lang: 'ko-KR',
      disableDragAndDrop: false,	//Drag and Drop 기능 없애기 여부
      callbacks: {
            onImageUpload: function(files) {
              summerImageUpload(".summernote", files);
        }
      }
    });
  },
  components: {
    Alert: Alert
  }
}
</script>

<style scope>
</style>