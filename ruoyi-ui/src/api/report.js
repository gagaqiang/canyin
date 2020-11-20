import request from '@/utils/request'

// 查询菜品类别列表
export function getOrderPriceReport() {
  return request({
    url: '/store/report/getOrderPriceReport',
    method: 'get',
  })
}
