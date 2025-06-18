import request from '@/utils/request'

// 查询宿舍楼信息列表
export function listManage(query) {
  return request({
    url: '/dorm/manage/list',
    method: 'get',
    params: query
  })
}

// 查询宿舍楼信息详细
export function getManage(id) {
  return request({
    url: '/dorm/manage/' + id,
    method: 'get'
  })
}

// 新增宿舍楼信息
export function addManage(data) {
  return request({
    url: '/dorm/manage',
    method: 'post',
    data: data
  })
}

// 修改宿舍楼信息
export function updateManage(data) {
  return request({
    url: '/dorm/manage',
    method: 'put',
    data: data
  })
}

// 删除宿舍楼信息
export function delManage(id) {
  return request({
    url: '/dorm/manage/' + id,
    method: 'delete'
  })
}
