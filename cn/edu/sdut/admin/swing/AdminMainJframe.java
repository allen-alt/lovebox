package cn.edu.sdut.admin.swing;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.ImageIcon;

public class AdminMainJframe extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminMainJframe frame = new AdminMainJframe();
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
	public AdminMainJframe() {
		setTitle("管理者界面");
		setIconImage(Toolkit.getDefaultToolkit().getImage(AdminMainJframe.class.getResource("/images/title.gif")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 603, 408);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("用户管理 ");
		mnNewMenu.setIcon(new ImageIcon(AdminMainJframe.class.getResource("/images/loin.png")));
		mnNewMenu.setFont(new Font("幼圆", Font.PLAIN, 15));
		menuBar.add(mnNewMenu);
		
		JMenuItem menuItem = new JMenuItem("用户列表");
		menuItem.setFont(new Font("幼圆", Font.PLAIN, 15));
		mnNewMenu.add(menuItem);
		
		JMenu mnNewMenu_1 = new JMenu("商品管理 ");
		mnNewMenu_1.setIcon(new ImageIcon(AdminMainJframe.class.getResource("/images/goods.png")));
		mnNewMenu_1.setFont(new Font("幼圆", Font.PLAIN, 15));
		menuBar.add(mnNewMenu_1);
		
		JMenuItem menuItem_1 = new JMenuItem("商品列表");
		menuItem_1.setFont(new Font("幼圆", Font.PLAIN, 15));
		mnNewMenu_1.add(menuItem_1);
		
		JMenuItem menuItem_2 = new JMenuItem("增加商品");
		menuItem_2.setFont(new Font("幼圆", Font.PLAIN, 15));
		mnNewMenu_1.add(menuItem_2);
		
		JMenu mnNewMenu_2 = new JMenu("分类管理 ");
		mnNewMenu_2.setIcon(new ImageIcon(AdminMainJframe.class.getResource("/images/charge.png")));
		mnNewMenu_2.setFont(new Font("幼圆", Font.PLAIN, 15));
		menuBar.add(mnNewMenu_2);
		
		JMenuItem menuItem_3 = new JMenuItem("种类列表");
		menuItem_3.setFont(new Font("幼圆", Font.PLAIN, 15));
		mnNewMenu_2.add(menuItem_3);
		
		JMenuItem menuItem_4 = new JMenuItem("增加种类");
		menuItem_4.setFont(new Font("幼圆", Font.PLAIN, 15));
		mnNewMenu_2.add(menuItem_4);
		
		JMenu mnNewMenu_3 = new JMenu("订单管理 ");
		mnNewMenu_3.setIcon(new ImageIcon(AdminMainJframe.class.getResource("/images/dingdancharge.png")));
		mnNewMenu_3.setFont(new Font("幼圆", Font.PLAIN, 15));
		menuBar.add(mnNewMenu_3);
		
		JMenuItem menuItem_5 = new JMenuItem("订单列表");
		menuItem_5.setFont(new Font("幼圆", Font.PLAIN, 15));
		mnNewMenu_3.add(menuItem_5);
		
		JMenu menu = new JMenu("退出系统 ");
		menu.setIcon(new ImageIcon(AdminMainJframe.class.getResource("/images/de.png")));
		menu.setFont(new Font("幼圆", Font.PLAIN, 15));
		menuBar.add(menu);
		
		JMenuItem menuItem_6 = new JMenuItem("退出系统");
		menuItem_6.setFont(new Font("幼圆", Font.PLAIN, 15));
		menuItem_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				exit(e);
			}
		});
		menu.add(menuItem_6);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGap(0, 633, Short.MAX_VALUE)
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGap(0, 518, Short.MAX_VALUE)
		);
		contentPane.setLayout(gl_contentPane);
		this.setLocationRelativeTo(null);
	}

	protected void exit(ActionEvent e) {
		this.dispose();
		
	}
	
}
