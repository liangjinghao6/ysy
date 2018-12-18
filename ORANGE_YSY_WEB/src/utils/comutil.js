import Vue from 'vue'
import VueResource from 'vue-resource'

Vue.use(VueResource)

var comutil = {
  ajaxPost:function(url, params) {
  return Vue.http.post(url, { params: params })
}
}
export default comutil
