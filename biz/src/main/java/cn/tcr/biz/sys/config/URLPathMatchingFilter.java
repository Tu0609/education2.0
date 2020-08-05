package cn.tcr.biz.sys.config;//package cn.tcr.auth.config;

import cn.tcr.biz.sys.util.FinalClass;
import cn.tcr.util.vo.sys.SysMenuCommon;
import cn.tcr.util.vo.sys.SysUserCommon;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.PathMatchingFilter;
import org.apache.shiro.web.util.WebUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author TuTu
 * @date 2020/6/18 8:38
 */
@Component
@Slf4j
public class URLPathMatchingFilter extends PathMatchingFilter {

    @Autowired
    private RestTemplate restTemplate;

    public static URLPathMatchingFilter testUtils;

    @PostConstruct
    public void init() {
        testUtils = this;
    }

    public boolean onPreHandle(ServletRequest request, ServletResponse response, Object mappedValue) throws Exception {

        //获取请求的url
        String requestURL = getPathWithinApplication(request);
        Subject subject = SecurityUtils.getSubject();

        log.info("---------------------请求的URL：" + requestURL);
//        log.info((String) subject.getPrincipal());
        if (!subject.isAuthenticated()) {
            log.info("未登录跳转到登录页面!");
            //保存当前地址并重定向到登录界面
            HttpServletRequest req = (HttpServletRequest) request;
            HttpServletResponse res = (HttpServletResponse) response;
            saveRequestAndRedirectToLogin(req,res);
            return false;
        }

        SysUserCommon user = (SysUserCommon) subject.getPrincipal();

        List<String> url = new ArrayList<>();
        log.info("------------------用户的ID" + user.getId());

        //根据用户ID获取权限信息
        SysMenuCommon[] menuCommon = testUtils.restTemplate.getForObject(FinalClass.SYS_URL + "/sys/get/menulist/" + user.getId(), SysMenuCommon[].class);

        List<SysMenuCommon> menuCommonList = Arrays.asList(menuCommon);

        for (SysMenuCommon menu : menuCommon) {
            url.add(menu.getApiUrl());
        }

        boolean hasPermission = false;
        //对路径进行判断
        for (String str : url) {
            if (requestURL.equals(str)) {
                hasPermission = true;
                break;
            }
        }

        if (hasPermission) {
            return true;
        } else {
            return false;
        }

    }

    private void saveRequestAndRedirectToLogin(HttpServletRequest request , HttpServletResponse response) throws Exception {
        WebUtils.saveRequest(request);
        WebUtils.issueRedirect(request,response, "login.html");

    }

}
