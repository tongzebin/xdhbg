package cn.xdh.service.impl;

import cn.xdh.dao.StudentDao;
import cn.xdh.entity.Student;
import cn.xdh.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentDao studentdao;


    @Override
    public List<Student> selectAllNameAndId() {
        return studentdao.selectAllNameAndId();
    }


    @Override
    public List<Student> selectIdAndNameByName(String username) {
        return studentdao.selectIdAndNameByName(username);
    }


}
