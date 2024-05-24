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
import javax.swing.JTextField;
import com.toedter.calendar.JDateChooser;
import javax.swing.border.TitledBorder;
import java.awt.Color;

public class JPanelInvoice extends JPanel {
	private JTable jtableInvoice;
	private JComboBox jcomboboxInvoice;
	private int value;
	private Map<String, Object> data;
	private JDateChooser jdateChooser;
	private JButton jbuttonSearch;
	private String type;



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
		panel_3.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
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
		
	}
	public void jcomboboxInvoice_actionPerformed(ActionEvent e) {
		OutInvoiceDetailsModel outInvoiceDetailsModel = new OutInvoiceDetailsModel();
		type = jcomboboxInvoice.getSelectedItem().toString();
		if(type.equalsIgnoreCase("All Invoice")) {
			fillDataToTable1(outInvoiceDetailsModel.findAlloutinvoicedetails());
		} else if(type.equalsIgnoreCase("Active Invoice")) {
			fillDataToTable1(outInvoiceDetailsModel.findAlloutinvoicedetailsByStatus(true));
		} else if(type.equalsIgnoreCase("Cancel Invoice")) {
			fillDataToTable1(outInvoiceDetailsModel.findAlloutinvoicedetailsByStatus(false));
		}
	}
	public void jbuttonSearch_actionPerformed(ActionEvent e) {
		type = jcomboboxInvoice.getSelectedItem().toString();
		OutInvoiceDetailsModel outInvoiceDetailsModel = new OutInvoiceDetailsModel();



		fillDataToTable1(outInvoiceDetailsModel.findByDateAll(jdateChooser.getDate()));
		if(type.equalsIgnoreCase("All Invoice")) {
			fillDataToTable1(outInvoiceDetailsModel.findByDateAll(jdateChooser.getDate()));
		} else if(type.equalsIgnoreCase("Active Invoice")) {
			fillDataToTable1(outInvoiceDetailsModel.findByDate(jdateChooser.getDate(), true));
		} else if(type.equalsIgnoreCase("Cancel Invoice")) {
			fillDataToTable1(outInvoiceDetailsModel.findByDate(jdateChooser.getDate(), false));
		}
		
	}
	public void jtableInvoice_mouseClicked(MouseEvent e) {
		
		int selectedRow = jtableInvoice.getSelectedRow();


		
		value = Integer.parseInt(jtableInvoice.getValueAt(selectedRow, 0).toString());
		
	}
	
	

}
