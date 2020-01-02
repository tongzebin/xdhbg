package cn.xdh.dao;

import cn.xdh.entity.City;
import cn.xdh.entity.Student;
import cn.xdh.entity.Teacher;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface StudentDao {
    //根据手机号和密码获取学生
    Student selectByPhoneAndPassword(@Param("mobile")String mobile,@Param("password")String password);

    //获取所有学生数量
    int selectAllNumber();

    //根据手机号获得所有的学生
    Student selectByMobile(String mobile);

    List<Map<String,Object>> getStudentByUndergraduate();

    List<Map<String,Object>> getStudentByGraduate();

    String selectCityById(Integer id);

    List<Student> getAllStudentByGraduate(@Param("is_graduate")int graduate);

    void addStudent(Student student);

    Student selectStudentByMobile(String mobile);

    List<Map<String,Object>> selectStudentLikeUsername(@Param("is_graduate")int is_graduate,@Param("username")String username);

    Student selectStudentById(int id);

    void deleteStudent(int id);

    List<City> selectProvince();

    List<City> selectCityByUpId(int upId);

    List<City> selectAreaByUpId(int upId);

    void updateStudent(Student student);

    /**
     * 查询所有学生姓名和id
     * @return
     */
    public List<Student> selectAllNameAndId();

    /**
     * 根据姓名查询学生id
     */
    /*@Select(value = "select * from xdh_student where xdh_student.username = #{username}")*/
    List<Student> selectIdAndNameByName(@Param(value = "username") String username);


}
