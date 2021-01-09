package cn.wlgl.Companywindows;

import java.awt.EventQueue;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.AbstractTableModel;

import cn.wlgl.factory.ServiceFactory;
import cn.wlgl.vo.NewPackage;

import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class JCompanyUpdate extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private static int[] enumber;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JCompanyUpdate frame = new JCompanyUpdate(enumber);
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
	public JCompanyUpdate(int[] enumber) {
		this.enumber = enumber;
		setTitle("\u5305\u88F9\u4FEE\u6539\u8868");
		setBounds(100, 100, 450, 300);
		setLocationRelativeTo(null);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("\u5FEB\u9012\u4FE1\u606F\u8868");
		lblNewLabel.setBounds(168, 10, 80, 15);
		contentPane.add(lblNewLabel);

		INewPackageTableModel ctm = new INewPackageTableModel();
		
		table = new JTable(ctm);
		table.getTableHeader().setReorderingAllowed(false);
		contentPane.setLayout(null);
		contentPane.setLayout(null);
		JScrollPane sp = new JScrollPane(table);
		sp.setBounds(10, 35, 414, 128);
		contentPane.add(sp);

		JButton btnNewButton = new JButton("\u9000\u51FA");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnNewButton.setBounds(71, 196, 93, 23);
		contentPane.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("\u786E\u8BA4\u4FEE\u6539");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int c = (int) table.getValueAt(table.getSelectedRow(), 0);
					ServiceFactory.getICompanyServiceInstance().updatePackage(enumber, c);
					dispose();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_1.setBounds(259, 196, 93, 23);
		contentPane.add(btnNewButton_1);
	}
}

class INewPackageTableModel extends AbstractTableModel {

	String[] columnNames = new String[] { "单号", "发送地址", "接收地址", "发货时间", "接收人手机号" };
	public List<NewPackage> list = null;

	public INewPackageTableModel() {
		try {
			list = ServiceFactory.getICompanyServiceInstance().SelectNewAll();
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