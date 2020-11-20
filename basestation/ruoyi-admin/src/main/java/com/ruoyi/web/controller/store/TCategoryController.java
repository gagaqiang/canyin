package com.ruoyi.web.controller.store;

import java.util.List;

import com.ruoyi.system.domain.TCategory;
import com.ruoyi.system.service.ITCategoryService;
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
 * 菜品类别Controller
 * 
 * @author yihao
 * @date 2020-10-21
 */
@RestController
@RequestMapping("/store/category")
public class TCategoryController extends BaseController
{
    @Autowired
    private ITCategoryService tCategoryService;

    /**
     * 查询菜品类别列表
     */
    //@PreAuthorize("@ss.hasPermi('store:category:list')")
    @GetMapping("/list")
    public TableDataInfo list(TCategory tCategory)
    {
        startPage();
        List<TCategory> list = tCategoryService.selectTCategoryList(tCategory);
        return getDataTable(list);
    }

    /**
     * 导出菜品类别列表
     */
    //@PreAuthorize("@ss.hasPermi('store:category:export')")
    @Log(title = "菜品类别", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(TCategory tCategory)
    {
        List<TCategory> list = tCategoryService.selectTCategoryList(tCategory);
        ExcelUtil<TCategory> util = new ExcelUtil<TCategory>(TCategory.class);
        return util.exportExcel(list, "category");
    }

    /**
     * 获取菜品类别详细信息
     */
    //@PreAuthorize("@ss.hasPermi('store:category:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Integer id)
    {
        return AjaxResult.success(tCategoryService.selectTCategoryById(id));
    }

    /**
     * 新增菜品类别
     */
    //@PreAuthorize("@ss.hasPermi('store:category:add')")
    @Log(title = "菜品类别", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody TCategory tCategory)
    {
        return toAjax(tCategoryService.insertTCategory(tCategory));
    }

    /**
     * 修改菜品类别
     */
    //@PreAuthorize("@ss.hasPermi('store:category:edit')")
    @Log(title = "菜品类别", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody TCategory tCategory)
    {
        return toAjax(tCategoryService.updateTCategory(tCategory));
    }

    /**
     * 删除菜品类别
     */
    //@PreAuthorize("@ss.hasPermi('store:category:remove')")
    @Log(title = "菜品类别", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Integer[] ids)
    {
        return toAjax(tCategoryService.deleteTCategoryByIds(ids));
    }


    /**
     * 查询菜品类别列表
     */
    //@PreAuthorize("@ss.hasPermi('store:category:list')")
    @GetMapping("/alllist")
    public AjaxResult alllist()
    {
        List<TCategory> list = tCategoryService.selectTCategoryList(new TCategory());
        return AjaxResult.success(list);
    }


}
