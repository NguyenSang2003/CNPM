package models;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import entities.Category;

public class CategoryModel {
	public List<Category> findAll(){
		List<Category> categories = new ArrayList<Category>();
		try {
			PreparedStatement preparedStatement = ConnectDB.connection().prepareStatement("select * from category");
			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				Category category = new Category();
				category.setCategoryID(resultSet.getString("categoryID"));
				category.setCategoryName(resultSet.getString("categoryName")); 	
				categories.add(category);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			categories = null;
		} finally {
			ConnectDB.disconnect();
		}
		return categories;
	}
	public boolean create(Category category) {
		boolean result = true;
		try {
			PreparedStatement preparedStatement = ConnectDB.connection()
					.prepareStatement("insert into category(categoryID, categoryName) values(?, ?)");
			preparedStatement.setString(1, category.getCategoryID());
			preparedStatement.setString(2, category.getCategoryName());
			//photo kieu byte
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
