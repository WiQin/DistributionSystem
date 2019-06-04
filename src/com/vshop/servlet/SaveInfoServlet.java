package com.vshop.servlet;

import com.vshop.entity.User;
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

@WebServlet("/saveInfo.do")
public class SaveInfoServlet extends HttpServlet {

    IUserService service;


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("进入保存");
        HttpSession session = request.getSession();
        if(session.getAttribute("user")!=null){

            service = new UserServiceImpl();

            User user = service.getUserByUserId(session.getAttribute("user").toString());
            user.setUser_name(request.getParameter("user_name"));
            user.setUser_birthday(request.getParameter("user_birthday"));
            user.setUser_city(request.getParameter("user_city"));
            //修改密码
            String user_pass = request.getParameter("user_pass");
            if(user_pass!= ""){
                user.setUser_pass(StringHelper.MD5(user_pass));
            }else{
                //不填保持不变
                user.setUser_pass(request.getParameter("hf_pass"));
            }
            user.setUser_faq(Integer.parseInt(request.getParameter("user_faq")));
            user.setUser_answer(request.getParameter("user_answer"));

            boolean b = service.saveUserInfo(user);
            if(b){
                request.setAttribute("msg","修改成功");
            }else{
                request.setAttribute("msg","修改失败");
            }
            request.getRequestDispatcher("main.jsp").forward(request,response);
            System.out.println("进入保存");
        }else{
                System.out.println("请先登陆");
                response.sendRedirect(request.getContextPath()+"/index.jsp");
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
