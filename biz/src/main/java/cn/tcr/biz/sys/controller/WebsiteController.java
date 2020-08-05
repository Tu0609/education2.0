package cn.tcr.biz.sys.controller;

import cn.tcr.biz.sys.util.FinalClass;
import cn.tcr.util.ResultUtil;
import cn.tcr.util.vo.sys.WebsiteCommon;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author TuTu
 * @date 2020/6/20 15:37
 */
@RestController
@Slf4j
public class WebsiteController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/system/pc/website/view")
    public ResultUtil getWebsiteInfo() {
        WebsiteCommon forObject = restTemplate.getForObject(FinalClass.SYS_URL + "/sys/pc/website/view", WebsiteCommon.class);
        return ResultUtil.success(forObject);
    }

}
