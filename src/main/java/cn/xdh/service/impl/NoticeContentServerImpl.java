package cn.xdh.service.impl;

import cn.xdh.dao.NoticeContentDao;
import cn.xdh.dao.TeacherDao;
import cn.xdh.entity.NoticeContent;
import cn.xdh.entity.NoticeData;
import cn.xdh.entity.TeacherLog;
import cn.xdh.service.NoticeContentService;
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
 * @created 2019-12-30 10:34
 * @function ""
 */
@Service
public class NoticeContentServerImpl implements NoticeContentService {
    @Autowired
    private NoticeContentDao noticeContentDao;
    @Autowired
    private TeacherLog teacherLog;
    @Autowired
    private TeacherDao teacherDao;
    @Override
    public Integer addNoticeContent(String content, Long time, HttpServletRequest request) {
        //获取cookie中的老师信息
        String action = "添加公告";
        teacherLog = SomeMethods.getCookieValue(request,teacherLog,action);
        //将日志实体类添加到日志表中
        teacherDao.addTeacherLog(teacherLog);
        Integer nc = noticeContentDao.addNoticeContent(content,time);
        return nc;
    }
}
