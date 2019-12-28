package cn.xdh.service;

import cn.xdh.entity.Notice;
import cn.xdh.entity.Student;

import java.util.Collection;
import java.util.List;

public interface StudentService {
    public Student selectByPhoneAndPassword(String phone, String password);

    // getNotices 查询公告
    public List<Notice> getNotices();

    public Student getDatas(int id);

}
