package cn.wlgl.Companywindows;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import cn.wlgl.factory.ServiceFactory;
import cn.wlgl.vo.NewPackage;
import cn.wlgl.vo.Package;
import cn.wlgl.vo.Person;

import javax.swing.JMenuBar;
import javax.swing.JToolBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

public class JCompanyMain extends JFrame implements Runnable {
	private JPanel contentPane;
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy��MM��dd�� hhʱmm��ss��");
	JLabel lblNewLabel = null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JCompanyMain frame = new JCompanyMain();
					new Thread(frame).start();
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
	public JCompanyMain() {
		setTitle("\u516C\u53F8\u7BA1\u7406\u754C\u9762");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 463, 319);
		setLocationRelativeTo(null);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 457, 23);
		contentPane.add(menuBar);

		//�ļ�
		JMenu mnNewMenu = new JMenu("\u6587\u4EF6");
		menuBar.add(mnNewMenu);

		//ע����¼
		JMenuItem mntmNewMenuItem = new JMenuItem("\u6CE8\u9500\u767B\u5F55");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JCompanyLogin jcl = new JCompanyLogin();
				jcl.setVisible(true);
				dispose();
			}
		});
		mnNewMenu.add(mntmNewMenuItem);

		//�˳�
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("\u9000\u51FA\u7A0B\u5E8F");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		mnNewMenu.add(mntmNewMenuItem_1);

		//����
		JMenu mnNewMenu_1 = new JMenu("\u529F\u80FD");
		menuBar.add(mnNewMenu_1);

		//�����ܹ���
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("\u5305\u88F9\u603B\u7BA1\u7406");
		mntmNewMenuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JCompanyManage jcm = new JCompanyManage();
				jcm.setVisible(true);
			}
		});
		mnNewMenu_1.add(mntmNewMenuItem_3);

		//ͳ�ư���
		JMenuItem mntmNewMenuItem_4 = new JMenuItem("\u7EDF\u8BA1\u5305\u88F9");
		mntmNewMenuItem_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JCompanyCount jcc = new JCompanyCount();
				jcc.setVisible(true);
			}
		});
		mnNewMenu_1.add(mntmNewMenuItem_4);
		
		//ɾ������
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("\u5220\u9664\u5305\u88F9");
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JCompanyDel jd = new JCompanyDel();
				jd.setVisible(true);
			}
		});
		mnNewMenu_1.add(mntmNewMenuItem_2);
		
		//�޸İ���
		JMenuItem mntmNewMenuItem_5 = new JMenuItem("\u7B7E\u6536\u5305\u88F9");
		mntmNewMenuItem_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		mnNewMenu_1.add(mntmNewMenuItem_5);

		//����
		JMenu mnNewMenu_4 = new JMenu("\u5173\u4E8E");
		menuBar.add(mnNewMenu_4);

		//����˵��
		JMenuItem mntmNewMenuItem_8 = new JMenuItem("\u5E2E\u52A9\u8BF4\u660E");
		mnNewMenu_4.add(mntmNewMenuItem_8);

		//������
		JMenuItem mntmNewMenuItem_9 = new JMenuItem("\u8457\u4F5C\u4EBA");
		mnNewMenu_4.add(mntmNewMenuItem_9);

		JToolBar toolBar = new JToolBar();
		toolBar.setBounds(0, 23, 457, 23);
		contentPane.add(toolBar);

		//�����ܹ���
		JButton btnNewButton_1 = new JButton("\u5305\u88F9\u603B\u7BA1\u7406");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JCompanyManage jcm = new JCompanyManage();
				jcm.setVisible(true);
			}
		});
		toolBar.add(btnNewButton_1);

		//ͳ�ư���
		JButton btnNewButton_2_2 = new JButton("\u7EDF\u8BA1\u5305\u88F9");
		btnNewButton_2_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JCompanyCount jcc = new JCompanyCount();
				jcc.setVisible(true);
			}
		});
		toolBar.add(btnNewButton_2_2);
		
		//ɾ������
		JButton btnNewButton = new JButton("\u5220\u9664\u5305\u88F9");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JCompanyDel jd = new JCompanyDel();
				jd.setVisible(true);
			}
		});
		toolBar.add(btnNewButton);
		
		//�޸İ���
		JButton btnNewButton_2 = new JButton("\u7B7E\u6536\u5305\u88F9");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				List<NewPackage> list;
				try {
					list = ServiceFactory.getICompanyServiceInstance().SelectNewAll();
					int[] enumber = new int[10000];
					int i = 0;
					for(NewPackage p : list) {
						enumber[i++] = p.getEnumber();
					}

					JCompanyUpdate ju = new JCompanyUpdate(enumber);
					ju.setVisible(true);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}				
			}
		});
		toolBar.add(btnNewButton_2);

		//ͳ��ʱ�䣬���̲߳���
		lblNewLabel = new JLabel(sdf.format(new Date()));
		lblNewLabel.setBounds(125, 205, 227, 76);
		contentPane.add(lblNewLabel);
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while (true) {
			try {
				Thread.sleep(100);// Thread.Sleep()�������ڽ���ǰ�߳�����һ��ʱ�䣬��λΪ���롣����Ϊÿ100��������һ���̡߳�
				lblNewLabel.setText(sdf.format(new Date()));// �ѵ�ǰ��ϵͳʱ�丳�赽�����Զ����JLabel��
			} catch (InterruptedException e) {
				e.printStackTrace();// �׳��쳣
			}
		}
	}
}
