import request from '@/utils/request'

// 查询桌编码列表
export function listDesk(query) {
  return request({
    url: '/store/desk/list',
    method: 'get',
    params: query
  })
}

// 查询桌编码详细
export function getDesk(id) {
  return request({
    url: '/store/desk/' + id,
    method: 'get'
  })
}

// 新增桌编码
export function addDesk(data) {
  return request({
    url: '/store/desk',
    method: 'post',
    data: data
  })
}

// 修改桌编码
export function updateDesk(data) {
  return request({
    url: '/store/desk',
    method: 'put',
    data: data
  })
}

// 删除桌编码
export function delDesk(id) {
  return request({
    url: '/store/desk/' + id,
    method: 'delete'
  })
}

// 导出桌编码
export function exportDesk(query) {
  return request({
    url: '/store/desk/export',
    method: 'get',
    params: query
  })
}