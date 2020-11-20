package com.ruoyi.system.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.TorderDetailMapper;
import com.ruoyi.system.domain.TorderDetail;
import com.ruoyi.system.service.ITorderDetailService;

/**
 * 订单明细Service业务层处理
 * 
 * @author yihao
 * @date 2020-10-24
 */
@Service
public class TorderDetailServiceImpl implements ITorderDetailService 
{
    @Autowired
    private TorderDetailMapper torderDetailMapper;

    /**
     * 查询订单明细
     * 
     * @param id 订单明细ID
     * @return 订单明细
     */
    @Override
    public TorderDetail selectTorderDetailById(Integer id)
    {
        return torderDetailMapper.selectTorderDetailById(id);
    }

    /**
     * 查询订单明细列表
     * 
     * @param torderDetail 订单明细
     * @return 订单明细
     */
    @Override
    public List<TorderDetail> selectTorderDetailList(TorderDetail torderDetail)
    {
        return torderDetailMapper.selectTorderDetailList(torderDetail);
    }

    /**
     * 新增订单明细
     * 
     * @param torderDetail 订单明细
     * @return 结果
     */
    @Override
    public int insertTorderDetail(TorderDetail torderDetail)
    {
        torderDetail.setCreateTime(DateUtils.getNowDate());
        return torderDetailMapper.insertTorderDetail(torderDetail);
    }

    /**
     * 修改订单明细
     * 
     * @param torderDetail 订单明细
     * @return 结果
     */
    @Override
    public int updateTorderDetail(TorderDetail torderDetail)
    {
        return torderDetailMapper.updateTorderDetail(torderDetail);
    }

    /**
     * 批量删除订单明细
     * 
     * @param ids 需要删除的订单明细ID
     * @return 结果
     */
    @Override
    public int deleteTorderDetailByIds(Integer[] ids)
    {
        return torderDetailMapper.deleteTorderDetailByIds(ids);
    }

    /**
     * 删除订单明细信息
     * 
     * @param id 订单明细ID
     * @return 结果
     */
    @Override
    public int deleteTorderDetailById(Integer id)
    {
        return torderDetailMapper.deleteTorderDetailById(id);
    }
}
