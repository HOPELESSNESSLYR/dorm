import request from '@/utils/request'

// 查询入住调宿退宿申请列表
export function listTune(query) {
  return request({
    url: '/dorm/tune/list',
    method: 'get',
    params: query
  })
}

// 查询入住调宿退宿申请详细
export function getTune(id) {
  return request({
    url: '/dorm/tune/' + id,
    method: 'get'
  })
}

// 新增入住调宿退宿申请
export function addTune(data) {
  return request({
    url: '/dorm/tune',
    method: 'post',
    data: data
  })
}

// 修改入住调宿退宿申请
export function updateTune(data) {
  return request({
    url: '/dorm/tune',
    method: 'put',
    data: data
  })
}

// 删除入住调宿退宿申请
export function delTune(id) {
  return request({
    url: '/dorm/tune/' + id,
    method: 'delete'
  })
}
