package cn.tcr.course.controller;


import cn.tcr.course.bean.CourseAudit;
import cn.tcr.course.bean.vo.QueryCourseAudit;
import cn.tcr.course.service.ICourseAuditService;
import cn.tcr.util.ResultUtil;
import cn.tcr.util.vo.course.CourseAuditCommon;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 课程信息-审核 前端控制器
 * </p>
 *
 * @author Tutu
 * @since 2020-06-18
 */
@RestController
//@RequestMapping("/tcr.course/course-audit")
@Slf4j
public class CourseAuditController {

    @Autowired
    private ICourseAuditService courseAuditService;

    /**
     *  获取课程审核信息
     * @param courseAudit
     * @return
     */
    @PostMapping(value = "/courses/pc/course/audit/list")
    public List<CourseAuditCommon> getCourseAuditPage(@RequestBody QueryCourseAudit courseAudit) {
        log.info("--------------------------获取课程审核信息------------------------------");
        log.info("------------------------查询条件：" + courseAudit);
        List<CourseAudit> courseAuditPage = courseAuditService.getCourseAuditPage(courseAudit);

        List<CourseAuditCommon> list = new ArrayList<>();

        for (CourseAudit audit : courseAuditPage) {
            CourseAuditCommon auditCommon = new CourseAuditCommon();
            BeanUtils.copyProperties(audit, auditCommon);
            list.add(auditCommon);
        }

        log.info("------------------------查询出的数据：" + courseAuditPage);
        return list;
    }

    /**
     *  更新课程审核信息
     * @param courseAudit
     * @return
     */
    @PutMapping(value = "/courses/pc/adv/update")
    public Integer updateCourseAudit(@RequestBody CourseAudit courseAudit) {
        log.info("--------------------------更新课程审核信息------------------------------");
        log.info("------------------------更新审核信息：" + courseAudit);
        return courseAuditService.updateCourseAudit(courseAudit);
    }
}

