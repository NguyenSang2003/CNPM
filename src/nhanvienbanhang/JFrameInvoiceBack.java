package nhanvienbanhang;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import java.awt.Font;
import java.util.Map;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import com.toedter.calendar.JDateChooser;

import entities.OutInvoiceDetails;
import entities.User;
import entities.Warehouse;
import entities.WarehouseBackInvoiceDetails;
import models.OutInvoiceDetailsModel;
import models.WarehouseBackInvoiceDetailsModel;
import models.WarehouseModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class JFrameInvoiceBack extends JFrame {
	private JTextField jtextFieldItemID;
	private JTextField jtextFieldQuantity;
	private JTextField jtextFieldFeedback;
	private JTextField jtextFieldUserID;
	private JButton jbuttonSubmit;
	private Map<String, Object> data;
	private JDateChooser jdateChooser;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFrameInvoiceBack frame = new JFrameInvoiceBack();
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
	public JFrameInvoiceBack() {
		setBounds(100, 100, 301, 350);
		getContentPane().setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
			JLabel lblNewLabel = new JLabel("Back Item Form");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
		JPanel panel = new JPanel();
		panel.add(lblNewLabel);
		getContentPane().add(panel);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 25));
		
	
		
		JPanel panel_5 = new JPanel();
		getContentPane().add(panel_5);
		panel_5.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblNewLabel_1_3 = new JLabel("User ID:      ");
		lblNewLabel_1_3.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		panel_5.add(lblNewLabel_1_3);
		
		jtextFieldUserID = new JTextField();
		jtextFieldUserID.setEditable(false);
		jtextFieldUserID.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		jtextFieldUserID.setColumns(10);
		panel_5.add(jtextFieldUserID);
		
		JPanel panel_1 = new JPanel();
		getContentPane().add(panel_1);
		panel_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblNewLabel_1 = new JLabel("Item ID:       ");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		panel_1.add(lblNewLabel_1);
			JPanel panel_2 = new JPanel();
		getContentPane().add(panel_2);
		panel_2.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		jtextFieldItemID = new JTextField();
		jtextFieldItemID.setEditable(false);
		jtextFieldItemID.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		panel_1.add(jtextFieldItemID);
		jtextFieldItemID.setColumns(10);
		
	
		
		JLabel lblNewLabel_1_1 = new JLabel("Quantity:      ");
		lblNewLabel_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		panel_2.add(lblNewLabel_1_1);
			JPanel panel_3 = new JPanel();
		getContentPane().add(panel_3);
		
		jtextFieldQuantity = new JTextField();
		jtextFieldQuantity.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		panel_2.add(jtextFieldQuantity);
		jtextFieldQuantity.setColumns(10);
		
	
		JLabel lblNewLabel_1_2 = new JLabel("Feedback:     ");
		lblNewLabel_1_2.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		panel_3.add(lblNewLabel_1_2);
		
		jtextFieldFeedback = new JTextField();
		jtextFieldFeedback.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		jtextFieldFeedback.setColumns(10);
		panel_3.add(jtextFieldFeedback);
		
		JPanel panel_4 = new JPanel();
		getContentPane().add(panel_4);
		panel_4.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblNewLabel_1_2_1 = new JLabel("Date:          ");
		lblNewLabel_1_2_1.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		panel_4.add(lblNewLabel_1_2_1);
		
		jdateChooser = new JDateChooser();
		panel_4.add(jdateChooser);
		
		JPanel panel_6 = new JPanel();
		getContentPane().add(panel_6);
		panel_6.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 15));
		
		jbuttonSubmit = new JButton("Submit");
		jbuttonSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jbuttonSubmit_actionPerformed(e);
			}
		});
		jbuttonSubmit.setFont(new Font("Times New Roman", Font.BOLD, 15));
		panel_6.add(jbuttonSubmit);
		
		JPanel panel_7 = new JPanel();
		getContentPane().add(panel_7);
		panel_7.setLayout(new BorderLayout(0, 0));
	}
	public JFrameInvoiceBack( Map<String, Object> data) {
		this();
		this.data = data;
		initJFrame();
	}
	public void initJFrame() {
//		WarehouseModel wareHouseModel = new WarehouseModel();
//		Warehouse warehouse = wareHouseModel.findByItemID(outInvoiceDetailsModel.findByID(value).getItemID());
//		warehouse.setTotalInventory(warehouse.getTotalInventory() + outInvoiceDetailsModel.findByID(value).getQuantity());
		User user = (User) data.get("user");
		OutInvoiceDetails outInvoiceDetails = (OutInvoiceDetails) data.get("item");
		jtextFieldUserID.setText(user.getUserID());
		jtextFieldItemID.setText(outInvoiceDetails.getItemID());
		
		
	}
	public void jbuttonSubmit_actionPerformed(ActionEvent e) {
		User user = (User) data.get("user");
		OutInvoiceDetails outInvoiceDetails = (OutInvoiceDetails) data.get("item");
		OutInvoiceDetailsModel outInvoiceDetailsModel = new OutInvoiceDetailsModel();
		WarehouseModel wareHouseModel = new WarehouseModel();
		Warehouse warehouse = wareHouseModel.findByItemID(outInvoiceDetails.getItemID());
		WarehouseBackInvoiceDetailsModel backInvoiceDetailsModel = new WarehouseBackInvoiceDetailsModel();
		WarehouseBackInvoiceDetails backInvoiceDetails = new WarehouseBackInvoiceDetails();
		backInvoiceDetails.setItemID(jtextFieldItemID.getText());
		backInvoiceDetails.setFeedback(jtextFieldFeedback.getText());
		backInvoiceDetails.setQuantity(Integer.parseInt(jtextFieldQuantity.getText()));
		backInvoiceDetails.setDate(jdateChooser.getDate());
		backInvoiceDetails.setUserID(jtextFieldUserID.getText());
		OutInvoiceDetails outInvoiceDetails2 = new OutInvoiceDetails();
		outInvoiceDetails2.setCreated(jdateChooser.getDate());
		outInvoiceDetails2.setCustomerName(outInvoiceDetails.getCustomerName());
		outInvoiceDetails2.setItemID(outInvoiceDetails.getItemID());
		outInvoiceDetails2.setItemName(outInvoiceDetails.getItemName());
		outInvoiceDetails2.setPayment(outInvoiceDetails.getPayment());
		outInvoiceDetails2.setPrice(outInvoiceDetails.getPrice());
		outInvoiceDetails2.setStatus(true);
		outInvoiceDetails2.setTotal(outInvoiceDetails.getPrice()*outInvoiceDetails.getQuantity());
		outInvoiceDetails2.setUnit(outInvoiceDetails.getUnit());
		outInvoiceDetails2.setUserID(user.getUserID());
		outInvoiceDetails2.setQuantity(outInvoiceDetails.getQuantity() - Integer.parseInt(jtextFieldQuantity.getText()));
		
		if(Integer.parseInt(jtextFieldQuantity.getText()) < outInvoiceDetails.getQuantity()){
			warehouse.setTotalInventory(warehouse.getTotalInventory() + Integer.parseInt(jtextFieldQuantity.getText()));
			outInvoiceDetails.setStatus(false);
			if(wareHouseModel.updateTotalInventory(warehouse) && outInvoiceDetailsModel.updateStatus(outInvoiceDetails) 
					&& outInvoiceDetailsModel.createInvoice(outInvoiceDetails2) && backInvoiceDetailsModel.create(backInvoiceDetails)) {
				JOptionPane.showMessageDialog(this, "Back Item Success");
				this.setVisible(false);
			} else {
			JOptionPane.showMessageDialog(this, "Back Item Failed");
			}
		} else if (Integer.parseInt(jtextFieldQuantity.getText()) == outInvoiceDetails.getQuantity()) {
			outInvoiceDetails.setStatus(false);
			warehouse.setTotalInventory(warehouse.getTotalInventory() + Integer.parseInt(jtextFieldQuantity.getText()));
			if(wareHouseModel.updateTotalInventory(warehouse) && outInvoiceDetailsModel.updateStatus(outInvoiceDetails) 
					 && backInvoiceDetailsModel.create(backInvoiceDetails)) {
				JOptionPane.showMessageDialog(this, "Back Item Success");
				this.setVisible(false);
			} else {
				JOptionPane.showMessageDialog(this, "Back Item Failed");
				}
		} else {
			JOptionPane.showMessageDialog(this, "Error");
		}
	}
}

