package cn.tcr.course.service;

import cn.tcr.course.bean.Course;
import cn.tcr.course.bean.vo.QueryCourse;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 课程信息 服务类
 * </p>
 *
 * @author Tutu
 * @since 2020-06-18
 */
public interface ICourseService extends IService<Course> {

    public List<Course> getCoursePage(QueryCourse queryCourse);

    public Integer updateCourse(Course course);
}
