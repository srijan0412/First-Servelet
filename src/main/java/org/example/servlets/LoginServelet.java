package org.example.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        if (!username.matches("[A-Z][a-zA-Z]{2,}")) {  // Capital first letter, at least 3 characters
            response.getWriter().println("Invalid Name! Name must start with a capital letter and have at least 3 characters.");
            return;
        }

        if (!password.matches("^(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$")) {
            response.getWriter().println("Invalid Password! Must have 8+ characters, 1 uppercase, 1 number, and exactly 1 special character.");
            return;
        }

        if ("admin".equals(username) && "admin123".equals(password)) {
            request.getRequestDispatcher("LoginSuccess.jsp").forward(request, response);
        } else {
            response.getWriter().println("Invalid Credentials!");
        }
    }
}
