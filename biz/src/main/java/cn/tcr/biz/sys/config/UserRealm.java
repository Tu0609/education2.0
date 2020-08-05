package cn.tcr.biz.sys.config;

import cn.tcr.biz.sys.util.FinalClass;
import cn.tcr.util.vo.sys.SysMenuCommon;
import cn.tcr.util.vo.sys.SysUserCommon;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;


/**
 * @author TuTu
 * @date 2020/6/17 10:01
 */
@Slf4j
public class UserRealm extends AuthorizingRealm {

    @Autowired
    private RestTemplate restTemplate;

    /**
     *  权限认证
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        //获取用户信息
        SysUserCommon user = (SysUserCommon) principalCollection.getPrimaryPrincipal();

        //根据用户ID获取权限信息
        ArrayList<SysMenuCommon> menuCommon = restTemplate.getForObject(FinalClass.SYS_URL + "/sys/get/menulist/" + user.getId(), ArrayList.class);

        //为当前用户设置角色和权限
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        for (SysMenuCommon menu : menuCommon) {
            log.info("-----------" + menu.getApiUrl());
            authorizationInfo.addStringPermission(menu.getApiUrl());
        }
        return authorizationInfo;
    }

    /**
     *  身份认证
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {

        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        //获取用户名称
        String username = token.getUsername();
        log.info("---------------------用户登录的用户名为：" + username);
        //获取用户密码
        String password = new String((char[]) token.getCredentials());
        log.info("---------------------用户登录的密码为：" + password);

        SysUserCommon userCommon = restTemplate.getForObject(FinalClass.SYS_URL + "/sys/login/"+ username ,SysUserCommon.class);

        if (userCommon == null) {
            log.info("---------------------该用户没有注册---------------------");
            return null;
        }

        log.info("----------------------查询出来的数据：" + userCommon);

        return new SimpleAuthenticationInfo(userCommon,userCommon.getUserPassword(),"");
    }
}
