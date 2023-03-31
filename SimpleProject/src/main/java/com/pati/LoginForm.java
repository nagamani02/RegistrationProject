package com.pati;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import com.register.User;
import com.register.AddressDao.AddressDao;
import com.register.AddressDao.LoginDao;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.ServletRequest;

@WebServlet("/LoginForm")
public class LoginForm extends HttpServlet {
	private LoginDao loginDao;

	public void init() {
		loginDao = new LoginDao();
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html");
		PrintWriter out = res.getWriter();
		{
			String email = req.getParameter("email");
			String password = req.getParameter("password");

			User front_enduser = new User();
			front_enduser.setEmail(email);
			front_enduser.setPassword(password);
			try {
				User db_user = loginDao.logindetails(front_enduser);

				if (db_user != null) {
					if (email.equals(db_user.getEmail()) && password.equals(db_user.getPassword())) {
						RequestDispatcher rd = req.getRequestDispatcher("Profile.jsp");
						rd.include(req, res);
						req.setAttribute("firstname", db_user.getFirstname());
						req.setAttribute("lastname", db_user.getLastname());
						req.getRequestDispatcher("Profile.jsp").forward(req, res);
					} else {
						out.println("Sorry username or password error");
						RequestDispatcher rd = req.getRequestDispatcher("Login.jsp");
						rd.include(req, res);
					}
				} else {
					out.println("Email doesn't exist!....Register First");
					RequestDispatcher rd = req.getRequestDispatcher("Registration.jsp");
					rd.include(req, res);
				}

			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}
}