package cn.tcr.lecturer.service.impl;

import cn.tcr.lecturer.bean.LecturerAudit;
import cn.tcr.lecturer.mapper.LecturerAuditMapper;
import cn.tcr.lecturer.service.ILecturerAuditService;
import cn.tcr.util.vo.lecturer.QueryLecturerAudit;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Tutu
 * @since 2020-06-18
 */
@Service
public class LecturerAuditServiceImpl extends ServiceImpl<LecturerAuditMapper, LecturerAudit> implements ILecturerAuditService {

    /**
     *  根据条件分页查询审核讲师
     * @param lecturerAudit
     * @return
     */
    @Override
    public List<LecturerAudit> getLecturerAuditPage(QueryLecturerAudit lecturerAudit) {

        Page page = new Page(lecturerAudit.getCurrend(), lecturerAudit.getLimit());

        QueryWrapper wrapper = new QueryWrapper();

        if (lecturerAudit.getLecturerName() != null) {
            wrapper.like("lecturer_name", lecturerAudit.getLecturerName());
        }

        if (lecturerAudit.getLecturerMobile() != null) {
            wrapper.eq("lecturer_mobile", lecturerAudit.getLecturerMobile());
        }

        if (lecturerAudit.getStatusId() != -1) {
            wrapper.eq("status_id", lecturerAudit.getStatusId());
        }

        if (lecturerAudit.getAuditStatus() != -1) {
            wrapper.eq("audit_status", lecturerAudit.getAuditStatus());
        }

        IPage iPage = baseMapper.selectPage(page, wrapper);

        return iPage.getRecords();
    }

    /**
     *  更新审核信息
     * @param lecturerAudit
     * @return
     */
    @Override
    public Integer updateLecturer(LecturerAudit lecturerAudit) {
        return baseMapper.updateById(lecturerAudit);
    }
}
