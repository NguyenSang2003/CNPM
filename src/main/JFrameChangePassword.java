package main;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.mindrot.jbcrypt.BCrypt;

import entities.User;
import models.UserModel;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Map;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JPasswordField;

public class JFrameChangePassword extends JFrame {

	private JPanel contentPane;
	private JButton jbuttonSave;
	private Map<String, Object> dataChangePassword;
	private JLabel jlabelUsername;
	private JPasswordField jpasswordField;
	private JPasswordField jpasswordConfirmPassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFrameChangePassword frame = new JFrameChangePassword();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public JFrameChangePassword() {
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		jlabelUsername = new JLabel("Change password for Username: ");
		jlabelUsername.setFont(new Font("Arial", Font.PLAIN, 18));
		jlabelUsername.setBounds(10, 10, 416, 58);
		contentPane.add(jlabelUsername);
		
		JLabel lblNewPassword = new JLabel("New Password:");
		lblNewPassword.setBounds(66, 89, 94, 24);
		contentPane.add(lblNewPassword);
		
		JLabel lblConfirmPassword = new JLabel("Confirm Password:");
		lblConfirmPassword.setBounds(66, 154, 94, 24);
		contentPane.add(lblConfirmPassword);
		
		jbuttonSave = new JButton("Save");
		jbuttonSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jbuttonSave_actionPerformed(e);
			}
		});
		jbuttonSave.setBounds(171, 218, 85, 32);
		contentPane.add(jbuttonSave);
		
		jpasswordField = new JPasswordField();
		jpasswordField.setBounds(170, 82, 137, 39);
		contentPane.add(jpasswordField);
		
		jpasswordConfirmPassword = new JPasswordField();
		jpasswordConfirmPassword.setBounds(170, 147, 137, 39);
		contentPane.add(jpasswordConfirmPassword);
	}
	public JFrameChangePassword(Map<String, Object> dataChangePassword) {
		this();
		this.dataChangePassword = dataChangePassword;
		initJFrame();
	}
	public void initJFrame() {
		User user = (User) dataChangePassword.get("user");
		jlabelUsername.setText("Change password for Username: " + user.getUsername());
	}
	public void jbuttonSave_actionPerformed(ActionEvent e) {
		String password = new String(jpasswordField.getPassword());
		String passwordConfirm = new String(jpasswordConfirmPassword.getPassword());
		if(password.equals(passwordConfirm)) {
			User user = (User) dataChangePassword.get("user");
			UserModel userModel = new UserModel();
			user.setPassword(BCrypt.hashpw(password, BCrypt.gensalt()));
			if(userModel.changePassword(user)) {
				JOptionPane.showMessageDialog(this, "change password success");
				this.setVisible(false);
				
				
			} else {
				JOptionPane.showMessageDialog(this, "change password failed", "FAILED", JOptionPane.ERROR_MESSAGE);
			}
			
		} else {
			JOptionPane.showMessageDialog(this, "you must fill the same password!", "FAILED", JOptionPane.ERROR_MESSAGE);
		}
	}
}
