package main;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import main.JFrameHome;
import models.UserModel;
import nhanvienbanhang.JPanelBuyItemsNhanVienBanHang;

import javax.swing.BoxLayout;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.JButton;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.util.HashMap;
import java.util.Map;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.border.TitledBorder;

public class JFrameLogin extends JFrame {

	private JPanel contentPane;
	private JTextField jtextFieldUsername;
	private JPasswordField jpasswordField;
	private JButton jbuttonLogin;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
		} catch (Throwable e) {
			e.printStackTrace();
		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFrameLogin frame = new JFrameLogin();
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
	public JFrameLogin() {
		setTitle("Warehouse Management");
		setBounds(100, 100, 352, 468);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(59, 59, 59)));
		panel.setForeground(new Color(255, 255, 255));
		contentPane.add(panel);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 0));
		
		JLabel lblNewLabel = new JLabel("\r\nWAREHOUSE MANAGEMENT");
		lblNewLabel.setForeground(new Color(255, 0, 0));
		lblNewLabel.setFont(new Font("SimSun-ExtB", Font.BOLD, 26));
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1);
		panel_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 10));
		
		JLabel lblNewLabel_1 = new JLabel("Username:  ");
		lblNewLabel_1.setIcon(new ImageIcon(JFrameLogin.class.getResource("/icon/372902_user_name_round_username_linecon_icon.png")));
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		panel_1.add(lblNewLabel_1);
		
		jtextFieldUsername = new JTextField();
		jtextFieldUsername.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				jtextFieldUsername.setText("");
			}
		});
		jtextFieldUsername.setText("Username");
		jtextFieldUsername.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		panel_1.add(jtextFieldUsername);
		jtextFieldUsername.setColumns(10);
		
		JPanel panel_2 = new JPanel();
		contentPane.add(panel_2);
		
		JLabel lblNewLabel_2 = new JLabel("Password:  ");
		lblNewLabel_2.setIcon(new ImageIcon(JFrameLogin.class.getResource("/icon/115716_lock_unlock_password_secure_security_icon.png")));
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		panel_2.add(lblNewLabel_2);
		
		jpasswordField = new JPasswordField();
		jpasswordField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				jpasswordField.setText("");
			}
		});
		jpasswordField.setText("***********");
		jpasswordField.setColumns(10);
		jpasswordField.setHorizontalAlignment(SwingConstants.LEFT);
		jpasswordField.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		panel_2.add(jpasswordField);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		contentPane.add(panel_3);
		
		jbuttonLogin = new JButton("Login");
		jbuttonLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jbuttonLogin_actionPerformed(e);
			}
		});
		jbuttonLogin.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		panel_3.add(jbuttonLogin);
	}
	public void jbuttonLogin_actionPerformed(ActionEvent e) {
		String username = jtextFieldUsername.getText();
		String password = new String(jpasswordField.getPassword());
		UserModel userModel = new UserModel();
		if(jtextFieldUsername.getText().equals("") || password.equals("")) {
			JOptionPane.showMessageDialog(this, "Please fill username and password!", "FAILED", JOptionPane.ERROR_MESSAGE);
		} else if(userModel.checkUserName(username) != null) {
			if(userModel.login(username, password) != null) {
				JOptionPane.showMessageDialog(this, "login success");
				Map<String, Object> data = new HashMap<String, Object>();
				data.put("user", userModel.checkUserName(username));
				JFrameHome jframeHome = new JFrameHome(data);
				
				jframeHome.setVisible(true);
				this.setVisible(false);
				
			} else {
				JOptionPane.showMessageDialog(this, "Username or password is incorrect!", "FAILED", JOptionPane.ERROR_MESSAGE);
			}
		} else {
			JOptionPane.showMessageDialog(this, "Username or password is incorrect!", "FAILED", JOptionPane.ERROR_MESSAGE);
		}
		
	}
	

}
