package com.ruoyi.system.service;

import com.ruoyi.system.domain.Tdishes;

import java.util.List;

/**
 * 菜品Service接口
 * 
 * @author yihao
 * @date 2020-10-24
 */
public interface ITdishesService 
{
    /**
     * 查询菜品
     * 
     * @param id 菜品ID
     * @return 菜品
     */
    public Tdishes selectTdishesById(Integer id);

    /**
     * 查询菜品列表
     * 
     * @param tdishes 菜品
     * @return 菜品集合
     */
    public List<Tdishes> selectTdishesList(Tdishes tdishes);

    /**
     * 新增菜品
     * 
     * @param tdishes 菜品
     * @return 结果
     */
    public int insertTdishes(Tdishes tdishes);

    /**
     * 修改菜品
     * 
     * @param tdishes 菜品
     * @return 结果
     */
    public int updateTdishes(Tdishes tdishes);

    /**
     * 批量删除菜品
     * 
     * @param ids 需要删除的菜品ID
     * @return 结果
     */
    public int deleteTdishesByIds(Integer[] ids);

    /**
     * 删除菜品信息
     * 
     * @param id 菜品ID
     * @return 结果
     */
    public int deleteTdishesById(Integer id);

    /**
     * 变更状态
     * @param ids
     * @return
     */
    String updateDisheStatus(Integer[] ids);


}
