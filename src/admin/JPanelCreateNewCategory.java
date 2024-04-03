package admin;

import javax.swing.JPanel;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.FlowLayout;
import javax.swing.JTextField;

import entities.Category;
import models.CategoryModel;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.BorderLayout;

public class JPanelCreateNewCategory extends JPanel {
	private JTextField jtextFieldCategoryID;
	private JTextField jtextFieldCategoryName;
	private JButton jbuttonCreate;

	/**
	 * Create the panel.
	 */
	public JPanelCreateNewCategory() {
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		JPanel panel = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel.getLayout();
		panel.setBackground(new Color(192, 192, 192));
		add(panel);
		
		JLabel lblNewLabel = new JLabel("Create New Category");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		add(panel_1);
		panel_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 50));
		
		JLabel lblNewLabel_1 = new JLabel("CategoryID:    ");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		panel_1.add(lblNewLabel_1);
		
		jtextFieldCategoryID = new JTextField();
		jtextFieldCategoryID.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		panel_1.add(jtextFieldCategoryID);
		jtextFieldCategoryID.setColumns(10);
		
		JPanel panel_2 = new JPanel();
		add(panel_2);
		panel_2.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 50));
		
		JLabel lblNewLabel_1_1 = new JLabel("CategoryName:  ");
		lblNewLabel_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		panel_2.add(lblNewLabel_1_1);
		
		jtextFieldCategoryName = new JTextField();
		jtextFieldCategoryName.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		jtextFieldCategoryName.setColumns(10);
		panel_2.add(jtextFieldCategoryName);
		
		JPanel panel_3 = new JPanel();
		add(panel_3);
		panel_3.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		jbuttonCreate = new JButton("Create");
		jbuttonCreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jbuttonCreate_actionPerformed(e);
			}
		});
		jbuttonCreate.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		panel_3.add(jbuttonCreate);
		
		JPanel panel_4 = new JPanel();
		add(panel_4);
		panel_4.setLayout(new BorderLayout(0, 0));

	}
	public void jbuttonCreate_actionPerformed(ActionEvent e) {
		CategoryModel categoryModel = new CategoryModel();
		Category category = new Category();
		category.setCategoryID(jtextFieldCategoryID.getText());
		category.setCategoryName(jtextFieldCategoryName.getText());
		if(jtextFieldCategoryID.getText().equals("") || jtextFieldCategoryName.getText().equals("")) {
			JOptionPane.showMessageDialog(this, "Create Failed", "FAILED", JOptionPane.ERROR_MESSAGE);
		}else if ( categoryModel.create(category)) {
			JOptionPane.showMessageDialog(this, "Create Success");
			jtextFieldCategoryID.setText("");
			jtextFieldCategoryName.setText("");
		} else {
			JOptionPane.showMessageDialog(this, "Create Failed", "FAILED", JOptionPane.ERROR_MESSAGE);
		}
	}

}
