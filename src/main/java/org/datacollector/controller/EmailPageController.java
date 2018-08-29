package org.datacollector.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.datacollector.model.Email;
import org.datacollector.service.EmailService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by 哲帆 on 2018.8.24.
 */
@RestController
@RequestMapping(value = "/contact")
public class EmailPageController {

    @Resource
    private EmailService emailService;

    @RequestMapping(value = "/get")
    public JSONObject getContactList(@RequestBody JSONObject json) {
        List<Email> contacts = emailService.findAll();

        JSONArray array = new JSONArray();
        for (int i = 0; i < contacts.size(); ++i) {
            JSONObject obj = new JSONObject();
            obj.put("name", contacts.get(i).getName());
            obj.put("mail", contacts.get(i).getAddress());

            array.add(obj);
        }
        JSONObject res = new JSONObject();
        res.put("result", array);

        return res;
    }

    @RequestMapping(value = "/add")
    public JSONObject addContact(@RequestBody JSONObject json) {
        System.out.println("add");
        Email newEmail = new Email();
        newEmail.setName(json.getString("name"));
        newEmail.setAddress(json.getString("mail"));

        JSONObject res = new JSONObject();

        if (emailService.save(newEmail))
            res.put("code", 10);
        else
            res.put("code", 11);

        return res;
    }

    @RequestMapping(value = "/delete")
    public JSONObject deleteContact(@RequestBody JSONObject json) {
        JSONObject res = new JSONObject();
        System.out.println(json.getString("name"));
        if (emailService.deleteById(json.getString("name")))
            res.put("code", 10);
        else
            res.put("code", 11);

        return res;
    }

}
