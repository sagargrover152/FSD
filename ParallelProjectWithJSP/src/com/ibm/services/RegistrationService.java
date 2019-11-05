package com.ibm.services;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ibm.bean.UserInfo;


@WebServlet("/registrationservice")
public class RegistrationService extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		UserInfo user = new UserInfo(Long.parseLong(request.getParameter("mob")),request.getParameter("pass"),request.getParameter("uname"),request.getParameter("addr"),Long.parseLong(request.getParameter("amnt")));
		request.setAttribute("user", user);
		request.getRequestDispatcher("registration").include(request, response);
	}

}
