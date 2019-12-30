package cn.xdh.web;

import cn.xdh.SomeMethods;
import cn.xdh.dao.AdminLogRepository;
import cn.xdh.entity.Admin;
import cn.xdh.entity.AdminLog;
import cn.xdh.entity.Student;
import cn.xdh.entity.Teacher;
import cn.xdh.service.impl.AdminServiceImpl;
import cn.xdh.service.impl.ClassServiceImpl;
import cn.xdh.service.impl.StudentServiceImpl;
import cn.xdh.service.impl.TeacherServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
public class AdminController {
    @Autowired
    private StudentServiceImpl studentservice;
    @Autowired
    private TeacherServiceImpl teacherservice;
    @Autowired
    private AdminServiceImpl adminservice;
    @Autowired
    private ClassServiceImpl classservice;

    //查询日志列表带分页
    @GetMapping(value = "/admin.adminlog")
    public ModelAndView getAdminlog(
            HttpServletRequest request,
            @RequestParam(name="page",required=false,defaultValue="1")int page,
            @RequestParam(name="size",required=false,defaultValue="10")int size,
            @RequestParam(name="type",required=false,defaultValue="all")String type) {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("admin/adminlog");
        String lookname = request.getParameter("lookname");
        Page<AdminLog> adminloglist = null;
        //判断查找的方式，然后通过sql获取所有管理员日志
        if (type.equals("likename")){
            //根据名字模糊查找所有日志
            adminloglist = adminservice.selectAllAdminLogByName(lookname,page - 1, size);
        }else if (type.equals("likeip")){
            //根据ip模糊查找日志
            adminloglist = adminservice.selectAllAdminLogByIp(lookname,page - 1, size);
        }else if (type.equals("likeall")) {
            //根据所有字段模糊查询日志
            adminloglist = adminservice.selectAllAdminLogByAll(lookname,page - 1,size);
        }else {
            //查找所有的管理员日志
            adminloglist = adminservice.selectAllAdminLog(page - 1, size);
        }
        mav.getModel().put("lookname", lookname);
        mav.getModel().put("current", adminloglist.getNumber()+1);
        mav.getModel().put("total", adminloglist.getTotalPages());
        mav.getModel().put("type", type);
        mav.addObject("adminLog",adminloglist.getContent());
        return mav;
    }

    //页面内点击首页
    @GetMapping(value = "/admin.index")
    public ModelAndView loginGet() {
        ModelAndView mav = new ModelAndView();
        //通过sql获取班级,教师,学生数量
        int studentNumber = studentservice.selectAllNumber();
        int classNumber = classservice.selectAllNumber();
        int teacherNumber = teacherservice.selectAllNumber();
        //通过sql获取最新五个管理员日志
        List<AdminLog> adminloglist = adminservice.selectNewAdminLog();
        //设置mav的视图
        mav.setViewName("admin/index");
        //设置键值对
        mav.getModel().put("studentNumber", studentNumber);
        mav.getModel().put("classNumber", classNumber);
        mav.getModel().put("teacherNumber", teacherNumber);
        mav.addObject("adminLog",adminloglist);
        return mav;
    }


}
