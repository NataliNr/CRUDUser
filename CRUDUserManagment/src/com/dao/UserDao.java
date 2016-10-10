package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.model.User;
import com.util.DbUtil;

public class UserDao {
	private Connection connection;

	public UserDao() {
		connection = DbUtil.getConnection();
	}

	public void addUser(User user) {
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(
					"insert into users(firstName,lastName,dateOfBirth,phoneNumber,email) values (?, ?, ?, ?, ?)");
			// Parameters start with 1
			preparedStatement.setString(1, user.getFirstName());
			preparedStatement.setString(2, user.getLastName());
			preparedStatement.setString(3, user.getDateOfBirth());
			preparedStatement.setString(4, user.getPhoneNumber());
			preparedStatement.setString(5, user.getEmail());

			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void deleteUser(int userid) {
		try {
			PreparedStatement preparedStatement = connection.prepareStatement("delete from users where userid=?");
			// Parameters start with 1
			preparedStatement.setInt(1, userid);
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void updateUser(User user) {
		try {
			String query = "update users set firstName=?, lastName=?, dateOfBirth=?, phoneNumber=?, email=?"
					+ "where userid=?";
			// Parameters start with 1
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, user.getFirstName());
			preparedStatement.setString(2, user.getLastName());
			preparedStatement.setString(3, user.getDateOfBirth());
			preparedStatement.setString(4, user.getPhoneNumber());
			preparedStatement.setString(5, user.getEmail());
			preparedStatement.setInt(5, user.getUserid());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public List<User> getAllUsers() {
		List<User> users = new ArrayList<User>();
		try {
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("select * from users");
			while (rs.next()) {
				User user = new User();
				user.setUserid(rs.getInt("userid"));
				user.setFirstName(rs.getString("firstName"));
				user.setLastName(rs.getString("lastName"));
				user.setDateOfBirth(rs.getString("DateOfBirth"));
				user.setPhoneNumber(rs.getString("phoneNumber"));
				user.setEmail(rs.getString("email"));
				users.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return users;
	}

	public User getUserById(int userid) {
		User user = new User();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement("select * from users where userid=?");
			preparedStatement.setInt(1, userid);
			ResultSet rs = preparedStatement.executeQuery();

			if (rs.next()) {
				user.setUserid(rs.getInt("userid"));
				user.setFirstName(rs.getString("firstName"));
				user.setLastName(rs.getString("lastName"));
				user.setDateOfBirth(rs.getString("DateOfBirth"));
				user.setPhoneNumber(rs.getString("phoneNumber"));
				user.setEmail(rs.getString("email"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return user;
	}
	
	public List<User> sortLastName() {
		List<User> users = new ArrayList<User>();
		try {
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("select * from users order by lastName" );
			while (rs.next()) {
				User user = new User();
				user.setUserid(rs.getInt("userid"));
				user.setFirstName(rs.getString("firstName"));
				user.setLastName(rs.getString("lastName"));
				user.setDateOfBirth(rs.getString("DateOfBirth"));
				user.setPhoneNumber(rs.getString("phoneNumber"));
				user.setEmail(rs.getString("email"));
				users.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return users;
	}
	public List<User> sortDateOfBirth() {
		List<User> users = new ArrayList<User>();
		try {
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("select * from users order by DateOfBirth" );
			while (rs.next()) {
				User user = new User();
				user.setUserid(rs.getInt("userid"));
				user.setFirstName(rs.getString("firstName"));
				user.setLastName(rs.getString("lastName"));
				user.setDateOfBirth(rs.getString("DateOfBirth"));
				user.setPhoneNumber(rs.getString("phoneNumber"));
				user.setEmail(rs.getString("email"));
				users.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return users;
	}


//	public List<User> searchUser() {
//		List<User> users = new ArrayList<User>();
//		try {
//			Statement statement = connection.createStatement();
//			ResultSet rs = statement.executeQuery("select * from users");
//			while (rs.next()) {
//				User user = new User();
//				user.setUserid(rs.getInt("userid"));
//				user.setFirstName(rs.getString("firstName"));
//				user.setLastName(rs.getString("lastName"));
//				user.setDateOfBirth(rs.getString("DateOfBirth"));
//				user.setPhoneNumber(rs.getString("phoneNumber"));
//				user.setEmail(rs.getString("email"));
//				users.add(user);
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//
//		return users;
//	}
}