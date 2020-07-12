package cn.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class MainFrm extends JFrame {

	private JPanel contentPane;
	private JDesktopPane table=null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrm frame = new MainFrm();
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
	public MainFrm() {
		setTitle("管理员主界面");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("数据维护");
		menuBar.add(mnNewMenu);
		
		JMenu mnNewMenu_2 = new JMenu("生鲜类别管理");
		mnNewMenu.add(mnNewMenu_2);
		
		JMenuItem menuItem_2 = new JMenuItem("生鲜类别添加");
		menuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SxTypeAddInterFrm shengxianTypeAddInterFrm=new SxTypeAddInterFrm();
				
				table.add(shengxianTypeAddInterFrm);
				shengxianTypeAddInterFrm.setVisible(true);
			}
		});
		mnNewMenu_2.add(menuItem_2);
		
		JMenuItem menuItem_3 = new JMenuItem("生鲜类别维护");
		mnNewMenu_2.add(menuItem_3);
		
		JMenu menu = new JMenu("商品管理");
		mnNewMenu.add(menu);
		
		JMenuItem menuItem = new JMenuItem("商品添加");
		menu.add(menuItem);
		
		JMenuItem menuItem_1 = new JMenuItem("商品维护");
		menu.add(menuItem_1);
		
		JMenu menu_1 = new JMenu("菜谱管理");
		mnNewMenu.add(menu_1);
		
		JMenu menu_2 = new JMenu("优惠券管理");
		mnNewMenu.add(menu_2);
		
		JMenu menu_3 = new JMenu("管理员信息管理");
		mnNewMenu.add(menu_3);
		
		JMenu menu_4 = new JMenu("商品采购管理");
		mnNewMenu.add(menu_4);
		
		JMenu mnNewMenu_1 = new JMenu("采购商品");
		menuBar.add(mnNewMenu_1);
		
		JMenu mnNewMenu_3 = new JMenu("关于我们");
		menuBar.add(mnNewMenu_3);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("关于Java1234");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Java1234InterFrm java1234InterFrm=new Java1234InterFrm();
				
				table.add(java1234InterFrm);
				java1234InterFrm.setVisible(true);
				
			}
		});
		mnNewMenu_3.add(mntmNewMenuItem);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		table = new JDesktopPane();
		table.setBackground(Color.WHITE);
		contentPane.add(table, BorderLayout.CENTER);
		table.setLayout(new BorderLayout(0, 0));
		
		JDesktopPane table_1 = new JDesktopPane();
		table.add(table_1, BorderLayout.CENTER);
		GroupLayout gl_table_1 = new GroupLayout(table_1);
		gl_table_1.setHorizontalGroup(
			gl_table_1.createParallelGroup(Alignment.LEADING)
				.addGap(0, 440, Short.MAX_VALUE)
		);
		gl_table_1.setVerticalGroup(
			gl_table_1.createParallelGroup(Alignment.LEADING)
				.addGap(0, 254, Short.MAX_VALUE)
		);
		table_1.setLayout(gl_table_1);
		
		//设置JFrame最大化
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
	}
}
