package cn.xdh.service.impl;

import cn.xdh.dao.AdminDao;
import cn.xdh.dao.AdminLogRepository;
import cn.xdh.dao.TeacherLogRepository;
import cn.xdh.entity.Admin;
import cn.xdh.entity.AdminLog;
import cn.xdh.entity.TeacherLog;
import cn.xdh.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.*;
import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    private AdminDao admindao;
    @Autowired
    private AdminLogRepository adminlogRepository;
    @Autowired
    private TeacherLogRepository teacherlogRepository;

    //根据手机号和密码获取管理员
    @Override
    public Admin selectByPhoneAndPassword(String mobile, String password){
        Admin admin = admindao.selectByPhoneAndPassword(mobile,password);
        return admin;
    }

    @Override
    public Admin selectByMobile(String mobile){
        Admin admin = admindao.selectByMobile(mobile);
        return admin;
    }

    //增加管理员日志
    @Override
    public int addAdminLog(AdminLog adminlog){
        int result = admindao.addAdminLog(adminlog);
        return result;
    }

    //查找所有的管理员日志
    @Override
    public List<AdminLog> selectNewAdminLog(){
        List<AdminLog> adminlog = admindao.selectNewAdminLog();
        return  adminlog;
    }

    //查找所有管理员日志并分页
    @Override
    public Page<AdminLog> selectAllAdminLog(int page, int size){
        Sort sort = new Sort(Sort.Direction.DESC, "id");
        Pageable pageable = PageRequest.of(page, size, sort);
        Page<AdminLog> adminlogs = adminlogRepository.findAll(pageable);
        return adminlogs;
    }

    //根据名字模糊查找管理员日志并分页
    @Override
    public Page<AdminLog> selectAllAdminLogByName(final String name, int page, int size){
        Sort sort = new Sort(Sort.Direction.DESC, "id");
        final Pageable pageable = PageRequest.of(page, size, sort);
        final Specification<AdminLog> queryCondition = new Specification<AdminLog>() {
            @Override
            public Predicate toPredicate(Root<AdminLog> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                //查找条件
                Predicate p1 = cb.like(root.get("admin_name").as(String.class), "%" + name + "%");
                return p1;
            }
        };
        Page<AdminLog> adminlogs = adminlogRepository.findAll(queryCondition,pageable);
        return adminlogs;
    }

    //根据Ip模糊查找管理员日志并分页
    @Override
    public Page<AdminLog> selectAllAdminLogByIp(final String ip, int page, int size){
        Sort sort = new Sort(Sort.Direction.DESC, "id");
        final Pageable pageable = PageRequest.of(page, size, sort);
        Specification<AdminLog> queryCondition = new Specification<AdminLog>() {
            @Override
            public Predicate toPredicate(Root<AdminLog> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                //查找条件
                Predicate p1 = cb.like(root.get("add_ip").as(String.class), "%" + ip + "%");
                return p1;
            }
        };
        Page<AdminLog> adminlogs = adminlogRepository.findAll(queryCondition,pageable);
        return adminlogs;
    }

    //根据几个模糊查找管理员日志并分页
    @Override
    public Page<AdminLog> selectAllAdminLogByAll(final String allname, int page, int size){
        Sort sort = new Sort(Sort.Direction.DESC, "id");
        final Pageable pageable = PageRequest.of(page, size, sort);
        Specification<AdminLog> queryCondition = new Specification<AdminLog>() {
            @Override
            public Predicate toPredicate(Root<AdminLog> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                //查找条件
                Predicate p1 = cb.like(root.get("add_ip").as(String.class), "%" + allname + "%");
                Predicate p2 = cb.like(root.get("admin_name").as(String.class), "%" + allname + "%");
                Predicate p3 = cb.like(root.get("admin_id").as(String.class), "%" + allname + "%");
                Predicate p4 = cb.like(root.get("content").as(String.class), "%" + allname + "%");
                return cb.or(p1,p2,p3,p4); 
            }
        };
        Page<AdminLog> adminlogs = adminlogRepository.findAll(queryCondition,pageable);
        return adminlogs;
    }

    //查找所有教师操作日志并分页
    @Override
    public Page<TeacherLog> selectAllTeacherLog(int page, int size){
        Sort sort = new Sort(Sort.Direction.DESC, "id");
        Pageable pageable = PageRequest.of(page, size, sort);
        Page<TeacherLog> teacherlogs = teacherlogRepository.findAll(pageable);
        return teacherlogs;
    }

    //根据名字模糊查找管理员日志并分页
    @Override
    public Page<TeacherLog> selectAllTeacherLogByName(final String name, int page, int size){
        Sort sort = new Sort(Sort.Direction.DESC, "id");
        final Pageable pageable = PageRequest.of(page, size, sort);
        final Specification<TeacherLog> queryCondition = new Specification<TeacherLog>() {
            @Override
            public Predicate toPredicate(Root<TeacherLog> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                //查找条件
                Predicate p1 = cb.like(root.get("teacher_name").as(String.class), "%" + name + "%");
                return p1;
            }
        };
        Page<TeacherLog> teacherlogs = teacherlogRepository.findAll(queryCondition,pageable);
        return teacherlogs;
    }

    //根据Ip模糊查找管理员日志并分页
    @Override
    public Page<TeacherLog> selectAllTeacherLogByIp(final String ip, int page, int size){
        Sort sort = new Sort(Sort.Direction.DESC, "id");
        final Pageable pageable = PageRequest.of(page, size, sort);
        Specification<TeacherLog> queryCondition = new Specification<TeacherLog>() {
            @Override
            public Predicate toPredicate(Root<TeacherLog> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                //查找条件
                Predicate p1 = cb.like(root.get("add_ip").as(String.class), "%" + ip + "%");
                return p1;
            }
        };
        Page<TeacherLog> teacherlogs = teacherlogRepository.findAll(queryCondition,pageable);
        return teacherlogs;
    }


    //根据名字模糊查找教师日志并分页
    @Override
    public Page<TeacherLog> selectAllTeacherLogByAll(final String allname, int page, int size){
        Sort sort = new Sort(Sort.Direction.DESC, "id");
        final Pageable pageable = PageRequest.of(page, size, sort);
        Specification<TeacherLog> queryCondition = new Specification<TeacherLog>() {
            @Override
            public Predicate toPredicate(Root<TeacherLog> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                //查找条件
                Predicate p1 = cb.like(root.get("add_ip").as(String.class), "%" + allname + "%");
                Predicate p2 = cb.like(root.get("teacher_name").as(String.class), "%" + allname + "%");
                Predicate p4 = cb.like(root.get("action").as(String.class), "%" + allname + "%");
                return cb.or(p1,p2,p4);
            }
        };
        Page<TeacherLog> teacherlogs = teacherlogRepository.findAll(queryCondition,pageable);
        return teacherlogs;
    }

}
