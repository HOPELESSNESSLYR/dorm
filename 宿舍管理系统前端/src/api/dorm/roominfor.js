import request from '@/utils/request'

// 查询房间信息列表
export function listRoominfor(query) {
  return request({
    url: '/dorm/roominfor/list',
    method: 'get',
    params: query
  })
}

// 查询房间信息详细
export function getRoominfor(id) {
  return request({
    url: '/dorm/roominfor/' + id,
    method: 'get'
  })
}

// 新增房间信息
export function addRoominfor(data) {
  return request({
    url: '/dorm/roominfor',
    method: 'post',
    data: data
  })
}

// 修改房间信息
export function updateRoominfor(data) {
  return request({
    url: '/dorm/roominfor',
    method: 'put',
    data: data
  })
}

// 删除房间信息
export function delRoominfor(id) {
  return request({
    url: '/dorm/roominfor/' + id,
    method: 'delete'
  })
}
// 入住人员确认
export function ruzhuConfirm(data) {
  return request({
    url: '/dorm/roominfor/ruzhuConfirm/',
    method: 'post',
    data: data
  })
}
//获得空余床位
export function getkongbed(data) {
  return request({
    url: '/dorm/roominfor/getkongbed/',
    method: 'post',
    data: data
  })
}
// 调换确认
export function diaohuanConfirm(data) {
  return request({
    url: '/dorm/roominfor/diaohuanConfirm/',
    method: 'post',
    data: data
  })
}
// 退宿确认
export function tuisuConfirm(data) {
  return request({
    url: '/dorm/roominfor/tuisuConfirm/',
    method: 'post',
    data: data
  })
}
// 请假出差确认
export function qingjiachuchaiConfirm(data) {
  return request({
    url: '/dorm/roominfor/qingjiachuchaiConfirm/',
    method: 'post',
    data: data
  })
}
//查询宿舍楼名称
export function getFloorName() {
  return request({
    url: '/dorm/roominfor/getFloorName/',
    method: 'get'
  })
}
//查询宿舍楼层
export function getFloor() {
  return request({
    url: '/dorm/roominfor/getFloor/',
    method: 'get'
  })
}
//查询房间号
export function getRoomNumber() {
  return request({
    url: '/dorm/roominfor/getRoomNumber/',
    method: 'get'
  })
}
//查询已住人员
export function getlivingpeople(data) {
  return request({
    url: '/dorm/roominfor/getlivingpeople/',
    method: 'post',
    data:data
  })
}
// 查询人员信息详细
export function getLivepeople2(IDnumber) {
  return request({
    url: '/dorm/roominfor/getLivepeople2/' + IDnumber,
    method: 'get'
  })
}
// 查询人员物品信息详细
export function getarticleDescription(IDnumber) {
  return request({
    url: '/dorm/roominfor/getarticleDescription/' + IDnumber,
    method: 'get'
  })
}

// 批量修改房间信息
export function batchUpdateRoominfor(data) {
  return request({
    url: '/dorm/roominfor/batchUpdate',
    method: 'put',
    data: data
  })
}



