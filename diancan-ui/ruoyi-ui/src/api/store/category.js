import request from '@/utils/request'

// 查询菜品类别列表
export function listCategory(query) {
  return request({
    url: '/store/category/list',
    method: 'get',
    params: query
  })
}

// 查询菜品类别详细
export function getCategory(id) {
  return request({
    url: '/store/category/' + id,
    method: 'get'
  })
}

// 新增菜品类别
export function addCategory(data) {
  return request({
    url: '/store/category',
    method: 'post',
    data: data
  })
}

// 修改菜品类别
export function updateCategory(data) {
  return request({
    url: '/store/category',
    method: 'put',
    data: data
  })
}

// 删除菜品类别
export function delCategory(id) {
  return request({
    url: '/store/category/' + id,
    method: 'delete'
  })
}

// 导出菜品类别
export function exportCategory(query) {
  return request({
    url: '/store/category/export',
    method: 'get',
    params: query
  })
}