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

    public  List<Works> selectById(int id);

    public  List<Works> selectAll();
}
