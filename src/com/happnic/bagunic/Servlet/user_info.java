package com.happnic.bagunic.Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.happnic.bagunic.DAO.RentDAO;
import com.happnic.bagunic.DAO.UserDAO;
import com.happnic.bagunic.VO.RentVO;


@WebServlet("/user_info")
public class user_info extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	      request.setCharacterEncoding("UTF-8");
	      String email = request.getParameter("email");
	      
	      
	      RentDAO dao = new RentDAO();
	      ArrayList<RentVO> user_info = dao.reservation_info(email);
	      response.setContentType("application/json");
	      response.setCharacterEncoding("utf-8");
	      PrintWriter out = response.getWriter();
	      
	      
	      Gson gson = new Gson();
	      String result = gson.toJson(user_info);
	      
	      out.print(result);

	}

}
