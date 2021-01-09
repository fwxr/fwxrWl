package cn.wlgl.Companywindows;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Enumeration;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableColumn;

import cn.wlgl.factory.ServiceFactory;
import cn.wlgl.vo.NewPackage;
import cn.wlgl.vo.Package;

import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class JCompanyManage extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JLabel lblNewLabel;
	private JTextField tnumber;
	private int i = 0;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JCompanyManage frame = new JCompanyManage();
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
	public JCompanyManage() {
		setTitle("\u5305\u88F9\u7BA1\u7406");
		setBounds(100, 100, 580, 351);
		setLocationRelativeTo(null);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		PackageTableModel ptm = new PackageTableModel();
		table = new JTable(ptm);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		table.getTableHeader().setReorderingAllowed(false);
		contentPane.setLayout(null);
		JScrollPane sp = new JScrollPane(table);
		sp.setBounds(33, 35, 511, 161);
		contentPane.add(sp);

		lblNewLabel = new JLabel("\u5DF2\u5206\u914D\u5305\u88F9\u8868");
		lblNewLabel.setBounds(230, 10, 83, 15);
		contentPane.add(lblNewLabel);

		JButton btnNewButton = new JButton("\u67E5\u8BE2\u603B\u4F53\u8868");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					ptm.list = ServiceFactory.getICompanyServiceInstance().findAll();
					table.updateUI();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton.setBounds(21, 206, 105, 23);
		contentPane.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("\u67E5\u8BE2\u672A\u7B7E\u6536\u8868");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					ptm.list = ServiceFactory.getICompanyServiceInstance().findFalse();
					table.updateUI();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_1.setBounds(147, 206, 116, 23);
		contentPane.add(btnNewButton_1);

		JComboBox tbox = new JComboBox();
		tbox.setModel(new DefaultComboBoxModel(
				new String[] { "\u5355\u53F7", "\u7528\u6237\u7F16\u53F7"}));
		tbox.setBounds(291, 206, 85, 23);
		contentPane.add(tbox);

		tnumber = new JTextField();
		tnumber.setBounds(386, 207, 66, 21);
		contentPane.add(tnumber);
		tnumber.setColumns(10);

		JButton btnNewButton_2 = new JButton("\u67E5\u8BE2");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (tnumber.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "查询编号不能为空!!!");
					return;
				}
				try {
					ptm.list = ServiceFactory.getICompanyServiceInstance().findByNumber(tbox.getSelectedIndex(),
							Integer.parseInt(tnumber.getText().trim()));
					table.updateUI();
				} catch (NumberFormatException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_2.setBounds(462, 206, 93, 23);
		contentPane.add(btnNewButton_2);

		JButton btnNewButton_3 = new JButton("\u5355\u53F7\u6392\u5E8F");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (i == 0) {
					Collections.sort(ptm.list, new Comparator<Package>() {
						@Override
						public int compare(Package p1, Package p2) {
							if (p2.getEnumber() > p1.getEnumber()) {
								return 1;
							} else {
								return -1;
							}
						}
					});
					i = 1;
				} else {
					Collections.sort(ptm.list, new Comparator<Package>() {
						@Override
						public int compare(Package p1, Package p2) {
							if (p1.getEnumber() > p2.getEnumber()) {
								return 1;
							} else {
								return -1;
							}
						}
					});
					i = 0;
				}
				table.updateUI();
			}
		});
		btnNewButton_3.setBounds(33, 6, 93, 23);
		contentPane.add(btnNewButton_3);

		JButton btnNewButton_4 = new JButton("\u9000\u51FA");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnNewButton_4.setBounds(420, 268, 93, 23);
		contentPane.add(btnNewButton_4);

	}
}

class PackageTableModel extends AbstractTableModel {

	String[] columnNames = new String[] {"单号", "用户编号", "发送地址", "接收地址", "发货时间", "接收时间", "费用", "接收人手机号","对方签收"};
	public List<Package> list = null;

	public PackageTableModel() {
		try {
			list = ServiceFactory.getICompanyServiceInstance().findAll();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// heros.size返回一共有多少行
	public int getRowCount() {
		// TODO Auto-generated method stub
		return list.size();
	}

	public int getColumnCount() {
		// TODO Auto-generated method stub
		return columnNames.length;
	}

	public String getColumnName(int columnIndex) {
		// TODO Auto-generated method stub
		return columnNames[columnIndex];
	}

	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return false;
	}

	// 先通过heros.get(rowIndex)获取行对应的Hero对象
	// 然后根据columnIndex返回对应的属性
	public Object getValueAt(int rowIndex, int columnIndex) {
		Package p = list.get(rowIndex);
		if (0 == columnIndex)
			return p.getEnumber();
		if (1 == columnIndex)
			return p.getPnumber();
		if (2 == columnIndex)
			return p.getSendaddress();
		if (3 == columnIndex)
			return p.getGetaddress();
		if (4 == columnIndex)
			return p.getSendtime();
		if (5 == columnIndex)
			return p.getGettime();
		if (6 == columnIndex)
			return p.getMoney();
		if (7 == columnIndex)
			return p.getPhone();
		if (8 == columnIndex)
			return p.getSign();
		return null;
	}

}