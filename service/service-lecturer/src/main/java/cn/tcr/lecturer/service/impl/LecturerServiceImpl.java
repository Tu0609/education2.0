package cn.tcr.lecturer.service.impl;

import cn.tcr.lecturer.bean.Lecturer;
import cn.tcr.lecturer.mapper.LecturerMapper;
import cn.tcr.lecturer.service.ILecturerService;
import cn.tcr.util.vo.lecturer.QueryLecturer;
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
public class LecturerServiceImpl extends ServiceImpl<LecturerMapper, Lecturer> implements ILecturerService {

    /**
     *  根据条件分页查询教师信息
     * @param queryLecturer
     * @return
     */
    @Override
    public List<Lecturer> getLecturerPage(QueryLecturer queryLecturer) {

        Page page = new Page(queryLecturer.getCurrend(), queryLecturer.getLimit());

        QueryWrapper wrapper = new QueryWrapper();

        if (queryLecturer.getLecturerName() != null) {
            wrapper.like("lecturer_name",queryLecturer.getLecturerName());
        }

        if (queryLecturer.getLecturerMobile() != null) {
            wrapper.eq("lecturer_mobile",queryLecturer.getLecturerMobile());
        }

        IPage list = baseMapper.selectPage(page,wrapper);

        return list.getRecords();
    }

    @Override
    public Integer updateLecturer(Lecturer lecturer) {
        return baseMapper.updateById(lecturer);
    }
}
