package admin;

import javax.swing.JPanel;
import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;

import com.toedter.calendar.JDateChooser;

import entities.Category;
import entities.Item;
import entities.Warehouse;
import models.CategoryModel;
import models.ItemModel;
import models.WarehouseModel;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.JButton;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class JPanelCreateItem extends JPanel {
	private JTextField jtextFieldItemID;
	private JTextField jtextFieldItemName;
	private JTextField jtextFieldPrice;
	private JTextField jtextFieldReview;
	private JTextField jtextFieldUnit;
	private JButton jbuttonCreateItem;
	private JComboBox jcomboBoxCategoryID;
	private JLabel jLabelImage;
	private JDateChooser jdateChooser;
	private JButton jbuttonBrowse;
	private File file;

	/**
	 * Create the panel.
	 */
	public JPanelCreateItem() {
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(192, 192, 192));
		add(panel);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblNewLabel = new JLabel("Create new item");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		add(panel_1);
		panel_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 10));
		
		JLabel lblNewLabel_1 = new JLabel("ItemID:        ");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		panel_1.add(lblNewLabel_1);
		
		jtextFieldItemID = new JTextField();
		jtextFieldItemID.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		panel_1.add(jtextFieldItemID);
		jtextFieldItemID.setColumns(10);
		
		JPanel panel_2 = new JPanel();
		add(panel_2);
		panel_2.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 10));
		
		JLabel lblNewLabel_1_1 = new JLabel("ItemName:     ");
		lblNewLabel_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		panel_2.add(lblNewLabel_1_1);
		
		jtextFieldItemName = new JTextField();
		jtextFieldItemName.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		jtextFieldItemName.setColumns(10);
		panel_2.add(jtextFieldItemName);
		
		JPanel panel_3 = new JPanel();
		add(panel_3);
		panel_3.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 10));
		
		JLabel lblNewLabel_1_1_1 = new JLabel("CategoryID:    ");
		lblNewLabel_1_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		panel_3.add(lblNewLabel_1_1_1);
		
		jcomboBoxCategoryID = new JComboBox();
		jcomboBoxCategoryID.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		panel_3.add(jcomboBoxCategoryID);
		
		JPanel panel_4 = new JPanel();
		add(panel_4);
		panel_4.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 10));
		
		JLabel lblNewLabel_1_1_2 = new JLabel("Price:           ");
		lblNewLabel_1_1_2.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		panel_4.add(lblNewLabel_1_1_2);
		
		jtextFieldPrice = new JTextField();
		jtextFieldPrice.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		jtextFieldPrice.setColumns(10);
		panel_4.add(jtextFieldPrice);
		
		JPanel panel_5 = new JPanel();
		add(panel_5);
		panel_5.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 10));
		
		JLabel lblNewLabel_1_1_2_1 = new JLabel("ExpiredDate:");
		lblNewLabel_1_1_2_1.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		panel_5.add(lblNewLabel_1_1_2_1);
		
		jdateChooser = new JDateChooser();
		panel_5.add(jdateChooser);
		
		JPanel panel_6 = new JPanel();
		add(panel_6);
		panel_6.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 10));
		
		JLabel lblNewLabel_1_1_2_2 = new JLabel("Review:           ");
		lblNewLabel_1_1_2_2.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		panel_6.add(lblNewLabel_1_1_2_2);
		
		jtextFieldReview = new JTextField();
		jtextFieldReview.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		jtextFieldReview.setColumns(10);
		panel_6.add(jtextFieldReview);
		
		JPanel jtextFi = new JPanel();
		add(jtextFi);
		jtextFi.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 10));
		
		JLabel lblNewLabel_1_1_2_2_1 = new JLabel("Unit:             ");
		lblNewLabel_1_1_2_2_1.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		jtextFi.add(lblNewLabel_1_1_2_2_1);
		
		jtextFieldUnit = new JTextField();
		jtextFieldUnit.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		jtextFieldUnit.setColumns(10);
		jtextFi.add(jtextFieldUnit);
		
		JPanel panel_7 = new JPanel();
		add(panel_7);
		panel_7.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 10));
		
		JLabel lblNewLabel_1_1_2_2_1_1 = new JLabel("Image:      ");
		lblNewLabel_1_1_2_2_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		panel_7.add(lblNewLabel_1_1_2_2_1_1);
		
		jLabelImage = new JLabel("");
		jLabelImage.setIcon(new ImageIcon(JPanelCreateItem.class.getResource("/icon/Profile.png")));
		panel_7.add(jLabelImage);
		
		jbuttonBrowse = new JButton("Browse");
		jbuttonBrowse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jbuttonBrowse_actionPerformed(e);
			}
		});
		jbuttonBrowse.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		panel_7.add(jbuttonBrowse);
		
		JPanel panel_10 = new JPanel();
		add(panel_10);
		panel_10.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 10));
		
		jbuttonCreateItem = new JButton("Create");
		jbuttonCreateItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jbuttonCreateItem_actionPerformed(e);
			}
		});
		jbuttonCreateItem.setFont(new Font("Times New Roman", Font.BOLD, 15));
		panel_10.add(jbuttonCreateItem);
		
		JPanel panel_8 = new JPanel();
		add(panel_8);
		panel_8.setLayout(new BorderLayout(0, 0));
		initJFrame();

	}
	public void jbuttonCreateItem_actionPerformed(ActionEvent e) {
		ItemModel itemModel = new ItemModel();
		Item item = new Item();
		item.setItemID(jtextFieldItemID.getText());
		item.setItemName(jtextFieldItemName.getText());
		item.setPrice(Double.parseDouble(jtextFieldPrice.getText()));
		item.setExpiredDate(jdateChooser.getDate());
		Category category = (Category) jcomboBoxCategoryID.getSelectedItem();
		item.setCategoryID(category.getCategoryID());
		item.setReview(jtextFieldReview.getText());
		item.setUnit(jtextFieldReview.getText());
		item.setStatus(true);	
		WarehouseModel warehouseModel = new WarehouseModel();
		Warehouse warehouse = new Warehouse();
		warehouse.setItemID(jtextFieldItemID.getText());
		warehouse.setItemName(jtextFieldItemName.getText());
		warehouse.setDateAdded(jdateChooser.getDate());
		warehouse.setStatus(true);
		warehouse.setTotalInventory(0);
		
		
		try {
			item.setImage(Files.readAllBytes(Paths.get(file.getAbsolutePath())));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		if(itemModel.create(item) && warehouseModel.create(warehouse)) {
			JOptionPane.showMessageDialog(this, "Create Success");
			jtextFieldItemID.setText("");
			jtextFieldItemName.setText("");
			jtextFieldPrice.setText("");
			jtextFieldReview.setText("");
			jtextFieldUnit.setText("");
			jdateChooser.setDate(null);
			jLabelImage.setIcon(new ImageIcon(JPanelCreateItem.class.getResource("/icon/Profile.png")));
		} else {
			JOptionPane.showMessageDialog(this, "Create Failed", "FAILED", JOptionPane.ERROR_MESSAGE);
		}
		
		
	}
	public void initJFrame() {
		CategoryModel categoryModel = new CategoryModel();
		DefaultComboBoxModel<Category> defaultComboBoxModel = new DefaultComboBoxModel<Category>();
		for (Category category : categoryModel.findAll()) {
			defaultComboBoxModel.addElement(category);
			}
		jcomboBoxCategoryID.setModel(defaultComboBoxModel);
		jcomboBoxCategoryID.setRenderer(new CellRender());
	}
	public class CellRender extends DefaultListCellRenderer{

		@Override
		public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected,
				boolean cellHasFocus) {
			// TODO Auto-generated method stub
			Category category = (Category) value;
			return super.getListCellRendererComponent(list, category.getCategoryID() + " - " + category.getCategoryName(), index, isSelected, cellHasFocus);
		}
		
	}
	public void jbuttonBrowse_actionPerformed(ActionEvent e) {
		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setDialogTitle("Select a photo");
		fileChooser.setMultiSelectionEnabled(false);
		int result = fileChooser.showOpenDialog(this);
		if(result == fileChooser.APPROVE_OPTION) {
			file = fileChooser.getSelectedFile();
			ImageIcon imageIcon = new ImageIcon(new ImageIcon(file.getAbsolutePath()).getImage().getScaledInstance(jLabelImage.getWidth(), 
					jLabelImage.getHeight(), Image.SCALE_DEFAULT));
			
			jLabelImage.setIcon(imageIcon);
		}

	}
	
}
