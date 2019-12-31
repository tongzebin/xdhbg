package cn.xdh.web;

import cn.xdh.entity.NoticeData;
import cn.xdh.service.impl.*;
import org.apache.ibatis.annotations.Param;
import cn.xdh.dao.StudentDao;
import cn.xdh.entity.Notice;
import cn.xdh.entity.Student;
import cn.xdh.service.StudentService;
import cn.xdh.service.impl.StudentServiceImpl;
import javafx.scene.shape.Path;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;
import java.util.List;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.List;
import java.util.Map;

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
