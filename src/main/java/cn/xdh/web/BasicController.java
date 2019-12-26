package cn.xdh.web;

import cn.xdh.service.impl.StudentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BasicController {
    @Autowired
    private StudentServiceImpl studentservice;

    @GetMapping(value = "")
    @ResponseBody
    public ModelAndView index() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("login");
        return mav;
    }

    @PostMapping(value = "login.do")
    @ResponseBody
    public ModelAndView login() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("student/index");
        return mav;
    }

    @GetMapping("/teacher/index")
    public String toIndex(){
        return "teacher/index";
    }


}
