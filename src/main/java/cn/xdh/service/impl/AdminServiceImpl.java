package cn.xdh.service.impl;

import cn.xdh.dao.AdminDao;
import cn.xdh.entity.Admin;
import cn.xdh.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    private AdminDao admindao;

    @Override
    public Admin selectByPhoneAndPassword(String mobile, String password){
        Admin admin = admindao.selectByPhoneAndPassword(mobile,password);
        return admin;
    }
}
