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
    // Bảng hiển thị danh sách mặt hàng
    private JTable jtableItems;
    // Ô nhập liệu để nhập từ khóa tìm kiếm
    private JTextField jtextFieldKeyword;
    // Nút tìm kiếm mặt hàng
    private JButton jbuttonSearchItem;
    // Nút làm mới danh sách mặt hàng
    private JButton jbuttonRefresh;

    /**
     * Tạo panel.
     */
    public JPanelItemNhanVienBanHang() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        
        JPanel panel = new JPanel();
        panel.setBackground(new Color(192, 192, 192));
        add(panel);
        panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
        
        // Tiêu đề "Items"
        JLabel lblNewLabel = new JLabel("Items");
        lblNewLabel.setBackground(new Color(0, 0, 0));
        lblNewLabel.setForeground(new Color(0, 0, 0));
        lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
        panel.add(lblNewLabel);
        
        JPanel panel_2 = new JPanel();
        add(panel_2);
        panel_2.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
        
        // Nhãn "Search: "
        JLabel lblNewLabel_1 = new JLabel("Search:  ");
        lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        panel_2.add(lblNewLabel_1);
        
        // Ô nhập từ khóa tìm kiếm
        jtextFieldKeyword = new JTextField();
        jtextFieldKeyword.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        panel_2.add(jtextFieldKeyword);
        jtextFieldKeyword.setColumns(15);
        
        // Nút tìm kiếm mặt hàng
        jbuttonSearchItem = new JButton("Search");
        jbuttonSearchItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                jbuttonSearchItem_actionPerformed(e);
            }
        });
        jbuttonSearchItem.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        panel_2.add(jbuttonSearchItem);
        
        // Nút làm mới danh sách mặt hàng
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
        
        // Bảng cuộn chứa bảng danh sách mặt hàng
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBorder(new TitledBorder(null, "Item Table", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        panel_1.add(scrollPane, BorderLayout.CENTER);
        
        jtableItems = new JTable();
        jtableItems.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        scrollPane.setViewportView(jtableItems);
        initJFrame();
    }
    
    // Khởi tạo frame và điền dữ liệu vào bảng
    public void initJFrame() {
        ItemModel itemModel = new ItemModel();
        fillDataToTable(itemModel.findAll());
    }
    
    // Normal flow bước 4: Hệ thống trả về sản phẩm phù hợp.
    // Điền kết quả dữ liệu vào danh sách items
    public void fillDataToTable(List<Item> items) {
        DefaultTableModel defaultTableModel = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                // Không cho phép chỉnh sửa các ô trong bảng
                return false;
            }
        };
        // Thêm các cột vào bảng
        defaultTableModel.addColumn("itemID");
        defaultTableModel.addColumn("itemName");
        defaultTableModel.addColumn("categoryID");
        defaultTableModel.addColumn("price");
        defaultTableModel.addColumn("expiredDate");
        defaultTableModel.addColumn("review");
        defaultTableModel.addColumn("unit");
        defaultTableModel.addColumn("image");
        
        // Thêm dữ liệu vào bảng
        for (Item item : items) {
            defaultTableModel.addRow(new Object[] {
                item.getItemID(), item.getItemName(), item.getCategoryID(), 
                item.getPrice(), item.getExpiredDate(), 
                item.getReview(), item.getUnit(), item.getImage()
            });
        }
        // Normal flow bước 5: Hệ thống hiển thị kết quả tìm kiếm cho quản trị viên.
        // Dữ liệu kết quả sẽ được điền vào bảng jtableItems để hiển thị kết quả
        jtableItems.getTableHeader().setReorderingAllowed(false);
        jtableItems.setModel(defaultTableModel);
        // Thiết lập renderer cho cột ảnh
        jtableItems.getColumnModel().getColumn(7).setCellRenderer(new ImageCellRender());
        // Đặt chiều cao hàng
        jtableItems.setRowHeight(60);
    }
    
    // normal flow: bước 1:Quản trị viên nhập nội dung tìm kiếm vào ô tìm kiếm "jtextFieldKeyword".
    // normal flow: bước 2: Hệ thống nhận nội dung tìm kiếm và truy vấn cơ sở dữ liệu
    // Nhấn nút search thì hệ thống sẽ lấy từ khóa để tìm kiếm trong dữ liệu. 
    // Kết quả sẽ được điền vào fillDataToTable
    public void jbuttonSearchItem_actionPerformed(ActionEvent e) {
        ItemModel itemModel = new ItemModel();
        String keyword = jtextFieldKeyword.getText();// Lấy từ khóa từ ô tìm kiếm
        fillDataToTable(itemModel.searchByKeyword(keyword)); // Tìm kiếm và điền kết quả vào bảng
    }
    
    // Lớp con để render ảnh trong bảng
    private class ImageCellRender extends DefaultTableCellRenderer {
        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
                                                       int row, int column) {
            JLabel jLabel = new JLabel();
            byte[] bytes = (byte[]) value;
            ImageIcon imageIcon = new ImageIcon(new ImageIcon(bytes).getImage().getScaledInstance(40, 40, Image.SCALE_DEFAULT));
            jLabel.setIcon(imageIcon);
            // Chỉnh ảnh vào chính giữa
            jLabel.setHorizontalAlignment(JLabel.CENTER);
            return jLabel;
        }
    }
    
    // Xử lý sự kiện khi nhấn nút làm mới
    public void jbuttonRefresh_actionPerformed(ActionEvent e) {
        ItemModel itemModel = new ItemModel();
        fillDataToTable(itemModel.findAll());
        jtextFieldKeyword.setText("");
    }
}
