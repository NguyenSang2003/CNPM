package models;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


import entities.WarehouseInInvoiceDetails;

public class WarehouseInInvoiceDetailsModel {
	public List<WarehouseInInvoiceDetails> warehouseInInvoiceDetails(){
		List<WarehouseInInvoiceDetails>warehouses=new ArrayList<WarehouseInInvoiceDetails>();
		try
		{
			PreparedStatement preparedStatement=ConnectDB.connection().prepareStatement("select * from warehouseInInvoiceDetails");
			ResultSet resultSet=preparedStatement.executeQuery();
			while(resultSet.next()) {
				WarehouseInInvoiceDetails Warehouse=new WarehouseInInvoiceDetails();
				Warehouse.setID(resultSet.getInt("ID"));
				Warehouse.setDateIn(resultSet.getDate("dateIn"));
				Warehouse.setItemID(resultSet.getString("itemID"));
				Warehouse.setManufactureID(resultSet.getString("manufactureID"));
				Warehouse.setPrice(resultSet.getDouble("price"));
				Warehouse.setQuantity(resultSet.getInt("quantity"));
				Warehouse.setStatus(resultSet.getBoolean("status"));
				Warehouse.setTotal(resultSet.getDouble("total"));
				Warehouse.setUnit(resultSet.getString("unit"));
				Warehouse.setUserID(resultSet.getString("userID"));
				warehouses.add(Warehouse);
			}
		}catch(Exception e)
		{
			e.printStackTrace();
			warehouses=null;
			
		}
		finally {
			ConnectDB.disconnect();
		}
		return warehouses;
	}
	public List<WarehouseInInvoiceDetails> findByDate(Date date){
		List<WarehouseInInvoiceDetails>warehouses=new ArrayList<WarehouseInInvoiceDetails>();
		try
		{
			PreparedStatement preparedStatement=ConnectDB.connection().prepareStatement("select * from warehouseInInvoiceDetails where dateIn = ?");
			preparedStatement.setDate(1, new java.sql.Date(date.getTime()));
			ResultSet resultSet=preparedStatement.executeQuery();
			while(resultSet.next()) {
				WarehouseInInvoiceDetails Warehouse=new WarehouseInInvoiceDetails();
				Warehouse.setID(resultSet.getInt("ID"));
				Warehouse.setDateIn(resultSet.getDate("dateIn"));
				Warehouse.setItemID(resultSet.getString("itemID"));
				Warehouse.setManufactureID(resultSet.getString("manufactureID"));
				Warehouse.setPrice(resultSet.getDouble("price"));
				Warehouse.setQuantity(resultSet.getInt("quantity"));
				Warehouse.setStatus(resultSet.getBoolean("status"));
				Warehouse.setTotal(resultSet.getDouble("total"));
				Warehouse.setUnit(resultSet.getString("unit"));
				Warehouse.setUserID(resultSet.getString("userID"));
				warehouses.add(Warehouse);
			}
		}catch(Exception e)
		{
			e.printStackTrace();
			warehouses=null;
			
		}
		finally {
			ConnectDB.disconnect();
		}
		return warehouses;
	}
	public boolean create(WarehouseInInvoiceDetails warehouseInInvoiceDetails)
	{
		boolean result=true;
		try
		{
			PreparedStatement preparedStatement=ConnectDB.connection().prepareStatement("insert into warehouseininvoiceDetails (itemID,quantity,price,total,dateIn,manufactureID,unit,userID,status) values(?,?,?,?,?,?,?,?,?)");
			preparedStatement.setString(1,warehouseInInvoiceDetails.getItemID());
			preparedStatement.setInt(2, warehouseInInvoiceDetails.getQuantity());
			preparedStatement.setDouble(3, warehouseInInvoiceDetails.getPrice());
			preparedStatement.setDouble(4,warehouseInInvoiceDetails.getTotal());
			preparedStatement.setDate(5, new java.sql.Date(warehouseInInvoiceDetails.getDateIn().getTime()));
			preparedStatement.setString(6, warehouseInInvoiceDetails.getManufactureID());
			preparedStatement.setString(7, warehouseInInvoiceDetails.getUnit());
			preparedStatement.setString(8, warehouseInInvoiceDetails.getUserID());
			preparedStatement.setBoolean(9, warehouseInInvoiceDetails.isStatus());
			result=preparedStatement.executeUpdate()>0;
		}catch(Exception e)
		{
			result=false;
			e.printStackTrace();
		}
		finally
		{
			ConnectDB.disconnect();
		}
		return result;
	}
}
