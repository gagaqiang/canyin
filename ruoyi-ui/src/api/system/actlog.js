import request from '@/utils/request'

// 查询流程日志列表
export function listActlog(query) {
  return request({
    url: '/system/actlog/list',
    method: 'get',
    params: query
  })
}

// 查询流程日志详细
export function getActlog(logNr) {
  return request({
    url: '/system/actlog/' + logNr,
    method: 'get'
  })
}

// 新增流程日志
export function addActlog(data) {
  return request({
    url: '/system/actlog',
    method: 'post',
    data: data
  })
}

// 修改流程日志
export function updateActlog(data) {
  return request({
    url: '/system/actlog',
    method: 'put',
    data: data
  })
}

// 删除流程日志
export function delActlog(logNr) {
  return request({
    url: '/system/actlog/' + logNr,
    method: 'delete'
  })
}

// 导出流程日志
export function exportActlog(query) {
  return request({
    url: '/system/actlog/export',
    method: 'get',
    params: query
  })
}