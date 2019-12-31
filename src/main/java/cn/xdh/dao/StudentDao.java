package cn.xdh.dao;

import cn.xdh.entity.Notice;
import cn.xdh.entity.Student;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;
import java.util.Map;

@Repository
public interface StudentDao {
    public Student selectByPhoneAndPassword(@Param("phone")String phone,@Param("password")String password);


    public List<Notice> getNotices();


    public Student getDatas(@Param("id") int id);


    public List<Map<String,Object>> getUsefulData(@Param("id") int id);

    public void updateData(@Param("id") int id,@Param("password")String password,@Param("birthday")long birthday,@Param("graduate_school")String graduate_school,@Param("stage_id")String stage_id);
}
