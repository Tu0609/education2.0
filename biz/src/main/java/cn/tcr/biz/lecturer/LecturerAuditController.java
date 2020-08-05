package cn.tcr.biz.lecturer;

import cn.tcr.util.ResultUtil;
import cn.tcr.util.vo.lecturer.LecturerAuditCommon;
import cn.tcr.util.vo.lecturer.QueryLecturerAudit;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author TuTu
 * @date 2020/6/21 10:14
 */
@RestController
@Slf4j
public class LecturerAuditController {

    private static final String LECTURER_URL = "http://education-lecturer";

    @Autowired
    private RestTemplate restTemplate;

    @PostMapping(value = "/user/pc/lecturer/audit/list")
    public List<LecturerAuditCommon> getLecturerAuditPage(@RequestBody QueryLecturerAudit lecturerAudit) {
        LecturerAuditCommon[] lecturerAuditCommons = restTemplate.postForObject(LECTURER_URL + "/users/pc/lecturer/audit/list", lecturerAudit, LecturerAuditCommon[].class);
        List<LecturerAuditCommon> lecturerAuditCommonList = Arrays.asList(lecturerAuditCommons);
        return lecturerAuditCommonList;
    }

    @PutMapping(value = "/user/pc/lecturer/audit/update")
    public ResultUtil updateLecturerAudit(@RequestBody LecturerAuditCommon lecturerAudit) {
        restTemplate.put(LECTURER_URL + "/users/pc/lecturer/audit/update", lecturerAudit);
        return ResultUtil.success("修改讲师审核信息成功！");
    }

}
