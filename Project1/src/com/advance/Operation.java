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
import java.util.Enumeration;
import java.util.ResourceBundle;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet({ "/addB", "/issueB", "/veiwB", "/operation", "/deleteU", "/deleteB" })
public class Operation extends HttpServlet {
	static Connection con = null;
	static Statement st = null;
	static ResultSet set = null;
	static PreparedStatement pst = null;
	static ResultSet set1 = null;
	static ResultSet j = null;

	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			resp.setContentType("text/html");
			ResourceBundle rb = ResourceBundle.getBundle("com.utilities.info");
			con = DriverManager.getConnection(rb.getString("url"), rb.getString("user"), rb.getString("pswd"));
			PrintWriter pw = resp.getWriter();
			String url = req.getRequestURL().substring(31);
			if (url.equals("addB")) {
				instertion(req);
				Admin.displayDettails(req, pw);
				RequestDispatcher d = req.getRequestDispatcher("/admin.html");
				d.include(req, resp);
				pw.println("<h3 class='addpart' style=\"color:green\">Book Added Successfully</h3>");
			} else if (url.equals("deleteB")) {
				Enumeration<String> names = req.getParameterNames();
				int no = Integer.parseInt(names.nextElement().substring(3));
				deletion(req, "book", no);
				Admin.displayDettails(req, pw);
				RequestDispatcher d = req.getRequestDispatcher("/admin.html");
				d.include(req, resp);
				pw.println("<h3 style=\"color:green\">Book Deleted Successfully</h3><hr>");
			} else if (url.equals("deleteU")) {
				Enumeration<String> names = req.getParameterNames();
				int us = Integer.parseInt(names.nextElement().substring(3));
				deletion(req, "users", us);
				Admin.displayDettails(req, pw);
				RequestDispatcher d = req.getRequestDispatcher("/admin.html");
				d.include(req, resp);
				pw.println("<h3 style=\"color:green\">User Deleted Successfully</h3><hr>");
			} else if (url.equals("veiwB")) {
				veiw(req, pw, "book");
			} else if (url.equals("issueB")) {
				Enumeration<String> names = req.getParameterNames();
				names.nextElement();
				String name = names.nextElement();
				int us = Integer.parseInt(name.substring(3));
				String val = req.getParameter(name);
				if (val.equals("Submit")) {
					issue(req, resp, pw, us);
					RequestDispatcher d = req.getRequestDispatcher("/users.html");
					d.include(req, resp);
					displayDettails(req, pw);
				}
			}
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
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
			if(set1!=null) {
				try {
					set1.close();
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

	private void issue(HttpServletRequest req, HttpServletResponse resp, PrintWriter pw, int us2) throws SQLException, ServletException, IOException {
		HttpSession s = req.getSession();
		String us = (String) s.getAttribute("user");
		String dt = new SimpleDateFormat("d MMM yyyy hh:mm").format(new Date());
		int num = Integer.parseInt(req.getParameter("noofitem"));
		st = con.createStatement();
		String sql = "select noofbooks from book where id=" + us2;
		set = st.executeQuery(sql);
		set.next();
		int no = set.getInt(1);
		if (no < num) {
			pw.println("<h3 class='msgpart'>Insuffcient Books </h3><hr class='msgpart'>");
		} else if (no == num) {
			deletion(req, "book", us2);
			insertIssue(req, us2, us, num, dt);
			pw.println("<h3 class='msgpart'> Books Issued</h3><hr class='msgpart'>");
			RequestDispatcher d = req.getRequestDispatcher("/users.html");
			d.include(req, resp);
			displayDettails(req, pw);
		} else if (no > num) {
			insertIssue(req, us2, us, num,  dt);
			String sql1 = "update book set noofbooks=noofbooks-" + num + " where id=" + us2;
			int i = st.executeUpdate(sql1);
			pw.println("<h3 class='msgpart'> Books Issued</h3><hr class='msgpart'>");

		}
	}

	public void veiw(HttpServletRequest req, PrintWriter pw, String str)
			throws SQLException {
		st = con.createStatement();
		String sql = "select * from '" + str + "'";
		set = st.executeQuery(sql);
		pw.println("<h1 style=\"margin-bottom: 40px;margin-left:350px;margin-top:50px\" >BOOK COLLECTION</h1>");
		pw.println(
				"<table class=\"table\" style=\"margin-bottom: 20px\"><thead><tr><th>ID</th><th>BOOK NAME</th><th>GENERE</th><th>AUTHOR</th><th>NO. OF BOOKS</th></tr></thead>");
		while (set.next()) {
			pw.println("<tbody><tr><td>" + set.getString("id") + "</td><td>" + set.getString("name") + "</td><td>"
					+ set.getString("type") + "</td><td>" + set.getString("author") + "</td><td>"
					+ set.getString("noofbooks") + "</td></tbody>");
		}
	}

	public void instertion(HttpServletRequest req) throws SQLException {
		String bookN = req.getParameter("bName");
		String type = req.getParameter("genere");
		String author = req.getParameter("author");
		int noBook = Integer.parseInt(req.getParameter("no"));
		String sql = "insert into book (`name`,`type`,`author` ,`noofbooks`) value (?,?,?,?) ";
		pst = con.prepareStatement(sql);
		pst.setString(1, bookN);
		pst.setString(2, type);
		pst.setString(3, author);
		pst.setInt(4, noBook);
		int i = pst.executeUpdate();
		con.close();
	}

	public void insertIssue(HttpServletRequest req, int us2, String us, int num, String dt) throws SQLException {
		String sql = "insert into `issuedbook` (`username`, `book_id`,`noofbooks`,`issueddate`,`type`) values(?,?,?,?,?)";
		pst = con.prepareStatement(sql);
		pst.setString(1, us);
		pst.setInt(2, us2);
		pst.setInt(3, num);
		pst.setString(4, dt);
		pst.setString(5, "Issued");
		int i = pst.executeUpdate();
	}

	public void deletion(HttpServletRequest req, String str, int no)
			throws SQLException {
		String sql = "delete from `" + str + "` where id=?";
		pst = con.prepareStatement(sql);
		pst.setInt(1,no);
		System.out.println(pst);
		int i = pst.executeUpdate();
		con.close();
	}

	public void displayDettails(HttpServletRequest req, PrintWriter pw)
			throws SQLException {
		Statement st = con.createStatement();
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
		String sq = "select book_id,sum(noofbooks) from issuedbook where username='" + us + "' group by book_id";
		pst = con.prepareStatement(sq);
		set1 = pst.executeQuery();
		pw.println("<h1 style=\"margin-bottom: 40px;margin-left:350px;margin-top:180px\" >ISSUEDBOOKS</h1>");
		pw.println(
				"<table class=\"table\" style=\"margin-bottom: 20px\"><thead><tr><th>BOOK NAME</th><th>GENERE</th><th>AUTHOR</th><th>NO. OF BOOKS</th></tr></thead>");
		while (set1.next()) {
			String sql1 = "select `name`,`author`,`type`,`noofbooks` from book where id=" + set1.getString(1);
			j = st.executeQuery(sql1);
			while (j.next()) {
				pw.println("<tr><td>" + j.getString("name") + "</td><td>" + j.getString("type") + "</td><td>"
						+ j.getString("author") + "</td><td>" + set1.getString(2) + "</td></tr>");
			}

		}

	}
}
