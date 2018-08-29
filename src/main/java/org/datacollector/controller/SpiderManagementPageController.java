package org.datacollector.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.datacollector.model.Spider;
import org.datacollector.service.SpiderManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by 哲帆 on 2018.8.24.
 */
@RestController
@RequestMapping(value = "/spider")
public class SpiderManagementPageController {

    @Autowired
    private SpiderManagementService spiderService;

    @RequestMapping(value = "/get")
    @ResponseBody
    public JSONObject getSpider(@RequestBody JSONObject json) {
        int limit = json.getInteger("pageSize");
        int skip = (json.getInteger("pageNum") - 1) * limit;
        List<Spider> data = spiderService.findAll(skip, limit);

        JSONArray array = new JSONArray();
        for (Spider aData : data) {
            JSONObject obj = new JSONObject();
            obj.put("name", aData.getSpiderName());
            obj.put("url", aData.getUrl());
            obj.put("time", aData.getCreateDate());

            array.add(obj);
        }
        JSONObject res = new JSONObject();
        res.put("result", array);

        return res;
    }

    @RequestMapping(value = "/create")
    @ResponseBody
    public JSONObject createSpider(@RequestBody JSONObject json) {
        String name = json.getString("name");
        String url = json.getString("url");
        String title1 = json.getString("title1");
        String date1 = json.getString("date1");
        String title2 = json.getString("title2");
        String date2 = json.getString("date2");

        JSONObject res = new JSONObject();
        if (spiderService.createSpider(name, url, title1, date1, title2, date2)) {
            res.put("code", 10);
        } else
            res.put("code", 11);

        return res;
    }

    @RequestMapping(value = "/delete")
    @ResponseBody
    public JSONObject deleteSpider(@RequestBody JSONObject json) {
        JSONObject res = new JSONObject();

        if (spiderService.deleteSpider(json.getString("name")))
            res.put("code", 10);
        else
            res.put("code", 11);

        return res;

    }
}
