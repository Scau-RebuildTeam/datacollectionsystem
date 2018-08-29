package org.datacollector.controller;

import com.alibaba.fastjson.JSONObject;
import org.datacollector.model.Data;
import org.datacollector.service.DataService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by 哲帆 on 2018.8.24.
 */
@RestController
@RequestMapping("/data")
public class DataPageController {

    @Resource
    private DataService dataService;

    @RequestMapping(value = "/get")
    public JSONObject getData(@RequestParam(name = "draw") int draw, @RequestParam(name = "length", defaultValue = "20") int pageSize, @RequestParam(name = "start", defaultValue = "0") int pageNum, @RequestParam(name = "search[value]") String query) {
        List<Data> list = dataService.getData(pageNum, pageSize, query);
        long count = dataService.count();

        JSONObject res = new JSONObject();
        res.put("draw", draw);
        res.put("recordsTotal", count);
        res.put("recordsFiltered", count);  //filter);
        res.put("data", list);
        return res;
    }

}
