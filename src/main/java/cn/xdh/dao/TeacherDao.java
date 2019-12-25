package cn.xdh.dao;

import cn.xdh.entity.Student;
import cn.xdh.entity.Teacher;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherDao {
    public Teacher selectByPhoneAndPassword(@Param("mobile") String mobile, @Param("password") String password);
}
