package com.happnic.bagunic.Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.happnic.bagunic.DAO.UserDAO;

@WebServlet("/email_check")
public class email_check extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String email = request.getParameter("email");
		UserDAO dao = new UserDAO();
		
		boolean check = dao.emailCheck(email);
		
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		if(check) {
			out.print(check);
			System.out.println(email + " : available");
		}else if(check) {
			out.print(check);
			System.out.println(email + " : exist");
		}
	}
}
