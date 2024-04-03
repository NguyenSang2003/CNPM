package main;

import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import admin.JPanelAdmin;
import main.JFrameChangePassword;
import nhanvienbanhang.JPanelNhanVienBanHang;
import quanlikho.JPanelQuanLiKho;
import quanlybanhang.JPanelQuanLyBanHang;
import entities.User;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;
import java.awt.event.ActionEvent;
import java.awt.BorderLayout;

public class JFrameHome extends JFrame {

	private JPanel contentPane;
	private JMenu jmenuWelcome;
	private JMenuItem jmenuItemChangePassword;
	private Map<String, Object> data;
	private JMenuItem jmenuItemLogout;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFrameHome frame = new JFrameHome();
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
	public JFrameHome() {
		setBounds(100, 100, 1146, 709);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		jmenuWelcome = new JMenu("Welcome");
		jmenuWelcome.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		menuBar.add(jmenuWelcome);
		
		JMenu mnNewMenu = new JMenu("Account");
		mnNewMenu.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		menuBar.add(mnNewMenu);
		
		jmenuItemChangePassword = new JMenuItem("Change Password");
		jmenuItemChangePassword.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jmenuItemChangePassword_actionPerformed(e);
			}
		});
		jmenuItemChangePassword.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		mnNewMenu.add(jmenuItemChangePassword);
		
		jmenuItemLogout = new JMenuItem("Log Out");
		jmenuItemLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jmenuItemLogout_actionPerformed(e);
			}
		});
		jmenuItemLogout.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		mnNewMenu.add(jmenuItemLogout);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
	}
	public JFrameHome(Map<String, Object> data) {
		this();
		this.data = data;
		initJFrame();
		
		
	}
	public void initJFrame() {
		User user = (User) data.get("user");
		jmenuWelcome.setText("Welcome " + user.getUsername());
		if(user.getRole() == 1) {
			JPanelNhanVienBanHang panelNhanVienBanHang = new JPanelNhanVienBanHang(data);
			contentPane.add(panelNhanVienBanHang);
			panelNhanVienBanHang.setVisible(true);
		} else if (user.getRole() == 2){
			JPanelQuanLyBanHang panelQuanLyBanHang = new JPanelQuanLyBanHang();
			contentPane.add(panelQuanLyBanHang);
			panelQuanLyBanHang.setVisible(true);
		} else if(user.getRole() == 0) {
			JPanelAdmin panelAdmin = new JPanelAdmin();
			contentPane.add(panelAdmin);
			panelAdmin.setVisible(true);
		} else if (user.getRole() == 3){
			JPanelQuanLiKho jPanelQuanLiKho = new JPanelQuanLiKho(data);
			contentPane.add(jPanelQuanLiKho);
			
			jPanelQuanLiKho.setVisible(true);
		}
	}
	public void jmenuItemChangePassword_actionPerformed(ActionEvent e) {
		User user = (User) data.get("user");
		Map<String, Object> dataChangePassword = new HashMap<String, Object>();
		dataChangePassword.put("user", user);
		JFrameChangePassword jframeChangePassword = new JFrameChangePassword(dataChangePassword);
		jframeChangePassword.setVisible(true);
		
	}
	public void jmenuItemLogout_actionPerformed(ActionEvent e) {
		JFrameLogin frameLogin = new JFrameLogin();
		frameLogin.setVisible(true);
		this.setVisible(false);
	}

}
