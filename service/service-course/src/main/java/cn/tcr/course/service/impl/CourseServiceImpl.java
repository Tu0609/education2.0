package cn.tcr.course.service.impl;

import cn.tcr.course.bean.Course;
import cn.tcr.course.bean.vo.QueryCourse;
import cn.tcr.course.mapper.CourseMapper;
import cn.tcr.course.service.ICourseService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 课程信息 服务实现类
 * </p>
 *
 * @author Tutu
 * @since 2020-06-18
 */
@Service
public class CourseServiceImpl extends ServiceImpl<CourseMapper, Course> implements ICourseService {

    /**
     *  根据条件分页查询课程信息
     * @param queryCourse
     * @return
     */
    @Override
    public List<Course> getCoursePage(QueryCourse queryCourse) {

        Page page = new Page(queryCourse.getCurrend(), queryCourse.getLimit());

        QueryWrapper wrapper = new QueryWrapper();

        if (queryCourse.getCourseName() != null) {
            wrapper.like("course_name", queryCourse.getCourseName());
        }

        if (queryCourse.getStatusId() != -1) {
            wrapper.eq("status_id", queryCourse.getStatusId());
        }

        if (queryCourse.getIsFree() != -1) {
            wrapper.eq("is_free", queryCourse.getIsFree());
        }

        if (queryCourse.getIsPutaway() != -1) {
            wrapper.eq("is_putaway", queryCourse.getIsPutaway());
        }

        IPage iPage = baseMapper.selectPage(page, wrapper);
        return iPage.getRecords();
    }

    /**
     *  更新课程信息
     * @param course
     * @return
     */
    @Override
    public Integer updateCourse(Course course) {
        return baseMapper.updateById(course);
    }
}
