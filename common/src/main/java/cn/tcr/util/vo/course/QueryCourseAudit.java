package cn.tcr.util.vo.course;

import lombok.Data;

/**
 * @author TuTu
 * @date 2020/6/20 17:09
 */
@Data
public class QueryCourseAudit {

    private String courseName;

    private Integer statusId;

    private Integer isFree;

    private Integer isPutaway;

    private Integer auditStatus;

    private Integer currend;

    private Integer limit;

}
