package cn.tcr.util.vo.course;

import lombok.Data;

/**
 * @author TuTu
 * @date 2020/6/18 16:47
 */
@Data
public class QueryCourse {

    private String courseName;

    private Integer statusId;

    private Integer isFree;

    private Integer isPutaway;

    private Integer currend;

    private Integer limit;
}
