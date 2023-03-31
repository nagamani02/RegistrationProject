package com.register.userDao;

import java.sql.DriverManager;

import com.register.User;
import com.register.AddressDao.AddressDao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserDao {

	public int userDetails(User user, int a_id) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Registration_schema", "root",
				"ammanana01");
		Statement st = connection.createStatement();
		ResultSet rs = st.executeQuery("select * from user where email='" + user.getEmail() + "'");
		int count = 0;
		int result = 0;
		while (rs.next()) {
			count++;
		}
		if (count == 0) {

			String userdetails = "insert into user"
					+ "(firstname,middlename, lastname,email,password, phoneno,address_id)values" + "(?,?,?,?,?,?,?);";
			PreparedStatement statement = connection.prepareStatement(userdetails);
			statement.setString(1, user.getFirstname());
			statement.setString(2, user.getMiddlename());
			statement.setString(3, user.getLastname());
			statement.setString(4, user.getEmail());
			statement.setString(5, user.getPassword());
			statement.setString(6, user.getPhoneno());
			statement.setInt(7, a_id);
			result = statement.executeUpdate();
		}
		return result;
	}

}
