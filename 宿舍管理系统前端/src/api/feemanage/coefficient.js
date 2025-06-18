import request from '@/utils/request'

// 查询每人天公摊费用列表
export function listCoefficient(query) {
  return request({
    url: '/feemanage/coefficient/list',
    method: 'get',
    params: query
  })
}

// 查询每人天公摊费用详细
export function getCoefficient(id) {
  return request({
    url: '/feemanage/coefficient/' + id,
    method: 'get'
  })
}

// 新增每人天公摊费用
export function addCoefficient(data) {
  return request({
    url: '/feemanage/coefficient',
    method: 'post',
    data: data
  })
}

// 修改每人天公摊费用
export function updateCoefficient(data) {
  return request({
    url: '/feemanage/coefficient',
    method: 'put',
    data: data
  })
}

// 删除每人天公摊费用
export function delCoefficient(id) {
  return request({
    url: '/feemanage/coefficient/' + id,
    method: 'delete'
  })
}
