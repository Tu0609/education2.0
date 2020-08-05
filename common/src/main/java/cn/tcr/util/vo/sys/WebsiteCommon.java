package cn.tcr.util.vo.sys;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 站点信息
 * </p>
 *
 * @author Tutu
 * @since 2020-06-18
 */
@Data
public class WebsiteCommon implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    private LocalDateTime gmtCreate;

    private LocalDateTime gmtModified;

    private Integer statusId;

    private Integer sort;

    private String logoIco;

    private String logoImg;

    private String websiteTitle;

    private String websiteKeyword;

    private String websiteDesc;

    private String copyright;

    private String icp;

    private String prn;

    private String weixin;

    private String weixinXcx;

    private String weibo;

    private Integer isEnableStatistics;

    private String statisticsCode;

    private Integer isShowService;

    private String service1;

    private String service2;

    private String userAgreement;

    private String recruitTitle;

    private String recruitInfo;

    private String entryAgreement;

}
