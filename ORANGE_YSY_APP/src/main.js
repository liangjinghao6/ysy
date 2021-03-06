import Vue from 'vue'
import store from '@/store'
import App from '@/App'
import MpvueRouterPatch from 'mpvue-router-patch'

Vue.prototype.$imgPrintUrl = 'http://39.96.38.93:8880/file/print/'
Vue.config.productionTip = false
Vue.use(MpvueRouterPatch)
const app = new Vue({
  store,
  ...App
})
app.$mount()

export default {
  // 这个字段走 app.json
  config: {
    pages: [
      'pages/index/index',
      'pages/topic/topic',
      'pages/catalog/catalog',
      'pages/cart/cart',
      'pages/ucenter/index'
    ], // Will be filled in webpack
    window: {
      backgroundTextStyle: 'dark',
      navigationBarBackgroundColor: '#fff',
      navigationBarTitleText: '小颜商城',
      navigationBarTextStyle: 'black',
      'enablePullDownRefresh': true
    },
    tabBar: {
      'backgroundColor': '#fafafa',
      'borderStyle': 'white',
      'selectedColor': '#b4282d',
      'color': '#666',
      'list': [{
        'pagePath': 'pages/index/index',
        'iconPath': 'static/images/ic_menu_choice_nor.png',
        'selectedIconPath': 'static/images/ic_menu_choice_pressed.png',
        'text': '首页'
      },
      {
        'pagePath': 'pages/topic/topic',
        'iconPath': 'static/images/ic_menu_topic_nor.png',
        'selectedIconPath': 'static/images/ic_menu_topic_pressed.png',
        'text': '会员'
      },
      {
        'pagePath': 'pages/cart/cart',
        'iconPath': 'static/images/ic_menu_shoping_nor.png',
        'selectedIconPath': 'static/images/ic_menu_shoping_pressed.png',
        'text': '购物车'
      },
      {
        'pagePath': 'pages/ucenter/index',
        'iconPath': 'static/images/ic_menu_me_nor.png',
        'selectedIconPath': 'static/images/ic_menu_me_pressed.png',
        'text': '我的'
      }
      ]
    }
  },
  'networkTimeout': {
    'request': 10000,
    'downloadFile': 10000
  },
  'debug': true
}
