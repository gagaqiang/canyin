package com.ruoyi.system.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.bean.BeanUtils;
import com.ruoyi.common.utils.uuid.IdUtils;
import com.ruoyi.system.domain.Tdishes;
import com.ruoyi.system.domain.Torder;
import com.ruoyi.system.domain.TorderDetail;
import com.ruoyi.system.domain.vo.*;
import com.ruoyi.system.mapper.TableEntityMapper;
import com.ruoyi.system.mapper.TdishesMapper;
import com.ruoyi.system.mapper.TorderDetailMapper;
import com.ruoyi.system.mapper.TorderMapper;
import com.ruoyi.system.service.ITorderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 订单Service业务层处理
 * 
 * @author yihao
 * @date 2020-10-24
 */
@Service
public class TorderServiceImpl implements ITorderService
{
    @Autowired
    private TorderMapper torderMapper;

    @Autowired
    private TorderDetailMapper torderDetailMapper;

    @Autowired
    private TableEntityMapper tableEntityMapper;
    @Autowired
    private TdishesMapper tdishesMapper;


    private static SimpleDateFormat day_sdf = new SimpleDateFormat("yyyy-MM-dd");

    /**
     * 查询订单
     * 
     * @param id 订单ID
     * @return 订单
     */
    @Override
    public Torder selectTorderById(Integer id)
    {
        return torderMapper.selectTorderById(id);
    }

    /**
     * 查询订单列表
     * 
     * @param torder 订单
     * @return 订单
     */
    @Override
    public List<Torder> selectTorderList(Torder torder)
    {
        return torderMapper.selectTorderList(torder);
    }

    /**
     * 新增订单
     * 
     * @param torder 订单
     * @return 结果
     */
    @Override
    @Transactional
    public int insertTorder(Torder torder) throws Exception {

        int i = tableEntityMapper.getTableEntityByNum(torder.getTableNumber());
        if (i == 0){
            throw new Exception("当前桌码不存在!");
        }

        torder.setOrderNumber(IdUtils.getID());
        torder.setCreateTime(DateUtils.getNowDate());
        return torderMapper.insertTorder(torder);
    }

    /**
     * 修改订单
     * 
     * @param torder 订单
     * @return 结果
     */
    @Override
    @Transactional
    public int updateTorder(Torder torder)
    {
        return torderMapper.updateTorder(torder);
    }

    /**
     * 批量删除订单
     * 
     * @param ids 需要删除的订单ID
     * @return 结果
     */
    @Override
    @Transactional
    public int deleteTorderByIds(Integer[] ids)
    {
        return torderMapper.deleteTorderByIds(ids);
    }

    /**
     * 删除订单信息
     * 
     * @param id 订单ID
     * @return 结果
     */
    @Override
    @Transactional
    public int deleteTorderById(Integer id)
    {
        return torderMapper.deleteTorderById(id);
    }



    @Override
    public TorderVo getOrderDetail(Integer id) {

        Torder order = selectTorderById(id);

        List<TorderDetailVo> detailList = torderDetailMapper.getListByOrderId(id);

        TorderVo tv = new TorderVo();

        BeanUtils.copyProperties(order, tv);
        tv.setDetailList(detailList);

        return tv;
    }

    @Override
    @Transactional
    public void addOrder(OrderReqHeaderVo vo) throws Exception {
        int i = tableEntityMapper.getTableEntityByNum(vo.getTableNumber());
        if (i == 0){
            throw new Exception("当前桌码不存在!");
        }

        Torder order = new Torder();
        order.setOrderNumber(IdUtils.getID());
        order.setMoney(vo.getMoney());
        order.setPeople(vo.getPeople());
        order.setRemark(vo.getRemark());
        order.setTableNumber(vo.getTableNumber());
        order.setStatus(1);

        int orderId = torderMapper.insertTorder(order);
        for(OrderReqDetailVo detailVo : vo.getDetailVoList()){

            TorderDetail detail = new TorderDetail();
            detail.setOrderId(orderId);
            detail.setDisheId(detailVo.getDisheId());
            Tdishes td = tdishesMapper.selectTdishesById(detailVo.getDisheId());
            detail.setName(td.getName());
            detail.setPrice((td.getPrice() * detail.getNumber()));
            detail.setNumber(detail.getNumber());

            torderDetailMapper.insertTorderDetail(detail);
        }

    }

    @Override
    @Transactional
    public void updateOrderStatus(Integer orderId, Integer status) {
        Torder order = new Torder();
        order.setId(orderId);
        order.setStatus(status);

        torderMapper.updateTorder(order);
    }

    @Override
    public List<OrderPriceVo> getOrderPriceReport() {


        List<OrderPriceVo> orderPriceVoList = new ArrayList<>();

        for(int i = 7; i > 0 ; i--){
            OrderPriceVo vo = new OrderPriceVo();
            String date = DateUtils.getDateDays(i);
            vo.setMoney(torderMapper.getOrderPriceReport(date));
            vo.setDate(date);

            orderPriceVoList.add(vo);
        }

        return orderPriceVoList;
    }

    @Override
    public Integer getTotalPriceReport() {
        return torderMapper.getTotalPriceReport();
    }

    @Override
    public Integer getTodayPrice() {
        return torderMapper.getTodayPrice(day_sdf.format(new Date()));
    }

    @Override
    public Integer getTotalOrders() {
        return torderMapper.getTotalOrders();
    }

    @Override
    public Integer getTodayOrders() {
        return torderMapper.getTodayOrders(day_sdf.format(new Date()));
    }

    @Override
    @Transactional
    public void addOrderByIds(Integer[] ids) {

        List<Tdishes> lists = tdishesMapper.selectDishesListByIds(ids);
        int money = 0;
        for (Tdishes td : lists){
            money = money + td.getPrice();
        }

        Torder order = new Torder();
        order.setOrderNumber(IdUtils.getID());
        order.setMoney(money);
        order.setTableNumber("A001");
        order.setStatus(1);
        order.setCreateTime(new Date());

        torderMapper.insertTorder(order);
        int orderId = order.getId();
        for(int i = 0; i< ids.length ; i++){

            TorderDetail detail = new TorderDetail();
            detail.setOrderId(orderId);
            detail.setDisheId(ids[i]);
            Tdishes td = tdishesMapper.selectTdishesById(ids[i]);
            detail.setName(td.getName());
            detail.setPrice((td.getPrice()));
            detail.setNumber(detail.getNumber());

            torderDetailMapper.insertTorderDetail(detail);
        }

    }
}
