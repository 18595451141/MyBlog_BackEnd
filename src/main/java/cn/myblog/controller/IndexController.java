package cn.myblog.controller;

import net.minidev.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
    //页面模板初始化
    @RequestMapping(value = "/index/{name}")
    public String index(@PathVariable("name") String name) {
        return name + ".html";
    }
}
