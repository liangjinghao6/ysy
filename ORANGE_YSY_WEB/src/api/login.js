import fetch from '@/utils/fetch'
import Vue from 'vue'
import axios from 'axios'

export function loginByUsername(account, password) {
  const data = {
    account: account,
    password: password,
  }
  return axios.get('/edi/login', {params: data})
}

export function logout() {
  return axios.get('/edi/logout')
}

export function getUserInfo(id) {
	return axios.get('/edi/user/detail/' + id)
}
