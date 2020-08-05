package cn.tcr.biz.course;

import cn.tcr.util.ResultUtil;
import cn.tcr.util.vo.course.CourseAuditCommon;
import cn.tcr.util.vo.course.QueryCourseAudit;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

/**
 * @author TuTu
 * @date 2020/6/20 19:22
 */
@RestController
@Slf4j
public class CourseAuditController {

    private static final String COURSE_URL = "http://education-course";

    @Autowired
    private RestTemplate restTemplate;

    @PostMapping(value = "/course/pc/course/audit/list")
    public ResultUtil getCourseAuditPage(@RequestBody QueryCourseAudit courseAudit) {
        CourseAuditCommon[] courseAuditCommons = restTemplate.postForObject(COURSE_URL + "/courses/pc/course/audit/list", courseAudit, CourseAuditCommon[].class);
        List<CourseAuditCommon> list = Arrays.asList(courseAuditCommons);
        return ResultUtil.success(list);
    }

    @PutMapping(value = "/course/pc/adv/update")
    public ResultUtil updateCourseAudit(@RequestBody CourseAuditCommon courseAudit) {
        restTemplate.put(COURSE_URL + "/courses/pc/adv/update", courseAudit);
        return ResultUtil.success("修改成功！");
    }

}
