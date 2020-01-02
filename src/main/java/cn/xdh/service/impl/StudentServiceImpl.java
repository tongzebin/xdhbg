package cn.xdh.service.impl;

import cn.xdh.dao.StudentDao;
import cn.xdh.dao.TeacherDao;
import cn.xdh.entity.City;
import cn.xdh.entity.Msg;
import cn.xdh.entity.Student;
import cn.xdh.entity.TeacherLog;
import cn.xdh.service.StudentService;
import cn.xdh.util.ExcelToObjectUtil;
import cn.xdh.util.SomeMethods;
import cn.xdh.util.VerifyPhone;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentDao studentDao;
    @Autowired
    private TeacherDao teacherDao;
    @Autowired
    TeacherLog teacherLog;
    @Autowired
    Msg msg;




    @Override
    public List<Student> selectAllNameAndId() {
        return studentDao.selectAllNameAndId();
    }

    public Student selectByMobileAndPassword(String mobile, String password) {
        Student student = studentDao.selectByMobileAndPassword(mobile, password);
        return student;

    }
    @Override
    public List<Student> selectIdAndNameByName(String username) {
        return studentDao.selectIdAndNameByName(username);
    }



    @Override
    public List<Map<String, Object>> getStudentByUndergraduate() {
        List<Map<String, Object>> undergraduateStudentList = studentDao.getStudentByUndergraduate();
        return undergraduateStudentList;
    }

    @Override
    public List<Map<String, Object>> getStudentByGraduate() {
        List<Map<String, Object>> graduateStudentList = studentDao.getStudentByGraduate();
        for (Map<String, Object> student:graduateStudentList){
            //获取省级城市id,查询城市名,插入Map集合中
            Integer aim_province_id = (Integer)student.get("aim_province_id");
            String aim_province = selectCityById(aim_province_id);
            student.put("aim_province",aim_province);
            //获取市级城市id,查询城市名,插入Map集合中
            Integer aim_city_id = (Integer)student.get("aim_city_id");
            String aim_city = selectCityById(aim_city_id);
            student.put("aim_city",aim_city);
            //获取县级城市id,查询城市名,插入Map集合中
            Integer aim_area_id = (Integer)student.get("aim_area_id");
            String aim_area = selectCityById(aim_area_id);
            student.put("aim_area",aim_area);
        }
        return graduateStudentList;
    }

    @Override
    public String selectCityById(Integer id) {
        return studentDao.selectCityById(id);
    }

    @Override
    public int addStudentService(Student student, HttpServletRequest request) {
        //获取要增加的学生的手机号
        String mobile = student.getMobile();
        //验证手机号是否正确
        boolean flag = VerifyPhone.isMobile(mobile);
        if (!flag){
            return 1;
        }
        //查询该学生是否已存在,存在则返回2,不存在则继续添加
        Student student1 = studentDao.selectStudentByMobile(mobile);
        if (student1!=null){
            return 2;
        }

        long newTime = SomeMethods.getCurrentTime();
        //入学时间join_study_time 默认系统当前时间
        student.setJoin_study_time(newTime);
        //是否毕业is_graduate 默认是0未毕业
        student.setIs_graduate(0);
        //阶段stage_id 默认是1,1阶段
        student.setStage_id(1);
        //密码password 默认是 123
        student.setPassword(SomeMethods.md5("123"));

        //获取cookie中的老师信息
        String action = "添加学生"+student.getUsername();
        teacherLog = SomeMethods.getCookieValue(request,teacherLog,action);
        //将日志实体类添加到日志表中
        teacherDao.addTeacherLog(teacherLog);
        //添加学生的操作
        studentDao.addStudent(student);
        return 3;
    }

    @Override
    public List<Student> getAllStudentByGraduate(Integer graduate) {
        return studentDao.getAllStudentByGraduate(graduate);
    }

    @Override
    public Student getStudentByMobile(String mobile) {
        return studentDao.selectStudentByMobile(mobile);
    }

    @Override
    public List<Map<String,Object>> getStudentLikeUsername(int is_graduate,String username) {
        System.out.println(is_graduate);
        List<Map<String, Object>> studentListByName =  studentDao.selectStudentLikeUsername(is_graduate,username);
        for (Map<String, Object> student:studentListByName){
            //获取省级城市id,查询城市名,插入Map集合中
            Integer aim_province_id = (Integer)student.get("aim_province_id");
            String aim_province = selectCityById(aim_province_id);
            student.put("aim_province",aim_province);
            //获取市级城市id,查询城市名,插入Map集合中
            Integer aim_city_id = (Integer)student.get("aim_city_id");
            String aim_city = selectCityById(aim_city_id);
            student.put("aim_city",aim_city);
            //获取县级城市id,查询城市名,插入Map集合中
            Integer aim_area_id = (Integer)student.get("aim_area_id");
            String aim_area = selectCityById(aim_area_id);
            student.put("aim_area",aim_area);
        }
        return studentListByName;
    }

    @Override
    public Student getStudentById(int id) {
        return studentDao.selectStudentById(id);
    }

    @Override
    public void deleteStudent(int id, HttpServletRequest request) {
        Student student = studentDao.selectStudentById(id);
        //获取cookie中的老师信息
        String action = "删除"+student.getUsername();
        SomeMethods.getCookieValue(request,teacherLog,action);
        //将日志实体类添加到日志表中
        teacherDao.addTeacherLog(teacherLog);
        //删除学生
        studentDao.deleteStudent(id);
    }

    @Override
    public List<City> getProvince() {
        return studentDao.selectProvince();
    }

    @Override
    public List<City> getCityByUpId(int upId) {
        return studentDao.selectCityByUpId(upId);
    }

    @Override
    public List<City> getAreaByUpId(int upId) {
        return studentDao.selectAreaByUpId(upId);
    }

    @Override
    public void updateStudent(Student student,HttpServletRequest request) {
        long newTime = SomeMethods.getCurrentTime();
        student.setGraduate_time(newTime);
        //获取cookie中的老师信息
        String action = "修改学生"+student.getUsername();
        SomeMethods.getCookieValue(request,teacherLog,action);
        //将日志实体类添加到日志表中
        teacherDao.addTeacherLog(teacherLog);
        //修改学生
        studentDao.updateStudent(student);
    }

    @Override
    public Msg batchAddStudent(HttpServletRequest request,String suffixName,MultipartFile excelFile)  {
            List<Student> list = null;
            try {
                //从xml读取需要的数据
                if (".xls".equals(suffixName)){
                    list = ExcelToObjectUtil.read(excelFile);
                }else{
                    list = ExcelToObjectUtil.readXlsx(excelFile);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (list.size()==0 ){
                msg.setMsg("数据为空");
                return msg;
            }

            for (Student student : list) {
                //设置默认性别是男
                student.setSex(1);
                int a = addStudentService(student,request);
                if (a==1){
                    msg.setMsg(student.getUsername()+"手机号码不正确,在他之前的已添加成功,请勿重复添加");
                    return msg;
                }else if (a==2){
                    msg.setMsg(student.getUsername()+"已存在,在他之前的已添加成功,请勿重复添加");
                    return msg;
                }
            }
        msg.setMsg("添加成功");
        return msg;
    }
}
