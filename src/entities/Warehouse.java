package entities;

import java.util.Date;

public class Warehouse {
	private int ID;
	private String itemID;
	private String itemName;
	private Date dateAdded;
	private boolean status;
	private int totalInventory;
	public Warehouse(int iD, String itemID, String itemName, Date dateAdded, boolean status, int totalInventory) {
		super();
		ID = iD;
		this.itemID = itemID;
		this.itemName = itemName;
		this.dateAdded = dateAdded;
		this.status = status;
		this.totalInventory = totalInventory;
	}
	public Warehouse() {
		super();
	}
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
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public Date getDateAdded() {
		return dateAdded;
	}
	public void setDateAdded(Date dateAdded) {
		this.dateAdded = dateAdded;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public int getTotalInventory() {
		return totalInventory;
	}
	public void setTotalInventory(int totalInventory) {
		this.totalInventory = totalInventory;
	}
	
	
	
}
