package cn.wlgl.Personwindows;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import cn.wlgl.factory.ServiceFactory;
import cn.wlgl.vo.NewPackage;
import cn.wlgl.vo.Person;
import cn.wlgl.vo.Package;

import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.Component;

public class JPersonSelect extends JFrame {

	private static Person p;
	private JPanel contentPane;
	private JTable table;
	private JTable table2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JPersonSelect frame = new JPersonSelect(p);
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
	public JPersonSelect(Person p) {
		this.p = p;
		setTitle("\u67E5\u8BE2\u5305\u88F9\u4FE1\u606F");
		setBounds(100, 100, 575, 402);
		setLocationRelativeTo(null);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		NewPackageTableModel nptm = new NewPackageTableModel(p.getPnumber());
		table = new JTable(nptm);
		table.getTableHeader().setReorderingAllowed(false);
		JScrollPane sp = new JScrollPane(table);
		sp.setBounds(10, 30, 549, 120);
		contentPane.add(sp);

		PackageTableModel ptm = new PackageTableModel(p.getPnumber());
		table2 = new JTable(ptm);
		table2.getTableHeader().setReorderingAllowed(false);
		table2.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		JScrollPane sp2 = new JScrollPane(table2);
		sp2.setBounds(10, 185, 549, 136);
		contentPane.add(sp2);

		JLabel lblNewLabel = new JLabel("\u672A\u5206\u914D\u5305\u88F9\u8868");
		lblNewLabel.setToolTipText("");
		lblNewLabel.setBounds(244, 5, 120, 15);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("\u5DF2\u5206\u914D\u5305\u88F9\u8868");
		lblNewLabel_1.setToolTipText("");
		lblNewLabel_1.setBounds(244, 160, 120, 15);
		contentPane.add(lblNewLabel_1);

		JButton btnNewButton = new JButton("\u9000\u51FA");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnNewButton.setBounds(242, 341, 93, 23);
		contentPane.add(btnNewButton);
	}
}

class NewPackageTableModel extends AbstractTableModel {

	int pnumber;
	String[] columnNames = new String[] { "单号", "发送地址", "接收地址", "发货时间", "接收人手机号" };
	public List<NewPackage> list = null;

	public NewPackageTableModel(int pnumber) {
		this.pnumber = pnumber;
		try {
			list = ServiceFactory.getIPersonServiceInstance().SelectNew(pnumber);
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
		NewPackage np = list.get(rowIndex);
		if (0 == columnIndex)
			return np.getEnumber();
		if (1 == columnIndex)
			return np.getSendaddress();
		if (2 == columnIndex)
			return np.getGetaddress();
		if (3 == columnIndex)
			return np.getSendtime();
		if (4 == columnIndex)
			return np.getPhone();
		return null;
	}

}

class PackageTableModel extends AbstractTableModel {

	int pnumber;
	String[] columnNames = new String[] { "单号", "发送地址", "接收地址", "发货时间", "接收时间", "费用", "接收人手机号","对方签收" };
	public List<Package> list = null;
	public PackageTableModel(int pnumber) {
		this.pnumber = pnumber;
		try {
			list = ServiceFactory.getIPersonServiceInstance().SelectPack(pnumber);
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
			return p.getSendaddress();
		if (2 == columnIndex)
			return p.getGetaddress();
		if (3 == columnIndex)
			return p.getSendtime();
		if (4 == columnIndex)
			return p.getGettime();
		if (5 == columnIndex)
			return p.getMoney();
		if (6 == columnIndex)
			return p.getPhone();
		if (7 == columnIndex)
			return p.getSign();
		return null;
	}

}