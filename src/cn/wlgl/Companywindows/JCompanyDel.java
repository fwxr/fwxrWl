package cn.wlgl.Companywindows;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import cn.wlgl.factory.ServiceFactory;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class JCompanyDel extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JCompanyDel frame = new JCompanyDel();
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
	public JCompanyDel() {
		setTitle("\u5220\u9664\u5FEB\u9012\u4FE1\u606F");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 350, 200);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("\u5220\u9664\u5FEB\u9012\u4FE1\u606F");
		lblNewLabel.setBounds(123, 10, 95, 15);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\u8F93\u5165\u5FEB\u9012\u5355\u53F7:");
		lblNewLabel_1.setBounds(10, 55, 95, 15);
		contentPane.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(107, 52, 134, 21);
		contentPane.add(textField);
		textField.setColumns(10);
		
		//取消按钮
		JButton btnNewButton = new JButton("\u53D6\u6D88");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnNewButton.setBounds(46, 130, 93, 23);
		contentPane.add(btnNewButton);
		
		//删除按钮
		JButton btnNewButton_1 = new JButton("\u5220\u9664");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (textField.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "发送地址不能为空!!");
					return;
				}
				int a = Integer.parseInt(textField.getText());
				try {
					ServiceFactory.getICompanyServiceInstance().doRemovePackage(a);
					JOptionPane.showMessageDialog(null, "删除成功！！");
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_1.setBounds(205, 130, 93, 23);
		contentPane.add(btnNewButton_1);
	}
}
