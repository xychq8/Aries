import axios from 'axios';

const host_addr = 'http://123.56.14.172:8082/api'



export let login = params => { return axios.post(host_addr + `/login`, params).then(res => res.data).catch(function(thrown){alert('服务繁忙!')});};


export let getMenu = id => { return axios.get(host_addr + `/menu/roleId/`+id).then(res => res.data).catch(function(thrown){alert('服务繁忙!')});};