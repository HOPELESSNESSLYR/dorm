import request from '@/utils/request'

// 查询人员信息列表
export function listLivepeople(query) {
  return request({
    url: '/livepeople/livepeople/list',
    method: 'get',
    params: query
  })
}

// 查询人员信息详细
export function getLivepeople(id) {
  return request({
    url: '/livepeople/livepeople/' + id,
    method: 'get'
  })
}

// 新增人员信息
export function addLivepeople(data) {
  return request({
    url: '/livepeople/livepeople',
    method: 'post',
    data: data
  })
}

// 修改人员信息
export function updateLivepeople(data) {
  return request({
    url: '/livepeople/livepeople',
    method: 'put',
    data: data
  })
}

// 删除人员信息
export function delLivepeople(id) {
  return request({
    url: '/livepeople/livepeople/' + id,
    method: 'delete'
  })
}

// 查询人员信息列表
export function getlistLivepeople() {
  return request({
    url: '/livepeople/livepeople/list2',
    method: 'get'
  })
}
