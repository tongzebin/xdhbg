package cn.xdh.dao;

import cn.xdh.entity.City;
import cn.xdh.entity.Student;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentDao {
    Student selectByMobileAndPassword(@Param("mobile")String mobile,@Param("password")String password);

    List<Student> getAllStudentByGraduate(@Param("is_graduate")int graduate);

    void addStudent(Student student);

    Student selectStudentByMobile(String mobile);

    List<Student> selectStudentLikeUsername(String username);

    Student selectStudentById(int id);

    void deleteStudent(int id);

    List<City> selectProvince();

    List<City> selectCityByUpId(int upId);

    List<City> selectAreaByUpId(int upId);

    void updateStudent(Student student);
}
