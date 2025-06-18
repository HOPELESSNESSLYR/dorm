import request from '@/utils/request'

// 查询宿舍固定资产列表
export function listFixedassets(query) {
  return request({
    url: '/feemanage/fixedassets/list',
    method: 'get',
    params: query
  })
}

// 查询宿舍固定资产详细
export function getFixedassets(id) {
  return request({
    url: '/feemanage/fixedassets/' + id,
    method: 'get'
  })
}

// 新增宿舍固定资产
export function addFixedassets(data) {
  return request({
    url: '/feemanage/fixedassets',
    method: 'post',
    data: data
  })
}

// 修改宿舍固定资产
export function updateFixedassets(data) {
  return request({
    url: '/feemanage/fixedassets',
    method: 'put',
    data: data
  })
}

// 删除宿舍固定资产
export function delFixedassets(id) {
  return request({
    url: '/feemanage/fixedassets/' + id,
    method: 'delete'
  })
}
