package org.datacollector.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by 哲帆 on 2018.8.24.
 */
@Controller
@RequestMapping("/view")
public class View {

    @RequestMapping(value = "/admin")
    public String admin() {
        return "admin";
    }

    @RequestMapping(value = "/error")
    public String error() {
        return "error";
    }

    @RequestMapping(value = "/index")
    public String index() {
        return "index";
    }

    @RequestMapping(value = "/redirect")
    public String redirect() {
        return "redirect";
    }

}
