package cn.myblog.service;

import cn.myblog.entity.Users;
import cn.myblog.mapper.UsersMapper;
import cn.myblog.util.AES128Utils;
import cn.myblog.util.AES256Utils;
import cn.myblog.util.SHA512Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsersService {
    @Autowired
    private UsersMapper users_Mapper;

    /*用户登录*/
    public Boolean UsersLogin(Users user){
        user.setUser_Pwd(SHA512Utils.SHA512(user.getUser_Pwd()));
        return users_Mapper.UsersLogin(user);
    }

    /*添加用户*/
    public Boolean UsersAdd(Users user){
        user.setUser_Pwd(SHA512Utils.SHA512(user.getUser_Pwd()));
        return users_Mapper.UsersAdd(user);
    }

}