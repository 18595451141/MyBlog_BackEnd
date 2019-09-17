package cn.myblog.service;

import cn.myblog.entity.Users_information;
import cn.myblog.entity.Users_state;
import cn.myblog.mapper.UsersMapper;
import cn.myblog.mapper.UsersStateMapper;
import cn.myblog.util.SHA512Utils;
import net.minidev.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpSession;
import java.util.List;

@Service
@Transactional(rollbackFor = Exception.class) //指定回滚，遇到异常Excel回滚
public class UsersService {

    @Autowired
    private UsersMapper users_Mapper;
    @Autowired
    private UsersStateMapper users_stateMapper;

    /*用户登录*/
    /*
        密码加密 已完成
        拦截登录 已完成
        单一登录 已完成
        自动登录 进行中


        图片验证码 待完成
        扫码登录 待完成
        第三方登录 待完成

        动态权限 待完成
    */
    public JSONObject UsersLogin(Users_information user, HttpSession session) {
        JSONObject json = new JSONObject();
        try {
            if (user.getUser_accountNumber() != null && user.getUser_password() != null && user.getUser_accountNumber() != "" && user.getUser_password() != "") {
                //把用户输入的加密成SHA512位密码
                user.setUser_password(SHA512Utils.SHA512(user.getUser_password()));
                //验证身份
                List<Users_information> usersLogin = users_Mapper.UsersLogin(user);
                if (1 == usersLogin.size()) {

                    Users_state users_state = new Users_state();
                    users_state.setUser_id(usersLogin.get(0).getUser_id());
                    users_state.setUs_sessionid(session.getId());
                    if(users_stateMapper.Users_stateUnique(users_state).size()>=1 && users_stateMapper.Users_stateUpdate(users_state)){
                        session.setAttribute("usersid", usersLogin.get(0).getUser_id());
                        session.setAttribute("userssessionid", session.getId());
                        json.put("state", "登录成功");
                    }else if(users_stateMapper.Users_stateAdd(users_state)){
                        session.setAttribute("usersid", usersLogin.get(0).getUser_id());
                        session.setAttribute("userssessionid", session.getId());
                        json.put("state", "登录成功");
                    }else{
                        json.put("state", "登录失败");
                    }
                    return json;

                    /*if (users_stateMapper.Users_stateUnique(users_state).size() == 0 && users_stateMapper.Users_stateAdd(users_state)) {
                        session.setAttribute("usersLogin", usersLogin);
                        session.setMaxInactiveInterval(60);//一分钟
                        json.put("state", "登录成功");
                        return json;
                    } else {
                        // 如果已经登录，则发送挤退信息
                        if (users_stateMapper.Users_stateDelete(users_state) && users_stateMapper.Users_stateAdd(users_state)) {
                            session.setAttribute("usersLogin", usersLogin);
                            session.setMaxInactiveInterval(60);//一分钟
                            json.put("state", "顶号成功");
                            return json;
                        } else {
                            json.put("state", "顶号失败");
                            return json;
                        }
                    }*/
                } else if (0 == usersLogin.size()) {
                    json.put("state", "用户名或密码错误");
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
            //throw new Exception("出现异常，联系管理员"); 自定义异常
            json.put("state", "出现异常，联系管理员");
            return json;
        }
    }

    /*用户注册*/
    /*
        基本注册 已完成
        用户密码加密 已完成
        手机短信验证码注册 未完成
        邮箱验证码注册 未完成
    */
    public JSONObject UsersAdd(Users_information user) {
        JSONObject json = new JSONObject();
        try {
            if (user.getUser_accountNumber() != null && user.getUser_password() != null && user.getUser_accountNumber() != "" && user.getUser_password() != "") {
                user.setUser_password(SHA512Utils.SHA512(user.getUser_password()));//用户输入的密码加密成SHA512位
                Integer UsersAccountDuplication = users_Mapper.UsersAccountDuplication(user);
                if (UsersAccountDuplication == 0) {
                    if (users_Mapper.UsersAdd(user)) {
                        json.put("state", "添加成功");
                        return json;
                    } else {
                        json.put("state", "添加失败");
                        return json;
                    }
                } else {
                    json.put("state", "用户名重复");
                    return json;
                }
            } else {
                json.put("state", "用户密码不能为空");
                return json;
            }
        } catch (Exception e) {
            e.printStackTrace();
            json.put("state", "出现异常，联系管理员");
            return json;
        }
    }

}