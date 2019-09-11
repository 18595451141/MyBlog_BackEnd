package cn.myblog.controller;

import cn.myblog.entity.Users_information;
import cn.myblog.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class IndexController {

    @Autowired
    private UsersService users_Service;

    @RequestMapping(value="/Users/{name}")
    @ResponseBody
    public Boolean UsersLogin(@PathVariable("name") String name, Users_information user){
        if(name.equals("UsersLogin")){
            return users_Service.UsersLogin(user);
        }else if(name.equals("UsersAdd")){
            return users_Service.UsersAdd(user);
        }else{
            return false;
        }
    }

    @RequestMapping(value="index/{name}")
    public String index(@PathVariable("name") String name){
        return name+".html";
    }

}
