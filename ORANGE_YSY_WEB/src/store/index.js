import Vue from 'vue'
import Vuex from 'vuex'
import app from './modules/app'
import operator from './modules/operator'
import permission from './modules/permission'
import getters from './getters'

Vue.use(Vuex)

const store = new Vuex.Store({
  modules: {
    app,
    operator,
    permission
  },
  getters
})

export default store
