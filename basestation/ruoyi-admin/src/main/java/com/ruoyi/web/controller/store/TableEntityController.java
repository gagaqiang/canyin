package com.ruoyi.web.controller.store;

import java.util.List;
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
import com.ruoyi.system.domain.TableEntity;
import com.ruoyi.system.service.ITableEntityService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 餐桌管理Controller
 * 
 * @author yihao
 * @date 2020-10-24
 */
@RestController
@RequestMapping("/store/desk")
public class TableEntityController extends BaseController
{
    @Autowired
    private ITableEntityService tableEntityService;

    /**
     * 查询桌编码列表
     */
    @PreAuthorize("@ss.hasPermi('system:desk:list')")
    @GetMapping("/list")
    public TableDataInfo list(TableEntity tableEntity)
    {
        startPage();
        List<TableEntity> list = tableEntityService.selectTableEntityList(tableEntity);
        return getDataTable(list);
    }

    /**
     * 导出桌编码列表
     */
    @PreAuthorize("@ss.hasPermi('system:desk:export')")
    @Log(title = "桌编码", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(TableEntity tableEntity)
    {
        List<TableEntity> list = tableEntityService.selectTableEntityList(tableEntity);
        ExcelUtil<TableEntity> util = new ExcelUtil<TableEntity>(TableEntity.class);
        return util.exportExcel(list, "desk");
    }

    /**
     * 获取桌编码详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:desk:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(tableEntityService.selectTableEntityById(id));
    }

    /**
     * 新增桌编码
     */
    @PreAuthorize("@ss.hasPermi('system:desk:add')")
    @Log(title = "桌编码", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody TableEntity tableEntity)
    {
        return toAjax(tableEntityService.insertTableEntity(tableEntity));
    }

    /**
     * 修改桌编码
     */
    @PreAuthorize("@ss.hasPermi('system:desk:edit')")
    @Log(title = "桌编码", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody TableEntity tableEntity)
    {
        return toAjax(tableEntityService.updateTableEntity(tableEntity));
    }

    /**
     * 删除桌编码
     */
    @PreAuthorize("@ss.hasPermi('system:desk:remove')")
    @Log(title = "桌编码", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(tableEntityService.deleteTableEntityByIds(ids));
    }
}
