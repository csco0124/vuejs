<template>
  <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
    <h1 class="page-header">Dashboard - Editor</h1>
    <h2 class="sub-header">Editor</h2>
    <button v-on:click="getAlert">안내창</button><button v-on:click="getAlert2">안내창2</button><br>
      <div class="container" style="width:90%;">
        <textarea class="summernote" id="summernote"><p>Seasons <b>coming up</b></p></textarea>
      </div>
      <div id="fileTemplate"></div>

      <button type="button" v-on:click="addFile" class="btn btn-outline-info">파일추가</button>
      <br><br>
      <button type="button" v-on:click="getAlert" class="btn btn-primary pull-left">저장</button>
      <br><br>
      <table class="table table-striped" v-clock>
        <thead>
           <tr>
            <th>#seq</th>
            <th>INSERT DATE</th>
          </tr>
        </thead>
        <transition-group name="list" tag="tbody">
          <tr v-for="(item) in contentsDataList" v-bind:key="item.seq">
            <td>{{item.seq}}</td>
            <td>{{item.insert_date}}</td>
          </tr>
        </transition-group>
      </table>
    <alert v-if="showAlert" v-on:close="showAlert = false">
      <div slot="contents">
        저장하시겠습니까?
      </div>
      <button slot="footer" type="button" v-on:click="registContents" class="btn btn-primary pull-right">저장</button>
	  </alert>
    <alert v-if="showAlert2" v-on:close="showAlert2 = false">
      <div slot="contents">
       {{responseMsg}}
      </div>
	  </alert> 
  </div>
</template>

<script>
import Alert from './common/Alert.vue'
import axios from 'axios'

export default {
  data(){
    return {
      showAlert : false,
      showAlert2 : false,
      responseMsg : "",
      contentsDataList : []
    }
  },
  computed: {
    
  },
  methods:{
    getAlert() {
      this.showAlert = true;
    },
    getAlert2() {
      this.showAlert2 = true;
    },
    addFile(){
      let fileObj = document.createElement("input");
      fileObj.setAttribute('type', "file");
      fileObj.setAttribute('name', "files");
      document.getElementById("fileTemplate").appendChild(fileObj);
    },
    registContents(){
      this.showAlert = false;
      this.responseMsg = "저장되었습니다.";
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
      ).then(response => {
        if(response.data.result != "S"){
          this.responseMsg = errorMsg;
        }else{
          this.responseMsg = "저장되었습니다.";
        }
        this.getAlert2();
        this.getContentsList();
      }).catch(e => {
        this.responseMsg = "[ERROR]" + e;
        this.getAlert2();
      });
    },
    getContentsList(){
      let form = new FormData();
      //form.append('title', '1');
      axios.post('/selectDbBbsFileListAsMap.json', form).then(response => {
        this.contentsDataList = response.data; 
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
    this.getContentsList();
  },
  components: {
    Alert: Alert
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