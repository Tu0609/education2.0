package cn.tcr.util.vo.course;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * <p>
 * 课程信息
 * </p>
 *
 * @author Tutu
 * @since 2020-06-18
 */
@Data
public class CourseCommon implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    private LocalDateTime gmtCreate;

    private LocalDateTime gmtModified;

    private Integer statusId;

    private Integer sort;

    private Long lecturerUserNo;

    private Long categoryId1;

    private Long categoryId2;

    private Long categoryId3;

    private String courseName;

    private String courseLogo;

    private Long introduceId;

    private Integer isFree;

    private BigDecimal courseOriginal;

    private BigDecimal courseDiscount;

    private Integer isPutaway;

    private Integer courseSort;

    private Integer countBuy;

    private Integer countStudy;

    private Integer periodTotal;


}
