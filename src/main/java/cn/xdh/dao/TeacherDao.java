package cn.xdh.dao;

import cn.xdh.entity.Teacher;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherDao {
    //根据手机号和密码获取教师
    public Teacher selectByPhoneAndPassword(@Param("mobile") String mobile, @Param("password") String password);

    //获取所有教师数量
    public int selectAllNumber();

}
