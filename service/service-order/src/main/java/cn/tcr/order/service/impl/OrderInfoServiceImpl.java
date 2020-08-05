package cn.tcr.order.service.impl;

import cn.tcr.order.bean.OrderInfo;
import cn.tcr.order.mapper.OrderInfoMapper;
import cn.tcr.order.service.IOrderInfoService;
import cn.tcr.util.vo.order.QueryOrder;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 订单信息表 服务实现类
 * </p>
 *
 * @author Tutu
 * @since 2020-06-19
 */
@Service
public class OrderInfoServiceImpl extends ServiceImpl<OrderInfoMapper, OrderInfo> implements IOrderInfoService {

    /**
     *  根据查询条件分页查询
     * @param queryOrder
     * @return
     */
    @Override
    public List<OrderInfo> getOrderInfoPage(QueryOrder queryOrder) {

        Page page = new Page(queryOrder.getCurrend(), queryOrder.getLimit());

        QueryWrapper wrapper = new QueryWrapper();

        if (queryOrder.getMobile() != null) {
            wrapper.eq("mobile", queryOrder.getMobile());
        }

        if (queryOrder.getCourseName() != null) {
            wrapper.like("course_name", queryOrder.getCourseName());
        }

        if (queryOrder.getCreateTime() != null && queryOrder.getEndTime() != null) {
            wrapper.between("gmt_create",queryOrder.getCreateTime(),queryOrder.getEndTime());
        }

        if (queryOrder.getOrderStatus() != -1) {
            wrapper.eq("order_status", queryOrder.getOrderStatus());
        }

        if (queryOrder.getOrderNo() != null) {
            wrapper.eq("order_no", queryOrder.getOrderNo());
        }

        if (queryOrder.getRemark() != null) {
            wrapper.like("remark", queryOrder.getRemark());
        }

        if (queryOrder.getLecturerName() != null) {
            wrapper.like("lecturer_name", queryOrder.getLecturerName());
        }

        if (queryOrder.getChannelType() != -1) {
            wrapper.eq("channel_type", queryOrder.getChannelType());
        }

        if (queryOrder.getPayType() != -1) {
            wrapper.eq("pay_type", queryOrder.getPayType());
        }

        IPage iPage = baseMapper.selectPage(page, wrapper);

        return iPage.getRecords();
    }
}
