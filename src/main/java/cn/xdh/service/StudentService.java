package cn.xdh.service;

import cn.xdh.entity.Student;

public interface StudentService {
    //根据手机号和密码获取学生
    public Student selectByPhoneAndPassword(String mobile, String password);

    //获取所有学生数量
    public int selectAllNumber();

}
