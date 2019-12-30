package cn.xdh.service.impl;

import cn.xdh.dao.TeacherDao;
import cn.xdh.entity.Teacher;
import cn.xdh.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeacherServiceImpl implements TeacherService {
    @Autowired
    private TeacherDao teacherdao;

    //根据手机号和密码获取教师
    @Override
    public Teacher selectByPhoneAndPassword(String mobile, String password){
        Teacher teacher = teacherdao.selectByPhoneAndPassword(mobile,password);
        return teacher;
    }

    //获取所有教师数量
    @Override
    public int selectAllNumber(){
        int number = teacherdao.selectAllNumber();
        return number;
    }

}
