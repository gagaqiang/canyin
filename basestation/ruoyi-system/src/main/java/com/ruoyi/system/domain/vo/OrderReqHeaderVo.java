package com.ruoyi.system.domain.vo;

import com.ruoyi.common.annotation.Excel;

import java.util.List;

/**
 * @author yihao
 * @title: OrderReqHeaderVo
 * @projectName diancan
 * @description: TODO
 * @date 2020/10/25下午7:34
 */
public class OrderReqHeaderVo {


    @Excel(name = "桌位号")
    private String tableNumber;
    /** 消费总价 */
    @Excel(name = "消费总价")
    private Integer money;
    //人数
    private Integer people;
    //备注
    private String remark;


    private List<OrderReqDetailVo> detailVoList;

    public String getTableNumber() {
        return tableNumber;
    }

    public void setTableNumber(String tableNumber) {
        this.tableNumber = tableNumber;
    }

    public Integer getMoney() {
        return money;
    }

    public void setMoney(Integer money) {
        this.money = money;
    }

    public Integer getPeople() {
        return people;
    }

    public void setPeople(Integer people) {
        this.people = people;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public List<OrderReqDetailVo> getDetailVoList() {
        return detailVoList;
    }

    public void setDetailVoList(List<OrderReqDetailVo> detailVoList) {
        this.detailVoList = detailVoList;
    }
}
