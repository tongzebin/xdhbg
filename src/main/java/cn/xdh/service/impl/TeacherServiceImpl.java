package cn.xdh.service.impl;

import cn.xdh.dao.TeacherDao;

import cn.xdh.entity.TeacherLog;
import cn.xdh.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherServiceImpl implements TeacherService {
    @Autowired
    TeacherDao teacherDao;

    @Override
    public List<TeacherLog> selectTeacherLog() {
        return teacherDao.selectTeacherLog();
    }

    @Override
    public void addTeacherLog(TeacherLog teacherLog) {
        teacherDao.addTeacherLog(teacherLog);
    }
}
