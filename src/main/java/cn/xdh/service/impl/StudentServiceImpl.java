package cn.xdh.service.impl;

import cn.xdh.dao.StudentDao;
import cn.xdh.entity.Student;
import cn.xdh.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentDao studentdao;

    public Student selectByPhoneAndPassword(String phone, String password){
        Student student = studentdao.selectByPhoneAndPassword(phone,password);
        return student;
    }
}
