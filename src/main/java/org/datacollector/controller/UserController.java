package org.datacollector.controller;

import com.alibaba.fastjson.JSONObject;
import org.datacollector.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

/**
 * Created by 哲帆 on 2018.8.24.
 */
@Controller
public class UserController {

    @Resource
    private UserService userService;

    @RequestMapping(value = "/login")
    @ResponseBody
    public JSONObject login(@RequestBody JSONObject json, HttpSession session) {
        String password = json.getString("password");

        JSONObject res = new JSONObject();
        if (userService.login(password)) {
            res.put("code", 10);
            session.setAttribute("user", System.currentTimeMillis());
        } else {
            res.put("code", 11);
        }
        return res;
    }

    @RequestMapping(value = "/logout")
    @ResponseBody
    public JSONObject logout(HttpSession session) {
        session.removeAttribute("user");
        return null;
    }


}
