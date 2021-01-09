package cn.wlgl.Personwindows;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import cn.wlgl.factory.ServiceFactory;
import cn.wlgl.vo.Person;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class JPersonRegist extends JFrame {

	private JPanel contentPane;
	private JTextField tusername;
	private JPasswordField tpassword;
	private JTextField tname;
	private JTextField tphone;
	private JTextField taddress;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JPersonRegist frame = new JPersonRegist();
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
	public JPersonRegist() {
		setTitle("\u7528\u6237\u6CE8\u518C");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setLocationRelativeTo(null);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("\u8D26\u53F7\uFF1A");
		lblNewLabel.setBounds(64, 22, 54, 15);
		contentPane.add(lblNewLabel);

		tusername = new JTextField();
		tusername.setBounds(128, 19, 165, 21);
		contentPane.add(tusername);
		tusername.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("\u5BC6\u7801\uFF1A");
		lblNewLabel_1.setBounds(64, 62, 54, 15);
		contentPane.add(lblNewLabel_1);

		tpassword = new JPasswordField();
		tpassword.setBounds(128, 59, 165, 21);
		contentPane.add(tpassword);

		JLabel lblNewLabel_2 = new JLabel("\u59D3\u540D\uFF1A");
		lblNewLabel_2.setBounds(64, 100, 54, 15);
		contentPane.add(lblNewLabel_2);

		tname = new JTextField();
		tname.setColumns(10);
		tname.setBounds(128, 97, 165, 21);
		contentPane.add(tname);

		JLabel lblNewLabel_3 = new JLabel("\u9ED8\u8BA4\u63A5\u6536\u4EBA\u624B\u673A\u53F7\uFF1A");
		lblNewLabel_3.setBounds(10, 138, 108, 15);
		contentPane.add(lblNewLabel_3);

		tphone = new JTextField();
		tphone.setColumns(10);
		tphone.setBounds(128, 135, 165, 21);
		contentPane.add(tphone);

		JLabel lblNewLabel_3_1 = new JLabel("\u9ED8\u8BA4\u63A5\u6536\u4EBA\u5730\u5740\uFF1A");
		lblNewLabel_3_1.setBounds(23, 176, 108, 15);
		contentPane.add(lblNewLabel_3_1);

		taddress = new JTextField();
		taddress.setColumns(10);
		taddress.setBounds(128, 173, 165, 21);
		contentPane.add(taddress);

		JLabel lblNewLabel_4 = new JLabel("(\u9009\u586B)");
		lblNewLabel_4.setBounds(303, 138, 54, 15);
		contentPane.add(lblNewLabel_4);

		JLabel lblNewLabel_4_1 = new JLabel("(\u9009\u586B)");
		lblNewLabel_4_1.setBounds(303, 176, 54, 15);
		contentPane.add(lblNewLabel_4_1);

		JButton btnNewButton = new JButton("\u6CE8\u518C");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (tusername.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "账号不能为空!!");
					return;
				}
				if (tpassword.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "密码不能为空!!");
					return;
				}
				if (tname.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "姓名不能为空!!");
					return;
				}
				Person p = new Person();
				p.setUsername(tusername.getText().trim());
				p.setPassword(tpassword.getText().trim());
				p.setName(tname.getText().trim());
				p.setPhone(tphone.getText().trim());
				p.setAddress(taddress.getText().trim());
				try {
					if (ServiceFactory.getIPersonServiceInstance().Regist(p)) {
						JOptionPane.showMessageDialog(null, "注册成功!!");
						JPersonLogin jl = new JPersonLogin();
						jl.setVisible(true);
						dispose();
					} else {
						JOptionPane.showMessageDialog(null, "注册失败,用户名重名!!");
						tusername.setText("");
						tusername.requestFocus();
					}
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton.setBounds(166, 215, 93, 23);
		contentPane.add(btnNewButton);

		//注册按钮
		JButton btnNewButton_1 = new JButton("\u53D6\u6D88");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JPersonLogin jl = new JPersonLogin();
				jl.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setBounds(295, 215, 93, 23);
		contentPane.add(btnNewButton_1);

		JButton btnNewButton_2 = new JButton("\u6E05\u9664");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tusername.setText("");
				tpassword.setText("");
				tname.setText("");
				taddress.setText("");
				tphone.setText("");
				tusername.requestFocus();
			}
		});
		btnNewButton_2.setBounds(38, 215, 93, 23);
		contentPane.add(btnNewButton_2);
	}
}
