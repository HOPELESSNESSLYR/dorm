import request from '@/utils/request'

// 查询免扣销假记录列表
export function listOff(query) {
  return request({
    url: '/feemanage/off/list',
    method: 'get',
    params: query
  })
}

// 查询免扣销假记录详细
export function getOff(id) {
  return request({
    url: '/feemanage/off/' + id,
    method: 'get'
  })
}

// 新增免扣销假记录
export function addOff(data) {
  return request({
    url: '/feemanage/off',
    method: 'post',
    data: data
  })
}

// 修改免扣销假记录
export function updateOff(data) {
  return request({
    url: '/feemanage/off',
    method: 'put',
    data: data
  })
}

// 删除免扣销假记录
export function delOff(id) {
  return request({
    url: '/feemanage/off/' + id,
    method: 'delete'
  })
}
