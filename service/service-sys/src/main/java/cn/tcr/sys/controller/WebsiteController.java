package cn.tcr.sys.controller;


import cn.tcr.util.ResultUtil;
import cn.tcr.sys.bean.Website;
import cn.tcr.sys.service.IWebsiteService;
import cn.tcr.util.vo.sys.WebsiteCommon;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 站点信息 前端控制器
 * </p>
 *
 * @author Tutu
 * @since 2020-06-18
 */
@RestController
//@RequestMapping("/tcr/sys/website")
@Slf4j
public class WebsiteController {

    @Autowired
    private IWebsiteService websiteService;

    @GetMapping(value = "/sys/pc/website/view")
    public WebsiteCommon getWebsiteInfo() {
        log.info("--------------------------获取站点信息--------------------------");
        Website one = websiteService.getOne(null);
        log.info("---------------------站点信息：" + one);
        WebsiteCommon websiteCommon = new WebsiteCommon();
        BeanUtils.copyProperties(one, websiteCommon);
        return websiteCommon;
    }

}

