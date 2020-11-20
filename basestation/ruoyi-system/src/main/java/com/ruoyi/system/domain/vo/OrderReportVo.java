package com.ruoyi.system.domain.vo;

import java.util.List;

/**
 * @author yihao
 * @title: OrderReportVo
 * @projectName diancan
 * @description: TODO
 * @date 2020/10/25下午8:42
 */
public class OrderReportVo {

    private Integer totalMoney;

    private Integer todayMoney;

    private Integer todayOrders;

    private Integer totalOrder;

    public Integer getTodayMoney() {
        return todayMoney;
    }

    public void setTodayMoney(Integer todayMoney) {
        this.todayMoney = todayMoney;
    }

    public Integer getTodayOrders() {
        return todayOrders;
    }

    public void setTodayOrders(Integer todayOrders) {
        this.todayOrders = todayOrders;
    }

    public Integer getTotalOrder() {
        return totalOrder;
    }

    public void setTotalOrder(Integer totalOrder) {
        this.totalOrder = totalOrder;
    }

    private List<OrderPriceVo> dateMoneys;

    public Integer getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(Integer totalMoney) {
        this.totalMoney = totalMoney;
    }

    public List<OrderPriceVo> getDateMoneys() {
        return dateMoneys;
    }

    public void setDateMoneys(List<OrderPriceVo> dateMoneys) {
        this.dateMoneys = dateMoneys;
    }
}
