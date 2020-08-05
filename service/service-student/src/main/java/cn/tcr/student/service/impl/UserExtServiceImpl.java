package cn.tcr.student.service.impl;

import cn.tcr.student.bean.UserExt;
import cn.tcr.student.mapper.UserExtMapper;
import cn.tcr.student.service.IUserExtService;
import cn.tcr.util.vo.student.QueryStudent;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Tutu
 * @since 2020-06-18
 */
@Service
public class UserExtServiceImpl extends ServiceImpl<UserExtMapper, UserExt> implements IUserExtService {

    @Autowired
    private UserExtMapper userExtMapper;

    /**
     *  根据条件分页查询学员信息
     * @param queryStudent
     * @return
     */
    @Override
    public List<UserExt> getStudentInfoPage(QueryStudent queryStudent) {

        Page page = new Page(queryStudent.getCurrend(), queryStudent.getLimit());

        //查询条件
        QueryWrapper queryWrapper = new QueryWrapper();

        if (queryStudent.getMobile() != null) {
            queryWrapper.eq("mobile",queryStudent.getMobile());
        }

        if (queryStudent.getNickname() != null) {
            queryWrapper.like("nickname",queryStudent.getNickname());
        }

        if (queryStudent.getStatusId() != -1) {
            queryWrapper.eq("statuc_id",queryStudent.getStatusId());
        }

        if (queryStudent.getCreateTime() != null && queryStudent.getEndTime() != null) {
            queryWrapper.between("gmt_create", queryStudent.getCreateTime(), queryStudent.getEndTime());
        }

        IPage iPage = baseMapper.selectPage(page, queryWrapper);

        return iPage.getRecords();
    }

    /**
     *  修改学员信息
     * @param userExt
     * @return
     */
    @Override
    public Integer updateStudent(UserExt userExt) {

//        QueryWrapper wrapper = new QueryWrapper();
//
//        if (userExt.getMobile() != null) {
//            wrapper.eq("mobile",  userExt.getMobile());
//        }
//
//        if (userExt.getNickname() != null) {
//            wrapper.like("nickname", userExt.getNickname());
//        }
//
//        if (userExt.getStatusId() != -1) {
//            wrapper.eq("status_id", userExt.getStatusId());
//        }
//
//        if (userExt.getRemark() != null) {
//            wrapper.eq("remark", userExt.getRemark());
//        }
//
//        wrapper.eq("sex", userExt.getSex());
//        wrapper.eq("age",userExt.getAge());

        int update = baseMapper.updateById(userExt);

        return update;
    }
}
