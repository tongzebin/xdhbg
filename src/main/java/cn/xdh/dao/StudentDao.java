package cn.xdh.dao;

import cn.xdh.entity.Student;
import cn.xdh.entity.Teacher;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentDao {
    //根据手机号和密码获取学生
    Student selectByPhoneAndPassword(@Param("mobile")String mobile,@Param("password")String password);

    //获取所有学生数量
    int selectAllNumber();

    //根据手机号获得所有的学生
    Student selectByMobile(String mobile);

}
