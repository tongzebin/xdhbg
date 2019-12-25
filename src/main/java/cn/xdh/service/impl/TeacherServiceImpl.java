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

    @Override
    public Teacher selectByPhoneAndPassword(String mobile, String password){
        Teacher teacher = teacherdao.selectByPhoneAndPassword(mobile,password);
        return teacher;
    }
}
