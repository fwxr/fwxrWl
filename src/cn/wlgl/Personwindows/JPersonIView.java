package cn.wlgl.Personwindows;

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

public class JPersonIView extends JFrame {

	private static Person p;
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
					JPersonIView frame = new JPersonIView(p);
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
	public JPersonIView(Person p) {
		this.p = p;
		setTitle("\u4E2A\u4EBA\u4FE1\u606F\u7BA1\u7406");
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
		tusername.setText(p.getUsername());
		tusername.setEditable(false);

		JLabel lblNewLabel_1 = new JLabel("\u5BC6\u7801\uFF1A");
		lblNewLabel_1.setBounds(64, 62, 54, 15);
		contentPane.add(lblNewLabel_1);

		tpassword = new JPasswordField();
		tpassword.setBounds(128, 59, 165, 21);
		contentPane.add(tpassword);
		tpassword.setText(p.getPassword());

		JLabel lblNewLabel_2 = new JLabel("\u59D3\u540D\uFF1A");
		lblNewLabel_2.setBounds(64, 100, 54, 15);
		contentPane.add(lblNewLabel_2);

		tname = new JTextField();
		tname.setColumns(10);
		tname.setBounds(128, 97, 165, 21);
		contentPane.add(tname);
		tname.setText(p.getName());

		JLabel lblNewLabel_3 = new JLabel("\u9ED8\u8BA4\u63A5\u6536\u4EBA\u624B\u673A\u53F7\uFF1A");
		lblNewLabel_3.setBounds(10, 138, 108, 15);
		contentPane.add(lblNewLabel_3);

		tphone = new JTextField();
		tphone.setColumns(10);
		tphone.setBounds(128, 135, 165, 21);
		contentPane.add(tphone);
		tphone.setText(p.getPhone());

		JLabel lblNewLabel_3_1 = new JLabel("\u9ED8\u8BA4\u63A5\u6536\u4EBA\u5730\u5740\uFF1A");
		lblNewLabel_3_1.setBounds(23, 176, 108, 15);
		contentPane.add(lblNewLabel_3_1);

		taddress = new JTextField();
		taddress.setColumns(10);
		taddress.setBounds(128, 173, 165, 21);
		contentPane.add(taddress);
		taddress.setText(p.getAddress());

		JLabel lblNewLabel_4 = new JLabel("(\u9009\u586B)");
		lblNewLabel_4.setBounds(303, 138, 54, 15);
		contentPane.add(lblNewLabel_4);

		JLabel lblNewLabel_4_1 = new JLabel("(\u9009\u586B)");
		lblNewLabel_4_1.setBounds(303, 176, 54, 15);
		contentPane.add(lblNewLabel_4_1);

		JButton btnNewButton_1 = new JButton("\u4FEE\u6539");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				p.setName(tname.getText().trim());
				p.setPassword(tpassword.getText().trim());
				p.setPhone(tphone.getText().trim());
				p.setAddress(taddress.getText().trim());
				try {
					if (ServiceFactory.getIPersonServiceInstance().update(p)) {
						JOptionPane.showMessageDialog(null, "修改成功!!");
					} else {
						JOptionPane.showMessageDialog(null, "修改失败，请重试!!");
					}
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_1.setBounds(240, 215, 93, 23);
		contentPane.add(btnNewButton_1);

		JButton btnNewButton_2 = new JButton("\u9000\u51FA");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnNewButton_2.setBounds(90, 215, 93, 23);
		contentPane.add(btnNewButton_2);
	}
}
