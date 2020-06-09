package com.neusoft.demosb.Interceptor;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        System.out.println("==========登录状态拦截");

        HttpSession session = request.getSession();
        System.out.println("sessionId为：" + session.getId());

        // 获取用户信息，如果没有用户信息直接返回提示信息
        Object accountInfo = session.getAttribute("account");
        if (accountInfo == null) {
            System.out.println("没有登录");
            //response.getWriter().write("Please Login In");
            String url = "/admin/toLogin";
            response.sendRedirect(url);//重定向网页，向浏览器发送一个特殊的header，转到指定页面
            return false;
        } else {
            System.out.println("已经登录过啦，用户信息为：" + session.getAttribute("account"));
        }

        return true;
    }
}
