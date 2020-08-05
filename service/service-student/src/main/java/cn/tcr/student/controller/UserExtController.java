package cn.tcr.student.controller;


import cn.tcr.student.bean.UserExt;
import cn.tcr.student.service.IUserExtService;
import cn.tcr.util.vo.student.QueryStudent;
import cn.tcr.util.vo.student.UserExtCommon;
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
//@RequestMapping("/tcr.student/user-ext")
public class UserExtController {

    @Autowired
    private IUserExtService userExtService;

    /**
     *  根据条件分页查询学员信息
     * @param queryStudent
     * @return
     */
    @PostMapping("/users/pc/user/ext/list")
    public List<UserExtCommon> getStudentInfoPage(@RequestBody QueryStudent queryStudent) {
        log.info("----------------------查询学员列表-------------------------");
        List<UserExt> studentInfoPage = userExtService.getStudentInfoPage(queryStudent);
        log.info("----------------学员信息：" + studentInfoPage);

        List<UserExtCommon> list = new ArrayList<>();

        for (UserExt userExt : studentInfoPage) {
            UserExtCommon userExtCommon = new UserExtCommon();
            BeanUtils.copyProperties(userExt, userExtCommon);
            list.add(userExtCommon);
        }
        return list;
    }

    /**
     *  修改学员信息
     * @param userExt
     * @return
     */
    @PutMapping("/users/pc/platform/update")
    public Integer  updateStudent(@RequestBody UserExt userExt) {
        log.info("----------------------修改学员信息-------------------------");
        log.info("----------------修改信息：" + userExt);
        return userExtService.updateStudent(userExt);
    }
}

