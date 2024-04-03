package admin;

import javax.swing.JPanel;
import javax.swing.AbstractButton;
import javax.swing.BoxLayout;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.util.Date;
import java.util.Enumeration;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import com.toedter.calendar.JDateChooser;

import entities.User;
import models.UserModel;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import javax.swing.JRadioButton;
import javax.swing.JCheckBox;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class JPanelCreateNewUser extends JPanel {
	private JTextField jtextFieldUserID;
	private JTextField jtextFieldUsername;
	private JComboBox jcomboboxRole;
	private final ButtonGroup jbuttonGroupShift = new ButtonGroup();
	private JPasswordField jpasswordField;
	private JDateChooser jdateChooserJoinDate;
	private JDateChooser jdateChooserLeaveDate;
	private JButton jbuttonCreate;

	/**
	 * Create the panel.
	 */
	public JPanelCreateNewUser() {
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(192, 192, 192));
		add(panel);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblNewLabel = new JLabel("Create New User");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		add(panel_1);
		panel_1.setLayout(new FlowLayout(FlowLayout.CENTER, 18, 15));
		
		JLabel lblNewLabel_1 = new JLabel("UserID:  ");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		panel_1.add(lblNewLabel_1);
		
		jtextFieldUserID = new JTextField();
		jtextFieldUserID.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		panel_1.add(jtextFieldUserID);
		jtextFieldUserID.setColumns(10);
		
		JPanel panel_2 = new JPanel();
		add(panel_2);
		panel_2.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 15));
		
		JLabel lblNewLabel_2 = new JLabel("Username:  ");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		panel_2.add(lblNewLabel_2);
		
		jtextFieldUsername = new JTextField();
		jtextFieldUsername.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		panel_2.add(jtextFieldUsername);
		jtextFieldUsername.setColumns(10);
		
		JPanel panel_3 = new JPanel();
		add(panel_3);
		panel_3.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 15));
		
		JLabel lblNewLabel_7 = new JLabel("Role:  ");
		lblNewLabel_7.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		panel_3.add(lblNewLabel_7);
		
		jcomboboxRole = new JComboBox();
		jcomboboxRole.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		jcomboboxRole.setMaximumRowCount(15);
		panel_3.add(jcomboboxRole);
		
		JPanel panel_4 = new JPanel();
		panel_4.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		add(panel_4);
		panel_4.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 15));
		
		JLabel lblNewLabel_3 = new JLabel("Join Date:  ");
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		panel_4.add(lblNewLabel_3);
		
		jdateChooserJoinDate = new JDateChooser();
		jdateChooserJoinDate.setFont(new Font("Times New Roman", Font.PLAIN, 10));
		BorderLayout bl_jdateChooserJoinDate = (BorderLayout) jdateChooserJoinDate.getLayout();
		panel_4.add(jdateChooserJoinDate);
		
		JLabel lblNewLabel_4 = new JLabel("Leave Date:  ");
		lblNewLabel_4.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		panel_4.add(lblNewLabel_4);
		
		jdateChooserLeaveDate = new JDateChooser();
		jdateChooserLeaveDate.setFont(new Font("Times New Roman", Font.PLAIN, 10));
		panel_4.add(jdateChooserLeaveDate);
		
		JPanel panel_5 = new JPanel();
		add(panel_5);
		panel_5.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 15));
		
		JLabel lblNewLabel_5 = new JLabel("Shift:  ");
		lblNewLabel_5.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		panel_5.add(lblNewLabel_5);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Morning");
		jbuttonGroupShift.add(rdbtnNewRadioButton);
		rdbtnNewRadioButton.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		panel_5.add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnNewRadioButton_2 = new JRadioButton("Afternoon");
		jbuttonGroupShift.add(rdbtnNewRadioButton_2);
		rdbtnNewRadioButton_2.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		panel_5.add(rdbtnNewRadioButton_2);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("Night");
		jbuttonGroupShift.add(rdbtnNewRadioButton_1);
		rdbtnNewRadioButton_1.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		panel_5.add(rdbtnNewRadioButton_1);
		
		JPanel panel_6 = new JPanel();
		add(panel_6);
		panel_6.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 15));
		
		JLabel lblNewLabel_6 = new JLabel("Password:  ");
		lblNewLabel_6.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		panel_6.add(lblNewLabel_6);
		
		jpasswordField = new JPasswordField();
		jpasswordField.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		jpasswordField.setColumns(10);
		panel_6.add(jpasswordField);
		
		JPanel panel_7 = new JPanel();
		add(panel_7);
		panel_7.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 15));
		
		jbuttonCreate = new JButton("Create");
		jbuttonCreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jbuttonCreate_actionPerformed(e);
			}
		});
		jbuttonCreate.setFont(new Font("Times New Roman", Font.PLAIN, 21));
		panel_7.add(jbuttonCreate);
		
		JPanel panel_8 = new JPanel();
		add(panel_8);
		panel_8.setLayout(new BorderLayout(0, 0));
		initJFrame();
	}
	private void initJFrame() {
		DefaultComboBoxModel<Integer> defaultComboBoxModel = new DefaultComboBoxModel<Integer>();
		
		defaultComboBoxModel.addElement(1);
		defaultComboBoxModel.addElement(2);
		defaultComboBoxModel.addElement(3);
		defaultComboBoxModel.addElement(4);
		jcomboboxRole.setModel(defaultComboBoxModel);
	}
	private String getElementSelected(ButtonGroup buttonGroup) {
		Enumeration<AbstractButton> elements = buttonGroup.getElements();
		
		while(elements.hasMoreElements()) {
			JRadioButton radioButton = (JRadioButton) elements.nextElement();
			if(radioButton.isSelected()) {
				return radioButton.getText();
				
			}
		}
		return null;
	}
	public void jbuttonCreate_actionPerformed(ActionEvent e) {
		String userID = jtextFieldUserID.getText();
		String username = jtextFieldUsername.getText();
		int role = Integer.parseInt(jcomboboxRole.getSelectedItem().toString()) ;
		Date joinDate = jdateChooserJoinDate.getDate();
		Date leaveDate = jdateChooserLeaveDate.getDate();
		String shift = getElementSelected(jbuttonGroupShift);
		String password = new String(jpasswordField.getPassword());
		UserModel model = new UserModel();
		User user = new User();
		user.setUserID(userID);
		user.setUsername(username);
		user.setRole(role);
		user.setJoinDate(joinDate);
		user.setLeaveDate(leaveDate);
		user.setShift(shift);
		user.setPassword(password);
		if(model.checkUserName(username) != null) {
			JOptionPane.showMessageDialog(this, "Account already exists", "FAILED", JOptionPane.ERROR_MESSAGE);
		} else {
			if(model.createNewUser(user)) {
				jtextFieldUserID.setText("");
				jtextFieldUsername.setText("");
				jdateChooserJoinDate.setDate(null);
				jdateChooserLeaveDate.setDate(null);
				jpasswordField.setText("");
			JOptionPane.showMessageDialog(this, "create new user success", "Success", JOptionPane.INFORMATION_MESSAGE);
			
		} else {
			JOptionPane.showMessageDialog(this, "create new user failed", "FAILED", JOptionPane.ERROR_MESSAGE);
		}
		
	}
	}
}
