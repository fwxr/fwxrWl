package cn.wlgl.Personwindows;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import cn.wlgl.vo.Person;

import javax.swing.JMenuBar;
import javax.swing.JToolBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class JPersonMain extends JFrame {
	private static Person p;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JPersonMain frame = new JPersonMain(p);
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
	public JPersonMain(Person p) {
		this.p = p;
		setTitle("\u7528\u6237\u4E3B\u754C\u9762");
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

		JMenu mnNewMenu = new JMenu("\u6587\u4EF6");
		menuBar.add(mnNewMenu);

		JMenuItem mntmNewMenuItem = new JMenuItem("\u6CE8\u9500\u767B\u5F55");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JPersonLogin jl = new JPersonLogin();
				jl.setVisible(true);
				dispose();
			}
		});
		mnNewMenu.add(mntmNewMenuItem);

		JMenuItem mntmNewMenuItem_1 = new JMenuItem("\u9000\u51FA\u7A0B\u5E8F");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		mnNewMenu.add(mntmNewMenuItem_1);

		JMenu mnNewMenu_1 = new JMenu("\u529F\u80FD");
		menuBar.add(mnNewMenu_1);

		JMenuItem mntmNewMenuItem_2 = new JMenuItem("\u4E2A\u4EBA\u4FE1\u606F\u7BA1\u7406");
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JPersonIView jiv = new JPersonIView(p);
				jiv.setVisible(true);
			}
		});
		mnNewMenu_1.add(mntmNewMenuItem_2);

		JMenuItem mntmNewMenuItem_7 = new JMenuItem("\u5BC4\u5305\u88F9");
		mntmNewMenuItem_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JPersonSend jps = new JPersonSend(p);
				jps.setVisible(true);
			}
		});
		mnNewMenu_1.add(mntmNewMenuItem_7);

		JMenuItem mntmNewMenuItem_3 = new JMenuItem("\u67E5\u8BE2\u5305\u88F9");
		mntmNewMenuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JPersonSelect jps = new JPersonSelect(p);
				jps.setVisible(true);
			}
		});
		mnNewMenu_1.add(mntmNewMenuItem_3);

		JMenu mnNewMenu_4 = new JMenu("\u5173\u4E8E");
		menuBar.add(mnNewMenu_4);

		JMenuItem mntmNewMenuItem_8 = new JMenuItem("\u5E2E\u52A9\u8BF4\u660E");
		mnNewMenu_4.add(mntmNewMenuItem_8);

		JMenuItem mntmNewMenuItem_9 = new JMenuItem("\u8457\u4F5C\u4EBA");
		mnNewMenu_4.add(mntmNewMenuItem_9);

		JToolBar toolBar = new JToolBar();
		toolBar.setBounds(0, 23, 457, 23);
		contentPane.add(toolBar);

		//个人信息
		JButton btnNewButton = new JButton("\u4E2A\u4EBA\u4FE1\u606F\u7BA1\u7406");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JPersonIView jiv = new JPersonIView(p);
				jiv.setVisible(true);
			}
		});
		toolBar.add(btnNewButton);

		//寄包裹
		JButton btnNewButton_1 = new JButton("\u5BC4\u5305\u88F9");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JPersonSend jps = new JPersonSend(p);
				jps.setVisible(true);
			}
		});
		toolBar.add(btnNewButton_1);

		//查询包裹
		JButton btnNewButton_2 = new JButton("\u67E5\u8BE2\u5305\u88F9");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JPersonSelect jps = new JPersonSelect(p);
				jps.setVisible(true);
			}
		});
		toolBar.add(btnNewButton_2);
		
	}
}
