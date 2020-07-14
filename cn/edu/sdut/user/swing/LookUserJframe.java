package cn.edu.sdut.user.swing;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import cn.edu.sdut.comm.CommonUtils;
import cn.edu.sdut.comm.prorperties.factory.BeanFactory;
import cn.edu.sdut.user.Com;
import cn.edu.sdut.user.dao.UserDao;
import cn.edu.sdut.user.entity.Tbuser;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Color;
import java.awt.SystemColor;

public class LookUserJframe extends JFrame {

	private JPanel contentPane;
	private JTextField useridtext;
	private JTextField usernametext;
	private JTextField usernicktext;
	private JTextField emailtext;
	private JTextField teltext;
	private JTextField adresstext;
	private JLabel label_6;
	private JTextField timetext;
	private JButton button;
	private JButton closebutton;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LookUserJframe frame = new LookUserJframe();
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
	public LookUserJframe() {
		setTitle("用户信息");
		setIconImage(Toolkit.getDefaultToolkit().getImage(LookUserJframe.class.getResource("/images/title.gif")));
		setBounds(100, 100, 516, 326);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.control);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel label = new JLabel("用户编号：");
		label.setFont(new Font("幼圆", Font.PLAIN, 15));
		label.setIcon(null);
		
		useridtext = new JTextField();
		useridtext.setEnabled(false);
		useridtext.setColumns(10);
		
		JLabel label_1 = new JLabel("用户名：");
		label_1.setFont(new Font("幼圆", Font.PLAIN, 15));
		
		usernametext = new JTextField();
		usernametext.setColumns(10);
		
		JLabel label_2 = new JLabel("用户昵称");
		label_2.setFont(new Font("幼圆", Font.PLAIN, 15));
		
		usernicktext = new JTextField();
		usernicktext.setColumns(10);
		
		JLabel label_3 = new JLabel("邮  箱：");
		label_3.setFont(new Font("幼圆", Font.PLAIN, 15));
		
		emailtext = new JTextField();
		emailtext.setColumns(10);
		
		JLabel label_4 = new JLabel("电话号码：");
		label_4.setFont(new Font("幼圆", Font.PLAIN, 15));
		
		teltext = new JTextField();
		teltext.setColumns(10);
		
		JLabel label_5 = new JLabel("收货地址：");
		label_5.setFont(new Font("幼圆", Font.PLAIN, 15));
		
		adresstext = new JTextField();
		adresstext.setColumns(10);
		
		label_6 = new JLabel("注册时间：");
		label_6.setFont(new Font("幼圆", Font.PLAIN, 15));
		
		timetext = new JTextField();
		timetext.setEnabled(false);
		timetext.setColumns(10);
		
		button = new JButton("修改");
		button.setFont(new Font("幼圆", Font.PLAIN, 15));
		button.setIcon(new ImageIcon(LookUserJframe.class.getResource("/images/xiugai.png")));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updateUserInfo(e);
				
			}
		});
		
		closebutton = new JButton("关闭");
		closebutton.setFont(new Font("幼圆", Font.PLAIN, 15));
		closebutton.setIcon(new ImageIcon(LookUserJframe.class.getResource("/images/de.png")));
		closebutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				closeButton(e);
			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(38)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(label)
										.addComponent(label_2))
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(useridtext, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(usernicktext, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(label_4)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(teltext, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(label_5)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(adresstext, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
							.addGap(34)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(label_3)
								.addComponent(label_6)
								.addComponent(label_1)))
						.addComponent(button))
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(usernametext, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(timetext, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(emailtext, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(27)
							.addComponent(closebutton)))
					.addContainerGap(64, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(33)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(label)
						.addComponent(useridtext, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_1)
						.addComponent(usernametext, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(28)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_2)
						.addComponent(usernicktext, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_3)
						.addComponent(emailtext, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(27)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_4)
						.addComponent(teltext, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_6)
						.addComponent(timetext, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(26)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_5)
						.addComponent(adresstext, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(6)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(button)
						.addComponent(closebutton))
					.addContainerGap(26, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
		this.setLocationRelativeTo(null);
		queryuserInfo(Com.userid);
//		queryuserInfo(2);
	}
	protected void updateUserInfo(ActionEvent e) {
		String username = this.usernametext.getText();
		String nickname = this.usernicktext.getText();
		String email = this.emailtext.getText();
		String tel = this.teltext.getText();
		String address = this.adresstext.getText();
		Tbuser tbuser = new Tbuser();
		if(this.usernametext.getText().isEmpty())
		{
			JOptionPane.showMessageDialog(this, "用户名不能为空！");
			return ;
		}
		if(nickname.isEmpty())
		{
			JOptionPane.showMessageDialog(this, "昵称不能为空！");
			return ;
		}
		if(tel.isEmpty())
		{
			JOptionPane.showMessageDialog(this, "手机号码不能为空！");
			return ;
		}
		tbuser.setUsername(username);
		tbuser.setNickname(nickname);
		tbuser.setEmail(email);
		tbuser.setTel(tel);
		tbuser.setAddress(address);
		tbuser.setUserid(Com.userid);
//		tbuser.setUserid(2);
		int row = dao.updateUserInformation(tbuser);
		if(row>0)
		{
			JOptionPane.showMessageDialog(this, "修改成功！");
			this.queryuserInfo(Com.userid);
//			this.queryuserInfo(2);
		}
		else
		{
			JOptionPane.showMessageDialog(this, "修改失败！");
		}
		
	}

	private void queryuserInfo(Integer userid)
	{
		Tbuser tbuser = dao.selectUserById(userid);
//		System.out.println(userid);
//		System.out.println(tbuser);
		this.useridtext.setText(tbuser.getUserid().toString());
		this.usernametext.setText(tbuser.getUsername());
		this.usernicktext.setText(tbuser.getNickname());
		this.emailtext.setText(tbuser.getEmail());
		this.teltext.setText(tbuser.getTel());
		this.timetext.setText(tbuser.getRegtime().toString());
		this.adresstext.setText(tbuser.getAddress());
	}
	
	protected void closeButton(ActionEvent e) {
		this.dispose();
	}
	private UserDao dao = BeanFactory.getInstance(CommonUtils.UserInfo.USERDAO);
}
