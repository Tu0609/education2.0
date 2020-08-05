package cn.tcr.sys.service.impl;

import cn.tcr.sys.bean.SysMenu;
//import cn.tcr.sys.controller.SysMenuController;
import cn.tcr.sys.mapper.SysMenuMapper;
import cn.tcr.sys.service.ISysMenuService;
import cn.tcr.util.vo.sys.SysMenuCommon;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 菜单信息 服务实现类
 * </p>
 *
 * @author Tutu
 * @since 2020-06-17
 */
@Service
public class SysMenuServiceImpl extends ServiceImpl<SysMenuMapper, SysMenu> implements ISysMenuService {

    @Override
    public List<SysMenuCommon> getMenuList(Long userId) {

        List<SysMenuCommon> list = new ArrayList<>();

        for (SysMenu menu : baseMapper.getMenuList(userId)) {
            SysMenuCommon menuCommon = new SysMenuCommon();
            BeanUtils.copyProperties(menu, menuCommon);
            list.add(menuCommon);
        }

        return list;
    }
}
