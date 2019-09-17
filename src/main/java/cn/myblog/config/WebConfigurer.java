package cn.myblog.config;

import cn.myblog.config.intercepors.LoginInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

//拦截器配置二
@Configuration
public class WebConfigurer implements WebMvcConfigurer {
    //将登录拦截器LoginInterceptor注入到WebConfigurer中。
    @Autowired
    private LoginInterceptor loginInterceptor;

    // 这个方法用来注册拦截器，我们自己写好的拦截器需要通过这里添加注册才能生效
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // addPathPatterns("/**") 表示拦截所有的请求，
        // excludePathPatterns("/index/{name}") 白名单，不拦截这个方法 需注意：登录首页需要加入白名单不然无限循环
        registry.addInterceptor(loginInterceptor).addPathPatterns("/**").excludePathPatterns("/Users/{name}");
    }

    // 这个方法是用来配置静态资源的，比如html，js，css，等等
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/**").addResourceLocations("classpath:/static/");
    }


}
