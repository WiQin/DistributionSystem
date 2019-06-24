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
import java.util.List;

@WebServlet("/main.do")
public class MainServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("进入MainServlet");

        HttpSession session = request.getSession();

        IUserService userService = new UserServiceImpl();

        String user_id = request.getParameter("user");
        if(user_id == null){
            user_id = session.getAttribute("user").toString();
        }

        User user = userService.getUserByUserId(user_id);

        if(user != null){
            System.out.println(user.getLeft_num()+","+user.getRight_num()+","+user.getLevel());

            List<User> userList = userService.getList(user.getLeft_num(),user.getRight_num(),user.getLevel());

            System.out.println(userList);

            int i = 0;
            for (User user2 :
                    userList) {
                if (user2.getLevel() == user.getLevel() + 1){
                    //第二层
                    switch (i){
                        case 0:
                            request.setAttribute("user_1",user2);
                            break;
                        case 1:
                            request.setAttribute("user_2",user2);
                            break;
                        default:
                            request.setAttribute("user_3",user2);
                            break;
                    }
                    i++;
                }else{

                }
            }
            
            request.setAttribute("list",userList);
            request.setAttribute("current_user",user);

            request.getRequestDispatcher("main.jsp").forward(request,response);

        }else{
            response.sendRedirect("error.jsp");
        }


    }
}
