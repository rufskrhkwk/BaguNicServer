package com.happnic.bagunic.Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/kakaoCash_success")
public class kakaoCash_success extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		//카카오 로그인 성공
		String email = request.getParameter("email");
		String basket_type = request.getParameter("basket_type");
		String park_area = request.getParameter("park_area");
		
		System.out.println(email +" at "+park_area+" : "+basket_type + "");
		out.print("<html><head><title>Bagunic Welcome");
		out.print("<body>");
		out.print("<h1>결제가 완료되었습니다</h1>");
		out.println("</body></html>");
		out.close();
		
	}
}
