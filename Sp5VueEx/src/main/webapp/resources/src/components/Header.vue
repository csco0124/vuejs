<template>
  <nav class="navbar navbar-inverse navbar-fixed-top">
    <div class="container-fluid" >
      <div class="navbar-header">
        <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
          <span class="sr-only">Toggle navigation</span>
          <span class="icon-bar"></span>
          <span class="icon-bar"></span>
          <span class="icon-bar"></span>
        </button>
        <a class="navbar-brand" href="#">VueSp5 Project (Server : {{this.$store.getters.getServer}})</a>
      </div>
      <div id="navbar" class="navbar-collapse collapse">
        <ul class="nav navbar-nav navbar-right">
          <li>
            <div style="float:left; padding:17px 0px 0px 0px; color:white; font-size:12px; color:#9d9d9d;" >언어선택 : </div>
            <div style="float:right; padding:7px 0px 0px 0px;">
            <select class="form-control" style="float:right;" v-on:change="changeLanguage($event)" v-model="languageVal">
              <option value="en">영어</option>
              <option value="ko">한국어</option>
            </select>
            </div>
          </li>
          <router-link tag="li" to="/Info" active-class="active"><a>Info</a></router-link>
        </ul>
        
      </div>
    </div>
  </nav>
</template>

<script>
export default {
  data(){
    return {
      languageVal : ""
    }
  },
  methods: {
      changeLanguage(event) {
        this.$i18n.locale = event.target.value;
      }
  },
  mounted() {
    console.log(this.$i18n.locale);
    this.languageVal = this.$i18n.locale;
  }
}
</script>

<style scope>

</style>