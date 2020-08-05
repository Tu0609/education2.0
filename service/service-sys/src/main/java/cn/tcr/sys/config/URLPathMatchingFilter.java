//package cn.tcr.sys.config;//package cn.tcr.auth.config;
//
//import cn.tcr.sys.bean.SysMenu;
//import cn.tcr.sys.bean.SysUser;
//import cn.tcr.sys.service.ISysMenuService;
//import lombok.extern.slf4j.Slf4j;
//import org.apache.shiro.SecurityUtils;
//import org.apache.shiro.subject.Subject;
//import org.apache.shiro.web.filter.PathMatchingFilter;
//import org.apache.shiro.web.util.WebUtils;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//
//import javax.annotation.PostConstruct;
//import javax.servlet.ServletRequest;
//import javax.servlet.ServletResponse;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.util.ArrayList;
//import java.util.List;
//
///**
// * @author TuTu
// * @date 2020/6/18 8:38
// */
//@Component
//@Slf4j
//public class URLPathMatchingFilter extends PathMatchingFilter {
//
//    @Autowired
//    private ISysMenuService menuService;
//
//    public static URLPathMatchingFilter testUtils;
//
//    @PostConstruct
//    public void init() {
//        testUtils = this;
//    }
//
//    public boolean onPreHandle(ServletRequest request, ServletResponse response, Object mappedValue) throws Exception {
//
//        //获取请求的url
//        String requestURL = getPathWithinApplication(request);
//        Subject subject = SecurityUtils.getSubject();
//
//        log.info("---------------------请求的URL：" + requestURL);
//        log.info((String) subject.getPrincipal());
//        if (!subject.isAuthenticated()) {
//            log.info("未登录跳转到登录页面!");
//            //保存当前地址并重定向到登录界面
//            HttpServletRequest req = (HttpServletRequest) request;
//            HttpServletResponse res = (HttpServletResponse) response;
//            saveRequestAndRedirectToLogin(req,res);
//            return false;
//        }
//
//        SysUser user = (SysUser) subject.getPrincipal();
//
//        List<String> url = new ArrayList<>();
//        log.info("------------------用户的ID" + user.getId());
//
//        List<SysMenu> menus =testUtils.menuService.getMenuList(user.getId());
//
//        for (SysMenu menu : menus) {
//            url.add(menu.getApiUrl());
//        }
//
//        boolean hasPermission = false;
//        //对路径进行判断
//        for (String str : url) {
//            if (requestURL.equals(str)) {
//                hasPermission = true;
//                break;
//            }
//        }
//
//        if (hasPermission) {
//            return true;
//        } else {
//            return false;
//        }
//
//    }
//
//    private void saveRequestAndRedirectToLogin(HttpServletRequest request , HttpServletResponse response) throws Exception {
//        WebUtils.saveRequest(request);
//        WebUtils.issueRedirect(request,response, "login.html");
//
//    }
//
//}
