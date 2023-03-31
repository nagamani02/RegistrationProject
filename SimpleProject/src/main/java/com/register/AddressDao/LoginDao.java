package com.register.AddressDao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.register.User;

public class LoginDao {

	public User logindetails(User front_enduser) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Registration_schema", "root",
				"ammanana01");
		Statement st = connection.createStatement();
		ResultSet rs = st.executeQuery("select * from user where email='" + front_enduser.getEmail() + "'");
		User db_user=null;
		while (rs.next()) {
			db_user = new User();
			db_user.setEmail(rs.getString("email"));
			db_user.setPassword(rs.getString("password"));
			db_user.setFirstname(rs.getString("firstname"));
			db_user.setLastname(rs.getString("lastname"));
			//System.out.println("email "+rs.getString("email"));
			//System.out.println("password "+rs.getString("password"));
			//System.out.println("firstname "+rs.getString("firstname"));
		}
		return db_user;

	}

}
