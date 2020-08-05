package cn.tcr.util.vo.sys;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 菜单信息
 * </p>
 *
 * @author Tutu
 * @since 2020-06-17
 */
@Data
public class SysMenuCommon implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    private LocalDateTime gmtCreate;

    private LocalDateTime gmtModified;

    private Integer statusId;

    private Integer sort;

    private Long parentId;

    private String menuName;

    private String menuUrl;

    private String apiUrl;

    private String menuIcon;

    private String remark;

    private Integer menuType;


}
