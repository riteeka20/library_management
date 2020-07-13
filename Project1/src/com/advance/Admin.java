package com.advance;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet({ "/admin", "/admin1", })
public class Admin extends HttpServlet {
	static Connection con = null;
	static Statement st = null;
	static Statement st2 = null;
	static ResultSet set = null;
	static ResultSet j = null;
	static PreparedStatement pst = null;
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			PrintWriter pw = resp.getWriter();
			ResourceBundle rb = ResourceBundle.getBundle("com.utilities.info");
			con = DriverManager.getConnection(rb.getString("url"), rb.getString("user"),
					rb.getString("pswd"));
			String url = req.getRequestURL().substring(31);
			String sub = req.getParameter("sub");
			resp.setContentType("text/html");
			if (url.equals("admin")) {
				if (sub.equals("Submit")) {
					if (check(req, resp, rb, con)) {
						displayDettails(req, pw);
						RequestDispatcher rq = req.getRequestDispatcher("/admin.html");
						rq.include(req, resp);
					} else {
						pw.println(
								"<h4  style=\"color:red;margin:265px 0 30px 570px\">Incorrect username or password </h4>");
						RequestDispatcher rq = req.getRequestDispatcher("/loginAdmin.html");
						rq.include(req, resp);
					}
				} else if (sub.equals("Register")) {
					pw.println("<h2 style=\"color:green;text-align:center\">Successfully Registered</h2>");
					pw.println(
							"<h4  style=\"color:red;text-align:center;margin-bottom:40px\">Signin to continue </h4>");
					insertUser(req, rb, con);
					RequestDispatcher rq = req.getRequestDispatcher("/loginAdmin.html");
					rq.include(req, resp);
				} else {
					RequestDispatcher rq = req.getRequestDispatcher("/signUpad.html");
					rq.include(req, resp);
				}
			} else if (url.equals("admin1")) {
				if (sub.equals("Add Book")) {
					RequestDispatcher rq = req.getRequestDispatcher("/addBook.html");
					rq.include(req, resp);
				}
				if (sub.equals("View Books")) {
					displayDettails(req, pw);
					RequestDispatcher rq = req.getRequestDispatcher("/admin.html");
					rq.include(req, resp);
					veiw(req, pw, rb, con, "book");
				}
				if (sub.equals("View Users")) {
					displayDettails(req, pw);
					RequestDispatcher rq = req.getRequestDispatcher("/admin.html");
					rq.include(req, resp);
					veiw(req, pw, rb, con, "users");
				}
				if (sub.equals("View Issued Books")) {
					displayDettails(req, pw);
					RequestDispatcher rq = req.getRequestDispatcher("/admin.html");
					rq.include(req, resp);
					veiwIssue(req, rb, con, pw);
				}
			}
		} catch (ClassNotFoundException | SQLException e) {
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
			if(st2!=null) {
				try {
					st2.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(j!=null) {
				try {
					j.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

	}

	public void veiwIssue(HttpServletRequest req, ResourceBundle rb, Connection con, PrintWriter pw)
			throws SQLException {
		st = con.createStatement();
		String sql = "select `username`,`book_id`,(noofbooks),`issueddate`,`returndate`,`type` from issuedbook";
		set = st.executeQuery(sql);
		pw.println("<link rel=\"stylesheet\"\r\n"
				+ "	href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css\"\r\n"
				+ "	integrity=\"sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T\"\r\n"
				+ "	crossorigin=\"anonymous\">");
		pw.println("<h1 style=\"margin-bottom: 40px;margin-left:350px;margin-top:50px\" >ISSUEDBOOKS</h1>");
		pw.println(
				"<table class=\"table\" style=\"margin: 20px 50px\"><thead><tr><th>USERNAME</th><th>BOOK NAME</th><th>GENERE</th><th>AUTHOR</th><th>NO. OF BOOKS</th><th>ISSUEDDATE</th></tr></thead>");
		while (set.next()) {
			st2 = con.createStatement();
			String sql1 = "select `name`,`author`,`type` from book where id= " + set.getString(2);
			 j = st2.executeQuery(sql1);
			while (j.next()) {
				pw.print("<tr><td>" + set.getString("username") + "</td><td>" + j.getString("name") + "</td><td>"
						+ j.getString("type") + "</td><td>" + j.getString("author") + "</td><td>"
						+ set.getString(3) +"</td><td>"+set.getString(4)+ "</td></tr>");
			}
		}
	}

	private boolean check(HttpServletRequest req, HttpServletResponse resp, ResourceBundle rb, Connection con)
			throws SQLException {
		String un = "", ps = "";
		String user = req.getParameter("username");
		String pass = req.getParameter("password");
		st = con.createStatement();
        set = st.executeQuery("select `username` , `password` from `users` where `type` = 'admin'");
		while (set.next()) {
			if (user.equals(set.getString(1))) {
				un = set.getString(1);
				ps = set.getString(2);
				break;
			}
		}
		if (user.equals(un) && pass.equals(ps)) {
			HttpSession sess = req.getSession();
			sess.setAttribute("admin", user);
			return true;
		}
		return false;

	}

	public void insertUser(HttpServletRequest req, ResourceBundle rb, Connection con) throws SQLException {

		String fn = req.getParameter("fn");
		String ln = req.getParameter("ln");
		String email = req.getParameter("email");
		String un = req.getParameter("un");
		String pswd = req.getParameter("pswd");
		String sql = "insert into users (`firstname`,`lastname`,`email`,`username`,`password`,`type`) value (?,?,?,?,?,?) ";
		pst = con.prepareStatement(sql);
		pst.setString(1, fn);
		pst.setString(2, ln);
		pst.setString(3, email);
		pst.setString(4, un);
		pst.setString(5, pswd);
		pst.setString(6, "admin");
		int i = pst.executeUpdate();
		con.close();
	}

	public void veiw(HttpServletRequest req, PrintWriter pw, ResourceBundle rb, Connection con, String str)
			throws SQLException {
		 st = con.createStatement();
		pw.println("<link rel=\"stylesheet\"\r\n"
				+ "	href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css\"\r\n"
				+ "	integrity=\"sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T\"\r\n"
				+ "	crossorigin=\"anonymous\">");
		if (str.equals("book")) {
			String sql = "select * from `" + str + "`";
			 set = st.executeQuery(sql);
			pw.println("<h1 style=\"margin-bottom: 40px;margin-left:350px;margin-top:50px\" >BOOK COLLECTION</h1>");
			pw.println(
					"<table class=\"table\" style=\"margin:20px 50px\"><thead><tr><th>ID</th><th>BOOK NAME</th><th>GENERE</th><th>AUTHOR</th><th>NO. OF BOOKS</th><th>DELETE</th></tr></thead>");
			while (set.next()) {
				pw.print("<tbody><tr><td>" + set.getString(1) + "</td><td>" + set.getString(2) + "</td><td>"
						+ set.getString(3) + "</td><td>" + set.getString(4) + "</td><td>" + set.getString(5)
						+ "</td><td><form action='deleteB'><input value='Delete' class='btn btn-danger' type='submit' name='sup"
						+ set.getString(1) + "'></form></td></tr></tbody>");
			}
		} else if (str.equals("users")) {
			String sql = "select * from `" + str + "` where type='user'";
			 set = st.executeQuery(sql);
			pw.println("<h1 style=\"margin-bottom: 40px;margin-left:350px;margin-top:50px\" >Users List</h1>");
			pw.println(
					"<table class=\"table\" style=\"margin:20px 50px\"><thead><tr><th>FIRST NAME</th><th>LAST NAME</th><th>EMAIL</th><th>USERNAME</th><th>DELETE</th></tr></thead>");
			while (set.next()) {
				pw.print("<tr><td>" + set.getString(2) + "</td><td>" + set.getString(3) + "</td><td>" + set.getString(4)
						+ "</td><td>" + set.getString(5) + "</td>"
						+ "<td><form action='deleteU'><input value='Delete' class='btn btn-danger' type='submit' name='sup"
						+ set.getString(1) + "'></form></td></tr>");
			}
			pw.print("</table>");
		}
	}
	public static void displayDettails(HttpServletRequest req, PrintWriter pw) throws SQLException {
		ResourceBundle rb = ResourceBundle.getBundle("com.utilities.info");
		con = DriverManager.getConnection(rb.getString("url"), rb.getString("user"),
				rb.getString("pswd"));
		 st = con.createStatement();
		HttpSession s = req.getSession();
		String us = (String) s.getAttribute("admin");
		String sql = "select * from `users` where username='" + us + "'";
		set = st.executeQuery(sql);
		set.next();
		pw.print("<div class='namepartad row'><div class=\"\"><h4 style='display:inline;margin-right:150px' >Name : " + set.getString(2)
				+ " " + set.getString(3) + "</h4></div>");
		pw.print("<div class=\" \"><h4 style='display:inline'>Email : " + set.getString(4)
				+ "</h4></div></div>");
	}

}
