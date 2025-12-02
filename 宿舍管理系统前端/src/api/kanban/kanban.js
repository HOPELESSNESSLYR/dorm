import request from '@/utils/request'

// 查询kb列表
export function listKanban(query) {
  return request({
    url: '/kanban/kanban/list',
    method: 'get',
    params: query
  })
}

// 查询kb详细
export function getKanban(kbid) {
  return request({
    url: '/kanban/kanban/' + kbid,
    method: 'get'
  })
}

// 新增kb
export function addKanban(data) {
  return request({
    url: '/kanban/kanban',
    method: 'post',
    data: data
  })
}

// 修改kb
export function updateKanban(data) {
  return request({
    url: '/kanban/kanban',
    method: 'put',
    data: data
  })
}

// 删除kb
export function delKanban(kbid) {
  return request({
    url: '/kanban/kanban/' + kbid,
    method: 'delete'
  })
}
