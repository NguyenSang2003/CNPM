package entities;

import java.util.Date;

public class OutInvoiceDetails {
	private int outInvoiceDetailsID;
	private String itemID;
	private String itemName;
	private int quantity;
	private double price;
	private double total;
	private boolean status;
	private String payment;
	private Date created;
	private String unit;
	private String userID;
	private String customerName;
	public int getOutInvoiceDetailsID() {
		return outInvoiceDetailsID;
	}
	public void setOutInvoiceDetailsID(int outInvoiceDetailsID) {
		this.outInvoiceDetailsID = outInvoiceDetailsID;
	}
	public String getItemID() {
		return itemID;
	}
	public void setItemID(String itemID) {
		this.itemID = itemID;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
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
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public String getPayment() {
		return payment;
	}
	public void setPayment(String payment) {
		this.payment = payment;
	}
	public Date getCreated() {
		return created;
	}
	public void setCreated(Date created) {
		this.created = created;
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
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public OutInvoiceDetails(int outInvoiceDetailsID, String itemID, String itemName, int quantity, double price,
			double total, boolean status, String payment, Date created, String unit, String userID,
			String customerName) {
		super();
		this.outInvoiceDetailsID = outInvoiceDetailsID;
		this.itemID = itemID;
		this.itemName = itemName;
		this.quantity = quantity;
		this.price = price;
		this.total = total;
		this.status = status;
		this.payment = payment;
		this.created = created;
		this.unit = unit;
		this.userID = userID;
		this.customerName = customerName;
	}
	public OutInvoiceDetails() {
		super();
	}
	
}
