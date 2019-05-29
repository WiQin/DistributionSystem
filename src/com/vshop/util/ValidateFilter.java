package com.vshop.util;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


public class ValidateFilter implements Filter {

    private ServletContext servletContext;

    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest)req;
        HttpServletResponse response = (HttpServletResponse)resp;
        HttpSession session = request.getSession();

        //获取配置的登陆页面地址
        String loginPage  = servletContext.getInitParameter("loginPage");
        System.out.println("登录页面"+loginPage);

        //获取需要登录才能访问的页面地址
        String validatePage = servletContext.getInitParameter("validatePage");

        //获取不需要登陆就可以访问的面地址
        String commonPage  = servletContext.getInitParameter("commonPage");

        //获取当前用户访问的地址
        String current_url = request.getServletPath();
        if(commonPage.indexOf(current_url)!= -1){
            chain.doFilter(req,resp);
        }else if(validatePage.indexOf(current_url)!= -1 && session.getAttribute("user")!= null){
            chain.doFilter(req,resp);
        }else{
            response.sendRedirect(request.getContextPath()+loginPage);
        }

    }

    public void init(FilterConfig config) throws ServletException {
        servletContext = config.getServletContext();
    }

}
