package entities;

import java.util.Date;

public class WarehouseInInvoiceDetails {
	private int ID;
	private String itemID;
	private int quantity;
	private double price;
	private double total;
	private Date dateIn;
	private String manufactureID;
	private String unit;
	private String userID;
	private boolean status;
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
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	public Date getDateIn() {
		return dateIn;
	}
	public void setDateIn(Date dateIn) {
		this.dateIn = dateIn;
	}
	public String getManufactureID() {
		return manufactureID;
	}
	public void setManufactureID(String manufactureID) {
		this.manufactureID = manufactureID;
	}
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	public String getUserID() {
		return userID;
	}
	public void setUserID(String userID) {
		this.userID = userID;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public WarehouseInInvoiceDetails(int iD, String itemID, int quantity, double price, double total, Date dateIn,
			String manufactureID, String unit, String userID, boolean status) {
		super();
		ID = iD;
		this.itemID = itemID;
		this.quantity = quantity;
		this.price = price;
		this.total = total;
		this.dateIn = dateIn;
		this.manufactureID = manufactureID;
		this.unit = unit;
		this.userID = userID;
		this.status = status;
	}
	public WarehouseInInvoiceDetails() {
		super();
	}
	
}
