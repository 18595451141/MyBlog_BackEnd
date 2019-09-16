package cn.myblog.service;

import cn.myblog.entity.Users_information;
import cn.myblog.entity.Users_state;
import cn.myblog.mapper.UsersMapper;
import cn.myblog.mapper.UsersStateMapper;
import cn.myblog.util.AES128Utils;
import cn.myblog.util.CommonlyUsedUtils;
import cn.myblog.util.SHA512Utils;
import net.minidev.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(rollbackFor = Exception.class) //指定回滚，遇到异常Excel回滚
public class UsersService {

    @Autowired
    private UsersMapper users_Mapper;
    @Autowired
    private UsersStateMapper users_stateMapper;

    /*用户登录*/
    public JSONObject UsersLogin(Users_information user) {
        JSONObject json = new JSONObject();
        try {
            if (user.getUser_accountNumber() != null && user.getUser_password() != null && user.getUser_accountNumber() != "" && user.getUser_password() != "") {
                //验证身份
                // 取出数据库AES128位的用户密码
                List<Users_information> usersLogin = users_Mapper.UsersLogin(user);
                if (1 == usersLogin.size()) {
                    //把用户输入的加密成SHA512位密码
                    String UserSHAPWD = SHA512Utils.SHA512(user.getUser_password());
                    Users_state users_state = new Users_state();
                    String UserDataPWD = AES128Utils.dcodes(usersLogin.get(0).getUser_password(), usersLogin.get(0).getUser_Key()); //数据库：用密钥解密成SHA512位密码
                    //身份通过的话
                    if (UserSHAPWD.equals(UserDataPWD)) {
                        users_state.setUser_id(usersLogin.get(0).getUser_id());
                        if (users_stateMapper.Users_stateUnique(users_state).size() == 0 && users_stateMapper.Users_stateAdd(users_state)) {
                            json.put("state", "登录成功");
                            return json;
                        } else {
                            // 如果已经登录，则发送挤退信息
                        /*WebSocketServer wss = new WebSocketServer();
                        wss.getWebSocket(false);*/
                            if (users_stateMapper.Users_stateDelete(users_state) && users_stateMapper.Users_stateAdd(users_state)) {
                                json.put("state", "顶号成功");
                                return json;
                            } else {
                                json.put("state", "顶号失败");
                                return json;
                            }
                        }
                    } else {
                        json.put("state", "密码错误");
                        return json;
                    }
                } else if (0 == usersLogin.size()) {
                    json.put("state", "无此账号");
                    return json;
                } else {
                    json.put("state", "联系管理员，账号重复");
                    return json;
                }
            } else {
                json.put("state", "用户名密码为空");
                return json;
            }
        } catch (Exception e) {
            //throw new Exception("系统错误：用户名重复,数据库里用户名必须唯一"); 自定义异常
            json.put("state", "无此用户");
            return json;
        }
    }


    /*添加用户*/
    public JSONObject UsersAdd(Users_information user) {
        JSONObject json = new JSONObject();
        try {
            if (user != null) {
                user.setUser_Key(CommonlyUsedUtils.getRandomNumber(16));//16位随机密钥 作AES128位加密解密用
                user.setUser_password(AES128Utils.ecodes(SHA512Utils.SHA512(user.getUser_password()), user.getUser_Key()));//用户输入的密码加密成SHA512位在用密钥加密成AES128位密码
                Integer UsersAccountDuplication = users_Mapper.UsersAccountDuplication(user);
                if (UsersAccountDuplication == 0 && users_Mapper.UsersAdd(user)) {
                    json.put("state", "添加成功");
                    return json;
                } else {
                    json.put("state", "添加失败");
                    return json;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            json.put("state", "添加出现异常，联系管理员");
            return json;
        }
        System.out.println("-----json：-----" + json);
        return json;
    }

    /*验证用户权限身份*/

}