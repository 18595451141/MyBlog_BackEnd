package cn.myblog.controller;

import cn.myblog.entity.Users_information;
import cn.myblog.service.UsersService;
import net.minidev.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping(value = "/Users")
public class UsersController {

    @Autowired
    private UsersService users_Service;

    @RequestMapping(value = "/UsersLogin")
    public JSONObject UsersLogin(Users_information user,HttpSession session) {
        return users_Service.UsersLogin(user,session);
    }

    @RequestMapping(value = "/UsersAdd")
    public JSONObject UsersAdd(Users_information user) {
        return users_Service.UsersAdd(user);
    }

}
