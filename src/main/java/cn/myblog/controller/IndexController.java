package cn.myblog.controller;

import cn.myblog.entity.Users;
import cn.myblog.mapper.UsersMapper;
import cn.myblog.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {

    @Autowired
    private UsersService users_Service;

    @RequestMapping(value="/UsersLogin")
    public Boolean index(Users user){
        return users_Service.UsersLogin(user);
    }
}
