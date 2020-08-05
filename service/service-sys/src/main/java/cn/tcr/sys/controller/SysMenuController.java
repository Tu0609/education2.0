package cn.tcr.sys.controller;


import cn.tcr.sys.service.ISysMenuService;
import cn.tcr.util.vo.sys.SysMenuCommon;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 菜单信息 前端控制器
 * </p>
 *
 * @author Tutu
 * @since 2020-06-17
 */
@RestController
@Slf4j
//@RequestMapping("/tcr/sys-menu")
public class SysMenuController {

    @Autowired
    private ISysMenuService menuService;

    @GetMapping("/sys/get/menulist/{userId}")
    public List<SysMenuCommon> getMenuList(@PathVariable("userId") Long userId) {
        return menuService.getMenuList(userId);
    }

}

