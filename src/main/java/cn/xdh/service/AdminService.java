package cn.xdh.service;

import cn.xdh.entity.Admin;

public interface AdminService {
    public Admin selectByPhoneAndPassword(String mobile, String password);

}
