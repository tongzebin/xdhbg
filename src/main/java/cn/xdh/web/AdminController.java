package cn.xdh.web;

import cn.xdh.service.impl.StudentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class AdminController {

    @GetMapping(value = "adminlog.do")
    public ModelAndView index() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("admin/adminlog");
        return mav;
    }




}
