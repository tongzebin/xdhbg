package cn.xdh.service;

import cn.xdh.dao.ExeperienceDao;
import cn.xdh.entity.Exeperience;
import cn.xdh.entity.Works;

import java.util.List;

/**
 * @author TZB
 */
public interface ExeperienceService {


    List<Exeperience> selectAll();

    List<Exeperience> selectByStudent_id(int id);

    Integer deleteById(int id);
}
