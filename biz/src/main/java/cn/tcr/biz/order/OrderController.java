package cn.tcr.biz.order;

import cn.tcr.util.ResultUtil;
import cn.tcr.util.vo.order.OrderInfoCommon;
import cn.tcr.util.vo.order.QueryOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.swing.*;
import javax.xml.transform.Result;
import java.util.Arrays;
import java.util.List;

/**
 * @author TuTu
 * @date 2020/6/22 8:17
 */
@RestController
public class OrderController {

    private static final String ORDER_URL = "http://education-order";

    @Autowired
    private RestTemplate restTemplate;

    @PostMapping(value = "/course/pc/order/info/list")
    public ResultUtil getOrderInfoPage(@RequestBody QueryOrder queryOrder) {
        OrderInfoCommon[] orderInfoCommons = restTemplate.postForObject(ORDER_URL + "/courses/pc/order/info/list", queryOrder, OrderInfoCommon[].class);
        List<OrderInfoCommon> list = Arrays.asList(orderInfoCommons);
        return ResultUtil.success(list);
    }
}
