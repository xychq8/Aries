import Vuex from 'vuex'
import Vue from 'vue'
import * as types from './type'

Vue.use(Vuex);

export default new Vuex.Store({
    state: {
        token: null
    },
    mutations: {
        [types.LOGIN]: (state,token) => {
            localStorage.token = token
            state.token = token;
        },
        [types.LOGOUT]: (state) => {
            localStorage.removeItem('token');
            state.token = null
        },
    },
    getters: {
        getToken: state => {
          return localStorage.token
        }
    }
})