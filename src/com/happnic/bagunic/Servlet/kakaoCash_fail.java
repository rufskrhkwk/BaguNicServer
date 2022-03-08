package com.happnic.bagunic.Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/kakaoCash_fail")
public class kakaoCash_fail extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		String email = request.getParameter("partner_user_id");

		System.out.println(email);

		out.print("<html><head><title>Bagunic</title></head>");
		out.print("<body>");
		out.print("<h1>결제가 실패했습니다.</h1>");
		out.println("</body></html>");
		out.close();
	}

}
