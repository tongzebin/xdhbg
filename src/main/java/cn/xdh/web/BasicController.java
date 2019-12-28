package cn.xdh.web;

import cn.xdh.dao.StudentDao;
import cn.xdh.entity.Notice;
import cn.xdh.entity.Student;
import cn.xdh.service.StudentService;
import cn.xdh.service.impl.StudentServiceImpl;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.Collection;
import java.util.List;

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
//        model.addAttribute("msgs",notices);
        ModelAndView mav = new ModelAndView();
//        打印notices
//        System.out.println(notices);
        mav.addObject("msgs",notices);
        mav.setViewName("student/index");
        return mav;
    }

    /**
     * 通过id获取学生信息  (学生信息页面)
     * @param id
     * @return
     */
    @GetMapping(value = "/list/{id}")
    public ModelAndView getAllDatas(@PathVariable("id") int id){
        Student studentDatas = studentservice.getDatas(id);
        System.out.println(studentDatas);
        ModelAndView mav = new ModelAndView();
        mav.addObject("dats",studentDatas);
        System.out.println(mav);
        mav.setViewName("student/studentDatas");
        System.out.println(id);
        return mav;
    }

    /**
     * 修改学生信息
     */



}
