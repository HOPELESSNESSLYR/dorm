import request from '@/utils/request'

// 查询房间水电记录列表
export function listHydropower(query) {
  return request({
    url: '/feemanage/hydropower/list',
    method: 'get',
    params: query
  })
}

// 查询房间水电记录详细
export function getHydropower(id) {
  return request({
    url: '/feemanage/hydropower/' + id,
    method: 'get'
  })
}

// 新增房间水电记录
export function addHydropower(data) {
  return request({
    url: '/feemanage/hydropower',
    method: 'post',
    data: data
  })
}

// 修改房间水电记录
export function updateHydropower(data) {
  return request({
    url: '/feemanage/hydropower',
    method: 'put',
    data: data
  })
}

// 删除房间水电记录
export function delHydropower(id) {
  return request({
    url: '/feemanage/hydropower/' + id,
    method: 'delete'
  })
}
