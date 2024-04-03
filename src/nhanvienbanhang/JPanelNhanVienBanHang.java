package nhanvienbanhang;

import javax.swing.JPanel;

import models.WarehouseModel;
import nhanvienbanhang.JPanelItemNhanVienBanHang;

import java.awt.BorderLayout;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import java.awt.Component;
import java.awt.Rectangle;
import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.util.Map;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class JPanelNhanVienBanHang extends JPanel {
	private JButton jbuttonItems;
	private JPanel jpanelMainNhanVienBanHang;
	private JButton jbuttonWarehouseStatus;
	private JButton jbuttonBuyItems;
	private Map<String, Object> data;
	private JButton jbuttonInvoice;

	/**
	 * Create the panel.
	 */
	public JPanelNhanVienBanHang() {
		setLayout(new BorderLayout(0, 0));
		
		JPanel jpanelMenu = new JPanel();
		jpanelMenu.setBackground(new Color(128, 128, 128));
		jpanelMenu.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		add(jpanelMenu, BorderLayout.WEST);
		jpanelMenu.setLayout(new BoxLayout(jpanelMenu, BoxLayout.Y_AXIS));
		
		jbuttonItems = new JButton("Items                      ");
		jbuttonItems.setForeground(new Color(0, 0, 0));
		jbuttonItems.setBorderPainted(false);
		jbuttonItems.setFocusPainted(false);
		jbuttonItems.setBackground(new Color(128, 128, 128));
		jbuttonItems.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jbuttonItems_actionPerformed(e);
			}
		});
		jbuttonItems.setIcon(new ImageIcon(JPanelNhanVienBanHang.class.getResource("/icon/1622836_checkmark_done_explore_find_magnifier_icon.png")));
		jbuttonItems.setFont(new Font("Times New Roman", Font.BOLD, 15));
		jpanelMenu.add(jbuttonItems);
		
		jbuttonWarehouseStatus = new JButton("Warehouse Status  ");
		jbuttonWarehouseStatus.setFocusPainted(false);
		jbuttonWarehouseStatus.setBorderPainted(false);
		jbuttonWarehouseStatus.setBackground(new Color(128, 128, 128));
		jbuttonWarehouseStatus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jbuttonWarehouseStatus_actionPerformed(e);
			}
		});
		jbuttonWarehouseStatus.setIcon(new ImageIcon(JPanelNhanVienBanHang.class.getResource("/icon/8333876_warehouse_storage unit_storehouse_icon.png")));
		jbuttonWarehouseStatus.setFont(new Font("Times New Roman", Font.BOLD, 15));
		jpanelMenu.add(jbuttonWarehouseStatus);
		
		jbuttonBuyItems = new JButton("Buy Items               ");
		jbuttonBuyItems.setBorderPainted(false);
		jbuttonBuyItems.setFocusPainted(false);
		jbuttonBuyItems.setBackground(new Color(128, 128, 128));
		jbuttonBuyItems.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jbuttonBuyItems_actionPerformed(e);
			}
		});
		jbuttonBuyItems.setIcon(new ImageIcon(JPanelNhanVienBanHang.class.getResource("/icon/3890936_buy_cart_market_purchase_shop_icon.png")));
		jbuttonBuyItems.setFont(new Font("Times New Roman", Font.BOLD, 15));
		jpanelMenu.add(jbuttonBuyItems);
		
		jbuttonInvoice = new JButton("Invoice                    ");
		jbuttonInvoice.setFocusPainted(false);
		jbuttonInvoice.setBorderPainted(false);
		jbuttonInvoice.setBackground(new Color(128, 128, 128));
		jbuttonInvoice.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jbuttonInvoice_actionPerformed(e);
			}
		});
		jbuttonInvoice.setFont(new Font("Times New Roman", Font.BOLD, 15));
		jbuttonInvoice.setIcon(new ImageIcon(JPanelNhanVienBanHang.class.getResource("/icon/8156552_bill_invoice_payment_receipt_billing_icon.png")));
		jpanelMenu.add(jbuttonInvoice);
		
		jpanelMainNhanVienBanHang = new JPanel();
		add(jpanelMainNhanVienBanHang, BorderLayout.CENTER);
		jpanelMainNhanVienBanHang.setLayout(new BorderLayout(0, 0));
		initJFrame();
	}
	public JPanelNhanVienBanHang( Map<String, Object> data) {
		this();
		this.data = data;
		
	}
	public void jbuttonItems_actionPerformed(ActionEvent e) {
		clearScreen();
		JPanelItemNhanVienBanHang panelItemNhanVienBanHang = new JPanelItemNhanVienBanHang();
		jpanelMainNhanVienBanHang.add(panelItemNhanVienBanHang);
		panelItemNhanVienBanHang.setVisible(true);
	}
	private void clearScreen() {
		jpanelMainNhanVienBanHang.removeAll();
		jpanelMainNhanVienBanHang.revalidate();
	}
	public void jbuttonWarehouseStatus_actionPerformed(ActionEvent e) {
		clearScreen();
		JPanelWarehouseNhanVienBanHang panelWarehouseNhanVienBanHang = new JPanelWarehouseNhanVienBanHang(data);
		jpanelMainNhanVienBanHang.add(panelWarehouseNhanVienBanHang);
		panelWarehouseNhanVienBanHang.setVisible(true);
		
	}
	public void initJFrame() {
		JPanelItemNhanVienBanHang panelItemNhanVienBanHang = new JPanelItemNhanVienBanHang();
		jpanelMainNhanVienBanHang.add(panelItemNhanVienBanHang);
		panelItemNhanVienBanHang.setVisible(true);
	}
	public void jbuttonBuyItems_actionPerformed(ActionEvent e) {
		clearScreen();
		JPanelBuyItemsNhanVienBanHang panelBuyItemsNhanVienBanHang = new JPanelBuyItemsNhanVienBanHang(data);
		jpanelMainNhanVienBanHang.add(panelBuyItemsNhanVienBanHang);
		panelBuyItemsNhanVienBanHang.setVisible(true);
	}
	public void jbuttonInvoice_actionPerformed(ActionEvent e) {
		clearScreen();
		JPanelInvoice panelInvoice = new JPanelInvoice(data);
		jpanelMainNhanVienBanHang.add(panelInvoice);
		panelInvoice.setVisible(true);
	}

}
