package cn.tcr.sys.controller;


import cn.tcr.sys.service.ISysUserService;
import cn.tcr.util.vo.sys.SysUserCommon;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 后台用户信息 前端控制器
 * </p>
 *
 * @author Tutu
 * @since 2020-06-17
 */
@RestController
@Slf4j
public class SysUserController {

    @Autowired
    private ISysUserService userService;

    @GetMapping(value = "/sys/login/{username}")
    public SysUserCommon login(@PathVariable("username") String username) {
        return userService.login(username);
    }

}

