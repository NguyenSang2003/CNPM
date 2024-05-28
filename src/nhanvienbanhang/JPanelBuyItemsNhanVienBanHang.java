package nhanvienbanhang;

import javax.swing.JPanel;
import java.awt.BorderLayout;

import javax.swing.AbstractButton;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import entities.Item;
import entities.OutInvoiceDetails;
import entities.User;
import entities.Warehouse;
import models.ItemModel;
import models.OutInvoiceDetailsModel;
import models.WarehouseModel;

import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.awt.event.ActionEvent;
import javax.swing.ListSelectionModel;
import java.awt.FlowLayout;
import javax.swing.JComboBox;
import com.toedter.calendar.JDateChooser;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;
import javax.swing.border.TitledBorder;
import javax.swing.ImageIcon;

public class JPanelBuyItemsNhanVienBanHang extends JPanel {
	private JTextField jtextFieldKeyword;
	private JTable jtableBuyItems;
	private JButton jbuttonSearchItems;
	private JTextField jtextFieldItemID;
	private JTextField jtextFieldItemName;
	private JTextField jtextFieldPrice;
	private JTextField jtextFieldQuantity;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JButton jbuttonCreateInvoice;
	private JTextField jtextFieldCustomerName;
	private JDateChooser dateChooser;
	private Map<String, Object> data;
	private JTextField jtextFieldUnit;
	private JButton jbuttonRefresh;

	/**
	 * Create the panel.
	 */
	public JPanelBuyItemsNhanVienBanHang() {
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(192, 192, 192));
		add(panel);
		
		JLabel lblNewLabel = new JLabel("Buy Items");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		add(panel_1);
		
		JLabel lblNewLabel_1 = new JLabel("Items Name:  ");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		panel_1.add(lblNewLabel_1);
		
		jtextFieldKeyword = new JTextField();
		jtextFieldKeyword.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		panel_1.add(jtextFieldKeyword);
		jtextFieldKeyword.setColumns(10);
		
		jbuttonSearchItems = new JButton("Search");
		jbuttonSearchItems.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jbuttonSearchItems_actionPerformed(e);
			}
		});
		jbuttonSearchItems.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		panel_1.add(jbuttonSearchItems);
		
		jbuttonRefresh = new JButton("Refresh");
		jbuttonRefresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jbuttonRefresh_actionPerformed(e);
			}
		});
		jbuttonRefresh.setIcon(new ImageIcon(JPanelBuyItemsNhanVienBanHang.class.getResource("/icon/352439_refresh_icon.png")));
		jbuttonRefresh.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		panel_1.add(jbuttonRefresh);
		
		JPanel panel_2 = new JPanel();
		add(panel_2);
		panel_2.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_2.add(scrollPane, BorderLayout.CENTER);
		
		jtableBuyItems = new JTable();
		jtableBuyItems.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				jtableBuyItems_mouseClicked(e);
			}
		});
		jtableBuyItems.addKeyListener(new KeyAdapter() {
			
		});
		jtableBuyItems.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane.setViewportView(jtableBuyItems);
		
		JPanel panel_3 = new JPanel();
		add(panel_3);
		panel_3.setLayout(new BoxLayout(panel_3, BoxLayout.Y_AXIS));
		
		JPanel panel_4 = new JPanel();
		panel_3.add(panel_4);
		panel_4.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblNewLabel_8 = new JLabel("Customer Name: ");
		lblNewLabel_8.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		panel_4.add(lblNewLabel_8);
		
		jtextFieldCustomerName = new JTextField();
		jtextFieldCustomerName.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		panel_4.add(jtextFieldCustomerName);
		jtextFieldCustomerName.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("ItemID:  ");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		panel_4.add(lblNewLabel_2);
		
		jtextFieldItemID = new JTextField();
		jtextFieldItemID.setEditable(false);
		jtextFieldItemID.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		panel_4.add(jtextFieldItemID);
		jtextFieldItemID.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Item Name: ");
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		panel_4.add(lblNewLabel_3);
		
		jtextFieldItemName = new JTextField();
		jtextFieldItemName.setEditable(false);
		jtextFieldItemName.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		panel_4.add(jtextFieldItemName);
		jtextFieldItemName.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Price: ");
		lblNewLabel_4.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		panel_4.add(lblNewLabel_4);
		
		jtextFieldPrice = new JTextField();
		jtextFieldPrice.setEditable(false);
		jtextFieldPrice.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		panel_4.add(jtextFieldPrice);
		jtextFieldPrice.setColumns(10);
		
		JPanel panel_5 = new JPanel();
		panel_3.add(panel_5);
		panel_5.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblNewLabel_5 = new JLabel("Quantity: ");
		lblNewLabel_5.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		panel_5.add(lblNewLabel_5);
		
		jtextFieldQuantity = new JTextField();
		jtextFieldQuantity.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		panel_5.add(jtextFieldQuantity);
		jtextFieldQuantity.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("Payment: ");
		lblNewLabel_6.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		panel_5.add(lblNewLabel_6);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Cash");
		buttonGroup.add(rdbtnNewRadioButton);
		panel_5.add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("Card");
		buttonGroup.add(rdbtnNewRadioButton_1);
		panel_5.add(rdbtnNewRadioButton_1);
		
		JLabel lblNewLabel_7 = new JLabel("Created: ");
		lblNewLabel_7.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		panel_5.add(lblNewLabel_7);
		
		dateChooser = new JDateChooser();
		panel_5.add(dateChooser);
		
		JLabel lblNewLabel_5_1 = new JLabel("Unit:");
		lblNewLabel_5_1.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		panel_5.add(lblNewLabel_5_1);
		
		jtextFieldUnit = new JTextField();
		jtextFieldUnit.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		jtextFieldUnit.setColumns(10);
		panel_5.add(jtextFieldUnit);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_3.add(panel_6);
		panel_6.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		jbuttonCreateInvoice = new JButton("Create Invoice");
		jbuttonCreateInvoice.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jbuttonCreateInvoice_actionPerformed(e);
			}
		});
		jbuttonCreateInvoice.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		panel_6.add(jbuttonCreateInvoice);
		initJFrame();
	}
	
			
		};
		defaultTableModel.addColumn("itemID");
		defaultTableModel.addColumn("itemName");
		defaultTableModel.addColumn("price");
		defaultTableModel.addColumn("expiredDate");
		for(Item item : items) {
			defaultTableModel.addRow(new Object[] {
					item.getItemID(), item.getItemName(),item.getPrice(), item.getExpiredDate()
			});
		}
		jtableBuyItems.getTableHeader().setReorderingAllowed(false);
		jtableBuyItems.setModel(defaultTableModel);
		jtableBuyItems.setRowHeight(60);
	}
	public void jbuttonCreateInvoice_actionPerformed(ActionEvent e) {
		OutInvoiceDetailsModel outInvoiceDetailsModel = new OutInvoiceDetailsModel();
		WarehouseModel wareHouseModel = new WarehouseModel();
		Warehouse warehouse = wareHouseModel.findByItemID(jtextFieldItemID.getText());
		OutInvoiceDetails outInvoiceDetails = new OutInvoiceDetails();
		outInvoiceDetails.setCustomerName(jtextFieldCustomerName.getText());
		outInvoiceDetails.setCreated(dateChooser.getDate());
		outInvoiceDetails.setItemID(jtextFieldItemID.getText());
		outInvoiceDetails.setItemName(jtextFieldItemName.getText());
		outInvoiceDetails.setPrice(Double.parseDouble(jtextFieldPrice.getText()));
		outInvoiceDetails.setQuantity(Integer.parseInt(jtextFieldQuantity.getText()));
		outInvoiceDetails.setTotal(Double.parseDouble(jtextFieldPrice.getText())*Double.parseDouble(jtextFieldQuantity.getText()));
		outInvoiceDetails.setStatus(true);
		outInvoiceDetails.setPayment(getElementSelected(buttonGroup));
		User user = (User) data.get("user");
		outInvoiceDetails.setUserID(user.getUserID());
		outInvoiceDetails.setUnit(jtextFieldUnit.getText());
		warehouse.setTotalInventory(warehouse.getTotalInventory() - Integer.parseInt(jtextFieldQuantity.getText()));
		if(outInvoiceDetailsModel.createInvoice(outInvoiceDetails) && wareHouseModel.updateTotalInventory(warehouse)) {
			
			JOptionPane.showMessageDialog(this, "Create Success");
			
			
		} else {
			JOptionPane.showMessageDialog(this, "Create failed", "FAILED", JOptionPane.ERROR_MESSAGE);
		}
		
		
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
	public void jbuttonRefresh_actionPerformed(ActionEvent e) {
		ItemModel itemModels = new ItemModel();
		fillDataToTable(itemModels.findAll());
		jtextFieldKeyword.setText("");
		jtextFieldItemID.setText("");
		jtextFieldPrice.setText("");
		jtextFieldItemName.setText("");
		jtextFieldUnit.setText("");
	}
	
	
}
