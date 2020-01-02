package cn.xdh.service.impl;

import cn.xdh.dao.NoticeContentDao;
import cn.xdh.entity.NoticeContent;
import cn.xdh.entity.NoticeData;
import cn.xdh.service.NoticeContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author victor
 * @site https://victorfengming.github.io/
 * @company XDL
 * @project xdh
 * @package cn.xdh.service.impl
 * @created 2019-12-30 10:34
 * @function ""
 */
@Service
public class NoticeContentServerImpl implements NoticeContentService {
    @Autowired
    private NoticeContentDao noticeContentDao;
    @Override
    public Integer addNoticeContent(String content, Long time) {
        Integer nc = noticeContentDao.addNoticeContent(content,time);
        return nc;
    }
}
