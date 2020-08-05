package cn.tcr.util.vo.lecturer;

import lombok.Data;

/**
 * @author TuTu
 * @date 2020/6/18 15:32
 */
@Data
public class QueryLecturerAudit {

    private String lecturerName;

    private String lecturerMobile;

    private Integer statusId;

    private Integer auditStatus;

    private Integer currend;

    private Integer limit;
}
