package entities;

import java.util.Date;

public class WarehouseBackInvoiceDetails {
	private int ID;
	private String itemID;
	private int quantity;
	private String feedback;
	private Date date;
	private String userID;
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getItemID() {
		return itemID;
	}
	public void setItemID(String itemID) {
		this.itemID = itemID;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getFeedback() {
		return feedback;
	}
	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getUserID() {
		return userID;
	}
	public void setUserID(String userID) {
		this.userID = userID;
	}
	public WarehouseBackInvoiceDetails(int iD, String itemID, int quantity, String feedback, Date date, String userID) {
		super();
		ID = iD;
		this.itemID = itemID;
		this.quantity = quantity;
		this.feedback = feedback;
		this.date = date;
		this.userID = userID;
	}
	public WarehouseBackInvoiceDetails() {
		super();
	}
	
}
