package cn.xdh.service.impl;

import cn.xdh.dao.ClassDao;
import cn.xdh.dao.TeacherDao;
import cn.xdh.entity.Teacher;
import cn.xdh.service.ClassService;
import cn.xdh.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClassServiceImpl implements ClassService {
    @Autowired
    private ClassDao classdao;

    //获取所有教师数量
    @Override
    public int selectAllNumber(){
        int number = classdao.selectAllNumber();
        return number;
    }

}
