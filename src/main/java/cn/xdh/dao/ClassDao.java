package cn.xdh.dao;

import cn.xdh.entity.Teacher;
import cn.xdh.entity.XdhClass;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ClassDao {
    //获取所有班级数量
    public int selectAllNumber();

    public XdhClass selectClassById(int id);
}
