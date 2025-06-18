import request from '@/utils/request'

// 查询登记入住人员列表
export function listOnlivepeople(query) {
  return request({
    url: '/dorm/onlivepeople/list',
    method: 'get',
    params: query
  })
}

// 查询登记入住人员详细
export function getOnlivepeople(id) {
  return request({
    url: '/dorm/onlivepeople/' + id,
    method: 'get'
  })
}

// 新增登记入住人员
export function addOnlivepeople(data) {
  return request({
    url: '/dorm/onlivepeople',
    method: 'post',
    data: data
  })
}

// 修改登记入住人员
export function updateOnlivepeople(data) {
  return request({
    url: '/dorm/onlivepeople',
    method: 'put',
    data: data
  })
}

// 删除登记入住人员
export function delOnlivepeople(id) {
  return request({
    url: '/dorm/onlivepeople/' + id,
    method: 'delete'
  })
}
