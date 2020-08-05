package cn.tcr.util.vo.order;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * @author TuTu
 * @date 2020/6/22 8:10
 */
@Data
public class OrderInfoCommon implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    private LocalDateTime gmtCreate;

    private LocalDateTime gmtModified;

    private Long lecturerUserNo;

    private String lecturerName;

    private Long userNo;

    private String mobile;

    private LocalDateTime registerTime;

    private Long orderNo;

    private Long courseId;

    private String courseName;

    private BigDecimal pricePayable;

    private BigDecimal priceDiscount;

    private BigDecimal pricePaid;

    private BigDecimal platformProfit;

    private BigDecimal lecturerProfit;

    private Integer tradeType;

    private Integer payType;

    private Integer channelType;

    private Integer orderStatus;

    private Integer isShowLecturer;

    private Integer isShowUser;

    private String remarkCus;

    private String remark;

    private LocalDateTime payTime;

}
