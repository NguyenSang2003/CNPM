package quanlikho;

import javax.swing.JPanel;
import javax.swing.BoxLayout;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import java.awt.Font;
import java.util.Iterator;

import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import entities.Feedback;
import models.FeedbackModel;

import javax.swing.JButton;
import java.awt.BorderLayout;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;

public class JPanelCheckSend extends JPanel {
	private JTable jtableCheckFeedback;

	/**
	 * Create the panel.
	 */
	public JPanelCheckSend() {
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		JPanel panel = new JPanel();
		add(panel);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblNewLabel = new JLabel("Check Feedback");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
		panel.add(lblNewLabel);
		
		JPanel panel_2 = new JPanel();
		add(panel_2);
		panel_2.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		panel_2.add(scrollPane, BorderLayout.CENTER);
		
		jtableCheckFeedback = new JTable();
		jtableCheckFeedback.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane.setViewportView(jtableCheckFeedback);
		initJFrame();
	}
	public void initJFrame() {
		FeedbackModel feedbackModel = new FeedbackModel();
		
		DefaultTableModel defaultTableModel = new DefaultTableModel() {

			@Override
			public boolean isCellEditable(int row, int column) {
				// TODO Auto-generated method stub
				return false;
			}
			
		};
		defaultTableModel.addColumn("feedbackID");
		defaultTableModel.addColumn("feedback");
		defaultTableModel.addColumn("warehouseItemID");
		defaultTableModel.addColumn("date");
		defaultTableModel.addColumn("typeFeedback");
		defaultTableModel.addColumn("userID");
		
		for (Feedback feedback : feedbackModel.findAll()) {
			defaultTableModel.addRow(new Object[] {
					feedback.getFeedbackID(),feedback.getFeedback(),
					feedback.getWarehouseItemID(),feedback.getDate(),feedback.getTypeFeedback(),feedback.getUserID()
			});
		}
		jtableCheckFeedback.setModel(defaultTableModel);
		jtableCheckFeedback.getTableHeader().setReorderingAllowed(false);
	}

}
