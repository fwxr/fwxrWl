package cn.wlgl.Personwindows;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import cn.wlgl.factory.ServiceFactory;
import cn.wlgl.vo.NewPackage;
import cn.wlgl.vo.Person;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class JPersonSend extends JFrame {

	private static Person p;
	private JPanel contentPane;
	private JTextField tsendaddress;
	private JTextField tphone;
	private JTextField tgetaddress;

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
	public JPersonSend(Person p) {
		this.p = p;
		setTitle("\u4E2A\u4EBA\u4FE1\u606F\u7BA1\u7406");
		setBounds(100, 100, 450, 300);
		setLocationRelativeTo(null);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel_2 = new JLabel("\u53D1\u9001\u5730\u5740\uFF1A");
		lblNewLabel_2.setBounds(70, 40, 68, 15);
		contentPane.add(lblNewLabel_2);

		tsendaddress = new JTextField();
		tsendaddress.setColumns(10);
		tsendaddress.setBounds(168, 37, 165, 21);
		contentPane.add(tsendaddress);
		tsendaddress.setText("");
		tsendaddress.requestFocus();

		JLabel lblNewLabel_3 = new JLabel("\u63A5\u6536\u4EBA\u624B\u673A\u53F7\uFF1A");
		lblNewLabel_3.setBounds(50, 85, 108, 15);
		contentPane.add(lblNewLabel_3);

		tphone = new JTextField();
		tphone.setColumns(10);
		tphone.setBounds(168, 82, 165, 21);
		contentPane.add(tphone);
		//tphone.setText(p.getPhone());

		JLabel lblNewLabel_3_1 = new JLabel("\u63A5\u6536\u4EBA\u5730\u5740\uFF1A");
		lblNewLabel_3_1.setBounds(65, 137, 82, 15);
		contentPane.add(lblNewLabel_3_1);

		tgetaddress = new JTextField();
		tgetaddress.setColumns(10);
		tgetaddress.setBounds(168, 134, 165, 21);
		contentPane.add(tgetaddress);
		//tgetaddress.setText(p.getAddress());

		//寄包裹按钮
		JButton btnNewButton_1 = new JButton("\u786E\u5B9A\u53D1\u9001\u5305\u88F9");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (tsendaddress.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "发送地址不能为空!!");
					return;
				}
				if (tgetaddress.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "接受地址不能为空!!");
					return;
				}
				if (tphone.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "接收人电话不能为空!!");
					return;
				}
				NewPackage np = new NewPackage();
				np.setPnumber(p.getPnumber());
				np.setSendaddress(tsendaddress.getText().trim());
				np.setGetaddress(tgetaddress.getText().trim());
				np.setPhone(tphone.getText().trim());
				try {
					if (ServiceFactory.getIPersonServiceInstance().Create(np)) {
						JOptionPane.showMessageDialog(null, "寄存成功！！");
						dispose();
					} else {
						JOptionPane.showMessageDialog(null, "寄存失败，请重试！！");
					}
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_1.setBounds(168, 215, 116, 23);
		contentPane.add(btnNewButton_1);

		JButton btnNewButton_2 = new JButton("\u9000\u51FA");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnNewButton_2.setBounds(50, 215, 93, 23);
		contentPane.add(btnNewButton_2);

		JButton btnNewButton_2_1 = new JButton("\u6E05\u9664");
		btnNewButton_2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tsendaddress.setText("");
				tgetaddress.setText("");
				tphone.setText("");
			}
		});
		btnNewButton_2_1.setBounds(315, 215, 93, 23);
		contentPane.add(btnNewButton_2_1);
	}
}
