package cn.xdh.web;


import cn.xdh.entity.Exeperience;
import cn.xdh.entity.Experience;
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
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
        //学生姓名
        model.addAttribute("names", studentServiceimpl.selectAllNameAndId());
        //心得列表
        model.addAttribute("exeperiences", MyPaging.paging(exeperienceList,pageNum,pageSize));
        //获取总页数

        int page = exeperienceList.size()/pageSize;
        int generalPage = exeperienceList.size()%pageSize==0&&page>0?page:page+1;
        //获取当前页
        GetCurrentPage.getcurrentPage(pageNum,generalPage,model);
        //总页数
        model.addAttribute("generalPage",generalPage);
        //判断页数是否符合标准
        if(generalPage<pageNum){
            //前端判断本页面是否存在数据,若不存跳到最后一页(首页除外)
            model.addAttribute("price",0);
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
            return "teacher/exeperience";
        }
        List<Exeperience> exeperienceList = new ArrayList<Exeperience>();
        for (Student student : studentList) {
            //根据list集合中装的id拿取数据
            exeperienceList.addAll(exeperienceServiceImpl.selectByStudent_id(student.getId()));
        }
        //心得列表
        model.addAttribute("exeperiences", MyPaging.paging(exeperienceList,pageNum,pageSize));
        //学生姓名
        model.addAttribute("names", studentList);
        //获取总页数
        int page = exeperienceList.size()/pageSize;
        int generalPage = exeperienceList.size()%pageSize==0&&page>0?page:page+1;

        //获取当前页
        GetCurrentPage.getcurrentPage(pageNum,generalPage,model);
        model.addAttribute("generalPage",generalPage);
        //判断输入的值是否符合标准
        model.addAttribute("price",1);
        if(generalPage<pageNum){
            //删除完本页最后一条时(非首页),发送的数据
            model.addAttribute("price",0);
        }

        return "teacher/exeperience";
    }


    /**
     * 根据作品表id进行删除
     *
     * @param id    作品删除
     * @return
     */
    @DeleteMapping("/teacher/exeperience/{id}")
    @ResponseBody
    public void deleteExperienceById(@PathVariable("id") int id, HttpServletRequest request) {
        exeperienceServiceImpl.deleteById(id,request);
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
    public void checkoutDel(@PathVariable("id") String id,HttpServletRequest request ){
        String[] strs=id.split(",");
        for (String s : strs){
            deleteExperienceById(Integer.parseInt(s),request);
        }
    }


    @RequestMapping(value = "/selectExperience", method = RequestMethod.GET)
    public String toEditor(Model model, Experience experience){
        //获取心得集合
        List<Experience> experienceList = exeperienceServiceImpl.selectExperience();
        int i = 1;
        //循环 修改显示在列表的 心得编号 可以注释 查看 不修改之前的效果
        for (Experience e:experienceList){
            e.setId(i);
            i++;
        }
        model.addAttribute("experience",experienceList);
        return "student/experienceList";
    }

    @GetMapping("/selectExperience/{id}")
    public ModelAndView deleteExperience(@PathVariable("id")int id){
        //获取当前所有心得
        List<Experience> experienceList = exeperienceServiceImpl.selectExperience();
        //因为修改了 id 而且修改的id正好是 experienceList集合下标减一 所以 按照这个删除
        exeperienceServiceImpl.deleteExperience(experienceList.get(id-1).getId());
        return new ModelAndView("redirect:");
    }

    @PostMapping("/insertExperience")
    public ModelAndView insertExperience(String context) throws ParseException {

        // 获取当前时间 的int
        Date add_time = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String format = sdf.format(add_time);
        int add_time1 =(int) (sdf.parse(format).getTime()/1000);
        //获取心得集合
        List<Experience> experienceList = exeperienceServiceImpl.selectExperience();
        //设置要增加的心得  get(int index) 获取位于index的值 获取的id表示比最大心得编号+1
        Experience experience = new Experience(experienceList.get(experienceList.size()-1).getId()+1,
                experienceList.get(0).getStudent_id(),context,add_time1);
        int i = exeperienceServiceImpl.insertExperience(experience);
        return new ModelAndView("redirect:/selectExperience");
    }

    @GetMapping("/toEditor")
    public String toEditor(){
        return "student/editor";
    }

}
