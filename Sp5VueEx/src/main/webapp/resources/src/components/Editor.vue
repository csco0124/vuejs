<template>
  <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
    <h1 class="page-header">Dashboard - Editor</h1>
    <h2 class="sub-header">Editor</h2>
    <button v-on:click="getAlert">안내창</button><br>
    <form method="post" action="/editorUpload" enctype="multipart/form-data">
      <div class="container">
        <textarea class="summernote" id="summernote" name="editordata"><p>Seasons <b>coming up</b></p></textarea>
        <a href="javascript:void(0);" onclick="javascript:getCode()">aaaa</a>
      </div>
      <input type="file" name="files">
      <input type="file" name="files">
      <input type="submit">
    </form>
    <alert v-if="showAlert" @close="showAlert = false">
      <div slot="contents">
        111w
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
      showAlert : false
    }
  },
  computed: {
    
  },
  methods:{
    getAlert() {
      this.showAlert = true;
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