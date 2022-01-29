package com.gbq.axs.axsxcs.filter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @ClassName TokenConfig
 * @Description TODO
 * @Author guobenqi
 * @Date 2021/10/27 22:04
 */
@Configuration
public class TokenConfig implements WebMvcConfigurer {
    @Autowired
    private TokenInterceptor tokenInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //注册TestInterceptor拦截器
        InterceptorRegistration registration = registry.addInterceptor(tokenInterceptor);
        registration.addPathPatterns("/**"); //所有路径都被拦截
        registration.excludePathPatterns(    //添加不拦截路径
                "/account/login",                    //登录路径
                "/register",
                "/account/getAccount",
                "/account/login/userpass",
                "/dealing/getAllDealing",
                "/dealing/getDealingById",
                "/dealing/searchDealing",
                "/posting/getAllPosting",
                "/posting/getPostingById",
                "/captcha",
                "/doc.html/**",
                "/*.html",                //html静态资源
                "/**/*.js",                  //js静态资源
                "/**/*.css",                  //css静态资源
                "/swagger-resources/**",
                "/webjars/**",
                "/v2/**"
                );

    }
}
