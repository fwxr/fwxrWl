package cn.wlgl.Companywindows;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import cn.wlgl.factory.DAOFactory;
import cn.wlgl.factory.ServiceFactory;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class JCompanyLogin extends JFrame {

	private JPanel contentPane;
	private JTextField tusername;
	private JPasswordField tpassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JCompanyLogin frame = new JCompanyLogin();
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
	public JCompanyLogin() {
		setTitle("\u7BA1\u7406\u5458\u767B\u5F55\u7A97\u53E3");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setLocationRelativeTo(null);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		tusername = new JTextField();
		tusername.setBounds(141, 81, 180, 21);
		contentPane.add(tusername);
		tusername.setColumns(10);

		JLabel lblNewLabel = new JLabel("\u8D26\u53F7\uFF1A");
		lblNewLabel.setBounds(86, 84, 54, 15);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("\u5BC6\u7801\uFF1A");
		lblNewLabel_1.setBounds(86, 133, 54, 15);
		contentPane.add(lblNewLabel_1);

		tpassword = new JPasswordField();
		tpassword.setBounds(141, 130, 180, 21);
		contentPane.add(tpassword);

		JButton btnNewButton = new JButton("\u767B\u5F55");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (tusername.getText().toString().equals("")) {
					JOptionPane.showMessageDialog(null, "账号不能为空!!");
					tusername.requestFocus();
					return;
				}
				if (tpassword.getText().toString().equals("")) {
					JOptionPane.showMessageDialog(null, "密码不能为空!!");
					tpassword.requestFocus();
					return;
				}
				try {
					if (ServiceFactory.getICompanyServiceInstance().Login(tusername.getText().trim(),
							tpassword.getText().trim())) {
						JCompanyMain jcm = new JCompanyMain();
						jcm.setVisible(true);
						dispose();
					} else {
						JOptionPane.showMessageDialog(null, "登录失败!!");
						tusername.setText("");
						tpassword.setText("");
						tusername.requestFocus();
					}
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton.setBounds(246, 198, 93, 23);
		contentPane.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("\u6E05\u9664");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tusername.setText("");
				tpassword.setText("");
				tusername.requestFocus();
			}
		});
		btnNewButton_1.setBounds(96, 198, 93, 23);
		contentPane.add(btnNewButton_1);

		JLabel lblNewLabel_2 = new JLabel("\u6B22\u8FCE\u4F7F\u7528");
		lblNewLabel_2.setFont(new Font("方正姚体", Font.BOLD | Font.ITALIC, 30));
		lblNewLabel_2.setBounds(141, 10, 166, 46);
		contentPane.add(lblNewLabel_2);
	}
}
