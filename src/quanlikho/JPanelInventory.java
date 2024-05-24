package quanlikho;

import javax.swing.JPanel;
import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JLabel;
import javax.swing.JList;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.FlowLayout;
import javax.swing.JComboBox;
import javax.swing.JComponent;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;



import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import entities.Category;
import entities.Item;
import entities.Warehouse;
import models.CategoryModel;
import models.ConnectDB;
import models.WarehouseModel;

import java.awt.event.ActionListener;
import java.awt.geom.Area;
import java.awt.geom.Ellipse2D;
import java.sql.PreparedStatement;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JSlider;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;

public class JPanelInventory extends JPanel {
	private JComboBox jcomboBoxCategory;
	private JTable jtableInventory;
	private JSlider jslider;
	private JTextField jtextFieldPrice;
	private JButton jbuttonRefresh;

	/**
	 * Create the panel.
	 */
	public JPanelInventory() {
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		JPanel panel = new JPanel();
		add(panel);
		
		JLabel lblNewLabel = new JLabel("Inventory By Category");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
		panel.add(lblNewLabel);
		



		JPanel panel_1 = new JPanel();
		add(panel_1);
		panel_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblNewLabel_1 = new JLabel("Category: ");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		panel_1.add(lblNewLabel_1);
		
		jcomboBoxCategory = new JComboBox();
		jcomboBoxCategory.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jcomboBoxCategory_actionPerformed(e);
			}
		});
		jcomboBoxCategory.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		panel_1.add(jcomboBoxCategory);
		
		jslider = new JSlider();
		jslider.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		jslider.setValue(100);
		jslider.setMinorTickSpacing(25);
		jslider.setMaximum(500);
		jslider.setToolTipText("");
		jslider.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				jslider_stateChanged(e);
			}
		});
		



		JLabel lblNewLabel_2 = new JLabel("0\r\n");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		panel_1.add(lblNewLabel_2);
		panel_1.add(jslider);
		
		JLabel lblNewLabel_3 = new JLabel("500");
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		panel_1.add(lblNewLabel_3);
		
		jtextFieldPrice = new JTextField();
		jtextFieldPrice.setEditable(false);
		panel_1.add(jtextFieldPrice);
		jtextFieldPrice.setColumns(10);
		
		jbuttonRefresh = new JButton("Refresh");
		jbuttonRefresh.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		jbuttonRefresh.setIcon(new ImageIcon(JPanelInventory.class.getResource("/icon/352439_refresh_icon.png")));
		jbuttonRefresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jbuttonRefresh_actionPerformed(e);
			}
		});
		panel_1.add(jbuttonRefresh);
		
		JPanel panel_2 = new JPanel();
		add(panel_2);
		panel_2.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBorder(new TitledBorder(null, "Warehouse Table", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_2.add(scrollPane, BorderLayout.CENTER);
		
		jtableInventory = new JTable();
		scrollPane.setViewportView(jtableInventory);
		initJFrame();
	}
	private void initJFrame() {
		CategoryModel categoryModel = new CategoryModel();
		DefaultComboBoxModel<Category> defaultComboBoxModel = new DefaultComboBoxModel<Category>();
		WarehouseModel warehouseModel = new WarehouseModel();
		for (Category categories : categoryModel.findAll()) {
			defaultComboBoxModel.addElement(categories);
		}
		jcomboBoxCategory.setModel(defaultComboBoxModel);
		jcomboBoxCategory.setRenderer(new CellRender());
		
			fillDataToTable3(warehouseModel.findAll());
			
		jtextFieldPrice.setText("< " + String.valueOf(jslider.getValue()));
		jslider.setValue(500);
		
	}
	public class CellRender extends DefaultListCellRenderer
	{

		@Override
		public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected,
				boolean cellHasFocus) {
			Category category=(Category)value;
			return super.getListCellRendererComponent(list, category.getCategoryName(), index, isSelected, cellHasFocus);
		}
		
	}

	private void fillDataToTable3(List<Warehouse> warehouses) {
		
		DefaultTableModel defaultTableModel=new DefaultTableModel() {

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
		defaultTableModel.addColumn("status	");
		defaultTableModel.addColumn("totalInventory");
	
		for(Warehouse Warehouse:warehouses) {
			defaultTableModel.addRow(new Object[] {
				Warehouse.getID(),Warehouse.getItemID(),Warehouse.getItemName(),Warehouse.getDateAdded(),Warehouse.isStatus(),Warehouse.getTotalInventory()
			});
			
		}
		jtableInventory.setModel(defaultTableModel);
		jtableInventory.getTableHeader().setReorderingAllowed(false);
	}
		public void jcomboBoxCategory_actionPerformed(ActionEvent e) {
		WarehouseModel warehouseModel = new WarehouseModel();
		Category category = (Category) jcomboBoxCategory.getSelectedItem();
		if(category.getCategoryName().equalsIgnoreCase("all")) {
			fillDataToTable3(warehouseModel.findAll());
		} else {
			fillDataToTable3(warehouseModel.inventory(category.getCategoryName()));
		}
		
	}
	public void jbuttonRefresh_actionPerformed(ActionEvent e) {
		initJFrame();
	}
	public void jslider_stateChanged(ChangeEvent e) {
		WarehouseModel warehouseModel = new  WarehouseModel();
		CategoryModel categoryModel = new CategoryModel();
		jcomboBoxCategory.setSelectedItem(categoryModel.findAll().get(0).toString());;
		System.out.println(jslider.getValue());
		jtextFieldPrice.setText("< " + String.valueOf(jslider.getValue()));
		fillDataToTable3(warehouseModel.totalInventory(jslider.getValue()));
	}
	
}
