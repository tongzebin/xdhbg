package cn.xdh.web;

import cn.xdh.entity.TeacherLog;
import cn.xdh.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;


/**
 * @author victor
 * @site https://ttk1907.github.io/
 * @company XDL
 * @project xdhbg
 * @package cn.xdh.web
 * @created 2019-12-27 17:23
 * @function ""
 */

@Controller
public class TeacherController {
    @Autowired
    TeacherService teacherService;

    @GetMapping(value = "/teacher/Log")
    public String getTeacherLog(Model model) {
        //查找所有的教师日志
        List<TeacherLog> teacherLogList = teacherService.selectTeacherLog();
        model.addAttribute("teacherLogList",teacherLogList);
        return "teacher/TeacherLogList";

    }

//    HttpServletRequest request,
//            @RequestParam(name="page",required=false,defaultValue="1")int page,
//            @RequestParam(name="size",required=false,defaultValue="10")int size,
//            @RequestParam(name="type",required=false,defaultValue="all")String type
}
