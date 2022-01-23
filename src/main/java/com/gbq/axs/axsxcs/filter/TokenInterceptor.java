package com.gbq.axs.axsxcs.filter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gbq.axs.axsxcs.config.jwt.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
// * @ClassName TokenInterceptor
 * @Description TODO
 * @Author guobenqi
 * @Date 2022/1/21 20:39
 */
@Component
public class TokenInterceptor implements HandlerInterceptor {
    @Autowired
    private JwtUtils jwtUtils;
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        response.setCharacterEncoding("utf-8");
        String token = request.getHeader("Bearer");
        System.out.println("你好"+token);
        Map<String,Object> map = new HashMap<>();
        if (token != null){
            try {
                Date expiredDateFromToken = jwtUtils.getExpiredDateFromToken(token);
                System.out.println(expiredDateFromToken);
                if (jwtUtils.isTokenExpired(token)){
                    map.put("msg","当前登录已经过期");
                    map.put("code","1000");
                    writeMessage(map,response);
                    return false;
                }
                Boolean aBoolean = jwtUtils.validateToken(token);
                if (aBoolean){
                    System.out.println("通过拦截器！");
                    return true;
                }
            }catch (Exception e){
                map.put("msg","当前登录已经过期");
                map.put("code","1000");
                writeMessage(map,response);
                return false;
            }

        }
        map.put("msg","还没登录，请登录！");
        map.put("code","2000");
        writeMessage(map,response);
        return false;


    }
    public void writeMessage(Map<String, Object> map, HttpServletResponse response){
        String json;
        try {
            json = new ObjectMapper().writeValueAsString(map);
            response.setContentType("application/json;charset=UTF-8");
            response.getWriter().println(json);
        } catch (IOException  e) {
            System.out.println(e);
//            log.error("token验证失败返回消息时捕获到异常信息[{}]",e.getMessage());
        }
    }
//    default void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable ModelAndView modelAndView) throws Exception {
//    }
//
//    default void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable Exception ex) throws Exception {
//    }

}
