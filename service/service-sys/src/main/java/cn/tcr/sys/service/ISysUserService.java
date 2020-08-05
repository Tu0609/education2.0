package cn.tcr.sys.service;

import cn.tcr.sys.bean.SysUser;
import cn.tcr.util.vo.sys.SysUserCommon;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 后台用户信息 服务类
 * </p>
 *
 * @author Tutu
 * @since 2020-06-17
 */
public interface ISysUserService extends IService<SysUser> {

    public SysUserCommon login(String username);

}
