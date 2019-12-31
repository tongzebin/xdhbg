package cn.xdh.service;

import cn.xdh.entity.Student;

public interface StudentService {
    public Student selectByPhoneAndPassword(String phone, String password);

}
