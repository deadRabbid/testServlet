package com.shevtcov.web;

import com.shevtcov.objects.Operation;
import com.shevtcov.objects.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by deadRabbit on 18.06.2015.
 */
public class UserServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Operation op = new Operation();
        if (request.getParameter("action") != null) {

            String edit_login = request.getParameter("edit_login");
            String edit_pass = request.getParameter("edit_pass");
            String edit_name = request.getParameter("edit_name");
            String edit_age = request.getParameter("edit_age");


            //edit_login, edit_pass, Integer.parseInt(edit_age), edit_name
            try {
                op.updateUser(Long.parseLong(request.getParameter("edit_id")), new User(edit_login, edit_pass, Integer.parseInt(edit_age), edit_name));
            } catch (Exception e) {
                e.printStackTrace();
            }
            try {
                op.removeUser(Long.parseLong(request.getParameter("id")));
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            String login = request.getParameter("login");
            String password = request.getParameter("password");
            String name = request.getParameter("name");
            String age = request.getParameter("age");
            try {
                op.addUser(new User(login, password, Integer.parseInt(age), name));
            } catch (Exception e) {
                e.printStackTrace();
            }


        }
            UserBeans ub = new UserBeans();

        try {
            ub.setList(op.getAll());
        } catch (Exception e) {
            e.printStackTrace();
        }
        request.setAttribute("model", ub);
            request.getRequestDispatcher("user.jsp").forward(request, response);


//        PrintWriter out = response.getWriter();
//        out.println("<html><head><title>Sample</title></head><body>");
//        out.println(name + " - " + age);
//        out.println("</body></html>");

    }
}
