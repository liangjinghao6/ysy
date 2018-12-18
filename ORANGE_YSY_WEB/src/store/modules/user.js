import {loginByUsername, logout, getUserInfo} from '@/api/login'
import {getToken, setToken, removeToken} from '@/utils/auth'

const user = {
  state: {
    user: '',
    status: '',
    code: '',
    token: getToken(),
    name: '',
    avatar: '',
    introduction: '',
    roles: [],
    setting: {
      articlePlatform: []
    }
  },

  mutations: {
    SET_CODE: (state, code) => {
      state.code = code
    },
    SET_TOKEN: (state, token) => {
      state.token = token
    },
    SET_INTRODUCTION: (state, introduction) => {
      state.introduction = introduction
    },
    SET_SETTING: (state, setting) => {
      state.setting = setting
    },
    SET_STATUS: (state, status) => {
      state.status = status
    },
    SET_NAME: (state, name) => {
      state.name = name
    },
    SET_AVATAR: (state, avatar) => {
      state.avatar = avatar
    },
    SET_ROLES: (state, roles) => {
      state.roles = roles
    }
  },

  actions: {
    // 用户名登录
    LoginByUsername({commit}, userInfo) {
      const account = userInfo.account.trim()
      return new Promise((resolve, reject) => {
        loginByUsername(account, userInfo.password).then(response => {

          const data = response.data;
          if (data.status == false) {
            reject({message: data.description})
            return false;
          }

          setToken(data.result.id)//保留原来写法,不给值,不能登录wxl

          commit('SET_TOKEN', data.result.id)
          commit('SET_NAME', data.result.name)
//          if (data.admin == true) {
//            commit('SET_ROLES', ['admin'])
//          }else{
//            commit('SET_ROLES', ['common'])
//          }

          //右上角图标
          commit('SET_AVATAR', 'https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif')

          resolve()
        }).catch(error => {
          reject(error)
        })
      })
    },

    GetUserInfo({commit, state}) {
        return new Promise((resolve, reject) => {
        	getUserInfo(state.token).then(response => {
            if (!response.data) { // 由于mockjs 不支持自定义状态码只能这样hack
              reject('error')
            }
            const data = response.data
            if(data.status == false) {
            	reject({message : data.description})
            }

            commit('SET_NAME', data.result.name)
         //   if (data.admin == true) {
              commit('SET_ROLES', ['admin'])
          //  }else{
          //    commit('SET_ROLES', ['common'])
          //  }
            //右上角图标
            commit('SET_AVATAR', 'https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif')
            resolve(state)
            // }).catch(error => {
            //   reject(error)
            // })
          })
        })
      },


    // 第三方验证登录
    // LoginByThirdparty({ commit, state }, code) {
    //   return new Promise((resolve, reject) => {
    //     commit('SET_CODE', code)
    //     loginByThirdparty(state.status, state.email, state.code).then(response => {
    //       commit('SET_TOKEN', response.data.token)
    //       setToken(response.data.token)
    //       resolve()
    //     }).catch(error => {
    //       reject(error)
    //     })
    //   })
    // },

    // 登出
    LogOut({commit, state}) {
      return new Promise((resolve, reject) => {
        logout(state.token).then(() => {
          commit('SET_TOKEN', '')
          commit('SET_ROLES', [])
          removeToken()
          resolve()
        }).catch(error => {
          reject(error)
        })
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

export default user
