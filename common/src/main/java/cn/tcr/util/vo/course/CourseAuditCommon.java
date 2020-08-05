package cn.tcr.util.vo.course;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * <p>
 * 课程信息-审核
 * </p>
 *
 * @author Tutu
 * @since 2020-06-18
 */
@Data
public class CourseAuditCommon implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    private LocalDateTime gmtCreate;

    private LocalDateTime gmtModified;

    private Integer statusId;

    private Integer sort;

    private Integer auditStatus;

    private String auditOpinion;

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

}
