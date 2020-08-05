package cn.tcr.sys.service.impl;

import cn.tcr.sys.bean.SysUser;
import cn.tcr.sys.mapper.SysUserMapper;
import cn.tcr.sys.service.ISysUserService;
import cn.tcr.util.vo.sys.SysUserCommon;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 后台用户信息 服务实现类
 * </p>
 *
 * @author Tutu
 * @since 2020-06-17
 */
@Service
@Slf4j
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements ISysUserService {

    public SysUserCommon login(String username) {
        //查询条件
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("mobile", username);

        SysUser sysUser = baseMapper.selectOne(wrapper);

        SysUserCommon userCommon = new SysUserCommon();

        BeanUtils.copyProperties(sysUser, userCommon);

        return userCommon;
    }


}
