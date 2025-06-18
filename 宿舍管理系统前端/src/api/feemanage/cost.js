import request from '@/utils/request'

// 查询个人费用明细列表
export function listCost(query) {
  return request({
    url: '/feemanage/cost/list',
    method: 'get',
    params: query
  })
}

// 查询个人费用明细详细
export function getCost(id) {
  return request({
    url: '/feemanage/cost/' + id,
    method: 'get'
  })
}

// 新增个人费用明细
export function addCost(data) {
  return request({
    url: '/feemanage/cost',
    method: 'post',
    data: data
  })
}

// 修改个人费用明细
export function updateCost(data) {
  return request({
    url: '/feemanage/cost',
    method: 'put',
    data: data
  })
}

// 删除个人费用明细
export function delCost(id) {
  return request({
    url: '/feemanage/cost/' + id,
    method: 'delete'
  })
}
