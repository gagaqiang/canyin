package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.TorderDetail;
import com.ruoyi.system.domain.vo.TorderDetailVo;

/**
 * 订单明细Mapper接口
 * 
 * @author yihao
 * @date 2020-10-24
 */
public interface TorderDetailMapper 
{
    /**
     * 查询订单明细
     * 
     * @param id 订单明细ID
     * @return 订单明细
     */
    public TorderDetail selectTorderDetailById(Integer id);

    /**
     * 查询订单明细列表
     * 
     * @param torderDetail 订单明细
     * @return 订单明细集合
     */
    public List<TorderDetail> selectTorderDetailList(TorderDetail torderDetail);

    /**
     * 新增订单明细
     * 
     * @param torderDetail 订单明细
     * @return 结果
     */
    public int insertTorderDetail(TorderDetail torderDetail);

    /**
     * 修改订单明细
     * 
     * @param torderDetail 订单明细
     * @return 结果
     */
    public int updateTorderDetail(TorderDetail torderDetail);

    /**
     * 删除订单明细
     * 
     * @param id 订单明细ID
     * @return 结果
     */
    public int deleteTorderDetailById(Integer id);

    /**
     * 批量删除订单明细
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteTorderDetailByIds(Integer[] ids);


    public List<TorderDetailVo> getListByOrderId(Integer orderId);
}
