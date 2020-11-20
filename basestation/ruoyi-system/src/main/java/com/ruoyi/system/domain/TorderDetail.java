package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 订单明细对象 t_order_detail
 * 
 * @author yihao
 * @date 2020-10-24
 */
public class TorderDetail extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Integer id;

    /** 订单ID */
    @Excel(name = "订单ID")
    private Integer orderId;

    /** 菜品ID */
    @Excel(name = "菜品ID")
    private Integer disheId;

    /** 菜名 */
    @Excel(name = "菜名")
    private String name;

    /** 单价 */
    @Excel(name = "单价")
    private Integer price;

    /** 数量 */
    @Excel(name = "数量")
    private Integer number;

    public void setId(Integer id)
    {
        this.id = id;
    }

    public Integer getId() 
    {
        return id;
    }
    public void setOrderId(Integer orderId) 
    {
        this.orderId = orderId;
    }

    public Integer getOrderId() 
    {
        return orderId;
    }
    public void setDisheId(Integer disheId) 
    {
        this.disheId = disheId;
    }

    public Integer getDisheId() 
    {
        return disheId;
    }
    public void setName(String name) 
    {
        this.name = name;
    }

    public String getName() 
    {
        return name;
    }
    public void setPrice(Integer price) 
    {
        this.price = price;
    }

    public Integer getPrice() 
    {
        return price;
    }
    public void setNumber(Integer number) 
    {
        this.number = number;
    }

    public Integer getNumber() 
    {
        return number;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("orderId", getOrderId())
            .append("disheId", getDisheId())
            .append("name", getName())
            .append("price", getPrice())
            .append("number", getNumber())
            .append("createTime", getCreateTime())
            .toString();
    }
}
