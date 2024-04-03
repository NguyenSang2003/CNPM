package quanlikho;

import java.awt.Color;

import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PiePlot3D;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import java.awt.BorderLayout;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import java.awt.Font;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.awt.FlowLayout;
import com.toedter.calendar.JDateChooser;

import entities.Item;
import entities.OutInvoiceDetails;
import models.ConnectDB;
import models.ItemModel;
import models.OutInvoiceDetailsModel;

import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.border.EtchedBorder;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.ListSelectionModel;

public class Chart extends JPanel {
	private JTable jtableWarehouse;
	private JButton jbuttonReviewChart;
	private JButton jbuttonRefresh;
	private JButton jbuttonSearch;
	private JDateChooser jdateChooser;
	
	
	/**
	 * Create the panel.
	 */
	
	public Chart() {
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		JPanel panel = new JPanel();
		add(panel);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblNewLabel = new JLabel("Item Chart");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		add(panel_1);
		panel_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblNewLabel_1 = new JLabel("Date: ");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		panel_1.add(lblNewLabel_1);
		
		jdateChooser = new JDateChooser();
		panel_1.add(jdateChooser);
		
		jbuttonSearch = new JButton("Search");
		jbuttonSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jbuttonSearch_actionPerformed(e);
			}
		});
		jbuttonSearch.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		panel_1.add(jbuttonSearch);
		
		jbuttonRefresh = new JButton("Refresh");
		jbuttonRefresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jbuttonRefresh_actionPerformed(e);
			}
		});
		jbuttonRefresh.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		jbuttonRefresh.setIcon(new ImageIcon(Chart.class.getResource("/icon/352439_refresh_icon.png")));
		panel_1.add(jbuttonRefresh);
		
		JPanel panel_2 = new JPanel();
		add(panel_2);
		panel_2.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Warehouse Invoice", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_2.add(scrollPane, BorderLayout.CENTER);
		
		jtableWarehouse = new JTable();
		jtableWarehouse.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane.setViewportView(jtableWarehouse);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		add(panel_3);
		panel_3.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		jbuttonReviewChart = new JButton("Review Chart \r\n");
		jbuttonReviewChart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jbuttonReviewChart_actionPerformed(e);
			}
		});
		jbuttonReviewChart.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		panel_3.add(jbuttonReviewChart);
		initJFrame();
//		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
//		dataset.setValue(80, "Marks", "Student 1");
//		dataset.setValue(50, "Marks", "Student 2");
//		dataset.setValue(30, "Marks", "Student 3");
//		JFreeChart freeChart = ChartFactory.createBarChart("Student scrore", "Student name", "marks", dataset, PlotOrientation.VERTICAL
//				, false, true,false);
//		CategoryPlot categoryPlot = freeChart.getCategoryPlot();
//		categoryPlot.setRangeGridlinePaint(Color.black);
//		ChartFrame chartFrame = new ChartFrame("Bar Chart For Student", freeChart);
//		chartFrame.setVisible(true);
//		chartFrame.setSize(484, 380);
		
		
		
	}
		public void initJFrame() {
			OutInvoiceDetailsModel detailsModel = new OutInvoiceDetailsModel();
			fillDataToTable1(detailsModel.findAlloutinvoicedetailsByStatus(true));
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
			jtableWarehouse.setModel(defaultTableModel);
			jtableWarehouse.getTableHeader().setReorderingAllowed(false);
	}
		public void jbuttonSearch_actionPerformed(ActionEvent e) {
			OutInvoiceDetailsModel detailsModel = new OutInvoiceDetailsModel();
			fillDataToTable1(detailsModel.findByDate(jdateChooser.getDate(), true));
		}
		public void jbuttonRefresh_actionPerformed(ActionEvent e) {
			OutInvoiceDetailsModel detailsModel = new OutInvoiceDetailsModel();
			fillDataToTable1(detailsModel.findAlloutinvoicedetailsByStatus(true));
			jdateChooser.setDate(null);
		}
		public void jbuttonReviewChart_actionPerformed(ActionEvent e) {
			OutInvoiceDetailsModel detailsModel = new OutInvoiceDetailsModel();
			DefaultCategoryDataset dataset = new DefaultCategoryDataset();
			Date date = jdateChooser.getDate();
			if(jdateChooser.getDate() == null) {
				try {
					PreparedStatement preparedStatement = ConnectDB.connection().prepareStatement("Select itemName as itemName,sum(quantity) as sum from outinvoicedetails where status = true group by itemName");
					
					ResultSet resultSet = preparedStatement.executeQuery();
					while (resultSet.next()) {
						dataset.addValue(resultSet.getInt("sum"), "Quantity", resultSet.getString("itemName"));
					}
				} catch (Exception e2) {
					// TODO: handle exception
					e2.printStackTrace();
				}
//				DefaultCategoryDataset dataset = new DefaultCategoryDataset();
//				dataset.setValue(quantityApple, "Quantity", "Apple");
//				dataset.setValue(quantityMango, "Quantity",  "Mango");
				JFreeChart freeChart = ChartFactory.createBarChart("Item", "Item", "Quantity", dataset, PlotOrientation.VERTICAL
						, false, true,false);
				CategoryPlot categoryPlot = freeChart.getCategoryPlot();
				categoryPlot.setRangeGridlinePaint(Color.black);
				ChartFrame chartFrame = new ChartFrame("Bar Chart For Item", freeChart);
				chartFrame.setVisible(true);
				chartFrame.setSize(484, 380);
			} else {
				
			
			try {
				PreparedStatement preparedStatement = ConnectDB.connection().prepareStatement("Select itemName as itemName,sum(quantity) as sum from outinvoicedetails where status = true and created = ? group by itemName");
				preparedStatement.setDate(1, new java.sql.Date(date.getTime()));
				ResultSet resultSet = preparedStatement.executeQuery();
				while (resultSet.next()) {
					dataset.addValue(resultSet.getInt("sum"), "Quantity", resultSet.getString("itemName"));
				}
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
//			DefaultCategoryDataset dataset = new DefaultCategoryDataset();
//			dataset.setValue(quantityApple, "Quantity", "Apple");
//			dataset.setValue(quantityMango, "Quantity",  "Mango");
			JFreeChart freeChart = ChartFactory.createBarChart("Item", "Item", "Quantity", dataset, PlotOrientation.VERTICAL
					, false, true,false);
			CategoryPlot categoryPlot = freeChart.getCategoryPlot();
			categoryPlot.setRangeGridlinePaint(Color.black);
			ChartFrame chartFrame = new ChartFrame("Bar Chart For Item", freeChart);
			chartFrame.setVisible(true);
			chartFrame.setSize(484, 380);
			}
		}
		
}

