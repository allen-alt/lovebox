package cn.view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;

import cn.dao.SxTypeDao;
import cn.model.SxType;
import cn.util.DbUtil;
import cn.util.StringUtil;

public class SxTypeAddInterFrm extends JInternalFrame {
	private JTextField sxTypeNameTxt;
	private JTextArea sxTypeDescTxt;
	
	private DbUtil dbUtil=new DbUtil();
	private SxTypeDao sxTypeDao=new SxTypeDao();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SxTypeAddInterFrm frame = new SxTypeAddInterFrm();
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
	public SxTypeAddInterFrm() {
		setClosable(true);
		setIconifiable(true);
		setTitle("生鲜类别添加");
		setBounds(100, 100, 450, 300);
		
		JLabel lblNewLabel = new JLabel("生鲜类别名称");
		
		JLabel lblNewLabel_1 = new JLabel("生鲜类别描述");
		
		sxTypeNameTxt = new JTextField();
		sxTypeNameTxt.setColumns(10);
		
		sxTypeDescTxt = new JTextArea();
		
		JButton btnNewButton = new JButton("添加");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sxTypeAddActionPerformed(e);
			}
		});
		
		JButton btnNewButton_1 = new JButton("重置");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resetValueActionPerformed(e);
			}
		});
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(32)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblNewLabel)
									.addGap(26)
									.addComponent(sxTypeNameTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
									.addComponent(btnNewButton_1)
									.addGroup(groupLayout.createSequentialGroup()
										.addComponent(lblNewLabel_1)
										.addGap(18)
										.addComponent(sxTypeDescTxt, GroupLayout.PREFERRED_SIZE, 154, GroupLayout.PREFERRED_SIZE)))))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(17)
							.addComponent(btnNewButton)))
					.addContainerGap(144, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(61)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(sxTypeNameTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(42)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1)
						.addComponent(sxTypeDescTxt, GroupLayout.PREFERRED_SIZE, 67, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton)
						.addComponent(btnNewButton_1))
					.addContainerGap(17, Short.MAX_VALUE))
		);
		getContentPane().setLayout(groupLayout);

	}
	/**
	 * 生鲜类别添加事件处理
	 * @param e
	 */
	private void sxTypeAddActionPerformed(ActionEvent evt) {
		String sxTypeName=this.sxTypeNameTxt.getText();
		String sxTypeDesc=this.sxTypeDescTxt.getText();
		if(StringUtil.isEmpty(sxTypeName)) {
			JOptionPane.showMessageDialog(null, "生鲜类别名称不能为空!");
			return ;
		}
		SxType sxType=new SxType(sxTypeName,sxTypeDesc);
		Connection con=null;
		try {
			con=dbUtil.getConnection();
			int n=sxTypeDao.add(con,sxType);
			if(n==1) {
				JOptionPane.showMessageDialog(null,"生鲜类别添加成功!");
				resetValue();
			}else {
				JOptionPane.showMessageDialog(null,"生鲜类别添加失败!");
			}
		}catch(Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null,"生鲜类别添加失败!");
		}finally {
			try {
				dbUtil.closeCon(con);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	/**
	 * 重置事件处理
	 * @param evt
	 */
	private void resetValueActionPerformed(ActionEvent evt) {
		this.resetValue();
		
	}

	/**
	 * 重置表单
	 */
	private void resetValue() {
		this.sxTypeNameTxt.setText("");
		this.sxTypeDescTxt.setText("");
	}
	
}
