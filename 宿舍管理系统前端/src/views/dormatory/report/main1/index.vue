<template>
  <div class="app-container">
    <iframe id="reportFrame" width="100%" height="800" frameborder="0" scrolling="auto"
            :src= "fr_cpt_url">
    </iframe>
  </div>

</template>

<script>
export default {
  name: 'main1',
  data() {
    return {
      fr_cpt_url: "http://10.10.10.203:8079/webroot/decision/view/report?viewlet=main1.cpt",
    }
  },
  mounted() {


      // setInterval(() => {
      //   document.getElementById("reportFrame").src="http://10.10.10.203:8079/webroot/decision/view/report?viewlet=main1.cpt";
      // }, 30000)

  },
  created() {

  }
}
</script>

<style scoped>

</style>
