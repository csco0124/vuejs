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
        <a class="navbar-brand" href="#">Project name</a>
      </div>
      <div id="navbar" class="navbar-collapse collapse">
        <ul class="nav navbar-nav navbar-right">
          <router-link tag="li" to="/Info" active-class="active"><a>Info</a></router-link>
        </ul>
      </div>
    </div>
  </nav>
</template>

<script>
export default {
 
}
</script>

<style scope>

</style>