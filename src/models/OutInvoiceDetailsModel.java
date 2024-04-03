package models;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import entities.OutInvoiceDetails;

public class OutInvoiceDetailsModel {
	public boolean createInvoice(OutInvoiceDetails outInvoiceDetails) {
		boolean result = true;
		try {
			PreparedStatement preparedStatement = ConnectDB.connection()
					.prepareStatement("insert into outinvoicedetails(itemID, itemName, quantity, price, "
							+ "total, status, payment, created, unit, userID, customerName) values(?, ?,?,?,?,?,?,?,?,?,?)");
			preparedStatement.setString(1, outInvoiceDetails.getItemID());
			preparedStatement.setString(2, outInvoiceDetails.getItemName());
			preparedStatement.setInt(3, outInvoiceDetails.getQuantity());
			preparedStatement.setDouble(4, outInvoiceDetails.getPrice());
			preparedStatement.setDouble(5, outInvoiceDetails.getTotal());
			preparedStatement.setBoolean(6, outInvoiceDetails.isStatus());
			preparedStatement.setString(7, outInvoiceDetails.getPayment());
			preparedStatement.setDate(8, new Date(outInvoiceDetails.getCreated().getTime()));
			preparedStatement.setString(9, outInvoiceDetails.getUnit());
			preparedStatement.setString(10, outInvoiceDetails.getUserID());
			preparedStatement.setString(11, outInvoiceDetails.getCustomerName());
			result = preparedStatement.executeUpdate() > 0;
		} catch (Exception e) {
			e.printStackTrace();
			result = false;
		} finally {
			ConnectDB.disconnect();
		}
		return result;
	}
	public List<OutInvoiceDetails> findAlloutinvoicedetails(){
		List<OutInvoiceDetails> outinvoicedetails= new ArrayList<OutInvoiceDetails>();
		try
		{
			PreparedStatement preparedStatement=ConnectDB.connection().prepareStatement("select * from outInvoiceDetails");
			ResultSet resultSet=preparedStatement.executeQuery();
			while(resultSet.next()) {
				OutInvoiceDetails invoiceDetails=new OutInvoiceDetails();
				invoiceDetails.setCreated(resultSet.getDate("created"));
				invoiceDetails.setCustomerName(resultSet.getString("customerName"));
				invoiceDetails.setItemID(resultSet.getString("itemID"));
				invoiceDetails.setPayment(resultSet.getString("payment"));
				invoiceDetails.setQuantity(resultSet.getInt("quantity"));
				invoiceDetails.setItemName(resultSet.getString("itemName"));
				invoiceDetails.setPrice(resultSet.getDouble("price"));
				invoiceDetails.setStatus(resultSet.getBoolean("status"));
				invoiceDetails.setUnit(resultSet.getString("unit"));
				invoiceDetails.setTotal(resultSet.getDouble("total"));
				invoiceDetails.setOutInvoiceDetailsID(resultSet.getInt("outInvoiceDetailsID"));
				invoiceDetails.setUserID(resultSet.getString("userID"));
				outinvoicedetails.add(invoiceDetails);
				
			}
		}catch(Exception e)
		{
			e.printStackTrace();
			outinvoicedetails=null;
		} finally {
			ConnectDB.disconnect();
		}
		return outinvoicedetails;
	}
	public List<OutInvoiceDetails> findAlloutinvoicedetailsByStatus(boolean status){
		List<OutInvoiceDetails> outinvoicedetails= new ArrayList<OutInvoiceDetails>();
		try
		{
			PreparedStatement preparedStatement=ConnectDB.connection().prepareStatement("select * from outInvoiceDetails where status = ?");
			preparedStatement.setBoolean(1, status);
			ResultSet resultSet=preparedStatement.executeQuery();
			while(resultSet.next()) {
				OutInvoiceDetails invoiceDetails=new OutInvoiceDetails();
				invoiceDetails.setCreated(resultSet.getDate("created"));
				invoiceDetails.setCustomerName(resultSet.getString("customerName"));
				invoiceDetails.setItemID(resultSet.getString("itemID"));
				invoiceDetails.setPayment(resultSet.getString("payment"));
				invoiceDetails.setQuantity(resultSet.getInt("quantity"));
				invoiceDetails.setItemName(resultSet.getString("itemName"));
				invoiceDetails.setPrice(resultSet.getDouble("price"));
				invoiceDetails.setStatus(resultSet.getBoolean("status"));
				invoiceDetails.setUnit(resultSet.getString("unit"));
				invoiceDetails.setTotal(resultSet.getDouble("total"));
				invoiceDetails.setOutInvoiceDetailsID(resultSet.getInt("outInvoiceDetailsID"));
				invoiceDetails.setUserID(resultSet.getString("userID"));
				outinvoicedetails.add(invoiceDetails);
				
			}
		}catch(Exception e)
		{
			e.printStackTrace();
			outinvoicedetails=null;
		} finally {
			ConnectDB.disconnect();
		}
		return outinvoicedetails;
	}
	public boolean updateStatus(OutInvoiceDetails outInvoiceDetails) {
		boolean result = true;
		try
		{
			PreparedStatement preparedStatement=ConnectDB.connection().prepareStatement("update outinvoicedetails set status = ? where outInvoiceDetailsID = ?");
			preparedStatement.setBoolean(1, outInvoiceDetails.isStatus());
			preparedStatement.setInt(2, outInvoiceDetails.getOutInvoiceDetailsID());
			result = preparedStatement.executeUpdate() > 0;
				
			
		}catch(Exception e)
		{
			e.printStackTrace();
			result = false;
		} finally {
			ConnectDB.disconnect();
		}
		return result;
	}
	public OutInvoiceDetails findByID(int id){
		OutInvoiceDetails invoiceDetails = null;
		try
		{
			PreparedStatement preparedStatement=ConnectDB.connection().prepareStatement("select * from outInvoiceDetails where outInvoiceDetailsID = ?");
			preparedStatement.setInt(1, id);
			ResultSet resultSet=preparedStatement.executeQuery();
			while(resultSet.next()) {
				invoiceDetails = new OutInvoiceDetails();
				invoiceDetails.setCreated(resultSet.getDate("created"));
				invoiceDetails.setCustomerName(resultSet.getString("customerName"));
				invoiceDetails.setItemID(resultSet.getString("itemID"));
				invoiceDetails.setPayment(resultSet.getString("payment"));
				invoiceDetails.setQuantity(resultSet.getInt("quantity"));
				invoiceDetails.setItemName(resultSet.getString("itemName"));
				invoiceDetails.setPrice(resultSet.getDouble("price"));
				invoiceDetails.setStatus(resultSet.getBoolean("status"));
				invoiceDetails.setUnit(resultSet.getString("unit"));
				invoiceDetails.setTotal(resultSet.getDouble("total"));
				invoiceDetails.setOutInvoiceDetailsID(resultSet.getInt("outInvoiceDetailsID"));
				invoiceDetails.setUserID(resultSet.getString("userID"));
				
				
			}
		}catch(Exception e)
		{
			e.printStackTrace();
			invoiceDetails=null;
		} finally {
			ConnectDB.disconnect();
		}
		return invoiceDetails;
	}
	public boolean delete(int id) {
		boolean result = true;
		try
		{
			PreparedStatement preparedStatement=ConnectDB.connection().prepareStatement("delete from outinvoicedetails where outInvoiceDetailsID = ?");
			
			preparedStatement.setInt(1, id);
			result = preparedStatement.executeUpdate() > 0;
				
			
		}catch(Exception e)
		{
			e.printStackTrace();
			result = false;
		} finally {
			ConnectDB.disconnect();
		}
		return result;
	}
	public List<OutInvoiceDetails> findByDate(java.util.Date date, boolean status){
		List<OutInvoiceDetails> outinvoicedetails= new ArrayList<OutInvoiceDetails>();
		try
		{
			PreparedStatement preparedStatement=ConnectDB.connection().prepareStatement("select * from outInvoiceDetails where created = ? and status = ?");
			preparedStatement.setDate(1, new Date(date.getTime()));
			preparedStatement.setBoolean(2, status);
			ResultSet resultSet=preparedStatement.executeQuery();
			while(resultSet.next()) {
				OutInvoiceDetails invoiceDetails=new OutInvoiceDetails();
				invoiceDetails.setCreated(resultSet.getDate("created"));
				invoiceDetails.setCustomerName(resultSet.getString("customerName"));
				invoiceDetails.setItemID(resultSet.getString("itemID"));
				invoiceDetails.setPayment(resultSet.getString("payment"));
				invoiceDetails.setQuantity(resultSet.getInt("quantity"));
				invoiceDetails.setItemName(resultSet.getString("itemName"));
				invoiceDetails.setPrice(resultSet.getDouble("price"));
				invoiceDetails.setStatus(resultSet.getBoolean("status"));
				invoiceDetails.setUnit(resultSet.getString("unit"));
				invoiceDetails.setTotal(resultSet.getDouble("total"));
				invoiceDetails.setOutInvoiceDetailsID(resultSet.getInt("outInvoiceDetailsID"));
				invoiceDetails.setUserID(resultSet.getString("userID"));
				outinvoicedetails.add(invoiceDetails);
				
			}
		}catch(Exception e)
		{
			e.printStackTrace();
			outinvoicedetails=null;
		} finally {
			ConnectDB.disconnect();
		}
		return outinvoicedetails;
	}
	public List<OutInvoiceDetails> findByDateAll(java.util.Date date){
		List<OutInvoiceDetails> outinvoicedetails= new ArrayList<OutInvoiceDetails>();
		try
		{
			PreparedStatement preparedStatement=ConnectDB.connection().prepareStatement("select * from outInvoiceDetails where created = ?");
			preparedStatement.setDate(1, new Date(date.getTime()));

			ResultSet resultSet=preparedStatement.executeQuery();
			while(resultSet.next()) {
				OutInvoiceDetails invoiceDetails=new OutInvoiceDetails();
				invoiceDetails.setCreated(resultSet.getDate("created"));
				invoiceDetails.setCustomerName(resultSet.getString("customerName"));
				invoiceDetails.setItemID(resultSet.getString("itemID"));
				invoiceDetails.setPayment(resultSet.getString("payment"));
				invoiceDetails.setQuantity(resultSet.getInt("quantity"));
				invoiceDetails.setItemName(resultSet.getString("itemName"));
				invoiceDetails.setPrice(resultSet.getDouble("price"));
				invoiceDetails.setStatus(resultSet.getBoolean("status"));
				invoiceDetails.setUnit(resultSet.getString("unit"));
				invoiceDetails.setTotal(resultSet.getDouble("total"));
				invoiceDetails.setOutInvoiceDetailsID(resultSet.getInt("outInvoiceDetailsID"));
				invoiceDetails.setUserID(resultSet.getString("userID"));
				outinvoicedetails.add(invoiceDetails);
				
			}
		}catch(Exception e)
		{
			e.printStackTrace();
			outinvoicedetails=null;
		} finally {
			ConnectDB.disconnect();
		}
		return outinvoicedetails;
	}
	public List<OutInvoiceDetails> findByShift(String userID){
		List<OutInvoiceDetails> outinvoicedetails= new ArrayList<OutInvoiceDetails>();
		try
		{
			PreparedStatement preparedStatement=ConnectDB.connection().prepareStatement("select * from outInvoiceDetails where userID = ? and status = true");
			preparedStatement.setString(1, userID);
			ResultSet resultSet=preparedStatement.executeQuery();
			while(resultSet.next()) {
				OutInvoiceDetails invoiceDetails = new OutInvoiceDetails();
				invoiceDetails.setCreated(resultSet.getDate("created"));
				invoiceDetails.setCustomerName(resultSet.getString("customerName"));
				invoiceDetails.setItemID(resultSet.getString("itemID"));
				invoiceDetails.setPayment(resultSet.getString("payment"));
				invoiceDetails.setQuantity(resultSet.getInt("quantity"));
				invoiceDetails.setItemName(resultSet.getString("itemName"));
				invoiceDetails.setPrice(resultSet.getDouble("price"));
				invoiceDetails.setStatus(resultSet.getBoolean("status"));
				invoiceDetails.setUnit(resultSet.getString("unit"));
				invoiceDetails.setTotal(resultSet.getDouble("total"));
				invoiceDetails.setOutInvoiceDetailsID(resultSet.getInt("outInvoiceDetailsID"));
				invoiceDetails.setUserID(resultSet.getString("userID"));
				outinvoicedetails.add(invoiceDetails);
				
			}
		}catch(Exception e)
		{
			e.printStackTrace();
			outinvoicedetails=null;
		} finally {
			ConnectDB.disconnect();
		}
		return outinvoicedetails;
	}
	public List<OutInvoiceDetails> findByShiftAndDate(String userID, java.util.Date date){
		List<OutInvoiceDetails> outinvoicedetails= new ArrayList<OutInvoiceDetails>();
		try
		{
			PreparedStatement preparedStatement=ConnectDB.connection().prepareStatement("select * from outInvoiceDetails where userID = ? and created = ? and status = true");
			preparedStatement.setString(1, userID);
			preparedStatement.setDate(2, new Date(date.getTime()));
			ResultSet resultSet=preparedStatement.executeQuery();
			while(resultSet.next()) {
				OutInvoiceDetails invoiceDetails = new OutInvoiceDetails();
				invoiceDetails.setCreated(resultSet.getDate("created"));
				invoiceDetails.setCustomerName(resultSet.getString("customerName"));
				invoiceDetails.setItemID(resultSet.getString("itemID"));
				invoiceDetails.setPayment(resultSet.getString("payment"));
				invoiceDetails.setQuantity(resultSet.getInt("quantity"));
				invoiceDetails.setItemName(resultSet.getString("itemName"));
				invoiceDetails.setPrice(resultSet.getDouble("price"));
				invoiceDetails.setStatus(resultSet.getBoolean("status"));
				invoiceDetails.setUnit(resultSet.getString("unit"));
				invoiceDetails.setTotal(resultSet.getDouble("total"));
				invoiceDetails.setOutInvoiceDetailsID(resultSet.getInt("outInvoiceDetailsID"));
				invoiceDetails.setUserID(resultSet.getString("userID"));
				outinvoicedetails.add(invoiceDetails);
				
			}
		}catch(Exception e)
		{
			e.printStackTrace();
			outinvoicedetails=null;
		} finally {
			ConnectDB.disconnect();
		}
		return outinvoicedetails;
	}
	public List<OutInvoiceDetails> data(String itemName){
		List<OutInvoiceDetails> outinvoicedetails= new ArrayList<OutInvoiceDetails>();
		try
		{
			PreparedStatement preparedStatement=ConnectDB.connection().prepareStatement("select * from outInvoiceDetails where itemName = ? and "
					+ "status = true");
			preparedStatement.setString(1, itemName);
			
			ResultSet resultSet=preparedStatement.executeQuery();
			while(resultSet.next()) {
				OutInvoiceDetails outinvoicedetail = new OutInvoiceDetails();
				outinvoicedetail.setCreated(resultSet.getDate("created"));
				outinvoicedetail.setCustomerName(resultSet.getString("customerName"));
				outinvoicedetail.setItemID(resultSet.getString("itemID"));
				outinvoicedetail.setPayment(resultSet.getString("payment"));
				outinvoicedetail.setQuantity(resultSet.getInt("quantity"));
				outinvoicedetail.setItemName(resultSet.getString("itemName"));
				outinvoicedetail.setPrice(resultSet.getDouble("price"));
				outinvoicedetail.setStatus(resultSet.getBoolean("status"));
				outinvoicedetail.setUnit(resultSet.getString("unit"));
				outinvoicedetail.setTotal(resultSet.getDouble("total"));
				outinvoicedetail.setOutInvoiceDetailsID(resultSet.getInt("outInvoiceDetailsID"));
				outinvoicedetail.setUserID(resultSet.getString("userID"));
				outinvoicedetails.add(outinvoicedetail);
			}
		}catch(Exception e)
		{
			e.printStackTrace();
			outinvoicedetails=null;
		} finally {
			ConnectDB.disconnect();
		}
		return outinvoicedetails;
	
}
}
