package cn.xdh.service;

import cn.xdh.dao.ExeperienceDao;
import cn.xdh.entity.Exeperience;
import cn.xdh.entity.Experience;
import cn.xdh.entity.Works;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author TZB
 */
public interface ExeperienceService {


    List<Exeperience> selectAll();

    List<Exeperience> selectByStudent_id(int id);

    Integer deleteById(int id, HttpServletRequest request);


    // 遍历所有心得
    List<Experience> selectExperience();

    // 删除某个心得
    int deleteExperience(int id);

    // 增加某个心得
    int insertExperience(Experience experience);


}
