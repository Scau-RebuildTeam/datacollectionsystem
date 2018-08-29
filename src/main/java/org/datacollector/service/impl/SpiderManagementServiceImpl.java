package org.datacollector.service.impl;

import com.github.pagehelper.PageHelper;
import org.datacollector.mappers.SpiderMapper;
import org.datacollector.model.Spider;
import org.datacollector.service.SpiderManagementService;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.text.DateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by 哲帆 on 2018.8.24.
 */
@Service
public class SpiderManagementServiceImpl implements SpiderManagementService {

    @Resource
    private SpiderMapper spiderMapper;

    @Override
    public boolean createSpider(String spiderName, String url, String title1, String date1, String title2, String date2) {
        Date time = new Date();
        DateFormat d2 = DateFormat.getDateTimeInstance();
        String createDate = d2.format(time);
        Spider spider = new Spider(spiderName, url, title1, date1, title2, date2, createDate);
        return save(spider);
    }

    @Override
    public boolean deleteSpider(String spiderName) {
        return deleteById(spiderName);
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public boolean save(Spider model) {
        if (spiderMapper.insert(model) == 1) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean deleteById(Object id) {
        if (spiderMapper.deleteByPrimaryKey(id) == 1) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    @Deprecated
    public List<Spider> find(String value) {
        return null;
    }

    @Override
    @Deprecated
    public List<Spider> findAll() {
        return null;
    }

    @Override
    public List<Spider> find(int pageNum, int pageSize, String value) {
        Example example = new Example(Spider.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.orEqualTo("spider_name", value);
        PageHelper.startPage(pageNum, pageSize);
        return spiderMapper.selectByExample(example);
    }

    @Override
    public List<Spider> findAll(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        return spiderMapper.selectAll();
    }
}
