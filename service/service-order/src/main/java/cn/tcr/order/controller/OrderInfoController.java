package cn.tcr.order.controller;


import cn.tcr.order.bean.OrderInfo;
import cn.tcr.order.service.IOrderInfoService;
import cn.tcr.util.ResultUtil;
import cn.tcr.util.vo.order.OrderInfoCommon;
import cn.tcr.util.vo.order.QueryOrder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 订单信息表 前端控制器
 * </p>
 *
 * @author Tutu
 * @since 2020-06-19
 */
@RestController
@Slf4j
//@RequestMapping("/tcr.order/order-info")
public class OrderInfoController {

    @Autowired
    private IOrderInfoService orderInfoService;

    /**
     * 更具条件获取订单信息
     * @param queryOrder
     * @return
     */
    @PostMapping(value = "/courses/pc/order/info/list")
    public List<OrderInfoCommon> getOrderInfoPage(@RequestBody QueryOrder queryOrder) {

        log.info("-----------------------获取订单信息--------------------------------");
        log.info("--------------------------订单查询的条件：" + queryOrder);

        List<OrderInfo> orderInfoPage = orderInfoService.getOrderInfoPage(queryOrder);

        log.info("--------------------------查询出来的订单数据：" + orderInfoPage);

        List<OrderInfoCommon> list = new ArrayList<>();

        for (OrderInfo orderInfo : orderInfoPage) {
            OrderInfoCommon orderInfoCommon = new OrderInfoCommon();
            BeanUtils.copyProperties(orderInfo, orderInfoCommon);
            list.add(orderInfoCommon);
        }
        return list;
    }

    @RequestMapping("/qwe")
    public void getTest() {
        log.info("你越权了!");
    }

}

