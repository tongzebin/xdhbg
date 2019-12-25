package cn.xdh.service;

import cn.xdh.entity.Teacher;

public interface TeacherService {
    public Teacher selectByPhoneAndPassword(String mobile, String password);

}
