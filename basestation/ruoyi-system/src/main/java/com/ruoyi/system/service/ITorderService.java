package com.ruoyi.system.service;

import com.ruoyi.system.domain.Torder;
import com.ruoyi.system.domain.vo.OrderPriceVo;
import com.ruoyi.system.domain.vo.OrderReqHeaderVo;
import com.ruoyi.system.domain.vo.TorderVo;

import java.util.List;

/**
 * 订单Service接口
 * 
 * @author yihao
 * @date 2020-10-24
 */
public interface ITorderService 
{
    /**
     * 查询订单
     * 
     * @param id 订单ID
     * @return 订单
     */
    public Torder selectTorderById(Integer id);

    /**
     * 查询订单列表
     * 
     * @param torder 订单
     * @return 订单集合
     */
    public List<Torder> selectTorderList(Torder torder);

    /**
     * 新增订单
     * 
     * @param torder 订单
     * @return 结果
     */
    public int insertTorder(Torder torder) throws Exception;

    /**
     * 修改订单
     * 
     * @param torder 订单
     * @return 结果
     */
    public int updateTorder(Torder torder);

    /**
     * 批量删除订单
     * 
     * @param ids 需要删除的订单ID
     * @return 结果
     */
    public int deleteTorderByIds(Integer[] ids);

    /**
     * 删除订单信息
     * 
     * @param id 订单ID
     * @return 结果
     */
    public int deleteTorderById(Integer id);


    /**
     * 获取订单详情
     * @param id
     * @return
     */
    public TorderVo getOrderDetail(Integer id);


    public void addOrder(OrderReqHeaderVo vo) throws Exception;


    /**
     * 更新订单状态
     * @param orderId
     * @param status
     */
    public void updateOrderStatus(Integer orderId, Integer status);


    /**
     * 查询近7天的日流水
     * @return
     */
    public List<OrderPriceVo> getOrderPriceReport();


    /**
     * 获取总收入
     * @return
     */
    public Integer getTotalPriceReport();

    /**
     * 今日收入
     * @return
     */
    public Integer getTodayPrice();


    /**
     * 总订单数
     * @return
     */
    public Integer getTotalOrders();

    /**
     * 今日订单数
     * @return
     */
    public Integer getTodayOrders();


    /**
     * 订单
     * @param ids
     */
    void addOrderByIds(Integer[] ids);
}
