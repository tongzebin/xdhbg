package cn.xdh.service.impl;

import cn.xdh.dao.DelNoticeDao;
import cn.xdh.service.DelNoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author victor
 * @site https://victorfengming.github.io/
 * @company XDL
 * @project xdh
 * @package cn.xdh.service.impl
 * @created 2019-12-30 14:33
 * @function ""
 */
@Service
public class DelNoticeServiceImpl implements DelNoticeService {
    @Autowired
    private DelNoticeDao delNoticeDao;
    @Override
    public Integer delNoticeService(Integer id) {
        return delNoticeDao.delNoticeDao(id);
    }
}
