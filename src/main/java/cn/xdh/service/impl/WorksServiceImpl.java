package cn.xdh.service.impl;

import cn.xdh.SomeMethods;
import cn.xdh.dao.StudentDao;
import cn.xdh.dao.TeacherDao;
import cn.xdh.dao.WorksDao;
import cn.xdh.entity.Teacher;
import cn.xdh.entity.TeacherLog;
import cn.xdh.entity.Works;
import cn.xdh.service.WorksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author TZB
 */
@Service
public class WorksServiceImpl implements WorksService {
    @Autowired
    private WorksDao worksDao;
    @Autowired
    private TeacherLog teacherLog;
    @Autowired
    private TeacherDao teacherDao;

    @Override
    public List<Works> selectById(int id) {
        return worksDao.selectById(id);
    }

    @Override
    public List<Works> selectAll() {
        return worksDao.selectAll();
    }
    @Override
    public Integer deleteById(int id, HttpServletRequest request) {
        //获取cookie中的老师信息
        String action = "删除作品";
        Cookie[] cookies = request.getCookies();
        String mobile = null;
        String password = null;
        for(Cookie cookie:cookies){
            if (cookie.getName().equals("mobile")){
                mobile = cookie.getValue();
            }
            if (cookie.getName().equals("password")){
                password = cookie.getValue();
            }

        }
        Teacher teacher = teacherDao.selectByPhoneAndPassword(mobile,password);
        TeacherLog teacherLog = new TeacherLog(teacher.getId(),teacher.getName(),action, SomeMethods.getCurrentTime(),SomeMethods.getIp4());
        //将日志实体类添加到日志表中
        teacherDao.addTeacherLog(teacherLog);
        return worksDao.deleteById(id);
    }
}
