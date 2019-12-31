package cn.xdh.web;

import cn.xdh.entity.Page;
import cn.xdh.entity.Student;
import cn.xdh.entity.Works;
import cn.xdh.service.impl.StudentServiceImpl;
import cn.xdh.service.impl.WorksServiceImpl;
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
public class WorkController {
    /**
     * 定义每个页面显示的数据条数
     */
    private final int pageSize=5;


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
    public String worksAll(Model model,@RequestParam("pageNum") int pageNum){
        List<Works> worksList=worksServiceimpl.selectAll();
        //获取总页数
        int page = worksList.size()/pageSize;
        int generalPage = worksList.size()%pageSize==0&&page>0?page:page+1;
        GetCurrentPage.getcurrentPage(pageNum,generalPage,model);
        model.addAttribute("generalPage",generalPage);

        model.addAttribute("names",studentServiceimpl.selectAllNameAndId());
        model.addAttribute("works", MyPaging.paging(worksList,pageNum,pageSize));
        //判断当前页是否有值
        model.addAttribute("price",1);
        if(generalPage<pageNum){
            model.addAttribute("price",0);
        }
        //获取当前页

        return "teacher/works";
    }


    /**
     * 根据学生姓名进行作品查询
     * @param username  学生姓名
     * @param model     返回作品集合
     * @return          跳到哪个网页
     */
    @GetMapping("/teacher/work")
    public String workByName(@RequestParam(value = "username")String username,Model model,int pageNum){

        //input数据回填
        model.addAttribute("backfill",username);
        List<Student> studentList = studentServiceimpl.selectIdAndNameByName(username);
        //如果根据条件没有查找到信息返回所有作品,并进行提示
        if(studentList.isEmpty()){
            model.addAttribute("pd","不存在该学生");
            worksAll(model,1);
            return "teacher/works";
        }
        List<Works> worksList=new ArrayList<>();
        for(Student student : studentList){
            //根据list集合中装的id拿取数据
            worksList.addAll(worksServiceimpl.selectById(student.getId()));
        }
        model.addAttribute("works",MyPaging.paging(worksList,pageNum,pageSize));
        model.addAttribute("names",studentList);
        //获取总页数
        int page = worksList.size()/pageSize;
        int generalPage = worksList.size()%pageSize==0&&page>0?page:page+1;
        model.addAttribute("generalPage",generalPage);
        GetCurrentPage.getcurrentPage(pageNum,generalPage,model);

        //判断当前页是否有数据
        model.addAttribute("price",1);
        if(generalPage<pageNum){
            model.addAttribute("price",0);
        }
        //获取当前页

        return "teacher/works";
    }

    /**
     * 根据作品表id进行删除
     * @param id        作品删除
     * @param model
     * @return
     */
    @DeleteMapping("/teacher/work/{id}")
    @ResponseBody
    public void deleteWork(@PathVariable("id")int id){
        worksServiceimpl.deleteById(id);
    }


    /**
     * 处理分页按钮请求
     */

    @GetMapping("/teacher/workpage")
    public String pagingRequest(Model model, Page page)  {
        if(page.getUsername().isEmpty()){
            worksAll(model,page.getPageNum());
        }else {
            workByName(page.getUsername(),model,page.getPageNum());
        }
        return "teacher/works";
    }



    /**
     * 多选删除
     */

    @DeleteMapping("/teacher/worksmulti/{id}")
    @ResponseBody
    public void checkoutDel(@PathVariable("id") String id ){
        String[] strs=id.split(",");
        for (String s : strs){
            deleteWork(Integer.parseInt(s));
        }
    }
}
