package cn.tcr.lecturer.service;

import cn.tcr.lecturer.bean.LecturerAudit;
import cn.tcr.util.vo.lecturer.QueryLecturerAudit;
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
public interface ILecturerAuditService extends IService<LecturerAudit> {

    public List<LecturerAudit> getLecturerAuditPage(QueryLecturerAudit lecturerAudit);

    public Integer updateLecturer(LecturerAudit lecturerAudit);
}
