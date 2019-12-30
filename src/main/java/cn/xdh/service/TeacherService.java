package cn.xdh.service;

import cn.xdh.entity.Teacher;

public interface TeacherService {
    //根据手机号和密码获取教师
    public Teacher selectByPhoneAndPassword(String mobile, String password);

    //获取所有教师数量
    public int selectAllNumber();

}
