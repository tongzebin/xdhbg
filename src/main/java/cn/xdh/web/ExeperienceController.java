package cn.xdh.web;

import cn.xdh.entity.Exeperience;
import cn.xdh.entity.Student;
import cn.xdh.service.impl.ExeperienceServiceImpl;
import cn.xdh.service.impl.StudentServiceImpl;
import cn.xdh.util.MyDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;


/**
 * @author TZB
 */
@Controller
public class ExeperienceController {
    @Autowired
    private ExeperienceServiceImpl exeperienceServiceImpl;
    @Autowired
    private StudentServiceImpl studentServiceimpl;

    /**
     * 显示所有学生作品
     *
     * @param model
     * @return
     */
    @GetMapping("/teacher/exeperiences")
    public String exeperienceAll(Model model) {
        List<Exeperience> exeperienceList = exeperienceServiceImpl.selectAll();
        exeperienceList.forEach(exeper -> exeper.setTime(MyDate.time(exeper.getAdd_time())));
        model.addAttribute("names", studentServiceimpl.selectAllNameAndId());
        model.addAttribute("exeperiences", exeperienceList);
        return "teacher/exeperience";
    }


    /**
     * 根据学生姓名进行作品查询
     *
     * @param username 学生姓名
     * @param model    返回作品集合
     * @return 跳到哪个网页
     */
    @GetMapping("/teacher/exeperience")
    public String exeperienceByName(@RequestParam(value = "username") String username, Model model) {
        //搜索栏数据回填
        model.addAttribute("backfill", username);
        List<Student> studentList = studentServiceimpl.selectIdAndNameByName(username);
        //如果根据条件没有查找到信息返回所有作品,并进行提示
        if (studentList.isEmpty()) {
            model.addAttribute("pd", "不存在该学生");
            exeperienceAll(model);
            return "teacher/exeperience";
        }
        List<Exeperience> exeperienceList = new ArrayList<>();
        for (Student student : studentList) {
            //根据list集合中装的id拿取数据
            exeperienceList.addAll(exeperienceServiceImpl.selectByStudent_id(student.getId()));
        }
        exeperienceList.forEach(exeper -> exeper.setTime(MyDate.time(exeper.getAdd_time())));
        model.addAttribute("exeperiences", exeperienceList);
        model.addAttribute("names", studentList);
        return "teacher/exeperience";
    }

    /**
     * 根据作品表id进行删除
     *
     * @param id    作品删除
     * @param model
     * @return
     */
    @GetMapping("/teacher/exeperience/{id}")
    public String deleteExperienceById(@PathVariable("id") int id) {
        exeperienceServiceImpl.deleteById(id);
        return "redirect:/teacher/exeperiences";
    }


}
