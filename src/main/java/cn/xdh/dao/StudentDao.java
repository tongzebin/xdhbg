package cn.xdh.dao;

import cn.xdh.entity.Student;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentDao {
    //根据手机号和密码获取学生
    public Student selectByPhoneAndPassword(@Param("mobile")String mobile,@Param("password")String password);

    //获取所有学生数量
    public int selectAllNumber();



}
