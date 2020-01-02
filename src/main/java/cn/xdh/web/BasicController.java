package cn.xdh.web;

import cn.xdh.entity.NoticeData;
import cn.xdh.service.impl.*;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class BasicController {
    @Autowired
    TeacherService teacherService;
    @Autowired
    TeacherLog teacherLog;
    @Autowired
    private StudentServiceImpl studentservice;
    @Autowired
    private StudentNumberServiceImpl studentNumberServiceImpl;
    @Autowired
    private NoticeDataServiceImpl noticeDataServiceImpl;
    @Autowired
    private NoticeContentServerImpl noticeContentServerImpl;
    @Autowired
    private DelNoticeServiceImpl delNoticeServiceImpl;

    @GetMapping(value = "")
    @ResponseBody
    public ModelAndView index() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("login");
        return mav;
    }

    @PostMapping(value = "login.do")
    public ModelAndView login(ModelAndView mav, HttpServletResponse response,String phone) {
        //1.判断登录的账号密码,是否正确
        //2.正确则将老师id,name,登录ip取到
        String teacher_name="";
        if ("1".equals(phone)){
            teacher_name = "岳阳";
        }else{
            teacher_name = "滕天凯";
        }

        //模拟登录时取值的过程
        int teacher_id = 1;
        String action = "登录系统";
        long add_time = SomeMethods.getCurrentTime();
        String add_ip = SomeMethods.getIp4();
        //new一个日志实体类作为插入教师日志表时的参数
        TeacherLog teacherLog = new TeacherLog(teacher_id,teacher_name,action,add_time,add_ip);
        teacherService.addTeacherLog(teacherLog);
//      登录时添加cookie,测试用
        CookieTestUtil cookieTestUtil = new CookieTestUtil();
        cookieTestUtil.cookieTest(response,teacher_id,teacher_name,add_ip);

        mav.setViewName("teacher/index");
        return mav;
    }
    //    初始化
    @GetMapping(value = "aNoticeManage")
    public List<NoticeData> aNoticeManage() {
        List<NoticeData> nd = noticeDataServiceImpl.selectNoticeData();
//        ModelAndView mav = new ModelAndView();
//        mav.addObject("noticeData", noticeDataServiceImpl.selectNoticeData());
//        System.out.println(noticeDataServiceImpl.selectNoticeData());
//        mav.setViewName("teacher/noticeManage");

        return nd;
    }
    @GetMapping(value = "selectNotice/{cont}")
    public List<NoticeData> selectNotice(@PathVariable String cont) {
        List<NoticeData> nd = noticeDataServiceImpl.searchNoticeData(cont);
        return nd;
    }
    @GetMapping(value = "noticeManage")
    public ModelAndView noticeManage() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("teacher/noticeManage");
        return mav;
    }
    //    增加公告
    @PostMapping(value = "noticeManage")
    public ModelAndView submitNotice(String noticeContent) {
        System.out.println(noticeContent);
        System.out.println(new Date().getTime());
        noticeContentServerImpl.addNoticeContent(noticeContent,new Date().getTime()/1000);
        ModelAndView mav = new ModelAndView();
        mav.setViewName("teacher/noticeManage");
        return mav;
    }
    //    删除公告
    @GetMapping(value = "delManage/{id}")
    public String delManage(@PathVariable Integer id) {
        System.out.println(id);
//        ModelAndView mav = new ModelAndView();
//        mav.setViewName("teacher/noticeManage");
        delNoticeServiceImpl.delNoticeService(id);
        if (id != null){
            return "true";
        }else
            return "false";
//        return mav;
    }
//    @RequestMapping(value = "submitNotice")
//    public String su(String noticeContent) {
//        System.out.println(noticeContent);
//        return "teacher/noticeManage";
//    }

    @GetMapping("/exit")
    public String exit(HttpServletResponse response, HttpServletRequest request){
        String action = "退出系统";
       //获取cookie中的老师信息
        SomeMethods.getCookieValue(request,teacherLog,action);
        //将日志实体类添加到日志表中
        teacherService.addTeacherLog(teacherLog);

        Cookie cookie = new Cookie("name", null);
        cookie.setMaxAge(0);
        response.addCookie(cookie);

        return "login";
    }

    @GetMapping("/index")
    public String goIndex(){
        return "teacher/index";
    }
}
