package models;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import entities.Feedback;
import entities.Item;



public class FeedbackModel {
	public boolean create(Feedback feedback) {
		boolean result = true ;
		try {
			PreparedStatement preparedStatement = ConnectDB.connection()
					.prepareStatement("insert into feedback(feedback,warehouseItemID,date,typeFeedback,userID) values(?,?,?,?,?)");
			preparedStatement.setString(1, feedback.getFeedback());
			preparedStatement.setString(2, feedback.getWarehouseItemID());
			preparedStatement.setDate(3, new Date(feedback.getDate().getTime()));
			preparedStatement.setString(4, feedback.getTypeFeedback());
			preparedStatement.setString(5, feedback.getUserID());
			result = preparedStatement.executeUpdate() > 0 ;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			result = false;
		}
		return result;
	}
	public List<Feedback> findAll(){
		List<Feedback> feedbacks = new ArrayList<Feedback>();
		try {
			PreparedStatement preparedStatement = ConnectDB.connection().prepareStatement("select * from feedback");
			ResultSet resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				Feedback feedback = new Feedback();
				feedback.setFeedbackID(resultSet.getInt("feedbackID"));
				feedback.setFeedback(resultSet.getString("feedback"));
				feedback.setDate(resultSet.getDate("date"));
				feedback.setTypeFeedback(resultSet.getString("typeFeedback"));
				feedback.setWarehouseItemID(resultSet.getString("warehouseItemID"));
				feedback.setUserID(resultSet.getString("userID"));
				feedbacks.add(feedback);
			}
		} catch (Exception e) {
			e.printStackTrace();
			feedbacks = null;
		} finally {
			ConnectDB.disconnect();
		}
		return feedbacks;
	}
}
