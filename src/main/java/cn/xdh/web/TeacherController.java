package cn.xdh.web;

import cn.xdh.entity.TeacherLog;
import cn.xdh.service.TeacherService;
import cn.xdh.util.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


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

    @GetMapping(value = "/teacher/Log/{page}")
    public String getTeacherLog(Model model, @PathVariable int page) {
        //查找所有的教师日志
        List<TeacherLog> teacherLogList = teacherService.selectTeacherLog();
        //数据量
        int total = teacherLogList.size();
        //防止数据库中没有值
        if (total==0){
            TeacherLog teacherLog = new TeacherLog();
            teacherLog.setTeacher_name("暂无日志");
            teacherLog.setAdd_time(0);
            teacherLogList.add(teacherLog);
            total = teacherLogList.size();
        }
        //总页数
        int totalPage = PageUtil.getTotalPage(total,PageUtil.count);
        //校对页数正确与否
        page=PageUtil.numberOfPage(page,totalPage);
        //页数集合
        List<Integer> totalPageList = PageUtil.pageUtil(page,totalPage);
        //分好页的未毕业学生集合
        List<TeacherLog> teacherLogs = PageUtil.teacherLogList(page,totalPage,total,teacherLogList);

        model.addAttribute("totalPage",totalPage);
        model.addAttribute("totalPageList",totalPageList);
        model.addAttribute("teacherLogs",teacherLogs);
        return "teacher/TeacherLogList";
    }

}
