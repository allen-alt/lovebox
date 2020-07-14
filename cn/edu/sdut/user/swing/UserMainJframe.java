package cn.edu.sdut.user.swing;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import cn.edu.sdut.bill.swing.BillJframe;
import cn.edu.sdut.goods.swing.GoodsJframe;

import java.awt.Toolkit;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class UserMainJframe extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserMainJframe frame = new UserMainJframe();
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
	public UserMainJframe() {
		setTitle("用户主界面");
		setIconImage(Toolkit.getDefaultToolkit().getImage(UserMainJframe.class.getResource("/images/title.gif")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 864, 566);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu menu = new JMenu(" 用户信息  ");
		menu.setFont(new Font("幼圆", Font.PLAIN, 15));
		menu.setIcon(new ImageIcon(UserMainJframe.class.getResource("/images/user1.gif")));
		menuBar.add(menu);
		
		JMenuItem menuItem_4 = new JMenuItem("查看用户信息");
		menuItem_4.setFont(new Font("新宋体", Font.PLAIN, 15));
		menuItem_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lookuser(e);
				
				
			}
		});
		menu.add(menuItem_4);
		
		JMenu menu_1 = new JMenu(" 商品信息  ");
		menu_1.setFont(new Font("幼圆", Font.PLAIN, 15));
		menu_1.setIcon(new ImageIcon(UserMainJframe.class.getResource("/images/goods3.gif")));
		menuBar.add(menu_1);
		
		JMenuItem menuItem_3 = new JMenuItem("查看商品列表");
		menuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GoodList(e);
			}
		});
		menu_1.add(menuItem_3);
		
		JMenu menu_2 = new JMenu(" 订单信息  ");
		menu_2.setFont(new Font("幼圆", Font.PLAIN, 15));
		menu_2.setIcon(new ImageIcon(UserMainJframe.class.getResource("/images/list3.gif")));
		menuBar.add(menu_2);
		
		JMenuItem menuItem_2 = new JMenuItem("查看订单列表");
		menuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LookBill(e);
			}
		});
		menu_2.add(menuItem_2);
		
		JMenu menu_3 = new JMenu(" 关于我们  ");
		menu_3.setFont(new Font("幼圆", Font.PLAIN, 15));
		menu_3.setIcon(new ImageIcon(UserMainJframe.class.getResource("/images/about3.gif")));
		menuBar.add(menu_3);
		
		JMenuItem menuItem_1 = new JMenuItem("查看关于我们");
		menuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				aboutMenu(e);
				
			}
		});
		menu_3.add(menuItem_1);
		
		JMenu menu_4 = new JMenu("退出系统   ");
		menu_4.setFont(new Font("幼圆", Font.PLAIN, 15));
		menu_4.setIcon(new ImageIcon(UserMainJframe.class.getResource("/images/tuichu1.gif")));
		menuBar.add(menu_4);
		
		JMenuItem menuItem = new JMenuItem("点击退出系统");
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				exitMenu(e);
			}
		});
		menu_4.add(menuItem);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		this.setLocationRelativeTo(null);
		//窗体最大化
//		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
	}

	protected void GoodList(ActionEvent e) {
		new GoodsJframe().setVisible(true);
		
	}

	protected void LookBill(ActionEvent e) {
		new BillJframe().setVisible(true);
		
	}

	protected void lookuser(ActionEvent e) {
		new LookUserJframe().setVisible(true);
		
	}

	protected void aboutMenu(ActionEvent e) {
		new AboutJframe().setVisible(true);
		
	}

	protected void exitMenu(ActionEvent e) {
		this.dispose();
	}

}
