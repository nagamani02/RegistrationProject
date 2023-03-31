package com.register.AddressDao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.register.Address;

public class AddressDao {

	public int addressDetalis(Address address) throws ClassNotFoundException, SQLException {
		int address_id = 0;

		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Registration_schema", "root",
				"ammanana01");

		int count = 0;
		Statement st = connection.createStatement();
		ResultSet rs = st.executeQuery("select * from address where addressline1 ='" + address.getAddressline1()
				+ "'and addressline2='" + address.getAddressline2() + "'and zipcode='" + address.getZipcode() + "'");
		
		while (rs.next()) {
			count++;
			address_id = rs.getInt("address_id");
		}

		if (count == 0) {
			String addressdetails = "insert into address" + "(addressline1, addressline2,city,state,zipcode)values"
					+ "(?,?,?,?,?);";
			PreparedStatement statement = connection.prepareStatement(addressdetails, Statement.RETURN_GENERATED_KEYS);
			statement.setString(1, address.getAddressline1());
			statement.setString(2, address.getAddressline2());
			statement.setString(3, address.getCity());
			statement.setString(4, address.getState());
			statement.setString(5, address.getZipcode());

			int output = statement.executeUpdate();
			if (output == 1) {
				ResultSet res = statement.getGeneratedKeys();
				while (res.next()) {
					address_id = res.getInt(1);
				}
			}
		}
		return address_id;
	}
}