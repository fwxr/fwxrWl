package cn.wlgl.Companywindows;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.AbstractTableModel;

import cn.wlgl.factory.ServiceFactory;
import cn.wlgl.vo.NewPackage;
import cn.wlgl.vo.Package;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class JCompanyCount extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField tcnumber;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JCompanyCount frame = new JCompanyCount();
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
	public JCompanyCount() {
		setTitle("\u5305\u88F9\u7EDF\u8BA1\u754C\u9762");
		setBounds(100, 100, 450, 300);
		setLocationRelativeTo(null);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		ACourierTableModel atm = new ACourierTableModel();
		table = new JTable(atm);
		table.getTableHeader().setReorderingAllowed(false);
		contentPane.setLayout(null);
		JScrollPane sp = new JScrollPane(table);
		sp.setBounds(10, 34, 424, 128);
		contentPane.add(sp);

		JLabel lblNewLabel = new JLabel("\u5305\u88F9\u7EDF\u8BA1\u8868");
		lblNewLabel.setBounds(182, 10, 88, 15);
		contentPane.add(lblNewLabel);

		JButton btnNewButton = new JButton("\u67E5\u8BE2\u603B\u4F53\u8868");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					atm.list = ServiceFactory.getICompanyServiceInstance().SelectNewAll();
					for (NewPackage p : atm.list) {
						atm.slist.add(ServiceFactory.getICompanyServiceInstance().countPackage(p.getEnumber()));
					}
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				table.updateUI();
			}
		});
		btnNewButton.setBounds(10, 172, 104, 23);
		contentPane.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("\u67E5\u8BE2");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (tcnumber.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "快递单号不能为空!!!");
				}
				try {
					atm.list.clear();
					atm.slist.clear();
					if (ServiceFactory.getICompanyServiceInstance().findByEnumber(Integer
							.parseInt(tcnumber.getText().trim())) != null) {
						atm.list.add(ServiceFactory.getICompanyServiceInstance()
								.findByEnumber(Integer.parseInt(tcnumber.getText().trim())));
						for (NewPackage np : atm.list) {
							atm.slist.add(ServiceFactory.getICompanyServiceInstance().countPackage(np.getEnumber()));
						}
					}
				} catch (NumberFormatException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				table.updateUI();
			}
		});
		btnNewButton_1.setBounds(341, 172, 93, 23);
		contentPane.add(btnNewButton_1);

		tcnumber = new JTextField();
		tcnumber.setBounds(243, 173, 88, 21);
		contentPane.add(tcnumber);
		tcnumber.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("\u5FEB\u9012\u5355\u53F7:");
		lblNewLabel_1.setBounds(182, 176, 61, 15);
		contentPane.add(lblNewLabel_1);

		JButton btnNewButton_2 = new JButton("\u9000\u51FA");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnNewButton_2.setBounds(177, 239, 93, 23);
		contentPane.add(btnNewButton_2);
	}
}

class ACourierTableModel extends AbstractTableModel {

	String[] columnNames = new String[] {"单号", "用户编号", "发送地址", "接收地址", "发货时间", "手机号"};
	public List<NewPackage> list = null;
	public List<Integer> slist = new ArrayList<Integer>();

	public ACourierTableModel() {
		try {
			list = ServiceFactory.getICompanyServiceInstance().SelectNewAll();
			for (NewPackage np : list) {
				slist.add(ServiceFactory.getICompanyServiceInstance().countPackage(np.getEnumber()));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

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

	public Object getValueAt(int rowIndex, int columnIndex) {
		NewPackage np = list.get(rowIndex);
		int s = slist.get(rowIndex);
		if (0 == columnIndex)
			return np.getEnumber();
		if (1 == columnIndex)
			return np.getPnumber();
		if (2 == columnIndex)
			return np.getSendaddress();
		if (3 == columnIndex)
			return np.getGetaddress();
		if (4 == columnIndex)
			return np.getSendtime();
		if (5 == columnIndex)
			return np.getPhone();
		if (6 == columnIndex)
			return s;
		return null;
	}

}