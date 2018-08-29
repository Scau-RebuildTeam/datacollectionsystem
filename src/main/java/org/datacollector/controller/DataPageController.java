package org.datacollector.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.datacollector.model.Data;
import org.datacollector.service.DataService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by 哲帆 on 2018.8.24.
 */
@Controller
@RequestMapping("/data")
public class DataPageController {

    @Resource
    private DataService dataService;

    @RequestMapping(value = "/get")
    @ResponseBody
    public JSONObject getData(HttpServletRequest request) {
        int draw = Integer.parseInt(request.getParameter("draw"));
        int limit = Integer.parseInt(request.getParameter("length"));
        int skip = Integer.parseInt(request.getParameter("start"));
        String query = request.getParameter("search[value]");
        List<Data> list = dataService.getData(skip / limit, limit, query);
        long count = dataService.count(query);

        JSONObject res = new JSONObject();
        res.put("draw", draw);
        res.put("recordsTotal", count);
        res.put("recordsFiltered", count);  //filter);
        res.put("data", list);
        return res;
    }

    @Deprecated
    @RequestMapping(value = "/query")
    @ResponseBody
    public JSONObject queryData(@RequestBody JSONObject json) {
        int limit = json.getIntValue("pageSize");
        int skip = (json.getIntValue("pageNum") - 1) * limit;

        String[] info = new String[3];
        info[0] = json.getString("source");
        info[1] = json.getString("time");
        info[2] = json.getString("key");

        JSONArray array = new JSONArray();
        dataService.getData(skip / limit, limit, info[0]);
        JSONObject res = new JSONObject();
        res.put("result", array);

        return res;
    }

}
