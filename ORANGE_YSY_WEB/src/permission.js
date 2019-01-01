import router from './router'
import store from './store'
import NProgress from 'nprogress' // Progress 进度条
import 'nprogress/nprogress.css'// Progress 进度条样式
import {getToken} from '@/utils/auth' // 验权
import axios from 'axios'
import {Message} from 'element-ui'

// permissiom judge
function hasPermission(roles, permissionRoles) {
  // console.debug(roles)
  // console.debug(permissionRoles)
  // return true
  // if (roles.indexOf('admin') >= 0) return true // admin权限 直接通过
  // if (!permissionRoles) return true
  // return roles.some(role => permissionRoles.indexOf(role) >= 0)
}

const whiteList = ['/login', '/authredirect']// 不重定向白名单

router.beforeEach((to, from, next) => {
  NProgress.start() // 开启Progress
  if(!getToken()) {// 判断是否有token
    if (whiteList.indexOf(to.path) !== -1) { // 在免登录白名单，直接进入
      next()
    } else {
      next('/login') // 否则全部重定向到登录页

    }
  } else if(store.state.operator.operatorId) {
    next();
  } else {
    axios.get(`/iweb/token/login?token=${getToken()}`).then(response => {
      if (response.data.status) {
        store.dispatch('saveData2Token', response.data.result).then(() => {
          store.dispatch('GenerateRoutes', {}).then(() => {// 获取菜单
            let myr = store.getters.addRouters
            router.addRoutes(myr); // 动态添加可访问路由表
            let routerFilter = [];
            for (let i = 0; i < myr.length; i++) {
              if (!myr[i].children) {
                continue;
              }
              let r = myr[i].children.filter(k => {
                return k.path == to.path
              });
              if (r.length > 0) {
                console.log(JSON.stringify(r))
                routerFilter = r;
                break;
              }
            }
            if (routerFilter.length == 0 || !routerFilter[0].name) {
              next({path: '/'})
            } else {
              next({name: routerFilter[0].name})
            }
          })
        })
      } else {
        store.dispatch('FedLogOut').then(() => {
          Message.error(response.data.message)
          next({path: '/login'})
        })
      }
    })
  }
  NProgress.done() // router在hash模式下 手动改变hash 重定向回来 不会触发afterEach 暂时hack方案 ps：history模式下无问题，可删除该行！
})

router.afterEach(() => {
  NProgress.done() // 结束Progress
})
