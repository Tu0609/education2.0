package cn.tcr.biz.sys.controller;

import cn.tcr.util.MD5;
import cn.tcr.util.ResultUtil;
import cn.tcr.util.vo.sys.LoginUserVO;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author TuTu
 * @date 2020/6/20 14:16
 */
@RestController
@Slf4j
public class SysUserController {

    @Autowired
    private RestTemplate restTemplate;

    @PostMapping("/login")
    public ResultUtil login(@RequestBody LoginUserVO loginUserVO) {

        Subject subject = SecurityUtils.getSubject();

        UsernamePasswordToken token = new UsernamePasswordToken(loginUserVO.getUsername(), MD5.encrypt(loginUserVO.getPassword()));

        try {
            subject.login(token);
            log.info("---------------------登录成功！---------------------");
        } catch (AuthenticationException e) {
            log.info("---------------------登录失败！---------------------");
            return ResultUtil.failed("用户登录失败！");
        }

        return ResultUtil.success("登录成功！");
    }

    @GetMapping("/course/pc/order/info/li")
    public ResultUtil test() {
        log.info("--------------------是否正确！");
        return ResultUtil.success("---------------------!!!!!");
    }
}
