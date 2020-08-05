//package cn.tcr.sys.config;
//
//import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
//import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import javax.servlet.Filter;
//import java.util.LinkedHashMap;
//import java.util.Map;
//
///**
// * @author TuTu
// * @date 2020/6/17 10:00
// */
//@Configuration
//public class ShiroConfig {
//
//    @Bean
//    public ShiroFilterFactoryBean shiroFilterFactoryBean (@Qualifier("defaultWebSecurityManager") DefaultWebSecurityManager defaultWebSecurityManager) {
//        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
//        //Shiro的核心安全接口,这个属性是必须的
//        shiroFilterFactoryBean.setSecurityManager(defaultWebSecurityManager);
//
//        //过滤器集合
//        Map<String, Filter> filterMap = new LinkedHashMap<>();
//        filterMap.put("requestURL", urlPathMatchingFilter());
//        shiroFilterFactoryBean.setFilters(filterMap);
//
//        shiroFilterFactoryBean.setLoginUrl("/login.html");
//
//        /*
//         * 对路径进行限制
//         * authc表示,这这个mapping代表的url需要登陆之后才能查看
//         * anon表示,这个mapping代表的url全部放行,所以可以看到所有js文件与image文件都被放行了
//         */
//        Map<String,String> filterChainDefinitionMap  = new LinkedHashMap<>();
//
//        filterChainDefinitionMap.put("/login","anon");
//        filterChainDefinitionMap.put("/login.html","anon");
//
//        filterChainDefinitionMap.put("/*","authc");
//        filterChainDefinitionMap.put("/**","requestURL");
//        filterChainDefinitionMap.put("/*","requestURL");
//
//        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);
//
//        return shiroFilterFactoryBean;
//    }
//
//    /**
//     * 不指定名字的话，自动创建一个方法名第一个字母小写的bean
//     */
//    @Bean(name = "defaultWebSecurityManager")
//    public DefaultWebSecurityManager securityManager(@Qualifier("userRealm") UserRealm userRealm) {
//        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
//        securityManager.setRealm(userRealm);
//        return securityManager;
//    }
//
//    /**
//     * Shiro Realm 继承自AuthorizingRealm的自定义Realm,即指定Shiro验证用户登录的类为自定义的
//     */
//    @Bean(name = "userRealm")
//    public UserRealm userRealm() {
//        UserRealm userRealm = new UserRealm();
//        return userRealm;
//    }
//
//    public URLPathMatchingFilter urlPathMatchingFilter() {
//        return new URLPathMatchingFilter();
//    }
//
//}
