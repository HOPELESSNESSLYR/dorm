import request from '@/utils/request'

// 查询每月入住天数临时列表
export function listManday(query) {
  return request({
    url: '/feemanage/manday/list',
    method: 'get',
    params: query
  })
}

// 查询每月入住天数临时详细
export function getManday(id) {
  return request({
    url: '/feemanage/manday/' + id,
    method: 'get'
  })
}

// 新增每月入住天数临时
export function addManday(data) {
  return request({
    url: '/feemanage/manday',
    method: 'post',
    data: data
  })
}

// 修改每月入住天数临时
export function updateManday(data) {
  return request({
    url: '/feemanage/manday',
    method: 'put',
    data: data
  })
}

// 删除每月入住天数临时
export function delManday(id) {
  return request({
    url: '/feemanage/manday/' + id,
    method: 'delete'
  })
}
