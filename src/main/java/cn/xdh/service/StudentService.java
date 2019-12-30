package cn.xdh.service;

import cn.xdh.entity.Notice;
import cn.xdh.entity.Student;
import org.apache.ibatis.annotations.Param;

import java.util.Collection;
import java.util.List;
import java.util.Map;

public interface StudentService {
    public Student selectByPhoneAndPassword(String phone, String password);

    // getNotices 查询公告
    public List<Notice> getNotices();

    public Student getDatas(int id);

    public String getClassName(int id);

    public List<Map<String,Object>> getUsefulData(int id);

    public void updateData(@Param("id") int id,String password,long birthday,String graduate_school,String stage_id);



}
