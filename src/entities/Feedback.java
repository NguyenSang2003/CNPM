package entities;

import java.util.Date;

public class Feedback {
	private int feedbackID;
	private String feedback;
	private String warehouseItemID;
	private Date date;
	private String typeFeedback;
	private String userID;
	public Feedback(int feedbackID, String feedback, String warehouseItemID, Date date, String typeFeedback,
			String userID) {
		super();
		this.feedbackID = feedbackID;
		this.feedback = feedback;
		this.warehouseItemID = warehouseItemID;
		this.date = date;
		this.typeFeedback = typeFeedback;
		this.userID = userID;
	}
	public Feedback() {
		super();
	}
	public int getFeedbackID() {
		return feedbackID;
	}
	public void setFeedbackID(int feedbackID) {
		this.feedbackID = feedbackID;
	}
	public String getFeedback() {
		return feedback;
	}
	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}
	public String getWarehouseItemID() {
		return warehouseItemID;
	}
	public void setWarehouseItemID(String warehouseItemID) {
		this.warehouseItemID = warehouseItemID;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getTypeFeedback() {
		return typeFeedback;
	}
	public void setTypeFeedback(String typeFeedback) {
		this.typeFeedback = typeFeedback;
	}
	public String getUserID() {
		return userID;
	}
	public void setUserID(String userID) {
		this.userID = userID;
	}
	
}
