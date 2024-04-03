package quanlikho;

import javax.swing.JPanel;
import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.FlowLayout;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import com.toedter.calendar.JDateChooser;

import admin.JPanelCreateItem.CellRender;
import entities.Item;
import entities.User;
import entities.Warehouse;
import entities.WarehouseInInvoiceDetails;
import models.ItemModel;
import models.WarehouseInInvoiceDetailsModel;
import models.WarehouseModel;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Map;
import java.awt.event.ActionEvent;
import java.awt.BorderLayout;
import java.awt.Component;

public class JPanelWarehouseInInvoice extends JPanel {
	private JTextField jtextFieldQuantity;
	private JTextField jtextFiledprice;
	private JTextField jtextFieldManufactured;
	private JTextField jtextFiledunit;
	private JTextField jtextFielduserID;
	private Map<String, Object> data;
	private JButton jbuttonCreate;
	private JComboBox jcomboBoxItemID;
	private JDateChooser jdateChooserDatein;

	/**
	 * Create the panel.
	 */
	public JPanelWarehouseInInvoice() {
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		JPanel panel = new JPanel();
		add(panel);
		
		JLabel lblNewLabel = new JLabel("Warehouse In Invoice");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
		panel.add(lblNewLabel);
		
		JPanel panel_7 = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel_7.getLayout();
		flowLayout.setVgap(10);
		add(panel_7);
		
		JLabel lblNewLabel_8 = new JLabel("userID: ");
		lblNewLabel_8.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		panel_7.add(lblNewLabel_8);
		
		jtextFielduserID = new JTextField();
		jtextFielduserID.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		jtextFielduserID.setEditable(false);
		panel_7.add(jtextFielduserID);
		jtextFielduserID.setColumns(10);
		
		JPanel panel_1 = new JPanel();
		add(panel_1);
		panel_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 10));
		
		JLabel lblNewLabel_1 = new JLabel("ItemID: ");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		panel_1.add(lblNewLabel_1);
		
		jcomboBoxItemID = new JComboBox();
		jcomboBoxItemID.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jcomboBoxItemID_actionPerformed(e);
			}
		});
		jcomboBoxItemID.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		panel_1.add(jcomboBoxItemID);
		
		JPanel panel_2 = new JPanel();
		FlowLayout flowLayout_1 = (FlowLayout) panel_2.getLayout();
		flowLayout_1.setVgap(10);
		add(panel_2);
		
		JLabel lblNewLabel_2 = new JLabel("Quantity: ");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		panel_2.add(lblNewLabel_2);
		
		jtextFieldQuantity = new JTextField();
		jtextFieldQuantity.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		panel_2.add(jtextFieldQuantity);
		jtextFieldQuantity.setColumns(10);
		
		JPanel panel_3 = new JPanel();
		FlowLayout flowLayout_2 = (FlowLayout) panel_3.getLayout();
		flowLayout_2.setVgap(10);
		add(panel_3);
		
		JLabel lblNewLabel_3 = new JLabel("Price: ");
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		panel_3.add(lblNewLabel_3);
		
		jtextFiledprice = new JTextField();
		jtextFiledprice.setEditable(false);
		jtextFiledprice.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel_3.add(jtextFiledprice);
		jtextFiledprice.setColumns(10);
		
		JPanel panel_4 = new JPanel();
		FlowLayout flowLayout_3 = (FlowLayout) panel_4.getLayout();
		flowLayout_3.setVgap(10);
		add(panel_4);
		
		JLabel lblNewLabel_4 = new JLabel("dateIn: ");
		lblNewLabel_4.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		panel_4.add(lblNewLabel_4);
		
		jdateChooserDatein = new JDateChooser();
		panel_4.add(jdateChooserDatein);
		
		JPanel panel_5 = new JPanel();
		FlowLayout flowLayout_4 = (FlowLayout) panel_5.getLayout();
		flowLayout_4.setVgap(10);
		add(panel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Manufactured: ");
		lblNewLabel_6.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		panel_5.add(lblNewLabel_6);
		
		jtextFieldManufactured = new JTextField();
		jtextFieldManufactured.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		panel_5.add(jtextFieldManufactured);
		jtextFieldManufactured.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		panel_5.add(lblNewLabel_5);
		
		JPanel panel_6 = new JPanel();
		FlowLayout flowLayout_5 = (FlowLayout) panel_6.getLayout();
		flowLayout_5.setVgap(10);
		add(panel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Unit: ");
		lblNewLabel_7.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		panel_6.add(lblNewLabel_7);
		
		jtextFiledunit = new JTextField();
		jtextFiledunit.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		jtextFiledunit.setEditable(false);
		panel_6.add(jtextFiledunit);
		jtextFiledunit.setColumns(10);
		
		JPanel panel_8 = new JPanel();
		FlowLayout flowLayout_6 = (FlowLayout) panel_8.getLayout();
		flowLayout_6.setVgap(10);
		add(panel_8);
		
		jbuttonCreate = new JButton("Create");
		jbuttonCreate.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		jbuttonCreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 jbuttonCreate_actionPerformed(e);
			}
		});
		panel_8.add(jbuttonCreate);
		
		JPanel panel_9 = new JPanel();
		add(panel_9);
		panel_9.setLayout(new BorderLayout(0, 0));

	}
	public JPanelWarehouseInInvoice(Map<String, Object> data) {
		this();
		this.data = data;
		initJFrame();
	}
	public void jbuttonCreate_actionPerformed(ActionEvent e) {
		User user=(User) data.get("user");
		Item item=(Item) jcomboBoxItemID.getSelectedItem();
		WarehouseModel model = new WarehouseModel();
		WarehouseInInvoiceDetails details=new WarehouseInInvoiceDetails();
		WarehouseInInvoiceDetailsModel detailsModel=new WarehouseInInvoiceDetailsModel();
		details.setItemID(item.getItemID());
		details.setDateIn(jdateChooserDatein.getDate());
		details.setStatus(true);
		details.setManufactureID(jtextFieldManufactured.getText());
		details.setQuantity(Integer.parseInt(jtextFieldQuantity.getText()));
		details.setPrice(Double.parseDouble(jtextFiledprice.getText()));
		details.setTotal(Integer.parseInt(jtextFieldQuantity.getText())*Double.parseDouble(jtextFiledprice.getText()));
		details.setUserID(user.getUserID());
		details.setUnit(jtextFiledunit.getText());
		Warehouse warehouse = model.findByItemID(item.getItemID());
		warehouse.setTotalInventory(warehouse.getTotalInventory() + Integer.parseInt(jtextFieldQuantity.getText()));
		if(detailsModel.create(details) && model.updateTotalInventory(warehouse))
		{
			JOptionPane.showMessageDialog(this, "Created Success");
			jtextFieldManufactured.setText("");
			jtextFieldQuantity.setText("");
			jdateChooserDatein.setDate(null);
			
		} else {
			JOptionPane.showMessageDialog(this, "Created Failed", "FAILED", JOptionPane.ERROR_MESSAGE);
		}
		
	}
	public void initJFrame() {
		User user=(User) data.get("user");
		jtextFielduserID.setText(user.getUserID());
		
		DefaultComboBoxModel<Item>itemS=new DefaultComboBoxModel<Item>();
		ItemModel itemModel=new ItemModel();
		for(Item item:itemModel.findAll())
		{
			itemS.addElement(item);;
			
		}
		jcomboBoxItemID.setModel(itemS);
		jcomboBoxItemID.setRenderer(new CellRender());
		Item item=(Item) jcomboBoxItemID.getSelectedItem();
		jtextFiledprice.setText(String.valueOf(item.getPrice()));
		jtextFiledunit.setText(item.getUnit());
		WarehouseInInvoiceDetails details=new WarehouseInInvoiceDetails();
		
	}
	public class CellRender extends DefaultListCellRenderer
	{

		@Override
		public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected,
				boolean cellHasFocus) {
			Item items=(Item)value;
			return super.getListCellRendererComponent(list, items.getItemID()+" - "+items.getItemName(), index, isSelected, cellHasFocus);
		}
		
	}
	public void jcomboBoxItemID_actionPerformed(ActionEvent e) {
		Item item=(Item) jcomboBoxItemID.getSelectedItem();
		jtextFiledprice.setText(String.valueOf(item.getPrice()));
		jtextFiledunit.setText(item.getUnit());
		
	}

}
