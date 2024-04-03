package entities;

import java.util.Date;

public class User {
	private String userID;
	private String username;
	private int role;
	private Date joinDate;
	private Date leaveDate;
	private String shift;
	private String password;
	public String getUserID() {
		return userID;
	}
	public void setUserID(String userID) {
		this.userID = userID;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public int getRole() {
		return role;
	}
	public void setRole(int role) {
		this.role = role;
	}
	public Date getJoinDate() {
		return joinDate;
	}
	public void setJoinDate(Date joinDate) {
		this.joinDate = joinDate;
	}
	public Date getLeaveDate() {
		return leaveDate;
	}
	public void setLeaveDate(Date leaveDate) {
		this.leaveDate = leaveDate;
	}
	public String getShift() {
		return shift;
	}
	public void setShift(String shift) {
		this.shift = shift;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public User(String userID, String username, int role, Date joinDate, Date leaveDate, String shift,
			String password) {
		super();
		this.userID = userID;
		this.username = username;
		this.role = role;
		this.joinDate = joinDate;
		this.leaveDate = leaveDate;
		this.shift = shift;
		this.password = password;
	}
	public User() {
		super();
	}
	
}
