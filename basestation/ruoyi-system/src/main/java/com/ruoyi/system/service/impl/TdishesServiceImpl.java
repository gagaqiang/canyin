package com.ruoyi.system.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.system.domain.Tdishes;
import com.ruoyi.system.mapper.TdishesMapper;
import com.ruoyi.system.service.ITdishesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 菜品Service业务层处理
 * 
 * @author yihao
 * @date 2020-10-24
 */
@Service
public class TdishesServiceImpl implements ITdishesService
{
    @Autowired
    private TdishesMapper tdishesMapper;

    /**
     * 查询菜品
     * 
     * @param id 菜品ID
     * @return 菜品
     */
    @Override
    public Tdishes selectTdishesById(Integer id)
    {
        return tdishesMapper.selectTdishesById(id);
    }

    /**
     * 查询菜品列表
     * 
     * @param tdishes 菜品
     * @return 菜品
     */
    @Override
    public List<Tdishes> selectTdishesList(Tdishes tdishes)
    {
        return tdishesMapper.selectTdishesList(tdishes);
    }

    /**
     * 新增菜品
     * 
     * @param tdishes 菜品
     * @return 结果
     */
    @Override
    public int insertTdishes(Tdishes tdishes)
    {
        tdishes.setStatus(1);
        tdishes.setCreateTime(DateUtils.getNowDate());
        return tdishesMapper.insertTdishes(tdishes);
    }

    /**
     * 修改菜品
     * 
     * @param tdishes 菜品
     * @return 结果
     */
    @Override
    public int updateTdishes(Tdishes tdishes)
    {
        return tdishesMapper.updateTdishes(tdishes);
    }

    /**
     * 批量删除菜品
     * 
     * @param ids 需要删除的菜品ID
     * @return 结果
     */
    @Override
    public int deleteTdishesByIds(Integer[] ids)
    {
        return tdishesMapper.deleteTdishesByIds(ids);
    }

    /**
     * 删除菜品信息
     * 
     * @param id 菜品ID
     * @return 结果
     */
    @Override
    public int deleteTdishesById(Integer id)
    {
        return tdishesMapper.deleteTdishesById(id);
    }


    @Override
    @Transactional
    public String updateDisheStatus(Integer[] ids) {

        String msg = "状态变更成功";
        for(int i = 0; i<ids.length; i++){
            Tdishes td = tdishesMapper.selectTdishesById(ids[i]);
            if (td.getStatus() == 1){
                tdishesMapper.updateDisheStatus(ids[i], 2);
                msg = "下架成功!";
            }else{
                tdishesMapper.updateDisheStatus(ids[i], 1);
                msg = "上架成功!";
            }
        }

        return msg;
    }
}
