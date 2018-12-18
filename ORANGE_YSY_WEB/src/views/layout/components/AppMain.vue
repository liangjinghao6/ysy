<template>
  <div class="app-main">
    <transition name="fade" mode="out-in">EEEEEEEEEE
        <router-view></router-view>
    </transition>
  </div>
</template>

<script>
  export default {
    name: 'AppMain',
    computed: {
      cachedViews() {
        return this.$store.state.app.cachedViews
      }
      // key() {
      //   return this.$route.name !== undefined ? this.$route.name + +new Date() : this.$route + +new Date()
      // }
    }
  }
</script>
<style rel="stylesheet/scss" lang="scss">
  .app-main {
    min-height: 100%;
  }
</style>
