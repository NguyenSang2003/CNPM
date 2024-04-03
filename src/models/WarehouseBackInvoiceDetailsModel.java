package models;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import entities.WarehouseBackInvoiceDetails;

public class WarehouseBackInvoiceDetailsModel {
	public boolean create(WarehouseBackInvoiceDetails warehouseBackinvoicedetails) {
		boolean result = true ;
		try {
			PreparedStatement preparedStatement = ConnectDB.connection()
					.prepareStatement("insert into warehousebackinvoicedetails(ID,itemID,quantity,feedback,date,userID) values(?,?,?,?,?,?)");
			preparedStatement.setInt(1, warehouseBackinvoicedetails.getID());
			preparedStatement.setString(2, warehouseBackinvoicedetails.getItemID());
			preparedStatement.setInt(3, warehouseBackinvoicedetails.getQuantity());
			preparedStatement.setString(4, warehouseBackinvoicedetails.getFeedback());
			preparedStatement.setDate(5, new Date(warehouseBackinvoicedetails.getDate().getTime()));
			preparedStatement.setString(6, warehouseBackinvoicedetails.getUserID());
			result = preparedStatement.executeUpdate() > 0 ;
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
			result = false;
		}
		return result;
	}
	public List<WarehouseBackInvoiceDetails> fillAllwarehousebackinvoicedetails(){
		List<WarehouseBackInvoiceDetails>warehouses=new ArrayList<WarehouseBackInvoiceDetails>();
		try
		{
			PreparedStatement preparedStatement=ConnectDB.connection().prepareStatement("select * from warehousebackinvoicedetails");
			ResultSet resultSet=preparedStatement.executeQuery();
			while(resultSet.next()) {
				WarehouseBackInvoiceDetails Warehouse= new WarehouseBackInvoiceDetails();
				Warehouse.setID(resultSet.getInt("ID"));
				Warehouse.setDate(resultSet.getDate("date"));
				Warehouse.setQuantity(resultSet.getInt("quantity"));
				Warehouse.setFeedback(resultSet.getString("feedback"));
				Warehouse.setUserID(resultSet.getString("userID"));
				Warehouse.setItemID(resultSet.getString("itemID"));
				warehouses.add(Warehouse);
			}
		}catch(Exception e)
		{
			e.printStackTrace();
			warehouses = null;
			
		}
		finally {
			ConnectDB.disconnect();
		}
		return warehouses;
}
	public List<WarehouseBackInvoiceDetails> findByDate(java.util.Date date){
		List<WarehouseBackInvoiceDetails>warehouses=new ArrayList<WarehouseBackInvoiceDetails>();
		try
		{
			PreparedStatement preparedStatement=ConnectDB.connection().prepareStatement("select * from warehousebackinvoicedetails where date = ?");
			preparedStatement.setDate(1, new Date(date.getTime()));
			ResultSet resultSet=preparedStatement.executeQuery();
			while(resultSet.next()) {
				WarehouseBackInvoiceDetails Warehouse= new WarehouseBackInvoiceDetails();
				Warehouse.setID(resultSet.getInt("ID"));
				Warehouse.setDate(resultSet.getDate("date"));
				Warehouse.setQuantity(resultSet.getInt("quantity"));
				Warehouse.setFeedback(resultSet.getString("feedback"));
				Warehouse.setUserID(resultSet.getString("userID"));
				Warehouse.setItemID(resultSet.getString("itemID"));
				warehouses.add(Warehouse);
			}
		}catch(Exception e)
		{
			e.printStackTrace();
			warehouses = null;
			
		}
		finally {
			ConnectDB.disconnect();
		}
		return warehouses;
}
	public List<WarehouseBackInvoiceDetails> findByShift(String userID){
		List<WarehouseBackInvoiceDetails>warehouses=new ArrayList<WarehouseBackInvoiceDetails>();
		try
		{
			PreparedStatement preparedStatement=ConnectDB.connection().prepareStatement("select * from warehousebackinvoicedetails where userID = ?");
			preparedStatement.setString(1, userID);
			ResultSet resultSet=preparedStatement.executeQuery();
			while(resultSet.next()) {
				WarehouseBackInvoiceDetails Warehouse= new WarehouseBackInvoiceDetails();
				Warehouse.setID(resultSet.getInt("ID"));
				Warehouse.setDate(resultSet.getDate("date"));
				Warehouse.setQuantity(resultSet.getInt("quantity"));
				Warehouse.setFeedback(resultSet.getString("feedback"));
				Warehouse.setUserID(resultSet.getString("userID"));
				Warehouse.setItemID(resultSet.getString("itemID"));
				warehouses.add(Warehouse);
			}
		}catch(Exception e)
		{
			e.printStackTrace();
			warehouses = null;
			
		}
		finally {
			ConnectDB.disconnect();
		}
		return warehouses;
}
	public List<WarehouseBackInvoiceDetails> findByShiftAndDate(String userID, java.util.Date date){
		List<WarehouseBackInvoiceDetails>warehouses=new ArrayList<WarehouseBackInvoiceDetails>();
		try
		{
			PreparedStatement preparedStatement=ConnectDB.connection().prepareStatement("select * from warehousebackinvoicedetails where userID = ? and date = ?");
			preparedStatement.setString(1, userID);
			preparedStatement.setDate(2, new Date(date.getTime()));
			ResultSet resultSet=preparedStatement.executeQuery();
			while(resultSet.next()) {
				WarehouseBackInvoiceDetails Warehouse= new WarehouseBackInvoiceDetails();
				Warehouse.setID(resultSet.getInt("ID"));
				Warehouse.setDate(resultSet.getDate("date"));
				Warehouse.setQuantity(resultSet.getInt("quantity"));
				Warehouse.setFeedback(resultSet.getString("feedback"));
				Warehouse.setUserID(resultSet.getString("userID"));
				Warehouse.setItemID(resultSet.getString("itemID"));
				warehouses.add(Warehouse);
			}
		}catch(Exception e)
		{
			e.printStackTrace();
			warehouses = null;
			
		}
		finally {
			ConnectDB.disconnect();
		}
		return warehouses;
}
}
