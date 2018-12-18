// module.exports = file => require('@/views/' + file + '.vue').default // vue-loader at least v13.0.0+
module.exports = file => () => import('@/views/' + file + '.vue') //wxl避免菜单不存在报错
