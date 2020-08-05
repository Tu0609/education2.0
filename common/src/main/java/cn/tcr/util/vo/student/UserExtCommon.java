package cn.tcr.util.vo.student;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author TuTu
 * @date 2020/6/20 15:51
 */
@Data
public class UserExtCommon {

    private Long id;

    private LocalDateTime gmtCreate;

    private LocalDateTime gmtModified;

    private Integer statusId;

    private Long userNo;

    private Integer userType;

    private String mobile;

    private Integer sex;

    private Integer age;

    private String nickname;

    private String headImgUrl;

    private String remark;

}
