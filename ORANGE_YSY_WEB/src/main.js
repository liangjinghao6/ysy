import Vue from 'vue'
import Element from 'element-ui'
import 'element-ui/lib/theme-chalk/index.css'
import i18n from './lang' // 国际化
import App from './App'
import router from './router'
import store from './store'
import comutils from './utils/comutils'
import * as filters from './filters' // 全局filter
import './icons' // icon
import './errorLog'// error log
import './permission' // 权限
import axios from 'axios'

Vue.prototype.$message = function (options) { // 消息默认值
  if (!options.duration) {
    options.duration = 1500
  }
  if (!options.showClose) {
    options.showClose = true
  }
  inElement.Message(options)
}
Vue.prototype.$http = axios;
Vue.use(comutils, {
  i18n: (key, value) => i18n.t(key, value)
})
Vue.use(Element, {
  i18n: (key, value) => i18n.t(key, value)
})


// register global utility filters.
Object.keys(filters).forEach(key => {
  Vue.filter(key, filters[key])
})

Vue.config.productionTip = false

let myVue = new Vue({
  el: '#app',
  router,
  store,
  i18n,
  template: '<App/>',
  components: {App}
})
axios.interceptors.response.use(
  response => {
    if (-999 == response.data) {//无权限的
      myVue.$store.dispatch('LogOut').then(() => {
        location.reload()// 为了重新实例化vue-router对象 避免bug
      })
    }
    return response
  },
  error => {
    if (error.response) {

    }
    return Promise.reject(error.response.data)
  });



