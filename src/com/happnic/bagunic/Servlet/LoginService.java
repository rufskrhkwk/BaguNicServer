package com.happnic.bagunic.Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.happnic.bagunic.DAO.UserDAO;
import com.happnic.bagunic.VO.UserVO;


@WebServlet("/LoginService")
public class LoginService extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String email = request.getParameter("email");
		String pw = request.getParameter("pw");
		
		System.out.print(email);
		
		UserDAO dao = new UserDAO();
		UserVO vo = dao.Login(email,pw);
		
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		
		
		if(vo != null) {
			System.out.println(email+" : Login ");
			String result = new Gson().toJson(vo);
			out.write(result);
		}else {
			System.out.println(email + ": Login fail");
			out.write("fail");
		}
	}

}
