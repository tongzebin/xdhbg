package cn.xdh.service;


import cn.xdh.entity.TeacherLog;

import java.util.List;

public interface TeacherService {

    void addTeacherLog(TeacherLog teacherLog);
    List<TeacherLog> selectTeacherLog();
}
