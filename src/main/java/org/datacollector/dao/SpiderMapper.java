package org.datacollector.dao;

import org.datacollector.model.Spider;

public interface SpiderMapper {
    int deleteByPrimaryKey(String spiderName);

    int insert(Spider record);

    int insertSelective(Spider record);

    Spider selectByPrimaryKey(String spiderName);

    int updateByPrimaryKeySelective(Spider record);

    int updateByPrimaryKey(Spider record);
}