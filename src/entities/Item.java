package entities;

import java.util.Date;

public class Item {
	private String itemID;
	private String itemName;
	private String categoryID;
	private boolean status;
	private int quantityInWarehouse;
	private double price;
	private Date expiredDate;
	private byte[] image;
	private String review;
	private String unit;
	public Item(String itemID, String itemName, String categoryID, boolean status, int quantityInWarehouse,
			double price, Date expiredDate, byte[] image, String review, String unit) {
		super();
		this.itemID = itemID;
		this.itemName = itemName;
		this.categoryID = categoryID;
		this.status = status;
		this.quantityInWarehouse = quantityInWarehouse;
		this.price = price;
		this.expiredDate = expiredDate;
		this.image = image;
		this.review = review;
		this.unit = unit;
	}
	public Item() {
		super();
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
	public String getCategoryID() {
		return categoryID;
	}
	public void setCategoryID(String categoryID) {
		this.categoryID = categoryID;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public int getQuantityInWarehouse() {
		return quantityInWarehouse;
	}
	public void setQuantityInWarehouse(int quantityInWarehouse) {
		this.quantityInWarehouse = quantityInWarehouse;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public Date getExpiredDate() {
		return expiredDate;
	}
	public void setExpiredDate(Date expiredDate) {
		this.expiredDate = expiredDate;
	}
	public byte[] getImage() {
		return image;
	}
	public void setImage(byte[] image) {
		this.image = image;
	}
	public String getReview() {
		return review;
	}
	public void setReview(String review) {
		this.review = review;
	}
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	
	
}
