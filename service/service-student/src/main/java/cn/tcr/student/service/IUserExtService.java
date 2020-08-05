package cn.tcr.student.service;

import cn.tcr.student.bean.UserExt;
import cn.tcr.util.vo.student.QueryStudent;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Tutu
 * @since 2020-06-18
 */
public interface IUserExtService extends IService<UserExt> {

    public List<UserExt> getStudentInfoPage(QueryStudent queryStudent);

    public Integer updateStudent(UserExt userExt);

}
