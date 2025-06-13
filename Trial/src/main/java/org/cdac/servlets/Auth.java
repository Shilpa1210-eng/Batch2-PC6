package org.cdac.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import org.cdac.POJO.UsersDaoImpl;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/Auth")
public class Auth extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
				String username = request.getParameter("userName");
				String password = request.getParameter("password");

				UsersDaoImpl authUser = new UsersDaoImpl();
				boolean isValid = authUser.authenticateUser(username, password);
				
				PrintWriter out = response.getWriter();

				if (isValid) {
					out.println("<h2>Login Successful!</h2>");
					// Optionally redirect
					// response.sendRedirect("Dashboard.jsp");
				} else {
					out.println("<h2 style='color:red;'>Invalid credentials!</h2>");
					out.println("<a href='Login.html'>Try again</a>");
				}
			}
		}
