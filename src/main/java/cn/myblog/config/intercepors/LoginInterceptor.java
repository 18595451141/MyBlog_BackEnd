package cn.myblog.config.intercepors;

import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Component
public class LoginInterceptor implements HandlerInterceptor {

    //这个方法是在访问接口之前执行的，我们只需要在这里写验证登陆状态的业务逻辑，就可以在用户调用指定接口之前验证登陆状态了
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session=request.getSession();
        System.out.println("session:"+session.getAttribute("usersLogin"));
        System.out.println("sessionid:"+session.getId());
        if (session.getAttribute("usersLogin")==null) {
            //跳转路径（方法）
            response.sendRedirect("/");
            System.out.println("----您未进行登录，请先去登录----");
            return false;
        } else {
            return true;
        }
    }
}
