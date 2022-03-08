package com.happnic.bagunic.Servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.happnic.bagunic.DAO.AppchatDAO;
import com.happnic.bagunic.VO.AppChatVO;

@WebServlet("/ChatList")
public class ChatList extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		AppchatDAO dao = new AppchatDAO();
		ArrayList<AppChatVO> list = dao.chatList();
		response.setCharacterEncoding("UTF-8");

		Gson gson = new Gson();
		String result = gson.toJson(list);
		response.getWriter().print(result);
	}
}


