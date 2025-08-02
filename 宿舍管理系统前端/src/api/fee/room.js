import request from '@/utils/request'

// 查询房间费用列表
export function listRoom(query) {
  return request({
    url: '/fee/room/list',
    method: 'get',
    params: query
  })
}

// 查询房间费用详细
export function getRoom(roomfeeId) {
  return request({
    url: '/fee/room/' + roomfeeId,
    method: 'get'
  })
}

// 新增房间费用
export function addRoom(data) {
  return request({
    url: '/fee/room',
    method: 'post',
    data: data
  })
}

// 修改房间费用
export function updateRoom(data) {
  return request({
    url: '/fee/room',
    method: 'put',
    data: data
  })
}

// 删除房间费用
export function delRoom(roomfeeId) {
  return request({
    url: '/fee/room/' + roomfeeId,
    method: 'delete'
  })
}


// 批量修改房间信息
export function batchUpdateRoom(data) {
  return request({
    url: '/fee/room/batchUpdate',
    method: 'put',
    data: data
  })
}