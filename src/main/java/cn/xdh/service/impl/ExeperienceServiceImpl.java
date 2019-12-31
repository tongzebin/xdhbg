package cn.xdh.service.impl;

import cn.xdh.dao.ExeperienceDao;
import cn.xdh.entity.Exeperience;
import cn.xdh.service.ExeperienceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author TZB
 */
@Service
public class ExeperienceServiceImpl implements ExeperienceService {

    @Autowired
    ExeperienceDao exeperienceDao;

    @Override
    public List<Exeperience> selectAll() {
        return exeperienceDao.selectAll();
    }

    @Override
    public List<Exeperience> selectByStudent_id(int id) {
        return exeperienceDao.selectByStudent_id(id);
    }

    @Override
    public Integer deleteById(int id) {
        return exeperienceDao.deleteById(id);
    }
}
