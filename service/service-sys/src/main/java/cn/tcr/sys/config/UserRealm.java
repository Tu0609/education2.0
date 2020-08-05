//package cn.tcr.sys.config;//package cn.tcr.auth.config;
//
//import cn.tcr.sys.bean.SysMenu;
//import cn.tcr.sys.bean.SysUser;
//import cn.tcr.sys.service.ISysMenuService;
//import cn.tcr.sys.service.ISysUserService;
//import cn.tcr.util.JwtUtils;
//import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
//import lombok.extern.slf4j.Slf4j;
//import org.apache.shiro.authc.*;
//import org.apache.shiro.authz.AuthorizationInfo;
//import org.apache.shiro.authz.SimpleAuthorizationInfo;
//import org.apache.shiro.realm.AuthorizingRealm;
//import org.apache.shiro.subject.PrincipalCollection;
//import org.springframework.beans.factory.annotation.Autowired;
////import org.springframework.data.redis.core.RedisTemplate;
//
//import java.util.List;
//
///**
// * @author TuTu
// * @date 2020/6/17 10:01
// */
//@Slf4j
//public class UserRealm extends AuthorizingRealm {
//
//    @Autowired
//    private ISysMenuService iSysMenuService;
//
//    @Autowired
//    private ISysUserService userService;
//
//    /**
//     *  权限认证
//     * @param principalCollection
//     * @return
//     */
//    @Override
//    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
//        //获取用户信息
//        SysUser user = (SysUser) principalCollection.getPrimaryPrincipal();
//        //根据用户ID获取权限信息
//        List<SysMenu> menuList = iSysMenuService.getMenuList(user.getId());
//        //为当前用户设置角色和权限
//        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
//        for (SysMenu menu : menuList) {
//            log.info("-----------" + menu.getApiUrl());
//            authorizationInfo.addStringPermission(menu.getApiUrl());
//        }
//        return authorizationInfo;
//    }
//
//    /**
//     *  身份认证
//     * @param authenticationToken
//     * @return
//     * @throws AuthenticationException
//     */
//    @Override
//    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
//
//        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
//        //获取用户名称
//        String username = token.getUsername();
//        log.info("---------------------用户登录的用户名为：" + username);
//        //获取用户密码
//        String password = new String((char[]) token.getCredentials());
//        log.info("---------------------用户登录的密码为：" + password);
//        //查询条件
//        QueryWrapper wrapper = new QueryWrapper();
//        wrapper.eq("mobile",username);
//
//        SysUser user = userService.getOne(wrapper);
//
//        if (user == null) {
//            log.info("---------------------该用户没有注册---------------------");
//            return null;
//        }
//
////        if (password.equals(user.getUserPassword())) {
////            //将用户信息存入redis，生成token
////            redisTemplate.opsForValue().set(JwtUtils.getJwtToken(user.getId().toString(), user.getMobile()),user);
////        }
//
//
//        return new SimpleAuthenticationInfo(user,user.getUserPassword(),"");
//    }
//}
