package com.advance;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet({ "/user", "/user1" })
public class Users extends HttpServlet {
	static Connection con = null;
	static Statement st = null;
	static ResultSet set = null;
	static PreparedStatement pst = null;
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			PrintWriter pw = resp.getWriter();
			ResourceBundle rb = ResourceBundle.getBundle("com.utilities.info");
			 con = DriverManager.getConnection(rb.getString("url"), rb.getString("user"), rb.getString("pswd"));
			resp.setContentType("text/html");
			String url = req.getRequestURL().substring(31);
			if (url.equals("user")) {
				String sub = req.getParameter("sub");
				if (sub.equals("Submit")) {
					if (check(req, resp)) {
						RequestDispatcher rq = req.getRequestDispatcher("/users.html");
						rq.include(req, resp);
						displayDettails(req, pw);
					} else {
						pw.println(
								"<h4  style=\"color:red;margin:265px 0 30px 570px\">Incorrect username or password </h4>");
						RequestDispatcher rq = req.getRequestDispatcher("/loginUser.html");
						rq.include(req, resp);
					}
				} else if (sub.equals("Register")) {
					insertion(req);
					pw.println("<h2 style=\"color:green;text-align:center\">Successfully Registered</h2>");
					pw.println(
							"<h4  style=\"color:red;text-align:center;margin-bottom:40px\">Signin to continue </h4>");
					RequestDispatcher rq = req.getRequestDispatcher("/loginUser.html");
					rq.include(req, resp);
				} else {
					RequestDispatcher rq = req.getRequestDispatcher("/signupUs.html");
					rq.include(req, resp);

				}
			} else if (url.equals("user1")) {
				String choice = req.getParameter("choice");
				if (choice.equals("View Books")) {
					RequestDispatcher rq = req.getRequestDispatcher("/users.html");
					rq.include(req, resp);
					display(req, resp, pw);
				}
			}

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}finally {
			if(con!=null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(st!=null) {
				try {
					st.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(pst!=null) {
				try {
					pst.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(set!=null) {
				try {
					set.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public void insertion(HttpServletRequest req) throws SQLException {
		
		String fn = req.getParameter("fn");
		String ln = req.getParameter("ln");
		String email = req.getParameter("email");
		String un = req.getParameter("un");
		String pass = req.getParameter("pswd");
		String sql = "insert into users (`firstname`,`lastname`,`email` ,`username`,`password`,`type`) value (?,?,?,?,?,?) ";
		pst = con.prepareStatement(sql);
		pst.setString(1, fn);
		pst.setString(2, ln);
		pst.setString(3, email);
		pst.setString(4, un);
		pst.setString(5, pass);
		pst.setString(6, "user");
		int i = pst.executeUpdate();
		con.close();
	}

	public void displayDettails(HttpServletRequest req, PrintWriter pw) throws SQLException {
		ResourceBundle rb = ResourceBundle.getBundle("com.utilities.info");
//		Connection con = DriverManager.getConnection(rb.getString("url"), rb.getString("user"), rb.getString("pswd"));
		 st = con.createStatement();
		HttpSession s = req.getSession();
		String us = (String) s.getAttribute("user");
		String sql = "select * from `users` where username='" + us + "'";
		set = st.executeQuery(sql);
		set.next();
		pw.println("<link rel=\"stylesheet\"\r\n"
				+ "	href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css\"\r\n"
				+ "	integrity=\"sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T\"\r\n"
				+ "	crossorigin=\"anonymous\">");
		pw.print("<div class='namepart row'><div class=\"col-6 col-md-4\"><h4 style='display:inline' >Name : " + set.getString(2)
				+ " " + set.getString(3) + "</h4></div>");
		pw.print("<div class=\"col-6 col-md-4\"><h4 style='display:inline'>Email : " + set.getString(4)
				+ "</h4></div></div>");
		String sq="select book_id,sum(noofbooks) from issuedbook where username='"+us+"' group by book_id";
		PreparedStatement pst = con.prepareStatement(sq);
		ResultSet set1 = pst.executeQuery();
		pw.println("<h1 style=\"margin-bottom: 40px;margin-left:350px;margin-top:50px\" >ISSUEDBOOKS</h1>");
		pw.println(
				"<table class=\"table\" style=\"margin-bottom: 20px\"><thead><tr><th>BOOK NAME</th><th>GENERE</th><th>AUTHOR</th><th>NO. OF BOOKS</th></tr></thead>");
		while (set1.next()) {
			String sql1 = "select `name`,`author`,`type`,`noofbooks` from book where id=" + set1.getString(1);
			ResultSet j = st.executeQuery(sql1);
			while (j.next()) {
				pw.println("<tr><td>" + j.getString("name") + "</td><td>" + j.getString("type") + "</td><td>"
						+ j.getString("author") + "</td><td>" + set1.getString(2) + "</td></tr>");
			}
			j.close();

		}
		set1.close();
		
	}

	public boolean check(HttpServletRequest req, HttpServletResponse resp) throws SQLException {
		String un = "", ps = "";
		ResourceBundle rb = ResourceBundle.getBundle("com.utilities.info");
//		Connection con = DriverManager.getConnection(rb.getString("url"), rb.getString("user"), rb.getString("pswd"));
		String user = req.getParameter("username");
		String pass = req.getParameter("password");
		HttpSession sess = req.getSession();
		sess.setAttribute("user", user);
		st = con.createStatement();
		set = st.executeQuery("select `username` , `password` from `users` where `type` = 'user'");
		while (set.next()) {
			if (user.equals(set.getString(1))) {
				un = set.getString(1);
				ps = set.getString(2);
				break;
			}
		}
		if (user.equals(un) && pass.equals(ps)) {
			return true;
		}
		return false;

	}

	public void display(HttpServletRequest req, HttpServletResponse resp, PrintWriter pw)
			throws SQLException, IOException {
		ResourceBundle rb = ResourceBundle.getBundle("com.utilities.info");
//		Connection con = DriverManager.getConnection(rb.getString("url"), rb.getString("user"), rb.getString("pswd"));
		 st = con.createStatement();
		HttpSession s = req.getSession();
		String us = (String) s.getAttribute("user");
		String sql1 = "select * from `users` where username='" + us + "'";
		set = st.executeQuery(sql1);
		set.next();
		pw.println("<link rel=\"stylesheet\"\r\n"
				+ "	href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css\"\r\n"
				+ "	integrity=\"sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T\"\r\n"
				+ "	crossorigin=\"anonymous\">");
		pw.print("<div class='namepart row'><div class=\"col-6 col-md-4\"><h4 style='display:inline' >Name : " + set.getString(2)
				+ " " + set.getString(3) + "</h4></div>");
		pw.print("<div class=\"col-6 col-md-4\"><h4 style='display:inline'>Email : " + set.getString(4)
				+ "</h4></div></div>");
		
		String sql = "select * from book";
		 set = st.executeQuery(sql);
		pw.println("<link rel=\"stylesheet\"\r\n"
				+ "	href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css\"\r\n"
				+ "	integrity=\"sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T\"\r\n"
				+ "	crossorigin=\"anonymous\">");
		
		pw.println("<h1 style=\"margin-bottom: 40px;margin-left:350px;margin-top:50px\" >BOOK COLLECTION</h1>");
		pw.println(
				"<table class=\"table\" style=\"margin-bottom: 20px\"><thead><tr><th>BOOK NAME</th><th>GENERE</th><th>AUTHOR</th><th>NO. OF BOOKS</th><th>ISSUE BOOK</th></tr></thead>");
		while (set.next()) {
			pw.println("<tr><td>" + set.getString(2) + "</td><td>" + set.getString(3) + "</td><td>" + set.getString(4)
					+ "</td><td>" + set.getString(5)
					+ "</td> <td><form action='issueB' method='post'><input type='text' style=\"width:80px\" name='noofitem'><input value='Submit' style=\"margin-left: 10px\" class='btn btn-success' type='submit' name='sup"
					+ set.getString(1)
					+ "'></form></td></tr>");
		}
	}
}
