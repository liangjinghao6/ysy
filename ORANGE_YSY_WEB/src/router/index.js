import Vue from 'vue'
import Router from 'vue-router'

const _import = require('./_import_' + process.env.NODE_ENV)
// in development-env not use lazy-loading, because lazy-loading too many pages
// will cause webpack hot update too slow. so only in production use
// lazy-loading;
// detail: https://panjiachen.github.io/vue-element-admin-site/#/lazy-loading

Vue.use(Router)

/* Layout */
import Layout from '../views/layout/Layout'

/**
 * hidden: true if `hidden:true` will not show in the sidebar(default is false)
 * redirect: noredirect if `redirect:noredirect` will no redirct in the
 * breadcrumb name:'router-name' the name is used by <keep-alive> (must set!!!)
 * meta : { role: ['admin','editor'] will control the page role (you can set
 * multiple roles) title: 'title' the name show in submenu and breadcrumb
 * (recommend set) icon: 'svg-name' the icon show in the sidebar, noCache: true
 * if fasle ,the page will no be cached(default is false) }
 */
export const constantRouterMap = [
  {path: '/login', component: _import('login/index'), hidden: true},
  {path: '/authredirect', component: _import('login/authredirect'), hidden: true},
  {path: '/404', component: _import('errorPage/404'), hidden: true},
  {path: '/401', component: _import('errorPage/401'), hidden: true},
  {
    path: '',
    component: Layout,
    redirect: 'dashboard',
    children: [{
      path: 'dashboard',
      component: _import('dashboard/index'),
      name: '首页',
      meta: {title: '首页', icon: 'dashboard', noCache: true}
    }]
  }
]

export default new Router({
  // mode: 'history', //后端支持可开
  scrollBehavior: () => ({y: 0}),
  routes: constantRouterMap
})

export const asyncRouterMap = [
  {
    path: '/user',
    component: Layout,
    redirect: '/user',

    children: [{
      path: 'index',
      component: _import('user/index'),
      name: '用户管理',
      meta: {
        title: '用户管理',
        icon: 'user',
        keepAlive: true
      }
    }]
  },
  {
    path: '/data',
    component: Layout,
    meta: {title: '数据管理', icon: 'table'},
    children: [{
      path: 'index',
      component: _import('data/source/index'),
      name: '数据源管理',
      meta: {title: '数据源管理', icon: 'table'}
    }]
  },
  {
    path: '/edi',
    component: Layout,
    redirect: '/edi',
    meta: {
      title: '报文模板管理',
      icon: 'form',
      role: ['admin']
    },
    children: [{
      path: 'type',
      component: _import('edi/type/index'),
      name: '报文类型管理',
      meta: {
        title: '报文类型管理',
        role: ['admin']
      }
    }, {
      path: 'source',
      component: _import('edi/source/index'),
      name: '报文来源管理',
      meta: {
        title: '报文来源管理',
        role: ['admin']
      }
    }, {
      path: 'tmp',
      component: _import('edi/tmp/index'),
      name: '报文模板管理',
      meta: {
        title: '报文模板管理',
        role: ['admin']
      }
    },{
      path: 'file',
      component: _import('edi/report/index'),
      name: '文件测试',
      meta: {
        title: '文件测试',
        role: ['admin']
      }
    }]
  },
  {
    path: '/column',
    component: Layout,
    redirect: '/column',
    meta: {
      title: '报文配置管理',
      icon: 'clipboard',
      role: ['admin']
    },
    children: [{
      path: 'unfixed',
      component: _import('column/unfixed/index'),
      name: '不定长报文配置',
      meta: {title: '不定长报文配置'}
    }, {
      path: 'fixed',
      component: _import('column/fixed/index'),
      name: '定长报文配置',
      meta: {title: '定长报文配置'}
    }, {
      path: 'xml',
      component: _import('column/xml/index'),
      name: 'xml报文配置',
      meta: {title: 'xml报文配置'}
    }, {
      path: 'excel',
      component: _import('column/excel/index'),
      name: 'excel报文配置',
      meta: {title: 'excel报文配置'}
    }, {
      path: 'data',
      component: _import('column/data/index'),
      name: '数据源报文配置',
      meta: {title: '数据源报文配置'}
    }, {
      path: 'custom',
      component: _import('column/custom/index'),
      name: '自定义报文配置',
      meta: {title: '自定义报文配置'}
    }]
  },

  {
    path: '/lnk',
    component: Layout,
    meta: {title: '报文映射管理', icon: 'component'},
    children: [{
      path: 'template',
      component: _import('lnk/template/index'),
      name: '报文模板映射管理',
      meta: {title: '报文模板映射管理'}
    }, {
      path: 'column',
      component: _import('lnk/column/index'),
      name: '报文字段映射管理',
      meta: {title: '报文字段映射管理'}
    }]
  },
  {
    path: '/task',
    component: Layout,
    meta: {title: '定时任务管理'},
    children: [{
      path: 'task',
      component: _import('task/task/index'),
      name: '定时任务管理',
      meta: {title: '定时任务管理', icon: 'email'}
    }]
  },
  {
    path: '/log',
    component: Layout,
    children: [{
      path: 'index',
      component: _import('log/index'),
      name: '日志管理',
      meta: {title: '日志管理', icon: 'documentation', noCache: true}
    }]
  },
  {
    path: '/coder',
    component: Layout,
    children: [{
      path: 'help',
      component: _import('coder/help'),
      name: 'GetStart',
      meta: {title: 'GetStart', icon: 'icon', noCache: true}
    }]
  },
  //
  // {
  // path: '/example',
  // component: Layout,
  // redirect: '/example/table/complex-table',
  // name: 'example',
  // meta: {
  // title: 'example',
  // icon: 'example'
  // }
  // },
  //
  // {
  // path: '/form',
  // component: Layout,
  // redirect: 'noredirect',
  // name: 'form',
  // meta: {
  // title: 'form',
  // icon: 'form'
  // },
  // children: [
  // { path: 'create-form', component: _import('form/create'), name:
  // 'createForm', meta: { title: 'createForm', icon: 'table' }},
  // { path: 'edit-form', component: _import('form/edit'), name: 'editForm',
  // meta: { title: 'editForm', icon: 'table' }}
  // ]
  // },
  //
  // {
  // path: '/error',
  // component: Layout,
  // redirect: 'noredirect',
  // name: 'errorPages',
  // meta: {
  // title: 'errorPages',
  // icon: '404'
  // },
  // children: [
  // { path: '401', component: _import('errorPage/401'), name: 'page401',
  // meta: { title: 'page401', noCache: true }},
  // { path: '404', component: _import('errorPage/404'), name: 'page404',
  // meta: { title: 'page404', noCache: true }}
  // ]
  // },
  //
  // {
  // path: '/error-log',
  // component: Layout,
  // redirect: 'noredirect',
  // children: [{ path: 'log', component: _import('errorLog/index'), name:
  // 'errorLog', meta: { title: 'errorLog', icon: 'bug' }}]
  // },
  //
  // {
  // path: '/excel',
  // component: Layout,
  // redirect: '/excel/export-excel',
  // name: 'excel',
  // meta: {
  // title: 'excel',
  // icon: 'excel'
  // },
  // children: [
  // { path: 'export-excel', component: _import('excel/exportExcel'), name:
  // 'exportExcel', meta: { title: 'exportExcel' }},
  // { path: 'export-selected-excel', component: _import('excel/selectExcel'),
  // name: 'selectExcel', meta: { title: 'selectExcel' }},
  // { path: 'upload-excel', component: _import('excel/uploadExcel'), name:
  // 'uploadExcel', meta: { title: 'uploadExcel' }}
  // ]
  // },
  //
  // {
  // path: '/zip',
  // component: Layout,
  // redirect: '/zip/download',
  // children: [{ path: 'download', component: _import('zip/index'), name:
  // 'exportZip', meta: { title: 'exportZip', icon: 'zip' }}]
  // },
  //
  // {
  // path: '/theme',
  // component: Layout,
  // redirect: 'noredirect',
  // children: [{ path: 'index', component: _import('theme/index'), name:
  // 'theme', meta: { title: 'theme', icon: 'theme' }}]
  // },
  //
  // {
  // path: '/clipboard',
  // component: Layout,
  // redirect: 'noredirect',
  // children: [{ path: 'index', component: _import('clipboard/index'), name:
  // 'clipboardDemo', meta: { title: 'clipboardDemo', icon: 'clipboard' }}]
  // },
  //
  // {
  // path: '/i18n',
  // component: Layout,
  // children: [{ path: 'index', component: _import('i18n-demo/index'), name:
  // 'i18n', meta: { title: 'i18n', icon: 'international' }}]
  // },

  {path: '*', redirect: '/404', hidden: true}
]
