package com.advance;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/loginMain")
public class Index extends HttpServlet {

	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String type = req.getParameter("type");
			if (type.equals("admin")) {
				resp.sendRedirect("loginAdmin.html");
			} else if(type.equals("user")){
				resp.sendRedirect("loginUser.html");
			}else {
				resp.sendRedirect("index.html");
			}
	}
}
