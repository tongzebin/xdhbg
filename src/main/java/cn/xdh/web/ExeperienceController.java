package cn.xdh.web;

import cn.xdh.entity.Exeperience;
import cn.xdh.entity.Page;
import cn.xdh.entity.Student;
import cn.xdh.service.impl.ExeperienceServiceImpl;
import cn.xdh.service.impl.StudentServiceImpl;
import cn.xdh.util.GetCurrentPage;
import cn.xdh.util.MyPaging;
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
public class ExeperienceController {
    /**
     *  每页显示的数据条数
     */
    private final int pageSize=5;

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
    public String exeperienceAll(Model model,int pageNum) {
        model.addAttribute("price",1);
        List<Exeperience> exeperienceList = exeperienceServiceImpl.selectAll();
        model.addAttribute("names", studentServiceimpl.selectAllNameAndId());
        model.addAttribute("exeperiences", MyPaging.paging(exeperienceList,pageNum,pageSize));
        //获取总页数

        int page = exeperienceList.size()/pageSize;
        int generalPage = exeperienceList.size()%pageSize==0&&page>0?page:page+1;
        //获取当前页
        GetCurrentPage.getcurrentPage(pageNum,generalPage,model);

        model.addAttribute("generalPage",generalPage);
        //判断页数是否符合标准
        if(pageNum<1||generalPage<pageNum){
            if(pageNum<1){
                return "redirect:/teacher/exeperiences?pageNum=1";
            }
            model.addAttribute("price",0);
            return "redirect:/teacher/exeperiences?pageNum="+generalPage;
        }
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
    public String exeperienceByName(String username,int pageNum,Model model) {
        //搜索栏数据回填
        model.addAttribute("backfill", username);
        List<Student> studentList = studentServiceimpl.selectIdAndNameByName(username);
        //如果根据条件没有查找到信息返回所有作品,并进行提示
        if (studentList.isEmpty()) {
            model.addAttribute("pd", "不存在该学生");
            exeperienceAll(model,1);
            return "teacher/exeperience";
        }
        List<Exeperience> exeperienceList = new ArrayList<>();
        for (Student student : studentList) {
            //根据list集合中装的id拿取数据
            exeperienceList.addAll(exeperienceServiceImpl.selectByStudent_id(student.getId()));
        }
        model.addAttribute("exeperiences", MyPaging.paging(exeperienceList,pageNum,pageSize));
        model.addAttribute("names", studentList);
        //获取总页数
        int page = exeperienceList.size()/pageSize;
        int generalPage = exeperienceList.size()%pageSize==0&&page>0?page:page+1;

        //获取当前页
        GetCurrentPage.getcurrentPage(pageNum,generalPage,model);
        model.addAttribute("generalPage",generalPage);
        //判断输入的值是否符合标准
        model.addAttribute("price",1);
        if(pageNum<1||generalPage<pageNum){
            if(pageNum<1){
                return "redirect:/teacher/exeperience?pageNum=1"+"&username="+username;
            }
            //删除完本页最后一条时(非首页),发送的数据
            model.addAttribute("price",0);
            return "redirect:/teacher/exeperience?pageNum="+generalPage+"&username="+username;
        }

        return "teacher/exeperience";
    }


    /**
     * 根据作品表id进行删除
     *
     * @param id    作品删除
     * @param model
     * @return
     */
    @DeleteMapping("/teacher/exeperience/{id}")
    @ResponseBody
    public void deleteExperienceById(@PathVariable("id") int id) {
        exeperienceServiceImpl.deleteById(id);
    }



    @GetMapping("/teacher/exeperpage")
    public String pagingRequest(Model model, Page page)  {
        if(page.getUsername().isEmpty()){
            exeperienceAll(model,page.getPageNum());
        }else {
            exeperienceByName(page.getUsername(),page.getPageNum(),model);
        }
        return "teacher/exeperience";
    }


    /**
     * 多选删除
     */
    @DeleteMapping("/teacher/exeperiencesmulti/{id}")
    @ResponseBody
    public void checkoutDel(@PathVariable("id") String id ){
        String[] strs=id.split(",");
        for (String s : strs){
            deleteExperienceById(Integer.parseInt(s));
        }
    }


}
