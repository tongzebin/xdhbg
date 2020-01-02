package cn.xdh.dao;

import cn.xdh.entity.Exeperience;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author TZB
 */
@Repository
public interface ExeperienceDao {

    List<Exeperience> selectAll();

    List<Exeperience> selectByStudent_id(int id);

    Integer deleteById(int id);
}
