package cn.myblog.controller;

import cn.myblog.entity.Users;
import cn.myblog.service.UsersService;
import cn.myblog.util.AES128Utils;
import cn.myblog.util.AES256Utils;
import cn.myblog.util.SHA512Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class IndexController {

    @Autowired
    private UsersService users_Service;

    @RequestMapping(value="/Users/{name}")
    public Boolean UsersLogin(@PathVariable("name") String name,Users user){
        if(name.equals("UsersLogin")){
            return users_Service.UsersLogin(user);
        }else if(name.equals("UsersAdd")){
            return users_Service.UsersAdd(user);
        }else{
            return false;
        }
    }

}
