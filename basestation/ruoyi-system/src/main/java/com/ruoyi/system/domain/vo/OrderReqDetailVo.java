package com.ruoyi.system.domain.vo;

import com.ruoyi.common.annotation.Excel;

/**
 * @author yihao
 * @title: OrderReqDetailVo
 * @projectName diancan
 * @description: TODO
 * @date 2020/10/25下午7:35
 */
public class OrderReqDetailVo {

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

    public Integer getDisheId() {
        return disheId;
    }

    public void setDisheId(Integer disheId) {
        this.disheId = disheId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }
}
