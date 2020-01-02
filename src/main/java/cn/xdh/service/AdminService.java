package cn.xdh.service;

import cn.xdh.entity.Admin;
import cn.xdh.entity.AdminLog;
import cn.xdh.entity.Teacher;
import cn.xdh.entity.TeacherLog;
import org.springframework.data.domain.Page;

import java.util.List;

public interface AdminService {
    //根据手机号和密码获取管理员
    public Admin selectByPhoneAndPassword(String mobile, String password);

    //增加管理员日志
    public int addAdminLog(AdminLog adminlog);

    //查找最新的五个管理员日志
    public List<AdminLog> selectNewAdminLog();

    //查找所有管理员日志并分页
    public Page<AdminLog> selectAllAdminLog(int page, int size);

    //根据名字模糊查找管理员日志并分页
    public Page<AdminLog> selectAllAdminLogByName(String name,int page, int size);

    //根据ip模糊查找管理员日志并分页
    public Page<AdminLog> selectAllAdminLogByIp(String ip,int page, int size);

    //根据所有字段模糊查找管理员日志并分页
    public Page<AdminLog> selectAllAdminLogByAll(String allname,int page, int size);

    //通过手机号查询管理员
    public Admin selectByMobile(String mobile);

    //查找所有教师操作日志并分页
    public Page<TeacherLog> selectAllTeacherLog(int page, int size);

    //根据名字模糊查找管理员日志并分页
    public Page<TeacherLog> selectAllTeacherLogByName(String name,int page, int size);

    //根据ip模糊查找管理员日志并分页
    public Page<TeacherLog> selectAllTeacherLogByIp(String ip,int page, int size);

    //根据所有字段模糊查找教师操作日志并分页
    public Page<TeacherLog> selectAllTeacherLogByAll(String allname,int page, int size);
}
