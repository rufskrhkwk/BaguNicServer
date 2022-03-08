package com.happnic.bagunic.Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.happnic.bagunic.DAO.UserDAO;


@WebServlet("/findPassWord")
public class findPassWord extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		
		UserDAO dao = new UserDAO();
		String[] arr = dao.findPw("발송에 사용할 이메일 주소","happyNic");
		
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		
		if(arr!=null) {
			out.print(arr);
		}else {
			out.print("error");
		}
	}
}
