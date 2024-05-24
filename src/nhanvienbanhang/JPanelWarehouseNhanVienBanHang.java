package nhanvienbanhang;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import entities.User;
import entities.Warehouse;
import models.ItemModel;
import models.WarehouseModel;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.ListSelectionModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Map;
import java.awt.Color;
import javax.swing.border.TitledBorder;
import javax.swing.JPopupMenu;
import java.awt.Component;
import javax.swing.JMenuItem;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class JPanelWarehouseNhanVienBanHang extends JPanel {
	private JTable jtableWarehouse;
	private JButton jbuttonOutOfStock;
	private String value;
	private Map<String, Object> data;
	/**
	 * Create the panel.
	 */
	public JPanelWarehouseNhanVienBanHang() {
		setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBorder(new TitledBorder(null, "Warehouse Table", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		add(scrollPane, BorderLayout.CENTER);
		
		jtableWarehouse = new JTable();
		jtableWarehouse.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				jtableWarehouse_mouseClicked(e);
			}
		});
		jtableWarehouse.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane.setViewportView(jtableWarehouse);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(192, 192, 192));
		add(panel, BorderLayout.NORTH);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblNewLabel = new JLabel("Warehouse Status");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		add(panel_1, BorderLayout.SOUTH);
		panel_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		jbuttonOutOfStock = new JButton("Out of Stock");
		jbuttonOutOfStock.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jbuttonOutOfStock_actionPerformed(e);
			}
		});
		jbuttonOutOfStock.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		panel_1.add(jbuttonOutOfStock);
		initJFrame();
	}
	public void initJFrame() {
		WarehouseModel warehouseModel = new WarehouseModel();
		DefaultTableModel defaultTableModel = new DefaultTableModel() {

			@Override
			public boolean isCellEditable(int row, int column) {
				// TODO Auto-generated method stub
				return false;
			}
			
		};
		defaultTableModel.addColumn("ID");
		defaultTableModel.addColumn("itemID");
		defaultTableModel.addColumn("itemName");
		defaultTableModel.addColumn("dateAdded");
		defaultTableModel.addColumn("status");
		defaultTableModel.addColumn("totalInventory");
		for (Warehouse warehouse : warehouseModel.findAll()) {
			defaultTableModel.addRow(new Object[] {
					warehouse.getID(), warehouse.getItemID(), warehouse.getItemName(), warehouse.getDateAdded(), warehouse.isStatus(),
					warehouse.getTotalInventory()
			});
		}
		jtableWarehouse.getTableHeader().setReorderingAllowed(false);
		jtableWarehouse.setModel(defaultTableModel);
		jtableWarehouse.setRowHeight(60);
		jbuttonOutOfStock.setEnabled(false);
	}
	public JPanelWarehouseNhanVienBanHang(Map<String, Object> data) {
		this();
		this.data = data;
		initJFrame();
		
	}
	public void jtableWarehouse_mouseClicked(MouseEvent e) {
		ItemModel itemModel = new ItemModel();
		jbuttonOutOfStock.setEnabled(true);
		int getSelectedRow = jtableWarehouse.getSelectedRow();
		value = jtableWarehouse.getValueAt(getSelectedRow, 1).toString();
		System.out.println(value);
		data.put("item", itemModel.findItem(value));
	}

	
	public void jbuttonOutOfStock_actionPerformed(ActionEvent e) {
		JFrameFeedBack  jFrameFeedBack = new JFrameFeedBack(data);
		jFrameFeedBack.setVisible(true);
		
	}
}
