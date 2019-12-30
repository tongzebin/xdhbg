package cn.xdh.interceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import sun.net.www.content.image.gif;
import sun.net.www.content.image.jpeg;
import sun.net.www.content.image.png;

@Component
public class InterceptorConfiguration implements WebMvcConfigurer {
    @Autowired
    private SomeInterceptor someinterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {


        registry.addInterceptor(someinterceptor).addPathPatterns("/admin*");

        /*//对所有的进行拦截   放行登录页面和首页
        registry.addInterceptor(someinterceptor).addPathPatterns("/**").excludePathPatterns("/","/index","/logout");
        */
    }
}
