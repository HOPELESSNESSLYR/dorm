import request from '@/utils/request'

// 查询个人物品列表
export function listArticle(query) {
  return request({
    url: '/dorm/article/list',
    method: 'get',
    params: query
  })
}

// 查询个人物品详细
export function getArticle(id) {
  return request({
    url: '/dorm/article/' + id,
    method: 'get'
  })
}

// 新增个人物品
export function addArticle(data) {
  return request({
    url: '/dorm/article',
    method: 'post',
    data: data
  })
}

// 修改个人物品
export function updateArticle(data) {
  return request({
    url: '/dorm/article',
    method: 'put',
    data: data
  })
}

// 删除个人物品
export function delArticle(id) {
  return request({
    url: '/dorm/article/' + id,
    method: 'delete'
  })
}
