package cn.tcr.lecturer.controller;


import cn.tcr.lecturer.bean.Lecturer;
import cn.tcr.lecturer.service.ILecturerService;
import cn.tcr.util.ResultUtil;
import cn.tcr.util.vo.lecturer.LecturerCommon;
import cn.tcr.util.vo.lecturer.QueryLecturer;
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
//@RequestMapping("/tcr.lecturer/lecturer")
@Slf4j
public class LecturerController {

    @Autowired
    private ILecturerService lecturerService;

    /**
     *  根据条件分页查询讲师信息
     *
     * @param queryLecturer
     * @return
     */
    @PostMapping("/users/pc/lecturer/list")
    public List<LecturerCommon> getLecturerPage(@RequestBody QueryLecturer queryLecturer) {
        log.info("--------------------查询讲师信息-----------------------------");
        List<Lecturer> lecturerPage = lecturerService.getLecturerPage(queryLecturer);
        log.info("---------------------查询到的信息：" + lecturerPage);

        List<LecturerCommon> list = new ArrayList<>();

        for (Lecturer lecturer : lecturerPage) {
            LecturerCommon lecturerCommon = new LecturerCommon();
            BeanUtils.copyProperties(lecturer, lecturerCommon);
            list.add(lecturerCommon);
        }

        return list;
    }

    /**
     *  更新讲师信息
     * @param lecturer
     * @return
     */
    @PutMapping("/users/pc/lecturer/update")
    public Integer updateLecturer(@RequestBody Lecturer lecturer) {
        log.info("--------------------修改讲师信息-----------------------------");
        log.info("--------------------------修改信息：" + lecturer);
        return lecturerService.updateLecturer(lecturer);
    }

}

