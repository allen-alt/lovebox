package cn.ui;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Dialog;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import cn.util.*;
import cn.model.*;
import cn.control.*;

public class FrmUserReg extends JDialog implements ActionListener{
	private JPanel toolBar = new JPanel();
	private JPanel workPane = new JPanel();
	private Button btnOk = new Button("注册");
	private Button btnCancel = new Button("取消");
	
	private JLabel labeluser_name = new JLabel("姓名：");
	private JLabel labelsex = new JLabel("性别：");
	private JLabel labelPwd = new JLabel("密码：");
	private JLabel labelphone = new JLabel("手机号码：");
	private JLabel labelemail = new JLabel("邮箱：");
	private JLabel labelcity = new JLabel("所在城市：");
	private JLabel labelifvip = new JLabel("是否会员：");
	private JLabel labelviptime = new JLabel("会员时长(月)：");
	
	private JPasswordField edtuser_name = new JPasswordField(20);
	private JPasswordField edtsex = new JPasswordField(20);
	private JPasswordField edtPwd = new JPasswordField(20);
	private JPasswordField edtphone = new JPasswordField(20);
	private JPasswordField edtemail = new JPasswordField(20);
	private JPasswordField edtcity = new JPasswordField(20);
	private JPasswordField edtifvip = new JPasswordField(20);
	private JPasswordField edtviptime = new JPasswordField(20);
	
	public FrmUserReg (Dialog f, String s, boolean b) {
		super(f, s, b);
		toolBar.setLayout(new FlowLayout(FlowLayout.RIGHT));
		toolBar.add(this.btnOk);
		toolBar.add(btnCancel);
		this.getContentPane().add(toolBar, BorderLayout.SOUTH);
		
		workPane.add(labeluser_name);
		workPane.add(edtuser_name);
		workPane.add(labelsex);
		workPane.add(edtsex);
		workPane.add(labelPwd);
		workPane.add(edtPwd);
		workPane.add(labelphone);
		workPane.add(edtphone);
		workPane.add(labelemail);
		workPane.add(edtemail);
		workPane.add(labelcity);
		workPane.add(edtcity);
		workPane.add(labelifvip);
		workPane.add(edtifvip);
		workPane.add(labelviptime);
		workPane.add(edtviptime);
		
		
		this.getContentPane().add(workPane, BorderLayout.CENTER);
		this.setSize(250, 500);
		this.btnCancel.addActionListener(this);
		this.btnOk.addActionListener(this);
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==this.btnCancel)
			this.setVisible(false);
		else if(e.getSource()==this.btnOk){
			String user_name=new String(this.edtPwd.getPassword());
			
			String pwd1=new String(this.edtPwd.getPassword());
			
			try {
				User user=(new userManager()).reg(pwd1);
				JOptionPane.showMessageDialog(null, "注册成功","成功",JOptionPane.INFORMATION_MESSAGE);
				this.setVisible(false);
			} catch (BaseException e1) {
				JOptionPane.showMessageDialog(null, e1.getMessage(),"错误",JOptionPane.ERROR_MESSAGE);
				return;
			}
			
		}
	}
	
}
