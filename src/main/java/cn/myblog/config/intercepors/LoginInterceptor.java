package cn.myblog.config.intercepors;

import cn.myblog.entity.Users_state;
import cn.myblog.mapper.UsersStateMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

/*拦截器配置一*/
@Component
public class LoginInterceptor implements HandlerInterceptor {

    @Autowired
    private UsersStateMapper usersStateMapper;

    //这个方法是在访问接口之前执行的，我们只需要在这里写验证登陆状态的业务逻辑，就可以在用户调用指定接口之前验证登陆状态了
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session=request.getSession();
        if (session.getAttribute("usersid")==null) {
            //跳转路径（方法）
            response.sendRedirect("/");
            System.out.println("----您未进行登录，请先去登录----");
            return false;
        } else {
            Users_state users_state=new Users_state();
            users_state.setUser_id(Integer.parseInt(session.getAttribute("usersid").toString()));
            users_state.setUs_sessionid(session.getAttribute("userssessionid").toString());
            List<Users_state> stateLogin=usersStateMapper.Users_stateLogin(users_state);
            if(stateLogin.size()>0){
                return true;
            }else{
                response.sendRedirect("/");
                System.out.println("----有人在别处登录，请重新登录----");
                return false;
            }
        }
    }
}
