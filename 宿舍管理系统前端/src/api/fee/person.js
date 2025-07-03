import request from '@/utils/request'

// 查询个人费用列表
export function listPerson(query) {
  return request({
    url: '/fee/person/list',
    method: 'get',
    params: query
  })
}

// 查询个人费用详细
export function getPerson(feepersonId) {
  return request({
    url: '/fee/person/' + feepersonId,
    method: 'get'
  })
}

// 新增个人费用
export function addPerson(data) {
  return request({
    url: '/fee/person',
    method: 'post',
    data: data
  })
}

// 修改个人费用
export function updatePerson(data) {
  return request({
    url: '/fee/person',
    method: 'put',
    data: data
  })
}

// 删除个人费用
export function delPerson(feepersonId) {
  return request({
    url: '/fee/person/' + feepersonId,
    method: 'delete'
  })
}
