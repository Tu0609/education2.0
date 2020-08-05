package cn.tcr.lecturer.controller;


import cn.tcr.lecturer.bean.Lecturer;
import cn.tcr.lecturer.bean.LecturerAudit;
import cn.tcr.lecturer.service.ILecturerAuditService;
import cn.tcr.util.ResultUtil;
import cn.tcr.util.vo.lecturer.LecturerAuditCommon;
import cn.tcr.util.vo.lecturer.LecturerCommon;
import cn.tcr.util.vo.lecturer.QueryLecturerAudit;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Tutu
 * @since 2020-06-18
 */
@RestController
@Slf4j
//@RequestMapping("/tcr.lecturer/lecturer-audit")
public class LecturerAuditController {

    @Autowired
    private ILecturerAuditService lecturerAuditService;

    @PostMapping(value = "/users/pc/lecturer/audit/list")
    public List<LecturerAuditCommon> getLecturerAuditPage(@RequestBody QueryLecturerAudit lecturerAudit) {
        log.info("-------------------------------获取讲师审核信息---------------------------------");
        List<LecturerAudit> lecturerAuditPage = lecturerAuditService.getLecturerAuditPage(lecturerAudit);
        log.info("-----------------------------查询出来的结果：" + lecturerAuditPage);

        List<LecturerAuditCommon> list = new ArrayList<>();

        for (LecturerAudit audit : lecturerAuditPage) {
            LecturerAuditCommon lecturerAuditCommon = new LecturerAuditCommon();
            BeanUtils.copyProperties(audit, lecturerAuditCommon);
            list.add(lecturerAuditCommon);
        }

        return list;
    }

    @PutMapping(value = "/users/pc/lecturer/audit/update")
    public Integer updateLecturerAudit(@RequestBody LecturerAudit lecturerAudit) {
        log.info("-------------------------------修改讲师审核信息---------------------------------");
        log.info("---------------------修改讲师审核信息：" + lecturerAudit);
        return lecturerAuditService.updateLecturer(lecturerAudit);
    }
}

