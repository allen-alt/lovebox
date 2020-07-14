package cn.edu.sdut.user.swing;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import cn.edu.sdut.admin.swing.AdminMainJframe;
import cn.edu.sdut.comm.CommonUtils;
import cn.edu.sdut.comm.prorperties.factory.BeanFactory;
import cn.edu.sdut.user.Com;
import cn.edu.sdut.user.dao.UserDao;
import cn.edu.sdut.user.entity.Tbuser;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Color;
import java.awt.SystemColor;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField UserText;
	private JPasswordField passwordText;
	private JButton resetbutton;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	public Login() {
		setBackground(new Color(230, 230, 250));
		setTitle("\u767B\u5F55");
		setIconImage(Toolkit.getDefaultToolkit().getImage(Login.class.getResource("/images/title.gif")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 554, 383);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.control);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JLabel Username = new JLabel("\u7528\u6237\u540D\uFF1A");
		Username.setFont(new Font("幼圆", Font.PLAIN, 15));
		Username.setIcon(new ImageIcon(Login.class.getResource("/images/loin.png")));

		JLabel password = new JLabel("密  码：");
		password.setFont(new Font("幼圆", Font.PLAIN, 15));
		password.setIcon(new ImageIcon(Login.class.getResource("/images/pw.png")));

		UserText = new JTextField();
		UserText.setBackground(new Color(255, 255, 255));
		UserText.setColumns(10);

		passwordText = new JPasswordField();
		passwordText.setBackground(new Color(255, 255, 255));

		JButton loginbutton = new JButton("\u767B\u5F55");
		loginbutton.setFont(new Font("幼圆", Font.PLAIN, 15));
		loginbutton.setIcon(new ImageIcon(Login.class.getResource("/images/tic.png")));
		loginbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loginButton(e);
			}
		});

		resetbutton = new JButton("\u91CD\u7F6E");
		resetbutton.setFont(new Font("幼圆", Font.PLAIN, 15));
		resetbutton.setIcon(new ImageIcon(Login.class.getResource("/images/de.png")));
		resetbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resetButton(e);
			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(100)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(Username)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(password, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
						.addComponent(passwordText)
						.addComponent(UserText, GroupLayout.DEFAULT_SIZE, 232, Short.MAX_VALUE))
					.addContainerGap(97, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(122)
					.addComponent(loginbutton)
					.addPreferredGap(ComponentPlacement.RELATED, 121, Short.MAX_VALUE)
					.addComponent(resetbutton)
					.addGap(117))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(82)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(Username)
						.addComponent(UserText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(50)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(password)
						.addComponent(passwordText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(55)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(loginbutton)
						.addComponent(resetbutton))
					.addContainerGap(62, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
		// 默认窗口出现在屏幕中间
		this.setLocationRelativeTo(null);
		// 默认enter会提交登录按钮
		this.getRootPane().setDefaultButton(loginbutton);
	}

	// 重置按钮方法
	protected void resetButton(ActionEvent e) {
		this.UserText.setText("");
		this.passwordText.setText("");
		this.UserText.requestFocus();
	}

	// 登录按钮方法
	protected void loginButton(ActionEvent e) {
		String uname = this.UserText.getText();
		String pdw = new String(this.passwordText.getPassword());
		if (uname.equals("")) {
			JOptionPane.showMessageDialog(this, "请输入用户名！");
			this.UserText.requestFocus();
			return;
		}
		if (pdw.equals("")) {
			JOptionPane.showMessageDialog(this, "请输入密码！");
			this.UserText.requestFocus();
			return;
		}
		if (uname.length() < 3 || uname.length() > 8) {
			JOptionPane.showMessageDialog(this, "用户名必须是3-8位！");
			this.UserText.requestFocus();
			return;
		}
		if (pdw.length() < 3 || pdw.length() > 8) {
			JOptionPane.showMessageDialog(this, "密码必须是3-8位！");
			this.UserText.requestFocus();
			return;
		}

		// 和Mysql数据库进行交互 查询tcbd1011 tbuser表;
		Tbuser user = new Tbuser();
		// 把用户输入的用户名、密码封装在user对象中
		user.setUsername(uname);
		user.setPassword(pdw);
//		 把user对象传给login方法;
		Tbuser u = dao.login(user);
		// 对u对象进行判断
		if (u != null) {
			// 查询到数据库的记录
//				JOptionPane.showMessageDialog(this, "登陆成功");
			// 关闭登陆窗口
			this.dispose();
			// 打开主窗口
//			if(u.getRole()==2)
//			{
			new UserMainJframe().setVisible(true);
			Com.userid=u.getUserid();
//			}
//			else if(u.getRole()==1)
//				new AdminMainJframe().setVisible(true);
		} else {
			// 没有查询到记录
			JOptionPane.showMessageDialog(this, "用户名或密码错误！");
			// 清空用户名、密码，用户名框获得焦点事件
			this.UserText.setText("");
			this.passwordText.setText("");
			this.UserText.requestFocus();
		}
	}

	// 在当前类中写一个dao的属性，左边写接口名;
	private UserDao dao = BeanFactory.getInstance(CommonUtils.UserInfo.USERDAO);
}
