import request from '@/utils/request'

// 查询菜品列表
export function listDishes(query) {
  return request({
    url: '/store/dishes/list',
    method: 'get',
    params: query
  })
}

// 查询菜品详细
export function getDishes(id) {
  return request({
    url: '/store/dishes/' + id,
    method: 'get'
  })
}

// 新增菜品
export function addDishes(data) {
  return request({
    url: '/store/dishes',
    method: 'post',
    data: data
  })
}

// 修改菜品
export function updateDishes(data) {
  return request({
    url: '/store/dishes',
    method: 'put',
    data: data
  })
}

// 删除菜品
export function delDishes(id) {
  return request({
    url: '/store/dishes/' + id,
    method: 'delete'
  })
}

// 导出菜品
export function exportDishes(query) {
  return request({
    url: '/store/dishes/export',
    method: 'get',
    params: query
  })

}

// 菜品类别
export function categoryLists(query) {
  return request({
    url: '/store/category/list',
    method: 'get',
  })
}

// 变更状态菜品
export function updateDisheStatus(id) {
  return request({
    url: '/store/dishes/updateDisheStatus/' + id,
    method: 'post'
  })
}

