package cn.xdh.dao;

import cn.xdh.entity.TeacherLog;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author ttk1907
 * @site https://ttk1907.github.io/
 * @company XDL
 * @project xdhbg
 * @package cn.xdh.dao
 * @created 2019-12-27 17:14
 * @function ""
 */
@Repository
public interface TeacherDao{
    void addTeacherLog(TeacherLog teacherLog);
    List<TeacherLog> selectTeacherLog();
}

