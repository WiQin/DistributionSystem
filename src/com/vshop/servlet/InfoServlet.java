package com.vshop.servlet;

import com.vshop.entity.User;
import com.vshop.service.IUserService;
import com.vshop.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/info.do")
public class InfoServlet extends HttpServlet {

    IUserService service;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        if(session.getAttribute("user")!=null){

            service = new UserServiceImpl();
            User user = service.getUserById(session.getAttribute("user").toString());

            request.setAttribute("user",user);

            request.getRequestDispatcher("info.jsp").forward(request,response);
            System.out.println("进入");
        }else{
            System.out.println("请先登陆");
            response.sendRedirect(request.getContextPath()+"/index.jsp");
        }





    }
}
