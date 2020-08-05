package cn.tcr.course.service;

import cn.tcr.course.bean.CourseAudit;
import cn.tcr.course.bean.vo.QueryCourseAudit;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 课程信息-审核 服务类
 * </p>
 *
 * @author Tutu
 * @since 2020-06-18
 */
public interface ICourseAuditService extends IService<CourseAudit> {

    public List<CourseAudit> getCourseAuditPage(QueryCourseAudit courseAudit);

    public Integer updateCourseAudit(CourseAudit courseAudit);
}
