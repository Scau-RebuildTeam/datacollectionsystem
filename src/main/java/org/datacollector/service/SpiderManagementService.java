package org.datacollector.service;

import org.datacollector.model.Spider;

import java.util.List;

/**
 * Created by 哲帆 on 2018.8.24.
 */
public interface SpiderManagementService extends BaseSqlService<Spider> {

    boolean createSpider(String spiderName, String url, String title1, String date1, String title2, String date2);

    boolean deleteSpider(String spiderName);

    List<Spider> find(int pageSize, int pageNum, String value);

    List<Spider> findAll(int pageSize, int pageNum);
}
