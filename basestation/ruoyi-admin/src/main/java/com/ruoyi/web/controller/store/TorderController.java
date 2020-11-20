package com.ruoyi.web.controller.store;

import java.util.List;

import com.ruoyi.system.domain.Torder;
import com.ruoyi.system.domain.vo.OrderReqHeaderVo;
import com.ruoyi.system.domain.vo.TorderVo;
import com.ruoyi.system.service.ITorderService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 订单管理Controller
 * 
 * @author yihao
 * @date 2020-10-24
 */
@RestController
@RequestMapping("/store/order")
public class TorderController extends BaseController
{
    @Autowired
    private ITorderService torderService;

    /**
     * 查询订单列表
     */
    @PreAuthorize("@ss.hasPermi('store:order:list')")
    @GetMapping("/list")
    public TableDataInfo list(Torder torder)
    {
        startPage();
        List<Torder> list = torderService.selectTorderList(torder);
        return getDataTable(list);
    }

    /**
     * 导出订单列表
     */
    @PreAuthorize("@ss.hasPermi('store:order:export')")
    @Log(title = "订单", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(Torder torder)
    {
        List<Torder> list = torderService.selectTorderList(torder);
        ExcelUtil<Torder> util = new ExcelUtil<Torder>(Torder.class);
        return util.exportExcel(list, "order");
    }

    /**
     * 获取订单详细信息
     */
    @PreAuthorize("@ss.hasPermi('store:order:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Integer id)
    {
        return AjaxResult.success(torderService.getOrderDetail(id));
    }

    /**
     * 新增订单
     */
    @PreAuthorize("@ss.hasPermi('store:order:add')")
    @Log(title = "订单", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Torder torder) throws Exception {
        return toAjax(torderService.insertTorder(torder));
    }

    /**
     * 修改订单
     */
    @PreAuthorize("@ss.hasPermi('store:order:edit')")
    @Log(title = "订单", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Torder torder)
    {
        return toAjax(torderService.updateTorder(torder));
    }

    /**
     * 删除订单
     */
    @PreAuthorize("@ss.hasPermi('store:order:remove')")
    @Log(title = "订单", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Integer[] ids)
    {
        return toAjax(torderService.deleteTorderByIds(ids));
    }


    /**
     * 新增订单
     * @param vo
     * @return
     */
    @PostMapping("/addOrder")
    public AjaxResult addOrder(@RequestBody OrderReqHeaderVo vo) throws Exception {
        torderService.addOrder(vo);
        return AjaxResult.success();
    }


    /**
     * 更新订单状态
     * @param orderId
     */
    @PostMapping("/updateOrderStatus")
    public AjaxResult updateOrderStatus(@RequestParam("orderId")Integer orderId){

        torderService.updateOrderStatus(orderId, 2);
        return AjaxResult.success();
    }



    /**
     * 购物车新增订单
     */
    @PostMapping("/addShoping/{ids}")
    public AjaxResult addShoping(@PathVariable Integer[] ids){
        torderService.addOrderByIds(ids);
        return AjaxResult.success("true");
    }

}
