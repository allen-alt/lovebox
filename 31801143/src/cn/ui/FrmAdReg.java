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

public class FrmAdReg extends JDialog implements ActionListener{
	private JPanel toolBar = new JPanel();
	private JPanel workPane = new JPanel();
	private Button btnOk = new Button("注册");
	private Button btnCancel = new Button("取消");
	
	
	private JLabel labelstuff_name = new JLabel("员工姓名：");
	private JLabel labelpwd = new JLabel("密码：");
	
	private JTextField edtstuff_name = new JTextField(20);
	private JPasswordField edtpwd = new JPasswordField(20);
	
	
	
	public FrmAdReg (Dialog f, String s, boolean b) {
		super(f, s, b);
		toolBar.setLayout(new FlowLayout(FlowLayout.RIGHT));
		toolBar.add(this.btnOk);
		toolBar.add(btnCancel);
		this.getContentPane().add(toolBar, BorderLayout.SOUTH);
		
		workPane.add(labelstuff_name);
		workPane.add(edtstuff_name);
		workPane.add(labelpwd);
		workPane.add(edtpwd);
		
		
		
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
			String stuff_name=new String(this.edtstuff_name.getText());
			
			String stuff_pwd=new String(this.edtpwd.getPassword());
			String pwd1=new String(this.edtpwd.getPassword());
			
			try {
				Ad pwd=(new AdManager()).reg(pwd1);
				JOptionPane.showMessageDialog(null, "注册成功","成功",JOptionPane.INFORMATION_MESSAGE);
				this.setVisible(false);
			} catch (BaseException e1) {
				JOptionPane.showMessageDialog(null, e1.getMessage(),"错误",JOptionPane.ERROR_MESSAGE);
				return;
			}
			
		}
	}
	
}
