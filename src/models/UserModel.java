package models;

import java.sql.Date;
import java.sql.PreparedStatement;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.mindrot.jbcrypt.BCrypt;

import entities.User;

public class UserModel {
	public User checkUserName(String username) {
		User user = null;
		try {
			
			PreparedStatement preparedStatement = ConnectDB.connection().prepareStatement("select * from user where username = ?");
			preparedStatement.setString(1, username);
			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				user = new User();
				user.setUserID(resultSet.getString("userID"));
				user.setUsername(resultSet.getString("username"));
				user.setRole(resultSet.getInt("role"));
				user.setJoinDate(resultSet.getDate("joinDate"));
				user.setLeaveDate(resultSet.getDate("leaveDate"));
				user.setShift(resultSet.getString("shift"));
				user.setPassword(resultSet.getString("password"));
				
			}
		} catch (Exception e) {
			e.printStackTrace();
			user = null;
		} finally {
			ConnectDB.disconnect();
		}
		return user;
	}
	public User login(String username, String password) {
		
		User user = checkUserName(username);
		if(user.getPassword().equals(password) || BCrypt.checkpw(password, user.getPassword())) {
			return user;
		} 
		return null;
	
	}
	public boolean changePassword(User user) {
		boolean result = true;
		try {
			PreparedStatement preparedStatement = ConnectDB.connection().prepareStatement("update user set password = ? where userID = ?");
			preparedStatement.setString(1, user.getPassword());
			preparedStatement.setString(2, user.getUserID());
			result = preparedStatement.executeUpdate() > 0 ;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			result = false;
		}  finally {
			ConnectDB.disconnect();
		}
		return result;
	}
	public boolean createNewUser(User user) {
		boolean result = true;
		try {
			PreparedStatement preparedStatement = ConnectDB.connection()
					.prepareStatement("insert into user(userID, userName, role, joinDate, leaveDate, shift, password) values(?, ?, ?, ?, ?, ? , ?)");
			preparedStatement.setString(1, user.getUserID());
			preparedStatement.setString(2, user.getUsername());
			preparedStatement.setInt(3, user.getRole());
			preparedStatement.setDate(4, new Date(user.getJoinDate().getTime()));
			preparedStatement.setDate(5, new Date(user.getLeaveDate().getTime()));
			preparedStatement.setString(6, user.getShift());
			preparedStatement.setString(7, user.getPassword());
			result = preparedStatement.executeUpdate() > 0;
		} catch (Exception e) {
			e.printStackTrace();
			result = false;
		} finally {
			ConnectDB.disconnect();
		}
		return result;
	}
//	public List<User> findUserByShift(String shift) {
//		List<User> users = new ArrayList<User>();
//		try {
//			
//			PreparedStatement preparedStatement = ConnectDB.connection().prepareStatement("select * from user where shift = ?");
//			preparedStatement.setString(1, shift);
//			ResultSet resultSet = preparedStatement.executeQuery();
//			while(resultSet.next()) {
//				User user = new User();
//				user.setUserID(resultSet.getString("userID"));
//				user.setUsername(resultSet.getString("username"));
//				user.setRole(resultSet.getInt("role"));
//				user.setJoinDate(resultSet.getDate("joinDate"));
//				user.setLeaveDate(resultSet.getDate("leaveDate"));
//				user.setShift(resultSet.getString("shift"));
//				user.setPassword(resultSet.getString("password"));
//				
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//			users = null;
//		} finally {
//			ConnectDB.disconnect();
//		}
//		return users;
//	}
	public User findUser(String shift) {
		User user = null;
		try {
			
			PreparedStatement preparedStatement = ConnectDB.connection().prepareStatement("select * from user where shift = ?");
			preparedStatement.setString(1, shift);
			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				user = new User();
				user.setUserID(resultSet.getString("userID"));
				user.setUsername(resultSet.getString("username"));
				user.setRole(resultSet.getInt("role"));
				user.setJoinDate(resultSet.getDate("joinDate"));
				user.setLeaveDate(resultSet.getDate("leaveDate"));
				user.setShift(resultSet.getString("shift"));
				user.setPassword(resultSet.getString("password"));
				
			}
		} catch (Exception e) {
			e.printStackTrace();
			user = null;
		} finally {
			ConnectDB.disconnect();
		}
		return user;
	}
}
