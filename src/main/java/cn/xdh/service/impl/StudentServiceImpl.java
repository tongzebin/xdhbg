package cn.xdh.service.impl;

import cn.xdh.dao.StudentDao;
import cn.xdh.entity.Notice;
import cn.xdh.entity.Student;
import cn.xdh.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Map;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentDao studentdao;

    @Override
    public Student selectByPhoneAndPassword(String phone, String password){
        Student student = studentdao.selectByPhoneAndPassword(phone,password);
        return student;
    }

    @Override
    public List<Notice> getNotices() {
        List<Notice> notices = studentdao.getNotices();
        return notices;
    }

    @Override
    public Student getDatas(int id) {
        Student studentDatas = studentdao.getDatas(id);
        return studentDatas;
    }

    @Override
    public String getClassName(int id) {
        return null;
    }


    @Override
    public List<Map<String, Object>> getUsefulData(int id) {
        List<Map<String, Object>> usefulDataList = studentdao.getUsefulData(id);

        return usefulDataList;
    }

    @Override
    public void  updateData(int id,String password,long birthday,String graduate_school,String stage_id) {
        studentdao.updateData(id,password,birthday,graduate_school,stage_id);
    }
}
