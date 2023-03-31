package com.pati;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.RequestDispatcher;
import java.io.PrintWriter;
import java.sql.SQLException;

import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.ServletException;
import java.io.IOException;
import jakarta.servlet.annotation.WebServlet;
import com.register.User;
import com.register.Address;
import com.register.userDao.UserDao;
import com.register.AddressDao.AddressDao;


@WebServlet("/RegistrationForm")
public class RegistrationForm extends HttpServlet {
	private UserDao userDao;
	private AddressDao addressDao;
	
	public void init() {
		addressDao=new AddressDao();
	    userDao=new UserDao();	
	 
	}
	public void doPost(HttpServletRequest req, HttpServletResponse res)throws ServletException, 
	IOException  {
		res.setContentType("text/html");
		PrintWriter out=res.getWriter();
		String firstname=req.getParameter("firstname");
		String middlename=req.getParameter("middlename");
		String lastname=req.getParameter("lastname");
		String email=req.getParameter("email");
		String password=req.getParameter("password");
		String addressline1=req.getParameter("address line1");
		String addressline2=req.getParameter("address line2");
		String phoneno=req.getParameter("phoneno");
		String city=req.getParameter("city");
		String state=req.getParameter("state");
		String zipcode=req.getParameter("zipcode");
		
		Address address=new Address();
		address.setAddressline1(addressline1);
		address.setAddressline2(addressline2);
		address.setCity(city);
		address.setState(state);
		address.setZipcode(zipcode);
		 
		User user=new User();
		user.setFirstname(firstname);
		user.setMiddlename(middlename);
		user.setLastname(lastname);
		user.setEmail(email);
		user.setPassword(password);
		user.setPhoneno(phoneno);
		user.setAddress(address);
		
		
		try {
			int a_id = addressDao.addressDetalis(address);
			if(a_id != 0) {
				int user_result = userDao.userDetails(user, a_id);
				if(user_result == 1) {
					out.println("registered succefully");
					RequestDispatcher rd=req.getRequestDispatcher("Login.jsp");
					rd.include(req,res);
				} else {
					out.println("Email already exist");
					RequestDispatcher rd=req.getRequestDispatcher("Registration.jsp");
					rd.include(req,res);
				}
			}
			
		} catch (ClassNotFoundException | SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			RequestDispatcher rd=req.getRequestDispatcher("error.jsp");
			rd.include(req,res);
		}
	
		
			
		
		
	}

}
