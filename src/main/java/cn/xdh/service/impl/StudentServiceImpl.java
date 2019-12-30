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

    //根据手机号和密码获取学生
    @Override
    public Student selectByPhoneAndPassword(String mobile, String password){
        Student student = studentdao.selectByPhoneAndPassword(mobile,password);
        return student;
    }

    //获取所有学生数量
    @Override
    public int selectAllNumber(){
        int number = studentdao.selectAllNumber();
        return number;
    }

}
