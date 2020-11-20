package com.ruoyi.system.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.system.domain.TCategory;
import com.ruoyi.system.mapper.TCategoryMapper;
import com.ruoyi.system.service.ITCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 菜品类别Service业务层处理
 * 
 * @author yihao
 * @date 2020-10-21
 */
@Service
public class TCategoryServiceImpl implements ITCategoryService
{
    @Autowired
    private TCategoryMapper tCategoryMapper;

    /**
     * 查询菜品类别
     * 
     * @param id 菜品类别ID
     * @return 菜品类别
     */
    @Override
    public TCategory selectTCategoryById(Integer id)
    {
        return tCategoryMapper.selectTCategoryById(id);
    }

    /**
     * 查询菜品类别列表
     * 
     * @param tCategory 菜品类别
     * @return 菜品类别
     */
    @Override
    public List<TCategory> selectTCategoryList(TCategory tCategory)
    {
        return tCategoryMapper.selectTCategoryList(tCategory);
    }

    /**
     * 新增菜品类别
     * 
     * @param tCategory 菜品类别
     * @return 结果
     */
    @Override
    public int insertTCategory(TCategory tCategory)
    {
        tCategory.setCreateTime(DateUtils.getNowDate());
        return tCategoryMapper.insertTCategory(tCategory);
    }

    /**
     * 修改菜品类别
     * 
     * @param tCategory 菜品类别
     * @return 结果
     */
    @Override
    public int updateTCategory(TCategory tCategory)
    {
        return tCategoryMapper.updateTCategory(tCategory);
    }

    /**
     * 批量删除菜品类别
     * 
     * @param ids 需要删除的菜品类别ID
     * @return 结果
     */
    @Override
    public int deleteTCategoryByIds(Integer[] ids)
    {
        return tCategoryMapper.deleteTCategoryByIds(ids);
    }

    /**
     * 删除菜品类别信息
     * 
     * @param id 菜品类别ID
     * @return 结果
     */
    @Override
    public int deleteTCategoryById(Integer id)
    {
        return tCategoryMapper.deleteTCategoryById(id);
    }
}
