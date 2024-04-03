package nhanvienbanhang;

import javax.swing.JPanel;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;

import java.awt.FlowLayout;
import javax.swing.JLabel;
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
import javax.swing.border.TitledBorder;
import java.awt.Color;
import javax.swing.border.EtchedBorder;

public class JPanelItemNhanVienBanHang extends JPanel {
	private JTable jtableItems;
	private JTextField jtextFieldKeyword;
	private JButton jbuttonSearchItem;
	private JButton jbuttonRefresh;

	/**
	 * Create the panel.
	 */
	public JPanelItemNhanVienBanHang() {
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(192, 192, 192));
		add(panel);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblNewLabel = new JLabel("Items");
		lblNewLabel.setBackground(new Color(0, 0, 0));
		lblNewLabel.setForeground(new Color(0, 0, 0));
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
		panel.add(lblNewLabel);
		
		JPanel panel_2 = new JPanel();
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
		jbuttonRefresh.setIcon(new ImageIcon(JPanelItemNhanVienBanHang.class.getResource("/icon/352439_refresh_icon.png")));
		jbuttonRefresh.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		panel_2.add(jbuttonRefresh);
		
		JPanel panel_1 = new JPanel();
		add(panel_1);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBorder(new TitledBorder(null, "Item Table", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.add(scrollPane, BorderLayout.CENTER);
		
		jtableItems = new JTable();
		jtableItems.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane.setViewportView(jtableItems);
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
		
		defaultTableModel.addColumn("review");
		defaultTableModel.addColumn("unit");
		defaultTableModel.addColumn("image");
		for (Item item : items) {
			defaultTableModel.addRow(new Object[] {
					item.getItemID(), item.getItemName(), item.getCategoryID(), 
					 item.getPrice(), item.getExpiredDate(), 
					item.getReview(), item.getUnit(), item.getImage()
			});
		}
		jtableItems.getTableHeader().setReorderingAllowed(false);;
		jtableItems.setModel(defaultTableModel);
		jtableItems.getColumnModel().getColumn(7).setCellRenderer(new ImageCellRender());
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
	public void jbuttonRefresh_actionPerformed(ActionEvent e) {
		ItemModel itemModel = new ItemModel();
		fillDataToTable(itemModel.findAll());
		jtextFieldKeyword.setText("");
	}

}
