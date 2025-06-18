import request from '@/utils/request'

// 查询柜子信息列表
export function listWardrobe(query) {
  return request({
    url: '/dorm/wardrobe/list',
    method: 'get',
    params: query
  })
}

// 查询柜子信息详细
export function getWardrobe(id) {
  return request({
    url: '/dorm/wardrobe/' + id,
    method: 'get'
  })
}

// 新增柜子信息
export function addWardrobe(data) {
  return request({
    url: '/dorm/wardrobe',
    method: 'post',
    data: data
  })
}

// 修改柜子信息
export function updateWardrobe(data) {
  return request({
    url: '/dorm/wardrobe',
    method: 'put',
    data: data
  })
}

// 删除柜子信息
export function delWardrobe(id) {
  return request({
    url: '/dorm/wardrobe/' + id,
    method: 'delete'
  })
}
