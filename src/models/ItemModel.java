package models;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import entities.Item;

public class ItemModel {
	public List<Item> findAll(){
		List<Item> items = new ArrayList<Item>();
		try {
			PreparedStatement preparedStatement = ConnectDB.connection().prepareStatement("select * from item");
			ResultSet resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				Item item = new Item();
				item.setItemID(resultSet.getString("itemID"));
				item.setItemName(resultSet.getString("itemName"));
				item.setCategoryID(resultSet.getString("categoryID"));;
				item.setStatus(resultSet.getBoolean("status"));
				item.setPrice(resultSet.getDouble("price"));
				item.setExpiredDate(resultSet.getDate("expiredDate"));
				item.setImage(resultSet.getBytes("image"));
				item.setReview(resultSet.getString("review"));
				item.setUnit(resultSet.getString("unit"));
				items.add(item);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			items = null;
		} finally {
			ConnectDB.disconnect();
		}
		return items;
	}
	public List<Item> searchByKeyword(String keyword){
		List<Item> items = new ArrayList<Item>();
		try {
			PreparedStatement preparedStatement = ConnectDB.connection().prepareStatement("select * from item where itemName like ?");
			preparedStatement.setString(1, "%" + keyword + "%");
			ResultSet resultSet = preparedStatement.executeQuery();
			
			
			while(resultSet.next()) {
				Item item = new Item();
				item.setItemID(resultSet.getString("itemID"));
				item.setItemName(resultSet.getString("itemName"));
				item.setCategoryID(resultSet.getString("categoryID"));;
				item.setStatus(resultSet.getBoolean("status"));
				item.setPrice(resultSet.getDouble("price"));
				item.setExpiredDate(resultSet.getDate("expiredDate"));
				item.setImage(resultSet.getBytes("image"));
				item.setReview(resultSet.getString("review"));
				item.setUnit(resultSet.getString("unit"));
				items.add(item);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			items = null;
		} finally {
			ConnectDB.disconnect();
		}
		return items;
	}
	public Item findItem(String itemID){
		Item item = null;
		try {
			PreparedStatement preparedStatement = ConnectDB.connection().prepareStatement("select * from item where itemID = ?");
			preparedStatement.setString(1, itemID);
			ResultSet resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				item = new Item();
				item.setItemID(resultSet.getString("itemID"));
				item.setItemName(resultSet.getString("itemName"));
				item.setCategoryID(resultSet.getString("categoryID"));;
				item.setStatus(resultSet.getBoolean("status"));
				item.setPrice(resultSet.getDouble("price"));
				item.setExpiredDate(resultSet.getDate("expiredDate"));
				item.setImage(resultSet.getBytes("image"));
				item.setReview(resultSet.getString("review"));
				item.setUnit(resultSet.getString("unit"));
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			item = null;
		} finally {
			ConnectDB.disconnect();
		}
		return item;
	}
	public boolean create(Item item) {
		boolean result = true ;
		try {
			PreparedStatement preparedStatement = ConnectDB.connection()
					.prepareStatement("insert into item(itemID,itemName,categoryID,status,price,expiredDate,image,review,unit) values(?,?,?,?,?,?,?,?,?)");
			preparedStatement.setString(1, item.getItemID());
			preparedStatement.setString(2, item.getItemName());
			preparedStatement.setString(3, item.getCategoryID());
			preparedStatement.setBoolean(4, item.isStatus());
			preparedStatement.setDouble(5, item.getPrice());
			preparedStatement.setDate(6, new Date(item.getExpiredDate().getTime()));
			preparedStatement.setBytes(7, item.getImage());
			preparedStatement.setString(8, item.getReview());
			preparedStatement.setString(9, item.getUnit());
			result = preparedStatement.executeUpdate() > 0 ;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			result = false;
		}
		return result;
	}
	public boolean update(Item item) {
		boolean result = true;
		try {
			PreparedStatement preparedStatement = ConnectDB.connection().prepareStatement("update item set price = ? where itemID = ?");
			preparedStatement.setDouble(1, item.getPrice());
			preparedStatement.setString(2, item.getItemID());
			result = preparedStatement.executeUpdate() > 0;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			result = false;
		} finally {
			ConnectDB.disconnect();
		}
		return result;
	}
}
