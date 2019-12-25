package cn.xdh.dao;


import cn.xdh.entity.Student;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentDao {
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
