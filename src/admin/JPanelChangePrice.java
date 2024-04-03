package admin;

import javax.swing.JPanel;


import javax.swing.BoxLayout;
import javax.swing.ImageIcon;

import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;
import java.awt.BorderLayout;
import java.awt.Component;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import entities.Item;
import models.ItemModel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.ListSelectionModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;
import javax.swing.border.TitledBorder;

public class JPanelChangePrice extends JPanel {
	private JTable jtableItems;
	private JTextField jtextFieldKeyword;
	private JButton jbuttonSearchItem;
	private JTextField jtextFieldChangePrice;
	private JButton jbuttonChange;
	private JButton jbuttonRefresh;
	private String itemID;

	/**
	 * Create the panel.
	 */
	public JPanelChangePrice() {
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(192, 192, 192));
		add(panel);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblNewLabel = new JLabel("Items");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
		panel.add(lblNewLabel);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		add(panel_2);
		panel_2.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblNewLabel_1 = new JLabel("Search:  ");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		panel_2.add(lblNewLabel_1);
		
		jtextFieldKeyword = new JTextField();
		jtextFieldKeyword.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		panel_2.add(jtextFieldKeyword);
		jtextFieldKeyword.setColumns(15);
		
		jbuttonSearchItem = new JButton("Search");
		jbuttonSearchItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jbuttonSearchItem_actionPerformed(e);
			}
		});
		jbuttonSearchItem.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		panel_2.add(jbuttonSearchItem);
		
		jbuttonRefresh = new JButton("Refresh");
		jbuttonRefresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jbuttonRefresh_actionPerformed(e);
			}
		});
		jbuttonRefresh.setIcon(new ImageIcon(JPanelChangePrice.class.getResource("/icon/352439_refresh_icon.png")));
		jbuttonRefresh.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		panel_2.add(jbuttonRefresh);
		
		JPanel panel_1 = new JPanel();
		add(panel_1);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBorder(new TitledBorder(null, "Item Table", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.add(scrollPane, BorderLayout.CENTER);
		
		jtableItems = new JTable();
		jtableItems.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				jtableItems_mouseClicked(e);
			}
		});
		jtableItems.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane.setViewportView(jtableItems);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		add(panel_3);
		panel_3.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblNewLabel_2 = new JLabel("Price: ");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		panel_3.add(lblNewLabel_2);
		
		jtextFieldChangePrice = new JTextField();
		jtextFieldChangePrice.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		panel_3.add(jtextFieldChangePrice);
		jtextFieldChangePrice.setColumns(10);
		
		jbuttonChange = new JButton("Change");
		jbuttonChange.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jbuttonChange_actionPerformed(e);
			}
		});
		jbuttonChange.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		panel_3.add(jbuttonChange);
		initJFrame();
	}
	public void initJFrame() {
		ItemModel itemModel = new ItemModel();
		fillDataToTable(itemModel.findAll());
		
	}
	public void fillDataToTable(List<Item> items) {
		DefaultTableModel defaultTableModel = new DefaultTableModel() {

			@Override
			public boolean isCellEditable(int row, int column) {
				// TODO Auto-generated method stub
				return false;
			}
			
		};
		defaultTableModel.addColumn("itemID");
		defaultTableModel.addColumn("itemName");
		defaultTableModel.addColumn("categoryID");
		
		defaultTableModel.addColumn("price");
		defaultTableModel.addColumn("expiredDate");
		
		
		defaultTableModel.addColumn("image");
		for (Item item : items) {
			defaultTableModel.addRow(new Object[] {
					item.getItemID(), item.getItemName(), item.getCategoryID(),
					 item.getPrice(), item.getExpiredDate(), 
					 item.getImage()
			});
		}
		jtableItems.getTableHeader().setReorderingAllowed(false);;
		jtableItems.setModel(defaultTableModel);
		jtableItems.getColumnModel().getColumn(5).setCellRenderer(new ImageCellRender());
		jtableItems.setRowHeight(60);
	}
	public void jbuttonSearchItem_actionPerformed(ActionEvent e) {
		ItemModel itemModel = new ItemModel();
		String keyword = jtextFieldKeyword.getText();
		fillDataToTable(itemModel.searchByKeyword(keyword));
	}
	private class ImageCellRender extends DefaultTableCellRenderer{

		@Override
		public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
				int row, int column) {
			JLabel jLabel = new JLabel();
			byte[] bytes = (byte[]) value;
			ImageIcon imageIcon=new ImageIcon(new ImageIcon(bytes).getImage().getScaledInstance(40, 40,Image.SCALE_DEFAULT));
			jLabel.setIcon(imageIcon);
			//CHỈNH CHO HÌNH VÀO CHÍNH GIỮA
			jLabel.setHorizontalAlignment(JLabel.CENTER);
			return jLabel;
			
		}
		
	}
	public void jbuttonChange_actionPerformed(ActionEvent e) {
		ItemModel itemModel = new ItemModel();
		Item item = itemModel.findItem(itemID);
		item.setPrice(Double.parseDouble(jtextFieldChangePrice.getText()));
		if(itemModel.update(item)) {
			JOptionPane.showMessageDialog(this, "Change Price Success");
			jtextFieldChangePrice.setText("");
			fillDataToTable(itemModel.findAll());
			
		} else {
			JOptionPane.showMessageDialog(this, "Change Price  Failed", "FAILED", JOptionPane.ERROR_MESSAGE);
		}	
		
	}
	public void jtableItems_mouseClicked(MouseEvent e) {
		int getSelectedRow = jtableItems.getSelectedRow();
		itemID = jtableItems.getValueAt(getSelectedRow, 0).toString();
		jtextFieldChangePrice.setText(jtableItems.getValueAt(getSelectedRow, 3).toString());
		
	}
	public void jbuttonRefresh_actionPerformed(ActionEvent e) {
		ItemModel itemModel = new ItemModel();
		fillDataToTable(itemModel.findAll());
		jtextFieldChangePrice.setText("");
	}

}
