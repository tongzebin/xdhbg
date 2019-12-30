package cn.xdh.dao;

import cn.xdh.entity.Admin;
import cn.xdh.entity.AdminLog;
import cn.xdh.entity.Student;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdminDao {
    //根据手机号和密码获取管理员
    public Admin selectByPhoneAndPassword(@Param("mobile") String mobile, @Param("password") String password);

    //增加管理员日志
    public int addAdminLog(AdminLog adminlog);

    //查找最新的五个管理员日志
    public List<AdminLog> selectNewAdminLog();


}
