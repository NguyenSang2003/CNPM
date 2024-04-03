package quanlybanhang;

import javax.swing.JPanel;
import javax.swing.JPopupMenu;

import nhanvienbanhang.JPanelInvoice;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JMenuItem;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.Color;

public class JPanelQuanLyBanHang extends JPanel {
	private JPanel jpanelMainQuanLyBanHang;
	private JButton jbuttonInvoice;
	private JButton jbuttonEarning;
	private JButton jbuttonCancelItem;
	private JButton jbuttonBackItem;

	/**
	 * Create the panel.
	 */
	public JPanelQuanLyBanHang() {
		setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(128, 128, 128));
		add(panel, BorderLayout.WEST);
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		
		jbuttonInvoice = new JButton("Invoice             ");
		jbuttonInvoice.setBackground(new Color(128, 128, 128));
		jbuttonInvoice.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jbuttonInvoice_actionPerformed(e);
			}
		});
		jbuttonInvoice.setFocusPainted(false);
		jbuttonInvoice.setBorderPainted(false);
		jbuttonInvoice.setIcon(new ImageIcon(JPanelQuanLyBanHang.class.getResource("/icon/Modify.png")));
		jbuttonInvoice.setFont(new Font("Times New Roman", Font.BOLD, 20));
		panel.add(jbuttonInvoice);
		
		jbuttonEarning = new JButton("Transactions   ");
		jbuttonEarning.setBackground(new Color(128, 128, 128));
		jbuttonEarning.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jbuttonEarning_actionPerformed(e);
			}
		});
		jbuttonEarning.setIcon(new ImageIcon(JPanelQuanLyBanHang.class.getResource("/icon/1737376_dollar_money_sign_icon.png")));
		jbuttonEarning.setFont(new Font("Times New Roman", Font.BOLD, 20));
		jbuttonEarning.setFocusPainted(false);
		jbuttonEarning.setBorderPainted(false);
		panel.add(jbuttonEarning);
		
		jbuttonCancelItem = new JButton("Cancel Invoice");
		jbuttonCancelItem.setBackground(new Color(128, 128, 128));
		jbuttonCancelItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jbuttonCancelItem_actionPerformed(e);
			}
		});
		jbuttonCancelItem.setFocusPainted(false);
		jbuttonCancelItem.setBorderPainted(false);
		jbuttonCancelItem.setIcon(new ImageIcon(JPanelQuanLyBanHang.class.getResource("/icon/Delete.png")));
		jbuttonCancelItem.setFont(new Font("Times New Roman", Font.BOLD, 20));
		panel.add(jbuttonCancelItem);
		
		jbuttonBackItem = new JButton("Back Item       ");
		jbuttonBackItem.setBackground(new Color(128, 128, 128));
		jbuttonBackItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jbuttonBackItem_actionPerformed(e);
			}
		});
		jbuttonBackItem.setIcon(new ImageIcon(JPanelQuanLyBanHang.class.getResource("/icon/Back.png")));
		jbuttonBackItem.setFocusPainted(false);
		jbuttonBackItem.setBorderPainted(false);
		jbuttonBackItem.setFont(new Font("Times New Roman", Font.BOLD, 20));
		panel.add(jbuttonBackItem);
		
		jpanelMainQuanLyBanHang = new JPanel();
		add(jpanelMainQuanLyBanHang, BorderLayout.CENTER);
		jpanelMainQuanLyBanHang.setLayout(new BorderLayout(0, 0));
		initJFrame();
	}

	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
	private void clearScreen() {
		jpanelMainQuanLyBanHang.removeAll();
		jpanelMainQuanLyBanHang.revalidate();
	}
	public void jbuttonInvoice_actionPerformed(ActionEvent e) {
		clearScreen();
		quanlybanhang.JPanelInvoice panelInvoice = new quanlybanhang.JPanelInvoice();
		jpanelMainQuanLyBanHang.add(panelInvoice);
		panelInvoice.setVisible(true);
	}
	private void initJFrame() {
		quanlybanhang.JPanelInvoice panelInvoice = new quanlybanhang.JPanelInvoice();
		jpanelMainQuanLyBanHang.add(panelInvoice);
		panelInvoice.setVisible(true);
	};
	public void jbuttonEarning_actionPerformed(ActionEvent e) {
		clearScreen();
		JPanelEarnMoney panelEarnMoney = new JPanelEarnMoney();
		jpanelMainQuanLyBanHang.add(panelEarnMoney);
		panelEarnMoney.setVisible(true);
	}
	public void jbuttonBackItem_actionPerformed(ActionEvent e) {
		clearScreen();
		JPanelBackItem panelCancelItem = new JPanelBackItem();
		jpanelMainQuanLyBanHang.add(panelCancelItem);
		panelCancelItem.setVisible(true);
	}
	public void jbuttonCancelItem_actionPerformed(ActionEvent e) {
		clearScreen();
		JPanelCancelInvoice jPanelCancelInvoice = new JPanelCancelInvoice();
		jpanelMainQuanLyBanHang.add(jPanelCancelInvoice);
		jPanelCancelInvoice.setVisible(true);
		
	}
}
