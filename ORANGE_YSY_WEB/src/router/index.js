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
    meta: {title: '会员管理', icon: 'table'},

    children: [{
      path: 'index',
      component: _import('user/list/index'),
      name: '用户管理',
      meta: {
        title: '用户管理',
        icon: 'user',
        keepAlive: true
      }
    }]
  },
  {
    path: '/goods',
    component: Layout,
    meta: {title: '商品管理', icon: 'table'},
    children: [{
      path: 'list',
      component: _import('goods/list/index'),
      name: '商品列表',
      meta: {title: '商品列表', icon: 'table'}
    }, {
      path: 'category',
      component: _import('goods/category/index'),
      name: '商品分类',
      meta: {title: '商品分类', icon: 'table'}
    }, {
      path: 'feature',
      component: _import('goods/feature/index'),
      name: '商品特征',
      meta: {title: '商品特征', icon: 'table'}
    }, {
      path: 'class',
      component: _import('goods/class/index'),
      name: '商品类别',
      meta: {title: '商品类别', icon: 'table'}
    }, {
      path: 'brand',
      component: _import('goods/brand/index'),
      name: '品牌管理',
      meta: {title: '品牌管理', icon: 'table'}
    }, {
      path: 'rules',
      component: _import('goods/rules/index'),
      name: '销售规则',
      meta: {title: '销售规则', icon: 'table'}
    }, {
      path: 'comment',
      component: _import('goods/comment/index'),
      name: '评论管理',
      meta: {title: '评论管理', icon: 'table'}
    }, {
      path: 'star',
      component: _import('goods/star/index'),
      name: '收藏浏览',
      meta: {title: '收藏浏览', icon: 'table'}
    }]
  },
  {
    path: '/order',
    component: Layout,
    meta: {title: '订单管理', icon: 'form'},
    children: [{
      path: 'list',
      component: _import('order/list/index'),
      name: '订单列表',
      meta: {
        title: '订单列表',
      }
    }, {
      path: 'address',
      component: _import('order/address/index'),
      name: '地址管理',
      meta: {
        title: '地址管理',
      }
    }]
  },
  {
    path: '/inventory',
    component: Layout,
    meta: {
      title: '库存管理',
      icon: 'clipboard',
    },
    children: [{
      path: 'list',
      component: _import('inventory/list/index'),
      name: '库存列表',
      meta: {title: '库存列表'}
    }, {
      path: 'invoice',
      component: _import('inventory/invoice/index'),
      name: '发货单',
      meta: {title: '发货单'}
    }]
  },

  {
    path: '/back',
    component: Layout,
    meta: {title: '退换货管理', icon: 'component'},
    children: [{
      path: 'list',
      component: _import('back/list/index'),
      name: '退换货管理',
      meta: {title: '退换货管理', icon: 'component'}
    }]
  },
  {
    path: '/score',
    component: Layout,
    meta: {title: '积分管理', icon: 'email'},
    children: [{
      path: 'list',
      component: _import('score/list/index'),
      name: '积分列表',
      meta: {title: '定时任务管理'}
    }, {
      path: 'exchange',
      component: _import('score/exchange/index'),
      name: '兑换申请',
      meta: {title: '定时任务管理'}
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
  }
]
