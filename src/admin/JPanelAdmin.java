package admin;

import javax.swing.JPanel;



import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.BoxLayout;
import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class JPanelAdmin extends JPanel {
	private JButton jbuttonCreateNewUser;
	private JPanel jpanelMainAdmin;
	private JButton jbuttonCreateNewItem;
	private JButton jbuttonCreateNewCategory;
	private JButton jbuttonChangePriceItem;

	/**
	 * Create the panel.
	 */
	public JPanelAdmin() {
		setLayout(new BorderLayout(0, 0));
		
		JPanel jpanelMenu = new JPanel();
		jpanelMenu.setBackground(new Color(128, 128, 128));
		add(jpanelMenu, BorderLayout.WEST);
		jpanelMenu.setLayout(new BoxLayout(jpanelMenu, BoxLayout.Y_AXIS));
		
		jbuttonCreateNewUser = new JButton("Create new user        ");
		jbuttonCreateNewUser.setBackground(new Color(128, 128, 128));
		jbuttonCreateNewUser.setFocusPainted(false);
		jbuttonCreateNewUser.setBorderPainted(false);
		jbuttonCreateNewUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jbuttonCreateNewUser_actionPerformed(e);
			}
		});
		jbuttonCreateNewUser.setIcon(new ImageIcon(JPanelAdmin.class.getResource("/icon/49576_new_add_plus_user_icon.png")));
		jbuttonCreateNewUser.setFont(new Font("Times New Roman", Font.BOLD, 20));
		jpanelMenu.add(jbuttonCreateNewUser);
		
		jbuttonCreateNewItem = new JButton("Create new item        ");
		jbuttonCreateNewItem.setBackground(new Color(128, 128, 128));
		jbuttonCreateNewItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jbuttonCreateNewItem_actionPerformed(e);
			}
		});
		jbuttonCreateNewItem.setIcon(new ImageIcon(JPanelAdmin.class.getResource("/icon/3934636_black friday_new ite_new item_icon.png")));
		jbuttonCreateNewItem.setBorderPainted(false);
		jbuttonCreateNewItem.setFocusPainted(false);
		jbuttonCreateNewItem.setFont(new Font("Times New Roman", Font.BOLD, 20));
		jpanelMenu.add(jbuttonCreateNewItem);
		
		jbuttonCreateNewCategory = new JButton("Create new category ");
		jbuttonCreateNewCategory.setBackground(new Color(128, 128, 128));
		jbuttonCreateNewCategory.setBorderPainted(false);
		jbuttonCreateNewCategory.setFocusPainted(false);
		jbuttonCreateNewCategory.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jbuttonCreateNewCategory_actionPerformed(e);
			}
		});
		jbuttonCreateNewCategory.setIcon(new ImageIcon(JPanelAdmin.class.getResource("/icon/3934629_new item_new package_shipoing_icon.png")));
		jbuttonCreateNewCategory.setFont(new Font("Times New Roman", Font.BOLD, 20));
		jpanelMenu.add(jbuttonCreateNewCategory);
		
		jbuttonChangePriceItem = new JButton("Change Price             ");
		jbuttonChangePriceItem.setBackground(new Color(128, 128, 128));
		jbuttonChangePriceItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jbuttonChangePriceItem_actionPerformed(e);
			}
		});
		jbuttonChangePriceItem.setFocusPainted(false);
		jbuttonChangePriceItem.setBorderPainted(false);
		jbuttonChangePriceItem.setIcon(new ImageIcon(JPanelAdmin.class.getResource("/icon/1034365_sale_buy_price_tag_icon.png")));
		jbuttonChangePriceItem.setFont(new Font("Times New Roman", Font.BOLD, 20));
		jpanelMenu.add(jbuttonChangePriceItem);
		
		jpanelMainAdmin = new JPanel();
		add(jpanelMainAdmin, BorderLayout.CENTER);
		jpanelMainAdmin.setLayout(new BorderLayout(0, 0));
		initJFrame();

	}
	public void jbuttonCreateNewUser_actionPerformed(ActionEvent e) {
		clearScreen();
		JPanelCreateNewUser panelCreateNewUserAdmin = new JPanelCreateNewUser();
		jpanelMainAdmin.add(panelCreateNewUserAdmin);
		panelCreateNewUserAdmin.setVisible(true);
		
	}
	private void clearScreen() {
		jpanelMainAdmin.removeAll();
		jpanelMainAdmin.revalidate();
	}
	private void initJFrame() {
		JPanelCreateNewUser panelCreateNewUserAdmin = new JPanelCreateNewUser();
		jpanelMainAdmin.add(panelCreateNewUserAdmin);
		panelCreateNewUserAdmin.setVisible(true);
	}
	public void jbuttonCreateNewItem_actionPerformed(ActionEvent e) {
		clearScreen();
		JPanelCreateItem jPanelCreateItem = new JPanelCreateItem();
		jpanelMainAdmin.add(jPanelCreateItem);
		jPanelCreateItem.setVisible(true);
	}
	public void jbuttonCreateNewCategory_actionPerformed(ActionEvent e) {
		clearScreen();
		JPanelCreateNewCategory jpanelcreatecategory = new JPanelCreateNewCategory();
		jpanelMainAdmin.add(jpanelcreatecategory);
		jpanelcreatecategory.setVisible(true);
	}
	public void jbuttonChangePriceItem_actionPerformed(ActionEvent e) {
		clearScreen();
		JPanelChangePrice jPanelChangePrice = new JPanelChangePrice();
		jpanelMainAdmin.add(jPanelChangePrice);
		jPanelChangePrice.setVisible(true);
	}
	
}
