package com.vshop.servlet;

import com.vshop.service.IUserService;
import com.vshop.service.impl.UserServiceImpl;
import com.vshop.util.StringHelper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/login.do")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("进入Servlet中");

        HttpSession session = request.getSession();

        System.out.println(request.getParameter("account"));
        System.out.println(request.getParameter("password"));

        String account = request.getParameter("account");
        String password = request.getParameter("password");

        IUserService userService = new UserServiceImpl();
        //接收返回结果
        String result = userService.login(account, StringHelper.MD5(password));
        System.out.println(result);

        //用户名存到session中
        if(result.equals("3")){
            session.setAttribute("user",account);
            session.setMaxInactiveInterval(3600);

        }

         PrintWriter out = response.getWriter();
         //结果返回给ajax请求
         out.print(result);//ajax请求登陆，返回值是中文乱码
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
