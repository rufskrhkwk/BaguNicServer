package com.happnic.bagunic.Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.oreilly.servlet.MultipartRequest;

@WebServlet("/getimg")
public class getimg extends HttpServlet {
	private static final long serialVersionUID = 1L;

	//App에서 사진을 받아와 저장.
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String folderTypePath = "C:\\Users\\smhrd\\projectimg";
	    String name = new String();
	    String fileName = new String();
	    PrintWriter out = response.getWriter();
	        
	    int sizeLimit = 5 * 1024 * 1024;
	    try {
	    	//MultipartRequest 파일 업로드 라이브러리.
	    	MultipartRequest multi = new MultipartRequest(request, folderTypePath, 
	    			sizeLimit, new DefaultFileRenamePolicy());
	    	Enumeration files = multi.getFileNames();

	        if (files.hasMoreElements()) {
	        	name = (String) files.nextElement();
	            fileName = multi.getFilesystemName(name);
	        }
	        
	        System.out.println("img save success" + fileName);
	        
	    } catch (IOException e) {
	    	out.println("img save fail");
	    }
	}
}




