package nhanvienbanhang;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import entities.Feedback;
import entities.Item;
import entities.User;
import models.FeedbackModel;

import java.awt.BorderLayout;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.util.Map;
import java.awt.FlowLayout;
import javax.swing.JTextField;
import com.toedter.calendar.JDateChooser;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class JFrameFeedBack extends JFrame {

	private JPanel contentPane;
	private JTextField jtextFieldUserID;
	private JTextField jtextFieldItemID;
	private Map<String, Object> data;
	private JTextField jtextfieldFeedback;
	private JTextField jtextfieldRequest;
	private JDateChooser jdateChooser;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFrameFeedBack frame = new JFrameFeedBack();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public JFrameFeedBack() {
		setTitle("Feedback");
		setBounds(100, 100, 504, 356);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));
		
		JPanel panel = new JPanel();
		contentPane.add(panel);
		
		JLabel lblNewLabel = new JLabel("Feedback ");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1);
		panel_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblNewLabel_1 = new JLabel("UserID: ");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		panel_1.add(lblNewLabel_1);
		
		jtextFieldUserID = new JTextField();
		jtextFieldUserID.setEditable(false);
		jtextFieldUserID.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		panel_1.add(jtextFieldUserID);
		jtextFieldUserID.setColumns(10);
		
		JPanel panel_2 = new JPanel();
		contentPane.add(panel_2);
		panel_2.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblNewLabel_1_1 = new JLabel("ItemID: ");
		lblNewLabel_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		panel_2.add(lblNewLabel_1_1);
		
		jtextFieldItemID = new JTextField();
		jtextFieldItemID.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		jtextFieldItemID.setEditable(false);
		jtextFieldItemID.setColumns(10);
		panel_2.add(jtextFieldItemID);
		
		JPanel panel_3 = new JPanel();
		contentPane.add(panel_3);
		panel_3.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Feedback:");
		lblNewLabel_1_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		panel_3.add(lblNewLabel_1_1_1);
		
		jtextfieldFeedback = new JTextField();
		jtextfieldFeedback.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		jtextfieldFeedback.setColumns(10);
		panel_3.add(jtextfieldFeedback);
		
		JPanel panel_4 = new JPanel();
		contentPane.add(panel_4);
		panel_4.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("Request:");
		lblNewLabel_1_1_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		panel_4.add(lblNewLabel_1_1_1_1);
		
		jtextfieldRequest = new JTextField();
		jtextfieldRequest.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		jtextfieldRequest.setColumns(10);
		panel_4.add(jtextfieldRequest);
		
		JPanel panel_5 = new JPanel();
		contentPane.add(panel_5);
		panel_5.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblNewLabel_1_1_1_1_1 = new JLabel("Date:");
		lblNewLabel_1_1_1_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		panel_5.add(lblNewLabel_1_1_1_1_1);
		
		jdateChooser = new JDateChooser();
		panel_5.add(jdateChooser);
		
		JPanel panel_6 = new JPanel();
		contentPane.add(panel_6);
		
		JButton jbuttonSend = new JButton("Send");
		jbuttonSend.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jbuttonSend_actionPerformed(e);
			}
		});
		jbuttonSend.setFont(new Font("Times New Roman", Font.BOLD, 15));
		panel_6.add(jbuttonSend);
	}
	public JFrameFeedBack(Map<String, Object> data) {
		this();
		this.data = data;
		initJFrame();
	}
	public void initJFrame() {
		User user = (User) data.get("user");
		Item item = (Item) data.get("item");
		jtextFieldUserID.setText(user.getUserID());
		jtextFieldItemID.setText(item.getItemID());
		
		FeedbackModel feedbackModel = new FeedbackModel();
		Feedback feedback = new Feedback();
		feedback.setFeedback(jtextfieldFeedback.getText());
		feedback.setDate(jdateChooser.getDate());
		feedback.setTypeFeedback(jtextfieldRequest.getText());
		feedbackModel.create(feedback);
	}
	public void jbuttonSend_actionPerformed(ActionEvent e) {
		FeedbackModel feedbackModel = new FeedbackModel();
		Feedback feedback = new Feedback();
		feedback.setUserID(jtextFieldUserID.getText());
		feedback.setFeedback(jtextfieldFeedback.getText());
		feedback.setDate(jdateChooser.getDate());
		feedback.setTypeFeedback(jtextfieldRequest.getText());
		feedback.setWarehouseItemID(jtextFieldItemID.getText());
		
		if (feedbackModel.create(feedback)) {
			JOptionPane.showMessageDialog(this, "send success");
			this.setVisible(false);
		} else {
			JOptionPane.showMessageDialog(this, "send failed");
		}
	}

}
