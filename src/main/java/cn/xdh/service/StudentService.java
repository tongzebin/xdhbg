package cn.xdh.service;

import cn.xdh.entity.City;
import cn.xdh.entity.Msg;
import cn.xdh.entity.Student;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

public interface StudentService {
    //根据手机号和密码获取学生
    public Student selectByPhoneAndPassword(String mobile, String password);

    //获取所有学生数量
    public int selectAllNumber();

    //根据手机号获得所有的学生
    public Student selectByMobile(String mobile);

    List<Map<String,Object>> getStudentByUndergraduate();

    List<Map<String,Object>> getStudentByGraduate();

    String selectCityById(Integer id);

    int addStudentService(Student student, HttpServletRequest request);

    List<Student> getAllStudentByGraduate(Integer graduate);

    Student getStudentByMobile(String mobile);

    List<Map<String,Object>> getStudentLikeUsername(int is_graduate, String username);

    Student getStudentById(int id);

    void deleteStudent(int id, HttpServletRequest request);

    List<Student> selectAllNameAndId();

    List<City> getProvince();

    List<City> getCityByUpId(int upId);

    List<City> getAreaByUpId(int upId);

    void updateStudent(Student student,HttpServletRequest request);

    Msg batchAddStudent(HttpServletRequest request, String suffixName, MultipartFile excelFile);

    List<Student> selectIdAndNameByName(String username);

}
