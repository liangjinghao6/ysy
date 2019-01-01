import {getToken, setToken, removeToken} from '@/utils/auth'

const operator = {
  state: {
    user: '',
    status: '',
    token: getToken(),
    name: '',
    skin: '',
    language: '',
    role: 0
  },

  mutations: {
    SET_OPERATOR: (state, operator) => {
      state.operatorId = operator.operatorId
      state.token = operator.token
      state.name = operator.name
      state.skin = operator.skin
      state.companyId = operator.companyId
      state.language = operator.language
      state.isPwdChange = operator.isPwdChange
    },
  },

  actions: {
    saveToken({commit}, token) {
      return new Promise((resolve, reject) => {
        setToken(token)
        resolve()
      })
    },

    saveData2Token({commit}, operator) {
      return new Promise((resolve, reject) => {
        setToken(operator.token)
        commit('SET_OPERATOR', operator);
        resolve()
      })
    },

    // 登出
    LogOut({commit, state}) {
      return new Promise((resolve, reject) => {
        commit('SET_TOKEN', '')
        commit('SET_ROLES', [])
        removeToken()
        resolve()
      })
    },


    // 前端 登出
    FedLogOut({commit}) {
      return new Promise(resolve => {
        commit('SET_TOKEN', '')
        removeToken()
        resolve()
      })
    }
  }
}

export default operator
