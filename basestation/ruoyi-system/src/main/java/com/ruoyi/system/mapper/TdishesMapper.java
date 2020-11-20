package com.ruoyi.system.mapper;

import com.ruoyi.system.domain.Tdishes;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 菜品Mapper接口
 * 
 * @author yihao
 * @date 2020-10-24
 */
public interface TdishesMapper 
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
     * 删除菜品
     * 
     * @param id 菜品ID
     * @return 结果
     */
    public int deleteTdishesById(Integer id);

    /**
     * 批量删除菜品
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteTdishesByIds(Integer[] ids);

    /**
     * 变更状态
     * @param id
     * @param status
     * @return
     */
    int updateDisheStatus(@Param("id") Integer id, @Param("status")Integer status);


    List<Tdishes> selectDishesListByIds(Integer[] ids);
}
