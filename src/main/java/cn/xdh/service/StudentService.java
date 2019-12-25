package cn.xdh.service;

import cn.xdh.entity.Student;

import java.util.List;

public interface StudentService {
    List<Student> selectAllNameAndId();

    List<Student> selectIdAndNameByName(String username);
}
