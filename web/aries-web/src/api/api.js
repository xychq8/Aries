import axios from 'axios';

const host_addr = 'http://10.234.138.164:8082/api'
//const host_addr = 'http://localhost:8082/api'

export let getIcon = () => { return axios.get(`/static/icon.json`).then(res => res).catch(function(thrown){});};

export let login = params => { return axios.post(host_addr + `/login`, params).then(res => res.data).catch(function(thrown){});};

export let getMenu = id => { return axios.get(host_addr + `/menu`).then(res => res.data).catch(function(thrown){});};

export let getUser = id => { return axios.get(host_addr + `/user`).then(res => res.data).catch(function(thrown){});};

export let updateUser = param => { return axios.post(host_addr + `/user/update`,param).then(res => res.data).catch(function(thrown){});};

export let getRoles = id => { return axios.get(host_addr + `/role/sub`).then(res => res.data).catch(function(thrown){});};

export let getUserMenu = id => { return axios.get(host_addr + `/menu/ur/`+ id).then(res => res.data).catch(function(thrown){});};

export let saveMenuRole = params => { return axios.post(host_addr + `/menu/menuRole`, params).then(res => res.data).catch(function(thrown){});};

export let getSchedule = params => { return axios.get(host_addr + `/data/schedule`+ params).then(res => res.data).catch(function(thrown){});};

export let getConsume = uuid => { return axios.get(host_addr + `/data/consume/`+ uuid).then(res => res.data).catch(function(thrown){});};

export let getConsumeByDay = (uuid,day) => { return axios.get(host_addr + `/data/consume/`+ uuid + "/" + day).then(res => res.data).catch(function(thrown){});};

export let getPosition = (uuid) => { return axios.get(host_addr + `/data/position/uuid/`+ uuid ).then(res => res.data).catch(function(thrown){});};

export let getPositionInfo = (param) => { return axios.post(host_addr + `/data/position/info`,param).then(res => res.data).catch(function(thrown){});};

export let getContext = (uuid) => { return axios.get(host_addr + `/data/context/all/`+ uuid ).then(res => res.data).catch(function(thrown){});};

export let getIndex = () => { return axios.get(host_addr + `/data/warning/indexes` ).then(res => res.data).catch(function(thrown){});};

export let getToken = () => { return host_addr }

