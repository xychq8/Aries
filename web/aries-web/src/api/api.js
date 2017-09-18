import axios from 'axios';

const host_addr = 'http://123.56.14.172:8082/api'
// const host_addr = 'http://localhost:8082/api'

export let login = params => { return axios.post(host_addr + `/login`, params).then(res => res.data).catch(function(thrown){alert('服务繁忙!')});};

export let getMenu = id => { return axios.get(host_addr + `/menu`).then(res => res.data).catch(function(thrown){alert('服务繁忙!')});};

export let getUser = id => { return axios.get(host_addr + `/user`).then(res => res.data).catch(function(thrown){alert('服务繁忙!')});};

export let updateUser = param => { return axios.post(host_addr + `/user/update`,param).then(res => res.data).catch(function(thrown){alert('服务繁忙!')});};

export let getRoles = id => { return axios.get(host_addr + `/role/sub`).then(res => res.data).catch(function(thrown){alert('服务繁忙!')});};

export let getUserMenu = id => { return axios.get(host_addr + `/menu/ur/`+ id).then(res => res.data).catch(function(thrown){alert('服务繁忙!')});};

export let saveMenuRole = params => { return axios.post(host_addr + `/api/menu/menuRole`, params).then(res => res.data).catch(function(thrown){alert('服务繁忙!')});};