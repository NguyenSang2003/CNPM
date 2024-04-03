package nhanvienbanhang;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import entities.OutInvoiceDetails;
import entities.Warehouse;
import models.OutInvoiceDetailsModel;
import models.WarehouseModel;

import java.awt.FlowLayout;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.ListSelectionModel;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.border.TitledBorder;

public class JPanelInvoice extends JPanel {
	private JTable jtableInvoice;
	private JComboBox jcomboboxInvoice;
	private JButton jbuttonCancelInvoice;
	private JButton jbuttonBackItem;
	private int value;
	private Map<String, Object> data;
	private JButton jbuttonRefresh;

	/**
	 * Create the panel.
	 */
	public JPanelInvoice() {
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(192, 192, 192));
		add(panel);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblNewLabel = new JLabel("Invoice");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
		panel.add(lblNewLabel);
		
		JPanel panel_3 = new JPanel();
		add(panel_3);
		panel_3.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblNewLabel_1 = new JLabel("Type Invoice: ");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 15));
		panel_3.add(lblNewLabel_1);
		
		jcomboboxInvoice = new JComboBox();
		jcomboboxInvoice.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jcomboboxInvoice_actionPerformed(e);
			}
		});
		jcomboboxInvoice.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		jcomboboxInvoice.setMaximumRowCount(15);
		panel_3.add(jcomboboxInvoice);
		
		jbuttonRefresh = new JButton("Refresh");
		jbuttonRefresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jbuttonRefresh_actionPerformed(e);
			}
		});
		jbuttonRefresh.setIcon(new ImageIcon(JPanelInvoice.class.getResource("/icon/352439_refresh_icon.png")));
		jbuttonRefresh.setFont(new Font("Times New Roman", Font.BOLD, 15));
		panel_3.add(jbuttonRefresh);
		
		JPanel panel_1 = new JPanel();
		add(panel_1);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBorder(new TitledBorder(null, "Invoice Table", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.add(scrollPane, BorderLayout.CENTER);
		
		jtableInvoice = new JTable();
		jtableInvoice.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				jtableInvoice_mouseClicked(e);
			}
		});
		jtableInvoice.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane.setViewportView(jtableInvoice);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		add(panel_2);
		panel_2.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		jbuttonCancelInvoice = new JButton("Cancel Invoice");
		jbuttonCancelInvoice.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jbuttonCancelInvoice_actionPerformed(e);
			}
		});
		jbuttonCancelInvoice.setFont(new Font("Times New Roman", Font.BOLD, 15));
		panel_2.add(jbuttonCancelInvoice);
		
		jbuttonBackItem = new JButton("Back Item");
		jbuttonBackItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jbuttonBackItem_actionPerformed(e);
			}
		});
		jbuttonBackItem.setFont(new Font("Times New Roman", Font.BOLD, 15));
		panel_2.add(jbuttonBackItem);
		initJFrame();
	}
	public JPanelInvoice(Map<String, Object> data) {
		this();
		this.data = data;
		initJFrame();
	}
	public void initJFrame() {
		OutInvoiceDetailsModel outInvoiceDetailsModel = new OutInvoiceDetailsModel();
		DefaultComboBoxModel<String> defaultComboBoxModel = new DefaultComboBoxModel<String>();
		defaultComboBoxModel.addElement("All Invoice");
		defaultComboBoxModel.addElement("Active Invoice");
		defaultComboBoxModel.addElement("Cancel Invoice");
		jcomboboxInvoice.setModel(defaultComboBoxModel);
		fillDataToTable1(outInvoiceDetailsModel.findAlloutinvoicedetails());
		jbuttonBackItem.setEnabled(false);
		jbuttonCancelInvoice.setEnabled(false);
	}
	private void fillDataToTable1(List<OutInvoiceDetails> outInvoiceDetail) {
		SimpleDateFormat simpleDateFormat=new SimpleDateFormat("dd/MM/yyyy");
		DefaultTableModel defaultTableModel=new DefaultTableModel() {

			@Override
			public boolean isCellEditable(int row, int column) {
				// TODO Auto-generated method stub
				return false;
			}
			
		};
		defaultTableModel.addColumn("outInvoiceDetailsID");
		defaultTableModel.addColumn("itemID");
		defaultTableModel.addColumn("itemName");
		defaultTableModel.addColumn("quantity");
		defaultTableModel.addColumn("price");
		defaultTableModel.addColumn("total");
		defaultTableModel.addColumn("status");
		defaultTableModel.addColumn("payment");
		defaultTableModel.addColumn("created");
		defaultTableModel.addColumn("unit");
		defaultTableModel.addColumn("userID");
		defaultTableModel.addColumn("customerName");
		for(OutInvoiceDetails details:outInvoiceDetail) {
			defaultTableModel.addRow(new Object[] {
				details.getOutInvoiceDetailsID(),details.getItemID(),details.getItemName(),details.getQuantity(),details.getPrice(),details.getTotal(),details.isStatus(),details.getPayment(),
				details.getCreated(),details.getUnit(),details.getUserID(),details.getCustomerName()
			});
			
		}
		jtableInvoice.setModel(defaultTableModel);
		jtableInvoice.getTableHeader().setReorderingAllowed(false);
		jtableInvoice.setRowHeight(60);
	}
	public void jcomboboxInvoice_actionPerformed(ActionEvent e) {
		OutInvoiceDetailsModel outInvoiceDetailsModel = new OutInvoiceDetailsModel();
		String type = jcomboboxInvoice.getSelectedItem().toString();
		if(type.equalsIgnoreCase("All Invoice")) {
			fillDataToTable1(outInvoiceDetailsModel.findAlloutinvoicedetails());
		} else if(type.equalsIgnoreCase("Active Invoice")) {
			fillDataToTable1(outInvoiceDetailsModel.findAlloutinvoicedetailsByStatus(true));
		} else if(type.equalsIgnoreCase("Cancel Invoice")) {
			fillDataToTable1(outInvoiceDetailsModel.findAlloutinvoicedetailsByStatus(false));
		}
	}
	public void jtableInvoice_mouseClicked(MouseEvent e) {
		jbuttonBackItem.setEnabled(true);
		jbuttonCancelInvoice.setEnabled(true);
		int selectedRow = jtableInvoice.getSelectedRow();
		value = Integer.parseInt(jtableInvoice.getValueAt(selectedRow, 0).toString());
		
	}
	public void jbuttonCancelInvoice_actionPerformed(ActionEvent e) {
		OutInvoiceDetailsModel outInvoiceDetailsModel = new OutInvoiceDetailsModel();
		OutInvoiceDetails outInvoiceDetails = outInvoiceDetailsModel.findByID(value);
		outInvoiceDetails.setStatus(false);
		WarehouseModel wareHouseModel = new WarehouseModel();
		Warehouse warehouse = wareHouseModel.findByItemID(outInvoiceDetailsModel.findByID(value).getItemID());
		warehouse.setTotalInventory(warehouse.getTotalInventory() + outInvoiceDetailsModel.findByID(value).getQuantity());
		if(outInvoiceDetailsModel.updateStatus(outInvoiceDetails) && wareHouseModel.updateTotalInventory(warehouse)) {
			JOptionPane.showMessageDialog(this, "Cancel Success");
			fillDataToTable1(outInvoiceDetailsModel.findAlloutinvoicedetails());
		} else {
			JOptionPane.showMessageDialog(this, "Cancel Failed");
		}
	}
	public void jbuttonBackItem_actionPerformed(ActionEvent e) {
		
		OutInvoiceDetailsModel outInvoiceDetailsModel = new OutInvoiceDetailsModel();
		WarehouseModel wareHouseModel = new WarehouseModel();
		Warehouse warehouse = wareHouseModel.findByItemID(outInvoiceDetailsModel.findByID(value).getItemID());
		warehouse.setTotalInventory(warehouse.getTotalInventory() + outInvoiceDetailsModel.findByID(value).getQuantity());
		data.put("item", outInvoiceDetailsModel.findByID(value));
		
			
			
			JFrameInvoiceBack back = new JFrameInvoiceBack(data);
			back.setVisible(true);
			
	
	}
	public void jbuttonRefresh_actionPerformed(ActionEvent e) {
		OutInvoiceDetailsModel outInvoiceDetailsModel = new OutInvoiceDetailsModel();
		String type = jcomboboxInvoice.getSelectedItem().toString();
		if(type.equalsIgnoreCase("All Invoice")) {
			fillDataToTable1(outInvoiceDetailsModel.findAlloutinvoicedetails());
		} else if(type.equalsIgnoreCase("Active Invoice")) {
			fillDataToTable1(outInvoiceDetailsModel.findAlloutinvoicedetailsByStatus(true));
		} else if(type.equalsIgnoreCase("Cancel Invoice")) {
			fillDataToTable1(outInvoiceDetailsModel.findAlloutinvoicedetailsByStatus(false));
		}
	}

}
