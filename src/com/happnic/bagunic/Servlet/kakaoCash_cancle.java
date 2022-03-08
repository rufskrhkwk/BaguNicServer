package com.happnic.bagunic.Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/kakaoCash_cancle")
public class kakaoCash_cancle extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		String email = request.getParameter("partner_user_id");
		String basket_type = request.getParameter("item_name");
		String park_area = request.getParameter("park_area");
		System.out.println(email);
		System.out.println(basket_type);

		out.print("<html><head><title>Bagunic</title></head>");
		out.print("<body>");
		out.print("<h1>결제를 취소하였습니다.</h1>");
		out.println("</body></html>");
		out.close();
	}

}
