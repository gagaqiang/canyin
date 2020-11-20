package com.ruoyi.system.domain.vo;

import com.ruoyi.system.domain.TorderDetail;

/**
 * @author yihao
 * @title: TorderDetailVo
 * @projectName diancan
 * @description: TODO
 * @date 2020/10/24下午4:14
 */
public class TorderDetailVo extends TorderDetail {

    private String disheName;

    public String getDisheName() {
        return disheName;
    }

    public void setDisheName(String disheName) {
        this.disheName = disheName;
    }
}
