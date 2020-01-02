package cn.xdh.web;

import cn.xdh.entity.City;
import cn.xdh.entity.Msg;
import cn.xdh.entity.Student;
import cn.xdh.service.StudentService;
import cn.xdh.service.impl.StudentServiceImpl;
import cn.xdh.util.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class StudentController {

    @Autowired
    private StudentServiceImpl studentService;

    @GetMapping("/student/Undergraduate/{page}")
    public String UndergraduateStudentList(Model model,@PathVariable int page) {
        List<Map<String, Object>> undergraduateStudentTotal = studentService.getStudentByUndergraduate();
        //System.out.println(undergraduateStudentTotal);
        //数据量
        int total = undergraduateStudentTotal.size();
        //防止数据库中没有值
//        undergraduateStudentTotal = PageUtil.preventionNull(total,undergraduateStudentTotal);
        if (total==0){
            Map<String, Object> map = new HashMap<String,Object>();
            map.put("username","没有数据");
            map.put("join_study_time",(long)0);
            undergraduateStudentTotal.add(map);
            total = undergraduateStudentTotal.size();
        }
        //总页数
        int totalPage = PageUtil.getTotalPage(total,PageUtil.count);
        //校对页数正确与否
        page=PageUtil.numberOfPage(page,totalPage);
        //页数集合
        List<Integer> totalPageList = PageUtil.pageUtil(page,totalPage);
        //分好页的未毕业学生集合
        List<Map<String,Object>> undergraduateStudentList = PageUtil.undergraduateStudentList(page,totalPage,total,undergraduateStudentTotal);
        //System.out.println(undergraduateStudentList);
        model.addAttribute("totalPage",totalPage);
        model.addAttribute("totalPageList",totalPageList);
        model.addAttribute("StudentList", undergraduateStudentList);
        model.addAttribute("likeName",0);
        return "teacher/UndergraduateStudentList";
    }

    @GetMapping("/student/Graduate/{page}")
    public String GraduateStudentList(Model model,@PathVariable int page) {
        List<Map<String, Object>> graduateStudentTotal = studentService.getStudentByGraduate();
        //数据量
        int total = graduateStudentTotal.size();
        //防止数据库中没有值
        if (total==0){
            Map<String, Object> map = new HashMap<String,Object>();
            map.put("username","没有数据");
            map.put("graduate_time",(long)0);
            graduateStudentTotal.add(map);
            total = graduateStudentTotal.size();
        }
        //总页数
        int totalPage = PageUtil.getTotalPage(total,PageUtil.count);
        //校对页数正确与否
        page=PageUtil.numberOfPage(page,totalPage);
        //页数集合
        List<Integer> totalPageList = PageUtil.pageUtil(page,totalPage);
        //分好页的毕业学生集合
        List<Map<String,Object>> graduateStudentList = PageUtil.graduateStudentList(page,totalPage,total,graduateStudentTotal);

        model.addAttribute("totalPage",totalPage);
        model.addAttribute("totalPageList",totalPageList);
        model.addAttribute("StudentList", graduateStudentList);
        model.addAttribute("likeName",0);
        return "teacher/GraduateStudentList";
    }

    //跳转到添加学生页面
    @GetMapping("/student/add/view")
    public String addStudentView() {
        return "teacher/StudentAdd";
    }


    //接受添加学生页面发来的参数,并封装成学生对象
    @PostMapping("/student/add")
    @ResponseBody
    public Msg addStudent(Student student, HttpServletRequest request) {
        int a = studentService.addStudentService(student, request);
        Msg msg = new Msg();
        if (a == 1) {
            //1是添加失败,手机号不正确
            msg.setMsg("添加失败,请输入正确的手机号");
            return msg;
        } else if (a == 2) {
            //2是添加失败,已存在该账户
            msg.setMsg("添加失败,该手机号已被注册");
            return msg;
        }
        //3是添加成功
        msg.setMsg("添加成功");
        return msg;
    }

    //毕业学员的模糊查询/student/like/0/1/
    @GetMapping("/student/like/{is_graduate}/{page}/{username}")
    public String undergraduateStudentList(Model model, @PathVariable String username, @PathVariable int is_graduate,@PathVariable int page) {
        List<Map<String,Object>> StudentTotalByLikeName = studentService.getStudentLikeUsername(is_graduate,username);
        //数据量
        int total = StudentTotalByLikeName.size();
        //防止数据库中没有值
        if (total==0){
            Map<String, Object> map = new HashMap<String,Object>();
            map.put("username","没有数据");
            map.put("graduate_time",(long)0);
            map.put("join_study_time",(long)0);
            StudentTotalByLikeName.add(map);
            total = StudentTotalByLikeName.size();
        }
        //总页数
        int totalPage = PageUtil.getTotalPage(total,PageUtil.count);
        //校对页数正确与否
        page=PageUtil.numberOfPage(page,totalPage);
        //页数集合
        List<Integer> totalPageList = PageUtil.pageUtil(page,totalPage);
        //分好页的毕业学生集合
        List<Map<String,Object>> StudentList = PageUtil.graduateStudentList(page,totalPage,total,StudentTotalByLikeName);

        model.addAttribute("totalPage",totalPage);
        model.addAttribute("totalPageList",totalPageList);
        model.addAttribute("StudentList", StudentList);
        model.addAttribute("likeName",1);
        model.addAttribute("name",username);
        if (is_graduate==0){
            return "teacher/UndergraduateStudentList";
        }else{
            return "teacher/GraduateStudentList";
        }
    }

    //跳转到修改学生信息页面
    @GetMapping("/student/edit/view/{id}")
    public String editStudentView(@PathVariable int id, Model model) {
        Student student = studentService.getStudentById(id);
        List<City> cityList = studentService.getProvince();
        model.addAttribute("cityList", cityList);
        model.addAttribute("student", student);
        return "teacher/StudentEdit";
    }

    //接收参数修改学生信息
    @PutMapping("/student/edit/{id}")
    public String editStudent(Student student, HttpServletRequest request) {
        studentService.updateStudent(student, request);
        return "teacher/UndergraduateStudentList";
    }

    //删除学生
    @DeleteMapping("/student/delete/{id}")
    @ResponseBody
    public Object deleteStudent(@PathVariable int id, HttpServletRequest request) {
        studentService.deleteStudent(id, request);
        return id;
    }

    //批量添加学生
    @PostMapping("/student/add/batch/{suffixName}")
    @ResponseBody
    public Msg addAllStudent(@RequestParam("ExcelFile") MultipartFile excelFile,HttpServletRequest request,@PathVariable String suffixName) throws Exception {
        return studentService.batchAddStudent(request,suffixName,excelFile);
    }

}
