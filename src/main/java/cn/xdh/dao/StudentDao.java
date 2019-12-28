package cn.xdh.dao;

import cn.xdh.entity.Notice;
import cn.xdh.entity.Student;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
public interface StudentDao {
    public Student selectByPhoneAndPassword(@Param("phone")String phone,@Param("password")String password);


    public List<Notice> getNotices();


    public Student getDatas(@Param("id") int id);
}
