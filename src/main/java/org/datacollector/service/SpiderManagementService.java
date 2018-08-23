package org.datacollector.service;

import org.datacollector.model.Spider;

/**
 * Created by 哲帆 on 2018.8.24.
 */
public interface SpiderManagementService extends BaseService<Spider> {

    void createSpider(String spiderName, String url, String title1, String date1, String title2, String date2);

    void deleteSpider(String spiderName, String url);

}
