package cn.xdh.web;

import cn.xdh.entity.Student;
import cn.xdh.entity.Works;
import cn.xdh.service.impl.StudentServiceImpl;
import cn.xdh.service.impl.WorksServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


/**
 * @author TZB
 */
@Controller
public class WorkController {
    @Autowired
    private WorksServiceImpl worksServiceimpl;
    @Autowired
    private StudentServiceImpl studentServiceimpl;

    /**
     * 显示所有学生作品
     * @param model
     * @return
     */
    @GetMapping("/teacher/works")
    //RequestParam
    //PathVariable
    public String worksAll(Model model){
        model.addAttribute("names",studentServiceimpl.selectAllNameAndId());
        model.addAttribute("works",worksServiceimpl.selectAll());
        return "teacher/works";
    }

    /**
     * 根据学生姓名进行作品查询
     * @param username  学生姓名
     * @param model     返回作品集合
     * @return          跳到哪个网页
     */
    @GetMapping("/teacher/work")
    public String workByName(@RequestParam(value = "username")String username,Model model){
        //数据回填
        model.addAttribute("backfill",username);
        List<Student> studentList = studentServiceimpl.selectIdAndNameByName(username);
        System.out.println(studentList);
        //如果根据条件没有查找到信息返回所有作品,并进行提示
        if(studentList.isEmpty()){
            model.addAttribute("pd","不存在该学生");
            //注:↓此方法↓return只是将被调用的方法结束,不会跳到另一个页面,需要自行return
            worksAll(model);
            return "teacher/works";
        }
        List<Works> worksList=new ArrayList<>();
        for(Student student : studentList){
            //根据list集合中装的id拿取数据
            worksList.addAll(worksServiceimpl.selectById(student.getId()));
        }

        model.addAttribute("works",worksList);
        model.addAttribute("names",studentList);
        return "teacher/works";
    }

}
