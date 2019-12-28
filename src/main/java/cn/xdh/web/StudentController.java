package cn.xdh.web;

import cn.xdh.entity.City;
import cn.xdh.entity.Msg;
import cn.xdh.entity.Student;
import cn.xdh.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class StudentController {
    @Autowired
    StudentService studentService;

    @GetMapping("/student/graduate/{graduate}")
    public String studentList(Model model, @PathVariable Integer graduate){
        List<Student> studentList = studentService.getAllStudentByGraduate(graduate);
        model.addAttribute("studentList",studentList);
        return "student/StudentList";
    }

    //跳转到添加学生页面
    @GetMapping("/student/add/view")
    public String addStudentView(){
        return "student/StudentAdd";
    }


    //接受添加学生页面发来的参数,并封装成学生对象
    @PostMapping("/student/add")
    @ResponseBody
    public Msg addStudent(Student student, HttpServletRequest request){
        int a = studentService.addStudentService(student,request);
        Msg msg = new Msg();
        if (a==1){
            //1是添加失败,手机号不正确
            msg.setMsg("添加失败,请输入正确的手机号");
            return msg;
        }else if (a==2){
            //2是添加失败,已存在该账户
            msg.setMsg("添加失败,该手机号已被注册");
            return msg;
        }
        //3是添加成功
        msg.setMsg("添加成功");
        System.out.println(msg);
        return msg;
    }

    @GetMapping("/student/like/{username}")
    public String studentList(Model model, @PathVariable String username){
        List<Student> studentList = studentService.getStudentLikeUsername(username);
        model.addAttribute("studentList",studentList);
        return "student/StudentList";
    }

    //跳转到修改学生信息页面
    @GetMapping("/student/edit/view/{id}")
    public String editStudentView(@PathVariable int id,Model model){
        Student student = studentService.getStudentById(id);
        List<City> cityList = studentService.getProvince();
        model.addAttribute("cityList",cityList);
        model.addAttribute("student",student);
        return "student/StudentEdit";
    }

    //接收参数修改学生信息
    @PutMapping("/student/edit/{id}")
    public String editStudent(Student student,HttpServletRequest request){
        studentService.updateStudent(student,request);
        return "student/StudentList";
    }

    //删除学生
    @DeleteMapping("/student/delete/{id}")
    @ResponseBody
    public Object deleteStudent(@PathVariable int id,HttpServletRequest request){
        studentService.deleteStudent(id,request);
        return id;
    }

}
