package cn.xdh.dao;

import cn.xdh.entity.Works;
import org.springframework.stereotype.Repository;

import java.util.List;


/**
 * @author TZB
 */
@Repository
public interface WorksDao {

    List<Works> selectById(int id);

    List<Works> selectAll();

}
