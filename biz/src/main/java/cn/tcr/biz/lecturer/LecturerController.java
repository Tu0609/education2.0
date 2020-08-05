package cn.tcr.biz.lecturer;

import cn.tcr.util.ResultUtil;
import cn.tcr.util.vo.lecturer.LecturerCommon;
import cn.tcr.util.vo.lecturer.QueryLecturer;
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
 * @date 2020/6/21 10:10
 */
@RestController
@Slf4j
public class LecturerController {

    private static final String LECTURER_URL = "http://education-lecturer";

    @Autowired
    private RestTemplate restTemplate;

    /**
     *  根据条件分页查询讲师信息
     *
     * @param queryLecturer
     * @return
     */
    @PostMapping("/user/pc/lecturer/list")
    public ResultUtil getLecturerPage(@RequestBody QueryLecturer queryLecturer) {
        LecturerCommon[] lecturerCommons = restTemplate.postForObject(LECTURER_URL + "/users/pc/lecturer/list", queryLecturer, LecturerCommon[].class);
        List<LecturerCommon> list = Arrays.asList(lecturerCommons);
        return ResultUtil.success(list);
    }

    /**
     *  更新讲师信息
     * @param lecturer
     * @return
     */
    @PutMapping("/user/pc/lecturer/update")
    public ResultUtil updateLecturer(@RequestBody LecturerCommon lecturer) {
        restTemplate.put(LECTURER_URL + "/users/pc/lecturer/update", lecturer);
        return ResultUtil.success("修改讲师信息成功！");
    }
}
