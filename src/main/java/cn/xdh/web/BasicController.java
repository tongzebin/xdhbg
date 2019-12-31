package cn.xdh.web;

import cn.xdh.entity.NoticeData;
import cn.xdh.service.impl.*;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;
import java.util.List;

@RestController
public class BasicController {
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
    public ModelAndView index() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("login");
        return mav;
    }

    @GetMapping(value = "teacher")
    public ModelAndView teacherIndex() {
        ModelAndView mav = new ModelAndView();
        mav.getModel().put("totalNumber", studentNumberServiceImpl.selectTotalNumber());
        mav.getModel().put("graduNumber", studentNumberServiceImpl.selectGraduNumber());
        mav.getModel().put("notGraduNumber", studentNumberServiceImpl.selectNotGraduNumber());

        mav.getModel().put("stageOne", studentNumberServiceImpl.selectStageOne());
        mav.getModel().put("stageTwo", studentNumberServiceImpl.selectStageOne());
        mav.getModel().put("stageThree", studentNumberServiceImpl.selectStageOne());
        mav.getModel().put("stageFour", studentNumberServiceImpl.selectStageOne());
        mav.getModel().put("stageFive", studentNumberServiceImpl.selectStageOne());
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


    @PostMapping(value = "login.do")
    public ModelAndView login() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("student/index");
        return mav;
    }


}
