package cn.myblog.service;

import cn.myblog.controller.WebSocketServer;
import cn.myblog.entity.Users_information;
import cn.myblog.entity.Users_state;
import cn.myblog.mapper.UsersMapper;
import cn.myblog.mapper.UsersStateMapper;
import cn.myblog.util.AES128Utils;
import cn.myblog.util.CommonlyUsedUtils;
import cn.myblog.util.SHA512Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.List;

@Service
@Transactional(rollbackFor = Exception.class) //指定回滚，遇到异常Excel回滚
public class UsersService {
    @Autowired
    private UsersMapper users_Mapper;
    @Autowired
    private UsersStateMapper users_stateMapper;

    /*用户登录*/
    public Boolean UsersLogin(Users_information user){
        if(user!=null){
        try {
            Users_state users_state=new Users_state();
            //验证身份
            String UserSHAPWD=SHA512Utils.SHA512(user.getUser_password()); //把用户输入的加密成SHA512位密码
            List<Users_information> usersLogin=users_Mapper.UsersLogin(user); //取出数据库AES128位的用户密码
            if(usersLogin.size()==1){
                String UserDataPWD=AES128Utils.dcodes(usersLogin.get(0).getUser_password(), usersLogin.get(0).getUser_Key()); //数据库：用密钥解密成SHA512位密码
                if(UserSHAPWD.equals(UserDataPWD)) {//身份通过
                    users_state.setUser_id(usersLogin.get(0).getUser_id());
                    if(users_stateMapper.Users_stateUnique(users_state).size()==0) {
                        if(users_stateMapper.Users_stateAdd(users_state)){
                            System.out.println("-----登录成功-----");
                        }
                        return false;
                    }else{
                        // 如果已经登录，则发送挤退信息
                        /*WebSocketServer wss = new WebSocketServer();
                        wss.getWebSocket(false);*/
                        if(users_stateMapper.Users_stateDelete(users_state)){
                            if(users_stateMapper.Users_stateAdd(users_state)){
                                System.out.println("-----顶号成功-----");
                                return true;
                            }
                        }
                        return false;
                    }
                }else {
                    System.out.println("-----密码错误-----");
                    return false;
                }
            }else{
                throw new Exception("系统错误：用户名重复,数据库里用户名必须唯一");
            }

        }catch (Exception e){
            System.out.println("-----无此用户-----");
            return false;
        }
        }else{
            return false;
        }
    }


    /*添加用户*/
    public Boolean UsersAdd(Users_information user){
        try {
            user.setUser_Key(CommonlyUsedUtils.getRandomNumber(16));//16位随机密钥 作AES128位加密解密用
            user.setUser_password(AES128Utils.ecodes(SHA512Utils.SHA512(user.getUser_password()),user.getUser_Key()));//用户输入的密码加密成SHA512位在用密钥加密成AES128位密码
            Integer UsersAccountDuplication=users_Mapper.UsersAccountDuplication(user);
            if(UsersAccountDuplication==0){
                return users_Mapper.UsersAdd(user);
            }else{
                return false;
            }
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    /*验证用户权限身份*/

}