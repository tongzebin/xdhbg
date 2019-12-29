package cn.xdh.service;

import cn.xdh.entity.City;
import cn.xdh.entity.Msg;
import cn.xdh.entity.Student;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface StudentService {

    Student selectByMobileAndPassword(String mobile, String password);

    int addStudentService(Student student, HttpServletRequest request);

    List<Student> getAllStudentByGraduate(Integer graduate);

    Student getStudentByMobile(String mobile);

    List<Student> getStudentLikeUsername(String username);

    Student getStudentById(int id);

    void deleteStudent(int id, HttpServletRequest request);

    List<City> getProvince();

    List<City> getCityByUpId(int upId);

    List<City> getAreaByUpId(int upId);

    void updateStudent(Student student,HttpServletRequest request);

    Msg batchAddStudent(HttpServletRequest request, String suffixName, MultipartFile excelFile);
}
