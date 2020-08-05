package cn.tcr.lecturer.service;

import cn.tcr.lecturer.bean.Lecturer;
import cn.tcr.util.vo.lecturer.QueryLecturer;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Tutu
 * @since 2020-06-18
 */
public interface ILecturerService extends IService<Lecturer> {

    public List<Lecturer> getLecturerPage(QueryLecturer queryLecturer);

    public Integer updateLecturer(Lecturer lecturer);
}
