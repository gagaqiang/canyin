package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 订单对象 t_order
 * 
 * @author yihao
 * @date 2020-10-24
 */
public class Torder extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Integer id;

    /** 桌位号 */
    @Excel(name = "桌位号")
    private String tableNumber;

    /** 消费总价 */
    @Excel(name = "消费总价")
    private Integer money;

    /** 订单状态 1:进行中，2:已结账 */
    @Excel(name = "订单状态 1:进行中，2:已结账")
    private Integer status;

    /** 订单号 */
    @Excel(name = "订单号")
    private String orderNumber;

    @Excel(name = "人数")
    private Integer people;

    @Excel(name = "备注")
    private String remark;

    public Integer getPeople() {
        return people;
    }

    public void setPeople(Integer people) {
        this.people = people;
    }

    @Override
    public String getRemark() {
        return remark;
    }

    @Override
    public void setRemark(String remark) {
        this.remark = remark;
    }

    public void setId(Integer id)
    {
        this.id = id;
    }

    public Integer getId() 
    {
        return id;
    }
    public void setTableNumber(String tableNumber)
    {
        this.tableNumber = tableNumber;
    }

    public String getTableNumber()
    {
        return tableNumber;
    }
    public void setMoney(Integer money) 
    {
        this.money = money;
    }

    public Integer getMoney() 
    {
        return money;
    }
    public void setStatus(Integer status) 
    {
        this.status = status;
    }

    public Integer getStatus() 
    {
        return status;
    }
    public void setOrderNumber(String orderNumber) 
    {
        this.orderNumber = orderNumber;
    }

    public String getOrderNumber() 
    {
        return orderNumber;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("tableNumber", getTableNumber())
            .append("money", getMoney())
            .append("status", getStatus())
            .append("createTime", getCreateTime())
            .append("orderNumber", getOrderNumber())
            .toString();
    }
}
