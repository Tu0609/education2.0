package cn.tcr.sys.service;

import cn.tcr.sys.bean.SysMenu;
import cn.tcr.util.vo.sys.SysMenuCommon;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 菜单信息 服务类
 * </p>
 *
 * @author Tutu
 * @since 2020-06-17
 */
public interface ISysMenuService extends IService<SysMenu> {

    //根据用户ID获取菜单信息

    public List<SysMenuCommon> getMenuList(Long userId);

}
