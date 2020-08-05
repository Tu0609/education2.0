package cn.tcr.util.vo.lecturer;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * <p>
 * 
 * </p>
 *
 * @author Tutu
 * @since 2020-06-18
 */
@Data
public class LecturerAuditCommon implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    private LocalDateTime gmtCreate;

    private LocalDateTime gmtModified;

    private Integer statusId;

    private Integer sort;

    private Integer auditStatus;

    private String auditOpinion;

    private Long lecturerUserNo;

    private String lecturerName;

    private String lecturerMobile;

    private String lecturerEmail;

    private String position;

    private String headImgUrl;

    private String introduce;

    private BigDecimal lecturerProportion;


}
