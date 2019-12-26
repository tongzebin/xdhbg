package cn.xdh.service;

import cn.xdh.entity.Works;

import java.util.List;

/**
 * @author TZB
 */
public interface WorksService {
    /**
     * 通过姓名查找作品
     * @return
     */

    List<Works> selectById(int id);
    List<Works> selectAll();
    Integer deleteById(int id);
}
