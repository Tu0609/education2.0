package cn.tcr.order.service;

import cn.tcr.order.bean.OrderInfo;
import cn.tcr.util.vo.order.QueryOrder;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 订单信息表 服务类
 * </p>
 *
 * @author Tutu
 * @since 2020-06-19
 */
public interface IOrderInfoService extends IService<OrderInfo> {

    public List<OrderInfo> getOrderInfoPage(QueryOrder queryOrder);

}
