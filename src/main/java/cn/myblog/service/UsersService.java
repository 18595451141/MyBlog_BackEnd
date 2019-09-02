package cn.myblog.service;

import cn.myblog.entity.Users;
import cn.myblog.mapper.UsersMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsersService {
    @Autowired
    private UsersMapper users_Mapper;
    public List<Users> FindUsers(){
        return users_Mapper.FindUsers();
    }
}