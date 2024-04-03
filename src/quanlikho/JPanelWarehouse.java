package quanlikho;

import javax.swing.JPanel;
import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;

import java.awt.FlowLayout;
import javax.swing.JLabel;
import java.awt.Font;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.swing.JComboBox;
import com.toedter.calendar.JDateChooser;

import entities.OutInvoiceDetails;
import entities.User;
import entities.WarehouseBackInvoiceDetails;
import entities.WarehouseInInvoiceDetails;
import models.OutInvoiceDetailsModel;
import models.UserModel;
import models.WarehouseBackInvoiceDetailsModel;
import models.WarehouseInInvoiceDetailsModel;

import java.awt.BorderLayout;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ListSelectionModel;
import javax.swing.JButton;
import javax.swing.ImageIcon;

public class JPanelWarehouse extends JPanel {
	private JComboBox jcomboBoxTypeWarehouse;
	private JComboBox jcomboBoxShift;
	private JTable jtableWarehouse;
	private JButton jbuttonSearch;
	private JDateChooser jdateChooser;
	private JButton jbuttonRefresh;

	/**
	 * Create the panel.
	 */
	public JPanelWarehouse() {
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		JPanel panel = new JPanel();
		add(panel);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblNewLabel = new JLabel("Warehouse Invoice");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		add(panel_1);
		panel_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel aa = new JLabel("Type Invoice:");
		aa.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		panel_1.add(aa);
		
		jcomboBoxTypeWarehouse = new JComboBox();
		jcomboBoxTypeWarehouse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jcomboBoxTypeWarehouse_actionPerformed(e);
			}
		});
		panel_1.add(jcomboBoxTypeWarehouse);
		
		JLabel lblNewLabel_1 = new JLabel("Shift:");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		panel_1.add(lblNewLabel_1);
		
		jcomboBoxShift = new JComboBox();
		jcomboBoxShift.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jcomboBoxShift_actionPerformed(e);
			}
		});
		panel_1.add(jcomboBoxShift);
		
		JLabel lblNewLabel_2 = new JLabel("Date: ");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		panel_1.add(lblNewLabel_2);
		
		jdateChooser = new JDateChooser();
		panel_1.add(jdateChooser);
		
		jbuttonSearch = new JButton("Search");
		jbuttonSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jbuttonSearch_actionPerformed(e);
			}
		});
		jbuttonSearch.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		panel_1.add(jbuttonSearch);
		
		jbuttonRefresh = new JButton("");
		jbuttonRefresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jbuttonRefresh_actionPerformed(e);
			}
		});
		jbuttonRefresh.setIcon(new ImageIcon(JPanelWarehouse.class.getResource("/icon/352439_refresh_icon.png")));
		jbuttonRefresh.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		panel_1.add(jbuttonRefresh);
		
		JPanel panel_2 = new JPanel();
		add(panel_2);
		panel_2.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBorder(new TitledBorder(null, "Warehouse Invoice", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_2.add(scrollPane, BorderLayout.CENTER);
		
		jtableWarehouse = new JTable();
		jtableWarehouse.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane.setViewportView(jtableWarehouse);
		initJFrame();
		
	}

	private void initJFrame() {
		
		DefaultComboBoxModel<String> defaultComboBoxModel = new DefaultComboBoxModel<String>();
		defaultComboBoxModel.addElement("Warehouse Out Invoice");
		defaultComboBoxModel.addElement("Warehouse Back Item Invoice");
		defaultComboBoxModel.addElement("Warehouse In Invoice");
		
		jcomboBoxTypeWarehouse.setModel(defaultComboBoxModel);
		DefaultComboBoxModel<String> defaultComboBoxModel1 = new DefaultComboBoxModel<String>();
		defaultComboBoxModel1.addElement("All");
		defaultComboBoxModel1.addElement("Morning");
		defaultComboBoxModel1.addElement("Afternoon");
		defaultComboBoxModel1.addElement("Night");
		jcomboBoxShift.setModel(defaultComboBoxModel1);
		OutInvoiceDetailsModel outInvoiceDetailsModel = new OutInvoiceDetailsModel();
		fillDataToTable1(outInvoiceDetailsModel.findAlloutinvoicedetailsByStatus(true));
		
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
		jtableWarehouse.setModel(defaultTableModel);
		jtableWarehouse.getTableHeader().setReorderingAllowed(false);
		
	}
	private void fillDataToTable5(List<WarehouseInInvoiceDetails> warehouses) {
		SimpleDateFormat simpleDateFormat=new SimpleDateFormat("dd/MM/yyyy");
		DefaultTableModel defaultTableModel=new DefaultTableModel() {

			@Override
			public boolean isCellEditable(int row, int column) {
				// TODO Auto-generated method stub
				return false;
			}
			
		};
		defaultTableModel.addColumn("ID");
		defaultTableModel.addColumn("itemID");
		defaultTableModel.addColumn("quantity");
		defaultTableModel.addColumn("price");
		defaultTableModel.addColumn("total");
		defaultTableModel.addColumn("dateIn");
		defaultTableModel.addColumn("manufactureID");
		defaultTableModel.addColumn("unit");
		defaultTableModel.addColumn("userID");
		defaultTableModel.addColumn("status");
	
		for(WarehouseInInvoiceDetails Warehouse:warehouses) {
			defaultTableModel.addRow(new Object[] {
			Warehouse.getID(),Warehouse.getItemID(),Warehouse.getQuantity(),Warehouse.getPrice(),Warehouse.getTotal(),Warehouse.getDateIn(),Warehouse.getManufactureID(),Warehouse.getUnit(),Warehouse.getUserID(),Warehouse.isStatus()
			});
			
		}
		jtableWarehouse.setModel(defaultTableModel);
		jtableWarehouse.getTableHeader().setReorderingAllowed(false);
	}
	private void fillDataToTable4(List<WarehouseBackInvoiceDetails> warehouses) {
		SimpleDateFormat simpleDateFormat=new SimpleDateFormat("dd/MM/yyyy");
		DefaultTableModel defaultTableModel=new DefaultTableModel() {
			@Override
			public boolean isCellEditable(int row, int column) {
				// TODO Auto-generated method stub
				return false;
			}
		};
		defaultTableModel.addColumn("ID");
		defaultTableModel.addColumn("itemID");
		defaultTableModel.addColumn("quantity");
		defaultTableModel.addColumn("feedback");
		defaultTableModel.addColumn("date");
		defaultTableModel.addColumn("userID");
	
		for(WarehouseBackInvoiceDetails Warehouse:warehouses) {
			defaultTableModel.addRow(new Object[] {
			Warehouse.getID(),Warehouse.getItemID(),Warehouse.getQuantity(),Warehouse.getFeedback(),Warehouse.getDate(),Warehouse.getUserID()
			});
			
		}
		jtableWarehouse.setModel(defaultTableModel);
		jtableWarehouse.getTableHeader().setReorderingAllowed(false);
	}
	public void jcomboBoxTypeWarehouse_actionPerformed(ActionEvent e) {
		OutInvoiceDetailsModel outInvoiceDetailsModel = new OutInvoiceDetailsModel();
		UserModel userModel = new UserModel();
		WarehouseInInvoiceDetailsModel warehouseInInvoiceDetailsModel = new WarehouseInInvoiceDetailsModel();
		WarehouseBackInvoiceDetailsModel backInvoiceDetailsModel = new WarehouseBackInvoiceDetailsModel();
		if(jcomboBoxTypeWarehouse.getSelectedItem().toString().equalsIgnoreCase("Warehouse Out Invoice")){
			jcomboBoxShift.setEnabled(true);
			jcomboBoxShift.setSelectedItem("All");
			fillDataToTable1(outInvoiceDetailsModel.findAlloutinvoicedetailsByStatus(true));
			jdateChooser.setDate(null);
			
		} else if(jcomboBoxTypeWarehouse.getSelectedItem().toString().equalsIgnoreCase("Warehouse In Invoice")) {
			jcomboBoxShift.setEnabled(false);
			jcomboBoxShift.setSelectedItem("All");
			jdateChooser.setDate(null);
			fillDataToTable5(warehouseInInvoiceDetailsModel.warehouseInInvoiceDetails());
		} else {
			jcomboBoxShift.setEnabled(true);
			jcomboBoxShift.setSelectedItem("All");
			jdateChooser.setDate(null);
			fillDataToTable4(backInvoiceDetailsModel.fillAllwarehousebackinvoicedetails());
			
		}
	
	}
	public void jcomboBoxShift_actionPerformed(ActionEvent e) {
		OutInvoiceDetailsModel outInvoiceDetailsModel = new OutInvoiceDetailsModel();
		UserModel userModel = new UserModel();
		
		WarehouseInInvoiceDetailsModel warehouseInInvoiceDetailsModel = new WarehouseInInvoiceDetailsModel();
		WarehouseBackInvoiceDetailsModel backInvoiceDetailsModel = new WarehouseBackInvoiceDetailsModel();
		if(jcomboBoxTypeWarehouse.getSelectedItem().toString().equalsIgnoreCase("Warehouse Out Invoice")){
			fillDataToTable1(outInvoiceDetailsModel.findAlloutinvoicedetails());
			if(jcomboBoxShift.getSelectedItem().toString().equalsIgnoreCase("All")) {
				fillDataToTable1(outInvoiceDetailsModel.findAlloutinvoicedetailsByStatus(true));
				jdateChooser.setDate(null);
			}else if(jcomboBoxShift.getSelectedItem().toString().equalsIgnoreCase("Morning")) {
				fillDataToTable1(outInvoiceDetailsModel.findByShift(userModel.findUser("Morning").getUserID()));
				jdateChooser.setDate(null);
			} else if(jcomboBoxShift.getSelectedItem().toString().equalsIgnoreCase("Night")) {
				fillDataToTable1(outInvoiceDetailsModel.findByShift(userModel.findUser("Night").getUserID()));
				jdateChooser.setDate(null);
			} else if(jcomboBoxShift.getSelectedItem().toString().equalsIgnoreCase("Afternoon")){
				fillDataToTable1(outInvoiceDetailsModel.findByShift(userModel.findUser("chieu").getUserID()));
				jdateChooser.setDate(null);
			}
		} else if(jcomboBoxTypeWarehouse.getSelectedItem().toString().equalsIgnoreCase("Warehouse Back Item Invoice")) {
			fillDataToTable4(backInvoiceDetailsModel.fillAllwarehousebackinvoicedetails());
			if(jcomboBoxShift.getSelectedItem().toString().equalsIgnoreCase("All")) {
				fillDataToTable4(backInvoiceDetailsModel.fillAllwarehousebackinvoicedetails());
				jdateChooser.setDate(null);
			} else if(jcomboBoxShift.getSelectedItem().toString().equalsIgnoreCase("Morning")) {
				fillDataToTable4(backInvoiceDetailsModel.findByShift(userModel.findUser("Morning").getUserID()));
				jdateChooser.setDate(null);
			} else if(jcomboBoxShift.getSelectedItem().toString().equalsIgnoreCase("Afternoon")) {
				fillDataToTable4(backInvoiceDetailsModel.findByShift(userModel.findUser("chieu").getUserID()));
				jdateChooser.setDate(null);
			} else if(jcomboBoxShift.getSelectedItem().toString().equalsIgnoreCase("Night")) {
				fillDataToTable4(backInvoiceDetailsModel.findByShift(userModel.findUser("Night").getUserID()));
				jdateChooser.setDate(null);
			}
		} 
	}
	public void jbuttonSearch_actionPerformed(ActionEvent e) {
		OutInvoiceDetailsModel outInvoiceDetailsModel = new OutInvoiceDetailsModel();
		UserModel userModel = new UserModel();
		
		WarehouseInInvoiceDetailsModel warehouseInInvoiceDetailsModel = new WarehouseInInvoiceDetailsModel();
		WarehouseBackInvoiceDetailsModel backInvoiceDetailsModel = new WarehouseBackInvoiceDetailsModel();
		if(jcomboBoxTypeWarehouse.getSelectedItem().toString().equalsIgnoreCase("Warehouse Out Invoice")){
			if(jcomboBoxShift.getSelectedItem().toString().equalsIgnoreCase("All")) {
				fillDataToTable1(outInvoiceDetailsModel.findByDate(jdateChooser.getDate(), true));
			} else if(jcomboBoxShift.getSelectedItem().toString().equalsIgnoreCase("Morning")) {
				fillDataToTable1(outInvoiceDetailsModel.findByShiftAndDate(userModel.findUser("Morning").getUserID(), jdateChooser.getDate()));
			} else if(jcomboBoxShift.getSelectedItem().toString().equalsIgnoreCase("Afternoon")) {
				fillDataToTable1(outInvoiceDetailsModel.findByShiftAndDate(userModel.findUser("chieu").getUserID(), jdateChooser.getDate()));
			} else if(jcomboBoxShift.getSelectedItem().toString().equalsIgnoreCase("Night")) {
				fillDataToTable1(outInvoiceDetailsModel.findByShiftAndDate(userModel.findUser("Night").getUserID(), jdateChooser.getDate()));
			}
		} else if(jcomboBoxTypeWarehouse.getSelectedItem().toString().equalsIgnoreCase("Warehouse Back Item Invoice")) {
			fillDataToTable4(backInvoiceDetailsModel.fillAllwarehousebackinvoicedetails());
			if(jcomboBoxShift.getSelectedItem().toString().equalsIgnoreCase("All")) {
				fillDataToTable4(backInvoiceDetailsModel.findByDate(jdateChooser.getDate()));
			} else if(jcomboBoxShift.getSelectedItem().toString().equalsIgnoreCase("Morning")) {
				fillDataToTable4(backInvoiceDetailsModel.findByShiftAndDate(userModel.findUser("Morning").getUserID(), jdateChooser.getDate()));
			} else if(jcomboBoxShift.getSelectedItem().toString().equalsIgnoreCase("Afternoon")) {
				fillDataToTable4(backInvoiceDetailsModel.findByShiftAndDate(userModel.findUser("chieu").getUserID(), jdateChooser.getDate()));
			} else if(jcomboBoxShift.getSelectedItem().toString().equalsIgnoreCase("Night")) {
				fillDataToTable4(backInvoiceDetailsModel.findByShiftAndDate(userModel.findUser("Night").getUserID(), jdateChooser.getDate()));
			}
		} else {
			fillDataToTable5(warehouseInInvoiceDetailsModel.findByDate(jdateChooser.getDate()));
		}
	}
	public void jbuttonRefresh_actionPerformed(ActionEvent e) {
		initJFrame();
	}
	

}
