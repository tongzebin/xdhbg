package cn.xdh.service;

import cn.xdh.entity.City;
import cn.xdh.entity.Student;

import java.util.List;
import java.util.Map;

public interface StudentService {

    Student selectByMobileAndPassword(String mobile, String password);

    int addStudentService(Student student);

    List<Student> getAllStudentByGraduate(Integer graduate);

    Student getStudentByMobile(String mobile);

    List<Student> getStudentLikeUsername(String username);

    Student getStudentById(int id);

    void deleteStudent(int id);

    List<City> getProvince();

    List<City> getCityByUpId(int upId);
}
