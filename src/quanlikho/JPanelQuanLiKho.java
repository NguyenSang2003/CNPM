package quanlikho;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.util.Map;
import java.awt.event.ActionEvent;

public class JPanelQuanLiKho extends JPanel {
	private JPanel panelMainQuanLiKho;
	private JButton jbuttonWarehouse;
	private JButton jbuttonItemChart;
	private JButton jbuttonWarehouseInInvoice;
	private Map<String, Object> data;
	private JButton jbuttonInventory;
	private JButton jbuttonFeedback;

	/**
	 * Create the panel.
	 */
	public JPanelQuanLiKho() {
		setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(128, 128, 128));
		add(panel, BorderLayout.WEST);
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		
		jbuttonWarehouse = new JButton("Warehouse  ");
		jbuttonWarehouse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jbuttonWarehouse_actionPerformed(e);
			}
		});
		jbuttonWarehouse.setBackground(new Color(128, 128, 128));
		jbuttonWarehouse.setFocusPainted(false);
		jbuttonWarehouse.setBorderPainted(false);
		jbuttonWarehouse.setIcon(new ImageIcon(JPanelQuanLiKho.class.getResource("/icon/8333876_warehouse_storage unit_storehouse_icon.png")));
		jbuttonWarehouse.setFont(new Font("Times New Roman", Font.BOLD, 20));
		panel.add(jbuttonWarehouse);
		
		jbuttonItemChart = new JButton("Item Chart  ");
		jbuttonItemChart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jbuttonItemChart_actionPerformed(e);
			}
		});
		jbuttonItemChart.setFocusPainted(false);
		jbuttonItemChart.setBorderPainted(false);
		jbuttonItemChart.setBackground(new Color(128, 128, 128));
		jbuttonItemChart.setIcon(new ImageIcon(JPanelQuanLiKho.class.getResource("/icon/1320813_analystic_chart_line_report_icon.png")));
		jbuttonItemChart.setFont(new Font("Times New Roman", Font.BOLD, 20));
		panel.add(jbuttonItemChart);
		
		jbuttonWarehouseInInvoice = new JButton("Import Item");
		jbuttonWarehouseInInvoice.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jbuttonWarehouseInInvoice_actionPerformed(e);
			}
		});
		jbuttonWarehouseInInvoice.setBackground(new Color(128, 128, 128));
		jbuttonWarehouseInInvoice.setBorderPainted(false);
		jbuttonWarehouseInInvoice.setFocusPainted(false);
		jbuttonWarehouseInInvoice.setSelectedIcon(new ImageIcon(JPanelQuanLiKho.class.getResource("/icon/3259399_add_media_social_icon.png")));
		jbuttonWarehouseInInvoice.setIcon(new ImageIcon(JPanelQuanLiKho.class.getResource("/icon/3259399_add_media_social_icon.png")));
		jbuttonWarehouseInInvoice.setFont(new Font("Times New Roman", Font.BOLD, 20));
		panel.add(jbuttonWarehouseInInvoice);
		
		jbuttonInventory = new JButton("Inventory    ");
		jbuttonInventory.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jbuttonInventory_actionPerformed(e);
			}
		});
		jbuttonInventory.setBackground(new Color(128, 128, 128));
		jbuttonInventory.setFocusPainted(false);
		jbuttonInventory.setBorderPainted(false);
		jbuttonInventory.setIcon(new ImageIcon(JPanelQuanLiKho.class.getResource("/icon/49590_boxes_customers_inventory_products_icon.png")));
		jbuttonInventory.setFont(new Font("Times New Roman", Font.BOLD, 20));
		panel.add(jbuttonInventory);
		
		jbuttonFeedback = new JButton("Feedback      ");
		jbuttonFeedback.setBackground(new Color(128, 128, 128));
		jbuttonFeedback.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jbuttonFeedback_actionPerformed(e);
			}
		});
		jbuttonFeedback.setFocusPainted(false);
		jbuttonFeedback.setBorderPainted(false);
		jbuttonFeedback.setIcon(new ImageIcon(JPanelQuanLiKho.class.getResource("/icon/Email.png")));
		jbuttonFeedback.setFont(new Font("Times New Roman", Font.BOLD, 20));
		panel.add(jbuttonFeedback);
		
		panelMainQuanLiKho = new JPanel();
		add(panelMainQuanLiKho, BorderLayout.CENTER);
		panelMainQuanLiKho.setLayout(new BorderLayout(0, 0));
		initJFrame();
	}
	public void initJFrame() {
//		Chart chart = new Chart();
//		panelMainQuanLiKho.add(chart);
//		chart.setVisible(true);
		JPanelWarehouse wareHousePanel = new JPanelWarehouse();
		panelMainQuanLiKho.add(wareHousePanel);
		wareHousePanel.setVisible(true);
	}
	public JPanelQuanLiKho(Map<String, Object> data) {
		this();
		this.data = data;
		initJFrame();
	}
	private void clearScreen() {
		panelMainQuanLiKho.removeAll();
		panelMainQuanLiKho.revalidate();
	}
	public void jbuttonItemChart_actionPerformed(ActionEvent e) {
		clearScreen();
		Chart chart = new Chart();
		panelMainQuanLiKho.add(chart);
		chart.setVisible(true);
	}
	public void jbuttonWarehouse_actionPerformed(ActionEvent e) {
		clearScreen();
		JPanelWarehouse wareHousePanel = new JPanelWarehouse();
		panelMainQuanLiKho.add(wareHousePanel);
		wareHousePanel.setVisible(true);
	}
	public void jbuttonWarehouseInInvoice_actionPerformed(ActionEvent e) {
		clearScreen();
		JPanelWarehouseInInvoice jPanelWarehouseInInvoice = new JPanelWarehouseInInvoice(data);
		panelMainQuanLiKho.add(jPanelWarehouseInInvoice);
		jPanelWarehouseInInvoice.setVisible(true);
		
	}
	public void jbuttonInventory_actionPerformed(ActionEvent e) {
		clearScreen();
		JPanelInventory inventory = new JPanelInventory();
		panelMainQuanLiKho.add(inventory);
		inventory.setVisible(true);
	}
	public void jbuttonFeedback_actionPerformed(ActionEvent e) {
		clearScreen();
		JPanelCheckSend checkSend = new JPanelCheckSend();
		panelMainQuanLiKho.add(checkSend);
		checkSend.setVisible(true);
	}

}
