package cn.xdh.service.impl;

import cn.xdh.dao.StudentDao;
import cn.xdh.entity.Notice;
import cn.xdh.entity.Student;
import cn.xdh.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentDao studentdao;

    @Override
    public Student selectByPhoneAndPassword(String phone, String password){
        Student student = studentdao.selectByPhoneAndPassword(phone,password);
        return student;
    }


    @Override
    public List<Notice> getNotices() {
        List<Notice> notices = studentdao.getNotices();
        return notices;
    }

    @Override
    public Student getDatas(int id) {
        Student studentDatas = studentdao.getDatas(id);
        return studentDatas;
    }
}
