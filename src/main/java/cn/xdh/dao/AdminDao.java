package cn.xdh.dao;

import cn.xdh.entity.Admin;
import cn.xdh.entity.Student;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminDao {
    public Admin selectByPhoneAndPassword(@Param("mobile") String mobile, @Param("password") String password);
}
