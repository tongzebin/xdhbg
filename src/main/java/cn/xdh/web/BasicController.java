package cn.xdh.web;

import cn.xdh.dao.StudentDao;
import cn.xdh.entity.Notice;
import cn.xdh.entity.Student;
import cn.xdh.service.StudentService;
import cn.xdh.service.impl.StudentServiceImpl;
import javafx.scene.shape.Path;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.List;
import java.util.Map;

@RestController
public class BasicController {
    @Autowired
    private StudentServiceImpl studentservice;


    @GetMapping(value = "")
    public ModelAndView index() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("login");
        return mav;
    }

    @PostMapping(value = "login.do")
    public ModelAndView login() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("student/index");
        return mav;
    }

//    @GetMapping("/index/{id}")
//    public String notice(Model model,Integer id){
//        model.addAttribute("studentList",studentservice.getAll(id));
//        return "index";
//    }

//    @GetMapping("/login.do/{id}")
//    public String notice(Model model,Integer id){
//        model.addAttribute("msg",studentservice.getAll(id));
//        return "login";
//    }

//    @GetMapping("/login.do/notice")
//    public String getNotices(Model model){
//        List<Notice> notices = studentservice.getNotices();
//        model.addAttribute("msgs",notices);
//        return "student/index";
//    }

    /**
     * notice 公告栏
     * @return
     */

    @GetMapping(value = "/notice")
    public ModelAndView getNotices(){
        List<Notice> notices = studentservice.getNotices();
        ModelAndView mav = new ModelAndView();
//        打印notices
        mav.addObject("msgs",notices);
        mav.setViewName("student/index");
        return mav;
    }

    /**
     * 通过id获取学生信息  (学生信息页面)
     * @param id
     * @return
     */
//    @GetMapping(value = "/list/{id}")
//    public ModelAndView getAllDatas(@PathVariable("id") int id){
//        Student studentDatas = studentservice.getDatas(id);
//        System.out.println(studentDatas);
//        ModelAndView mav = new ModelAndView();
//        mav.addObject("dats",studentDatas);
////        System.out.println(mav);
//        mav.setViewName("student/studentDatas");
//        System.out.println(id);
//        return mav;
//    }


    /**
     * 学生信息页面根据id显示信息
     * @param id
     * @return
     */
    @GetMapping(value = "/list/{id}")
    public ModelAndView getUsefulData(@PathVariable("id") int id){
        List<Map<String, Object>> usefulDataList = studentservice.getUsefulData(id);
//        System.out.println(usefulDataList);
        ModelAndView mav = new ModelAndView();
        mav.addObject("dats",usefulDataList);
        mav.setViewName("student/studentDatas");
        return mav;
    }


    /**
     * 学生信息修改页面显示未修改前的信息,查出当前员工信息,在页面回显
     * @param id
     * @return
     */
    @GetMapping("/edit/{id}")
    public ModelAndView datasedit(@PathVariable("id") int id){
        List<Map<String, Object>> usefulDataList = studentservice.getUsefulData(id);
        ModelAndView mav = new ModelAndView();
        mav.addObject("edits",usefulDataList);
        mav.setViewName("student/datasedit");
        return mav;
    }


    @PutMapping("/list/{id}")
    public ModelAndView updataData(@PathVariable("id") int id,String password,String birth,String graduate_school,String stage_id) throws ParseException {
        String str_birth;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        long birthday =  sdf.parse(birth).getTime()/1000;
//        System.out.println(birthday);
//        System.out.println(password);
        studentservice.updateData(id,password,birthday,graduate_school,stage_id);
        List<Map<String, Object>> usefulData2 = studentservice.getUsefulData(id);
        System.out.println(usefulData2);
        ModelAndView mav = new ModelAndView();
        mav.setViewName("redirect:student/studentDatas");
        return mav;
    }

}
