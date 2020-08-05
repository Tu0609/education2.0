package cn.tcr.sys.mapper;

import cn.tcr.sys.bean.SysMenu;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 菜单信息 Mapper 接口
 * </p>
 *
 * @author Tutu
 * @since 2020-06-17
 */
public interface SysMenuMapper extends BaseMapper<SysMenu> {

    //根据用户ID获取菜单信息
    public List<SysMenu> getMenuList(@Param("userId") Long userId);

}
