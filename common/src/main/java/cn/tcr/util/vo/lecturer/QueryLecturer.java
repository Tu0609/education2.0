package cn.tcr.util.vo.lecturer;

import lombok.Data;

/**
 * @author TuTu
 * @date 2020/6/18 14:34
 */
@Data
public class QueryLecturer {

    private String lecturerName;

    private String lecturerMobile;

    private Integer statusId;

    private Integer currend;

    private Integer limit;

}
