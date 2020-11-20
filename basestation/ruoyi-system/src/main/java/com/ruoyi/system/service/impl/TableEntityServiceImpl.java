package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.TableEntityMapper;
import com.ruoyi.system.domain.TableEntity;
import com.ruoyi.system.service.ITableEntityService;

/**
 * 桌编码Service业务层处理
 * 
 * @author yihao
 * @date 2020-10-24
 */
@Service
public class TableEntityServiceImpl implements ITableEntityService 
{
    @Autowired
    private TableEntityMapper tableEntityMapper;

    /**
     * 查询桌编码
     * 
     * @param id 桌编码ID
     * @return 桌编码
     */
    @Override
    public TableEntity selectTableEntityById(Long id)
    {
        return tableEntityMapper.selectTableEntityById(id);
    }

    /**
     * 查询桌编码列表
     * 
     * @param tableEntity 桌编码
     * @return 桌编码
     */
    @Override
    public List<TableEntity> selectTableEntityList(TableEntity tableEntity)
    {
        return tableEntityMapper.selectTableEntityList(tableEntity);
    }

    /**
     * 新增桌编码
     * 
     * @param tableEntity 桌编码
     * @return 结果
     */
    @Override
    public int insertTableEntity(TableEntity tableEntity)
    {
        return tableEntityMapper.insertTableEntity(tableEntity);
    }

    /**
     * 修改桌编码
     * 
     * @param tableEntity 桌编码
     * @return 结果
     */
    @Override
    public int updateTableEntity(TableEntity tableEntity)
    {
        return tableEntityMapper.updateTableEntity(tableEntity);
    }

    /**
     * 批量删除桌编码
     * 
     * @param ids 需要删除的桌编码ID
     * @return 结果
     */
    @Override
    public int deleteTableEntityByIds(Long[] ids)
    {
        return tableEntityMapper.deleteTableEntityByIds(ids);
    }

    /**
     * 删除桌编码信息
     * 
     * @param id 桌编码ID
     * @return 结果
     */
    @Override
    public int deleteTableEntityById(Long id)
    {
        return tableEntityMapper.deleteTableEntityById(id);
    }
}
