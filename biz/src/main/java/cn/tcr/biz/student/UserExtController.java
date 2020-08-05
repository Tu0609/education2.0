package cn.tcr.biz.student;

import cn.tcr.biz.sys.util.FinalClass;
import cn.tcr.util.ResultUtil;
import cn.tcr.util.vo.student.QueryStudent;
import cn.tcr.util.vo.student.UserExtCommon;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.xml.transform.Result;
import java.net.URL;
import java.util.Arrays;
import java.util.List;

/**
 * @author TuTu
 * @date 2020/6/20 15:54
 */
@RestController
@Slf4j
public class UserExtController {

    private static final String STUDENT_URL = "http://education-student";

    @Autowired
    private RestTemplate restTemplate;

    @PostMapping("/user/pc/user/ext/list")
    public ResultUtil getStudentInfoPage(@RequestBody QueryStudent queryStudent) {
        UserExtCommon[] forObject = restTemplate.postForObject(STUDENT_URL + "/users/pc/user/ext/list", queryStudent ,UserExtCommon[].class);
        List<UserExtCommon> list = Arrays.asList(forObject);
        return ResultUtil.success(list);
    }

    @PutMapping("/user/pc/platform/update")
    public ResultUtil  updateStudent(@RequestBody UserExtCommon userExt) {
        restTemplate.put(STUDENT_URL + "/users/pc/platform/update", userExt);
        return ResultUtil.success("删除成功！");
    }
}
