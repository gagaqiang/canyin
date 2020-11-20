package com.ruoyi.web.controller.store;

import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.system.domain.vo.OrderReportVo;
import com.ruoyi.system.service.ITorderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 报表
 * @author yihao
 * @title: ReportController
 * @projectName diancan
 * @description: TODO
 * @date 2020/10/25下午8:07
 */

@RestController
@RequestMapping("/store/report")
public class ReportController  extends BaseController {


    @Autowired
    private ITorderService iTorderService;

    /**
     * 首页获取报表数据
     * 1.总营业额
     * 2.今日营业额
     * 3.订单总数
     * 4.桌位数
     *
     * 5.获取最近7天的日营业额
     * @return
     */
    @GetMapping("/getOrderPriceReport")
    public AjaxResult getOrderPriceReport(){

        OrderReportVo reportVo = new OrderReportVo();
        //七日营业额
        reportVo.setDateMoneys(iTorderService.getOrderPriceReport());
        //总营业额
        reportVo.setTotalMoney(iTorderService.getTotalPriceReport());
        //今日营业额
        reportVo.setTodayMoney(iTorderService.getTodayPrice());
        //订单总数
        reportVo.setTotalOrder(iTorderService.getTotalOrders());
        //今日订单总数
        reportVo.setTodayOrders(iTorderService.getTodayOrders());

        return AjaxResult.success(reportVo);
    }


    /**
     * 一周营业额
     * @return
     */
    @GetMapping("/getOrderSevenDayPriceReport")
    public AjaxResult getOrderSevenDayPriceReport(){

        OrderReportVo reportVo = new OrderReportVo();
        //七日营业额
        reportVo.setDateMoneys(iTorderService.getOrderPriceReport());

        return AjaxResult.success(reportVo);
    }





}
