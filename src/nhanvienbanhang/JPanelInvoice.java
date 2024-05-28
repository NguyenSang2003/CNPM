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
			JLabel lblNewLabel_1 = new JLabel("Type Invoice: ");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 15));
		JPanel panel_3 = new JPanel();
		add(panel_3);
		panel_3.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
	
		panel_3.add(lblNewLabel_1);
		jcomboboxInvoice.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		jcomboboxInvoice.setMaximumRowCount(15);
		panel_3.add(jcomboboxInvoice);
		jcomboboxInvoice = new JComboBox();
		jcomboboxInvoice.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jcomboboxInvoice_actionPerformed(e);
			}
		});
			JPanel panel_1 = new JPanel();
		add(panel_1);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		jbuttonRefresh = new JButton("Refresh");
		jbuttonRefresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jbuttonRefresh_actionPerformed(e);
			}
		});
		jbuttonRefresh.setIcon(new ImageIcon(JPanelInvoice.class.getResource("/icon/352439_refresh_icon.png")));
		jbuttonRefresh.setFont(new Font("Times New Roman", Font.BOLD, 15));
		panel_3.add(jbuttonRefresh);
		


	
		
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
