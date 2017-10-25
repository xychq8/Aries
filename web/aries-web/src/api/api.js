import axios from 'axios';

const host_addr = 'http://10.234.138.194:8082/api'
//const host_addr = 'http://localhost:8082/api'


export let login = params => { return axios.post(host_addr + `/login`, params).then(res => res.data).catch(function(thrown){alert('服务繁忙!')});};

export let getMenu = id => { return axios.get(host_addr + `/menu`).then(res => res.data).catch(function(thrown){alert('服务繁忙!')});};

export let getUser = id => { return axios.get(host_addr + `/user`).then(res => res.data).catch(function(thrown){alert('服务繁忙!')});};

export let updateUser = param => { return axios.post(host_addr + `/user/update`,param).then(res => res.data).catch(function(thrown){alert('服务繁忙!')});};

export let getRoles = id => { return axios.get(host_addr + `/role/sub`).then(res => res.data).catch(function(thrown){alert('服务繁忙!')});};

export let getUserMenu = id => { return axios.get(host_addr + `/menu/ur/`+ id).then(res => res.data).catch(function(thrown){alert('服务繁忙!')});};

export let saveMenuRole = params => { return axios.post(host_addr + `/menu/menuRole`, params).then(res => res.data).catch(function(thrown){alert('服务繁忙!')});};

export let getSchedule = params => { return axios.get(host_addr + `/data/schedule`+ params).then(res => res.data).catch(function(thrown){alert('服务繁忙!')});};

export let getConsume = uuid => { return axios.get(host_addr + `/data/consume/`+ uuid).then(res => res.data).catch(function(thrown){alert('服务繁忙!')});};

export let getConsumeByDay = (uuid,day) => { return axios.get(host_addr + `/data/consume/`+ uuid + "/" + day).then(res => res.data).catch(function(thrown){alert('服务繁忙!')});};