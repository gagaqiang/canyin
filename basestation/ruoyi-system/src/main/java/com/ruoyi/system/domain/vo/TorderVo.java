package com.ruoyi.system.domain.vo;

import com.ruoyi.system.domain.Torder;

import java.util.List;

/**
 * @author yihao
 * @title: TorderVo
 * @projectName diancan
 * @description: TODO
 * @date 2020/10/24下午4:06
 */
public class TorderVo extends Torder {

    private List<TorderDetailVo> detailList;

    public List<TorderDetailVo> getDetailList() {
        return detailList;
    }

    public void setDetailList(List<TorderDetailVo> detailList) {
        this.detailList = detailList;
    }
}
