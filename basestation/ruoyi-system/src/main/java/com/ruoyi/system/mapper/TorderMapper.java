package com.ruoyi.system.mapper;

import com.ruoyi.system.domain.Torder;

import java.util.List;

/**
 * 订单Mapper接口
 * 
 * @author yihao
 * @date 2020-10-24
 */
public interface TorderMapper 
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
    public int insertTorder(Torder torder);

    /**
     * 修改订单
     * 
     * @param torder 订单
     * @return 结果
     */
    public int updateTorder(Torder torder);

    /**
     * 删除订单
     * 
     * @param id 订单ID
     * @return 结果
     */
    public int deleteTorderById(Integer id);

    /**
     * 批量删除订单
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteTorderByIds(Integer[] ids);

    /**
     * 获取某日的营业额
     * @param time
     * @return
     */
    public Integer getOrderPriceReport(String time);

    /**
     * 获取总收入
     * @return
     */
    public Integer getTotalPriceReport();

    /**
     * 今日收入
     * @return
     */
    public Integer getTodayPrice(String time);

    /**
     * 总订单数
     * @return
     */
    public Integer getTotalOrders();

    /**
     * 今日订单数
     * @return
     */
    public Integer getTodayOrders(String time);
}
