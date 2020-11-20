package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.TableEntity;

/**
 * 桌编码Mapper接口
 * 
 * @author yihao
 * @date 2020-10-24
 */
public interface TableEntityMapper 
{
    /**
     * 查询桌编码
     * 
     * @param id 桌编码ID
     * @return 桌编码
     */
    public TableEntity selectTableEntityById(Long id);

    /**
     * 查询桌编码列表
     * 
     * @param tableEntity 桌编码
     * @return 桌编码集合
     */
    public List<TableEntity> selectTableEntityList(TableEntity tableEntity);

    /**
     * 新增桌编码
     * 
     * @param tableEntity 桌编码
     * @return 结果
     */
    public int insertTableEntity(TableEntity tableEntity);

    /**
     * 修改桌编码
     * 
     * @param tableEntity 桌编码
     * @return 结果
     */
    public int updateTableEntity(TableEntity tableEntity);

    /**
     * 删除桌编码
     * 
     * @param id 桌编码ID
     * @return 结果
     */
    public int deleteTableEntityById(Long id);

    /**
     * 批量删除桌编码
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteTableEntityByIds(Long[] ids);


    public int getTableEntityByNum(String num);
}
