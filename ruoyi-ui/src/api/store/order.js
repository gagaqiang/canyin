import request from '@/utils/request'

// 查询订单列表
export function listOrder(query) {
  return request({
    url: '/store/order/list',
    method: 'get',
    params: query
  })
}

// 查询订单详细
export function getOrder(id) {
  return request({
    url: '/store/order/' + id,
    method: 'get'
  })
}

// 新增订单
export function addOrder(data) {
  return request({
    url: '/store/order',
    method: 'post',
    data: data
  })
}

// 修改订单
export function updateOrder(data) {
  return request({
    url: '/store/order',
    method: 'put',
    data: data
  })
}

// 删除订单
export function delOrder(id) {
  return request({
    url: '/store/order/' + id,
    method: 'delete'
  })
}

// 导出订单
export function exportOrder(query) {
  return request({
    url: '/store/order/export',
    method: 'get',
    params: query
  })
}

// 修改订单
export function jiezhangOrder(id) {
  return request({
    url: '/store/order/updateOrderStatus?orderId='+id,
    method: 'post',
  })
}
