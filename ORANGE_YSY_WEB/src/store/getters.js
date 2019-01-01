const getters = {//getters的作用只是简化写法,不要用了,直接 state.user.orgnId就行,wxl
  sidebar: state => state.app.sidebar,
  language: state => state.operator.language == 0 ? 'zh' : 'en',
  visitedViews: state => state.app.visitedViews,
  cachedViews: state => state.app.cachedViews,
  token: state => state.operator.token,
  name: state => state.operator.name,
  role: state => state.operator.role,
  skin: state => state.operator.skin,
  routers: state => state.permission.routers,
  addRouters: state => state.permission.addRouters,
  companyId: state => state.operator.companyId
}
export default getters
