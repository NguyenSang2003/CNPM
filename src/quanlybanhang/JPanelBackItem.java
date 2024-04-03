package quanlybanhang;

import javax.swing.JPanel;

import java.awt.BorderLayout;
import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import entities.OutInvoiceDetails;
import entities.Warehouse;
import entities.WarehouseBackInvoiceDetails;
import models.OutInvoiceDetailsModel;
import models.WarehouseBackInvoiceDetailsModel;
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
import javax.swing.JTextField;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;

public class JPanelBackItem extends JPanel {
	private JTable jtableInvoice;
	private int value;
	private Map<String, Object> data;
	private JDateChooser jdateChooser;
	private JButton jbuttonSearch;
	private String type;
	private JButton jbuttonRefresh;
	private JButton jbuttonTotal;
	private JTextField jtextFieldTotal;

	/**
	 * Create the panel.
	 */
	public JPanelBackItem() {
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(192, 192, 192));
		add(panel);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblNewLabel = new JLabel("Back Item");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
		panel.add(lblNewLabel);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		add(panel_3);
		panel_3.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblNewLabel_2 = new JLabel("Date: ");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 15));
		panel_3.add(lblNewLabel_2);
		
		jdateChooser = new JDateChooser();
		panel_3.add(jdateChooser);
		
		jbuttonSearch = new JButton("Search");
		jbuttonSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jbuttonSearch_actionPerformed(e);
			}
		});
		jbuttonSearch.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		panel_3.add(jbuttonSearch);
		
		jbuttonRefresh = new JButton("Refresh");
		jbuttonRefresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jbuttonRefresh_actionPerformed(e);
			}
		});
		jbuttonRefresh.setIcon(new ImageIcon(JPanelBackItem.class.getResource("/icon/352439_refresh_icon.png")));
		jbuttonRefresh.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		panel_3.add(jbuttonRefresh);
		
		JPanel panel_1 = new JPanel();
		add(panel_1);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Invoice Table", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
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
		
		jbuttonTotal = new JButton("Total");
		jbuttonTotal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jbuttonTotal_actionPerformed(e);
			}
		});
		jbuttonTotal.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		panel_2.add(jbuttonTotal);
		
		jtextFieldTotal = new JTextField();
		jtextFieldTotal.setEditable(false);
		jtextFieldTotal.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		panel_2.add(jtextFieldTotal);
		jtextFieldTotal.setColumns(10);
		initJFrame();
	}
	public JPanelBackItem(Map<String, Object> data) {
		this();
		this.data = data;
		initJFrame();
	}
	public void initJFrame() {
		WarehouseBackInvoiceDetailsModel backInvoiceDetailsModel = new WarehouseBackInvoiceDetailsModel();
		fillDataToTable4(backInvoiceDetailsModel.fillAllwarehousebackinvoicedetails());
		jtextFieldTotal.setText("0");
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
		jtableInvoice.setModel(defaultTableModel);
		jtableInvoice.getTableHeader().setReorderingAllowed(false);
	}
	public void jtableInvoice_mouseClicked(MouseEvent e) {
		
		int selectedRow = jtableInvoice.getSelectedRow();
		value = Integer.parseInt(jtableInvoice.getValueAt(selectedRow, 0).toString());
		
	}
	public void jbuttonSearch_actionPerformed(ActionEvent e) {
		WarehouseBackInvoiceDetailsModel backInvoiceDetailsModel = new WarehouseBackInvoiceDetailsModel();
		
		fillDataToTable4(backInvoiceDetailsModel.findByDate(jdateChooser.getDate()));
		
		
	}
	public void jbuttonRefresh_actionPerformed(ActionEvent e) {
		WarehouseBackInvoiceDetailsModel backInvoiceDetailsModel = new WarehouseBackInvoiceDetailsModel();
		fillDataToTable4(backInvoiceDetailsModel.fillAllwarehousebackinvoicedetails());
		jdateChooser.setDate(null);
		jtextFieldTotal.setText("0");
	}
	public void jbuttonTotal_actionPerformed(ActionEvent e) {
		double total = 0;
		WarehouseBackInvoiceDetailsModel backInvoiceDetailsModel = new WarehouseBackInvoiceDetailsModel();
		if(jdateChooser.getDate() == null) {
			for (WarehouseBackInvoiceDetails warehouseBackInvoiceDetails : backInvoiceDetailsModel.fillAllwarehousebackinvoicedetails()) {
				total+= warehouseBackInvoiceDetails.getQuantity();
			}
			jtextFieldTotal.setText(String.valueOf(total));
		} else {
			for (WarehouseBackInvoiceDetails warehouseBackInvoiceDetails : backInvoiceDetailsModel.findByDate(jdateChooser.getDate())) {
				total+= warehouseBackInvoiceDetails.getQuantity();
			}
			jtextFieldTotal.setText(String.valueOf(total));
		}
		
	}
	

}
