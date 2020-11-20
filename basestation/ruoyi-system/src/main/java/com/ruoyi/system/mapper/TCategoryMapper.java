package com.ruoyi.system.mapper;

import com.ruoyi.system.domain.TCategory;

import java.util.List;

/**
 * 菜品类别Mapper接口
 * 
 * @author yihao
 * @date 2020-10-21
 */
public interface TCategoryMapper 
{
    /**
     * 查询菜品类别
     * 
     * @param id 菜品类别ID
     * @return 菜品类别
     */
    public TCategory selectTCategoryById(Integer id);

    /**
     * 查询菜品类别列表
     * 
     * @param tCategory 菜品类别
     * @return 菜品类别集合
     */
    public List<TCategory> selectTCategoryList(TCategory tCategory);

    /**
     * 新增菜品类别
     * 
     * @param tCategory 菜品类别
     * @return 结果
     */
    public int insertTCategory(TCategory tCategory);

    /**
     * 修改菜品类别
     * 
     * @param tCategory 菜品类别
     * @return 结果
     */
    public int updateTCategory(TCategory tCategory);

    /**
     * 删除菜品类别
     * 
     * @param id 菜品类别ID
     * @return 结果
     */
    public int deleteTCategoryById(Integer id);

    /**
     * 批量删除菜品类别
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteTCategoryByIds(Integer[] ids);
}
