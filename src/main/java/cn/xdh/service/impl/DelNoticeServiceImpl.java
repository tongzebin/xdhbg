package cn.xdh.service.impl;

import cn.xdh.dao.DelNoticeDao;
import cn.xdh.dao.TeacherDao;
import cn.xdh.entity.TeacherLog;
import cn.xdh.service.DelNoticeService;
import cn.xdh.util.SomeMethods;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

/**
 * @author victor
 * @site https://victorfengming.github.io/
 * @company XDL
 * @project xdh
 * @package cn.xdh.service.impl
 * @created 2019-12-30 14:33
 * @function ""
 */
@Service
public class DelNoticeServiceImpl implements DelNoticeService {
    @Autowired
    private DelNoticeDao delNoticeDao;
    @Autowired
    private TeacherLog teacherLog;
    @Autowired
    private TeacherDao teacherDao;
    @Override
    public Integer delNoticeService(Integer id, HttpServletRequest request) {
        //获取cookie中的老师信息
        String action = "删除公告";
        teacherLog = SomeMethods.getCookieValue(request,teacherLog,action);
        //将日志实体类添加到日志表中
        teacherDao.addTeacherLog(teacherLog);
        return delNoticeDao.delNoticeDao(id);
    }
}
