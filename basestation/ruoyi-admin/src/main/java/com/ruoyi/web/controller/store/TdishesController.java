package com.ruoyi.web.controller.store;

import java.util.ArrayList;
import java.util.List;

import com.ruoyi.common.utils.bean.BeanUtils;
import com.ruoyi.system.domain.TCategory;
import com.ruoyi.system.domain.Tdishes;
import com.ruoyi.system.domain.vo.TdishesVo;
import com.ruoyi.system.service.ITCategoryService;
import com.ruoyi.system.service.ITdishesService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 菜品管理Controller
 * 
 * @author yihao
 * @date 2020-10-24
 */
@RestController
@RequestMapping("/store/dishes")
public class TdishesController extends BaseController
{
    @Autowired
    private ITdishesService tdishesService;
    @Autowired
    private ITCategoryService itCategoryService;

    /**
     * 查询菜品列表
     */
    @PreAuthorize("@ss.hasPermi('store:dishes:list')")
    @GetMapping("/list")
    public TableDataInfo list(Tdishes tdishes)
    {
        startPage();
        List<Tdishes> list = tdishesService.selectTdishesList(tdishes);

        List<TdishesVo> li = new ArrayList<>();
        for(Tdishes t : list){
            TdishesVo vo = new TdishesVo();
            BeanUtils.copyProperties(t, vo);

            TCategory tc = itCategoryService.selectTCategoryById(t.getCategoryId());
            vo.setCategoryName(tc.getName());

            li.add(vo);
        }

        return getDataTable(li);
    }

    /**
     * 导出菜品列表
     */
    @PreAuthorize("@ss.hasPermi('store:dishes:export')")
    @Log(title = "菜品", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(Tdishes tdishes)
    {
        List<Tdishes> list = tdishesService.selectTdishesList(tdishes);
        ExcelUtil<Tdishes> util = new ExcelUtil<Tdishes>(Tdishes.class);
        return util.exportExcel(list, "dishes");
    }

    /**
     * 获取菜品详细信息
     */
    @PreAuthorize("@ss.hasPermi('store:dishes:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Integer id)
    {
        return AjaxResult.success(tdishesService.selectTdishesById(id));
    }

    /**
     * 新增菜品
     */
    @PreAuthorize("@ss.hasPermi('store:dishes:add')")
    @Log(title = "菜品", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Tdishes tdishes)
    {
        return toAjax(tdishesService.insertTdishes(tdishes));
    }

    /**
     * 修改菜品
     */
    @PreAuthorize("@ss.hasPermi('store:dishes:edit')")
    @Log(title = "菜品", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Tdishes tdishes)
    {
        return toAjax(tdishesService.updateTdishes(tdishes));
    }

    /**
     * 删除菜品
     */
    @PreAuthorize("@ss.hasPermi('store:dishes:remove')")
    @Log(title = "菜品", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Integer[] ids)
    {
        return toAjax(tdishesService.deleteTdishesByIds(ids));
    }



    /**
     * 变更状态
     */
    @PostMapping("/updateDisheStatus/{ids}")
    public AjaxResult updateDisheStatus(@PathVariable Integer[] ids){
        return AjaxResult.success(tdishesService.updateDisheStatus(ids));
    }




    /**
     * 获取上架的菜谱集合
     * @param tdishes  --- 传值菜谱类型ID，categoryId
     * @return
     */
    @GetMapping("/getOnDisheslist")
    public AjaxResult getOnDisheslist(Tdishes tdishes){

        tdishes.setStatus(1);
        List<Tdishes> list = tdishesService.selectTdishesList(tdishes);
        List<TdishesVo> li = new ArrayList<>();
        for(Tdishes t : list){
            TdishesVo vo = new TdishesVo();
            BeanUtils.copyProperties(t, vo);

            TCategory tc = itCategoryService.selectTCategoryById(t.getCategoryId());
            vo.setCategoryName(tc.getName());
            li.add(vo);
        }
        return AjaxResult.success(li);
    }


    /**
     * 类别获取菜品集合
     */
    @GetMapping("/getDishesBycateidList/{ids}")
    public AjaxResult getDishesBycateidList(@PathVariable Integer[] ids){
        Tdishes tdishes = new Tdishes();
        tdishes.setCategoryId(ids[0]);
        tdishes.setStatus(1);

        List<Tdishes> list = tdishesService.selectTdishesList(tdishes);
        List<TdishesVo> li = new ArrayList<>();
        for(Tdishes t : list){
            TdishesVo vo = new TdishesVo();
            BeanUtils.copyProperties(t, vo);

            TCategory tc = itCategoryService.selectTCategoryById(t.getCategoryId());
            vo.setCategoryName(tc.getName());
            li.add(vo);
        }

        return AjaxResult.success(li);
    }


}
