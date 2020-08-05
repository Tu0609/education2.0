package cn.tcr.biz.course;

import cn.tcr.util.ResultUtil;
import cn.tcr.util.vo.course.CourseCommon;
import cn.tcr.util.vo.course.QueryCourse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.xml.transform.Result;
import java.util.Arrays;
import java.util.List;

/**
 * @author TuTu
 * @date 2020/6/20 19:11
 */
@RestController
@Slf4j
public class CourseController {

    private static final String COURSE_URL = "http://education-course";

    @Autowired
    private RestTemplate restTemplate;

    @PostMapping(value = "/course/pc/course/list")
    public ResultUtil getCoursePage(@RequestBody QueryCourse queryCourse) {
        CourseCommon[] courseCommons = restTemplate.postForObject(COURSE_URL + "/courses/pc/course/list", queryCourse, CourseCommon[].class);
        List<CourseCommon> list = Arrays.asList(courseCommons);
        return ResultUtil.success(list);
    }

    @PutMapping(value = "/course/pc/course/update")
    public ResultUtil updateCourse(@RequestBody CourseCommon course)  {
        restTemplate.put(COURSE_URL + "/courses/pc/course/update", course);
        return ResultUtil.success("修改成功！");
    }

}
