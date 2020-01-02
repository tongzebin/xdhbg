package cn.xdh.service.impl;

import cn.xdh.dao.ExeperienceDao;
import cn.xdh.dao.TeacherDao;
import cn.xdh.entity.Exeperience;
import cn.xdh.entity.TeacherLog;
import cn.xdh.service.ExeperienceService;
import cn.xdh.util.SomeMethods;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author TZB
 */
@Service
public class ExeperienceServiceImpl implements ExeperienceService {

    @Autowired
    ExeperienceDao exeperienceDao;
    @Autowired
    private TeacherLog teacherLog;
    @Autowired
    private TeacherDao teacherDao;

    @Override
    public List<Exeperience> selectAll() {
        return exeperienceDao.selectAll();
    }

    @Override
    public List<Exeperience> selectByStudent_id(int id) {
        return exeperienceDao.selectByStudent_id(id);
    }

    @Override
    public Integer deleteById(int id, HttpServletRequest request) {
        //获取cookie中的老师信息
        String action = "删除心得";
        teacherLog = SomeMethods.getCookieValue(request,teacherLog,action);
        //将日志实体类添加到日志表中
        teacherDao.addTeacherLog(teacherLog);
        return exeperienceDao.deleteById(id);
    }
}
