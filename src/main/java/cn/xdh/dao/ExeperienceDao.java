package cn.xdh.dao;

import cn.xdh.entity.Exeperience;
import cn.xdh.entity.Experience;
import org.apache.ibatis.annotations.Param;
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

    // 查所有心得
    List<Experience> selectExperience();
    // 删除某个心得
    int deleteExperience(@Param("id") int id);
    // 增加某个心得
    int insertExperience(Experience experience);
}
