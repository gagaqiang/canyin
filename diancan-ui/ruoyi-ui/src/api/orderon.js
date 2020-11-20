import request from '@/utils/request'

// 查询菜品类别列表
export function getcategoryList() {
  return request({
    url: '/store/category/alllist',
    method: 'get',
  })
}

// 类别查询菜品列表
export function getDishesBycateidList(id) {
  return request({
    url: '/store/dishes/getDishesBycateidList/'+id,
    method: 'get',
  })
}

//新增保存
export function addShoping(id) {
  return request({
    url: '/store/order/addShoping/'+id,
    method: 'post',
  })
}

