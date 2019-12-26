package cn.xdh.service.impl;

import cn.xdh.dao.WorksDao;
import cn.xdh.entity.Works;
import cn.xdh.service.WorksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author TZB
 */
@Service
public class WorksServiceImpl implements WorksService {
    @Autowired
    private WorksDao worksDao;

    @Override
    public List<Works> selectById(int id) {
        return worksDao.selectById(id);
    }

    @Override
    public List<Works> selectAll() {
        return worksDao.selectAll();
    }

    @Override
    public Integer deleteById(int id) {
        return worksDao.deleteById(id);
    }
}
