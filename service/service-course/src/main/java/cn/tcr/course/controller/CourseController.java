package cn.tcr.course.controller;


import cn.tcr.course.bean.Course;
import cn.tcr.course.bean.vo.QueryCourse;
import cn.tcr.course.service.ICourseService;
import cn.tcr.util.ResultUtil;
import cn.tcr.util.vo.course.CourseCommon;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 课程信息 前端控制器
 * </p>
 *
 * @author Tutu
 * @since 2020-06-18
 */
@RestController
@Slf4j
//@RequestMapping("/tcr.course/course")
public class CourseController {

    @Autowired
    private ICourseService courseService;

    /**
     *  根据条件分页查询课程信息
     * @param queryCourse
     * @return
     */
    @PostMapping(value = "/courses/pc/course/list")
    public List<CourseCommon> getCoursePage(@RequestBody QueryCourse queryCourse) {
        log.info("------------------------查询课程信息----------------------------");
        List<Course> coursePage = courseService.getCoursePage(queryCourse);

        List<CourseCommon> list = new ArrayList<>();

        for (Course course : coursePage) {
            CourseCommon courseCommon = new CourseCommon();
            BeanUtils.copyProperties(course, courseCommon);
            list.add(courseCommon);
        }

        log.info("-------------------课程信息：" + coursePage);
        return list;
    }

    /**
     *  更新课程信息
     * @param course
     * @return
     */
    @PutMapping(value = "/courses/pc/course/update")
    public Integer updateCourse(@RequestBody Course course) {
        log.info("------------------------更新课程信息----------------------------");
        log.info("-------------------条件信息：" + course);
        return courseService.updateCourse(course);
    }
}

