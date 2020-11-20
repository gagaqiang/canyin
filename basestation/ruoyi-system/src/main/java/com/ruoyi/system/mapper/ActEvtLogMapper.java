package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.ActEvtLog;

/**
 * 【请填写功能名称】Mapper接口
 * 
 * @author ruoyi
 * @date 2020-10-20
 */
public interface ActEvtLogMapper 
{
    /**
     * 查询【请填写功能名称】
     * 
     * @param logNr 【请填写功能名称】ID
     * @return 【请填写功能名称】
     */
    public ActEvtLog selectActEvtLogById(Long logNr);

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param actEvtLog 【请填写功能名称】
     * @return 【请填写功能名称】集合
     */
    public List<ActEvtLog> selectActEvtLogList(ActEvtLog actEvtLog);

    /**
     * 新增【请填写功能名称】
     * 
     * @param actEvtLog 【请填写功能名称】
     * @return 结果
     */
    public int insertActEvtLog(ActEvtLog actEvtLog);

    /**
     * 修改【请填写功能名称】
     * 
     * @param actEvtLog 【请填写功能名称】
     * @return 结果
     */
    public int updateActEvtLog(ActEvtLog actEvtLog);

    /**
     * 删除【请填写功能名称】
     * 
     * @param logNr 【请填写功能名称】ID
     * @return 结果
     */
    public int deleteActEvtLogById(Long logNr);

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param logNrs 需要删除的数据ID
     * @return 结果
     */
    public int deleteActEvtLogByIds(Long[] logNrs);
}
