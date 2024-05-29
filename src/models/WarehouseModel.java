package models;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import entities.OutInvoiceDetails;
import entities.Warehouse;

//Class này sẽ kết nối với csdl và lấy dữ liệu lên
public class WarehouseModel {
	// Phương thức tìm và trả về danh sách tất cả các kho hàng
	public List<Warehouse> findAll(){
		List<Warehouse> warehouses = new ArrayList<Warehouse>();
		try {
            // Kết nối và thực hiện truy vấn lấy tất cả các kho hàng từ cơ sở dữ liệu
			PreparedStatement preparedStatement = ConnectDB.connection().prepareStatement("select * from warehouse");
			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				Warehouse warehouse = new Warehouse();
				warehouse.setID(resultSet.getInt("ID"));
				warehouse.setItemID(resultSet.getString("itemID"));
				warehouse.setItemName(resultSet.getString("itemName"));
				warehouse.setDateAdded(resultSet.getDate("dateAdded"));
				warehouse.setStatus(resultSet.getBoolean("status"));
				warehouse.setTotalInventory(resultSet.getInt("totalInventory"));
				warehouses.add(warehouse);
			}
		} catch (Exception e) {
			e.printStackTrace();
			warehouses = null;
		} finally {
			ConnectDB.disconnect();
		}
		return warehouses;
	}
	
    // Phương thức cập nhật tổng số lượng tồn kho của một kho hàng cụ thể
	public boolean updateTotalInventory(Warehouse warehouse) {
		boolean result = true;
		try
		{
			PreparedStatement preparedStatement=ConnectDB.connection().prepareStatement("update warehouse set totalInventory = ? where ID = ?");
			preparedStatement.setInt(1, warehouse.getTotalInventory());
			preparedStatement.setInt(2, warehouse.getID());
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
	
    // Phương thức tìm một kho hàng dựa trên mã mặt hàng
	public Warehouse findByItemID(String itemID){
		Warehouse warehouse = null;
		try {
			PreparedStatement preparedStatement = ConnectDB.connection().prepareStatement("select * from warehouse where itemID = ?");
			preparedStatement.setString(1, itemID);
			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				warehouse = new Warehouse();
				warehouse.setID(resultSet.getInt("ID"));
				warehouse.setItemID(resultSet.getString("itemID"));
				warehouse.setItemName(resultSet.getString("itemName"));
				warehouse.setDateAdded(resultSet.getDate("dateAdded"));
				warehouse.setStatus(resultSet.getBoolean("status"));
				warehouse.setTotalInventory(resultSet.getInt("totalInventory"));
			
			}
		} catch (Exception e) {
			e.printStackTrace();
			warehouse = null;
		} finally {
			ConnectDB.disconnect();
		}
		return warehouse;
	}
	
    // Phương thức tạo một kho hàng mới
	public boolean create(Warehouse warehouse) {
		boolean result = true;
		try {
			PreparedStatement preparedStatement = ConnectDB.connection().prepareStatement("insert into warehouse(itemID, itemName, dateAdded, status, totalInventory)"
					+ " value(?, ?, ?, ?, ?)");
			preparedStatement.setString(1, warehouse.getItemID());
			preparedStatement.setString(2, warehouse.getItemName());
			preparedStatement.setDate(3, new Date(warehouse.getDateAdded().getTime()));
			preparedStatement.setBoolean(4, warehouse.isStatus());
			preparedStatement.setInt(5, warehouse.getTotalInventory());
			result = preparedStatement.executeUpdate() > 0 ;
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			result = false;
		}  finally {
			ConnectDB.disconnect();
		}
		return result;
	}
	
    // Phương thức tìm các kho hàng theo danh mục
	public List<Warehouse> inventory(String category){
		List<Warehouse> warehouses = new ArrayList<Warehouse>();
		try {
			PreparedStatement preparedStatement = ConnectDB.connection().prepareStatement("SELECT warehouse.ID, warehouse.itemID, warehouse.itemName, warehouse.dateAdded, warehouse.status, warehouse.totalInventory from item, warehouse, category where "
					+ "category.categoryID = item.categoryID and item.itemID = warehouse.itemID and "
					+ "category.categoryName = ?");
			preparedStatement.setString(1, category);
			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				Warehouse warehouse = new Warehouse();
				warehouse.setID(resultSet.getInt("warehouse.ID"));
				warehouse.setItemID(resultSet.getString("warehouse.itemID"));
				warehouse.setItemName(resultSet.getString("warehouse.itemName"));
				warehouse.setDateAdded(resultSet.getDate("warehouse.dateAdded"));
				warehouse.setStatus(resultSet.getBoolean("warehouse.status"));
				warehouse.setTotalInventory(resultSet.getInt("warehouse.totalInventory"));
				warehouses.add(warehouse);
			}
		} catch (Exception e) {
			e.printStackTrace();
			warehouses = null;
		} finally {
			ConnectDB.disconnect();
		}
		return warehouses;
	}
	
    // Phương thức tìm các kho hàng có tổng số lượng tồn kho nhỏ hơn một giá trị nhất định
	public List<Warehouse> totalInventory(int totalInventory){
		List<Warehouse> warehouses = new ArrayList<Warehouse>();
		try {
			PreparedStatement preparedStatement = ConnectDB.connection().prepareStatement("select * from warehouse where totalInventory < ?");
			preparedStatement.setInt(1, totalInventory);
			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				Warehouse warehouse = new Warehouse();
				warehouse.setID(resultSet.getInt("ID"));
				warehouse.setItemID(resultSet.getString("itemID"));
				warehouse.setItemName(resultSet.getString("itemName"));
				warehouse.setDateAdded(resultSet.getDate("dateAdded"));
				warehouse.setStatus(resultSet.getBoolean("status"));
				warehouse.setTotalInventory(resultSet.getInt("totalInventory"));
				warehouses.add(warehouse);
			}
		} catch (Exception e) {
			e.printStackTrace();
			warehouses = null;
		} finally {
			ConnectDB.disconnect();
		}
		return warehouses;
	}
}
