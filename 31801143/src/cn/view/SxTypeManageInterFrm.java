package cn.view;



import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Vector;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import cn.dao.SxTypeDao;
import cn.model.SxType;
import cn.util.DbUtil;
import cn.util.StringUtil;





public class SxTypeManageInterFrm extends JInternalFrame {

	private JTable sxTypeTable;
	private JTextArea sxTypeDescTxt;

	

	private DbUtil dbUtil=new DbUtil();

	private SxTypeDao sxTypeDao=new SxTypeDao();
	private JTextField s_sxTypeNameTxt;
	private JTextField idTxt;
	private JTextField sxTypeNameTxt;



	/**
	* Launch the application.
	*/

	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SxTypeManageInterFrm frame = new SxTypeManageInterFrm();
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

	public SxTypeManageInterFrm() {
		setClosable(true);
		setIconifiable(true);
		setTitle("生鲜类别管理");
		setBounds(100, 100, 498, 485);

		

		JScrollPane scrollPane = new JScrollPane();
		
		JLabel label = new JLabel("\u751F\u9C9C\u7C7B\u522B\u540D\u79F0");
		
		s_sxTypeNameTxt = new JTextField();
		s_sxTypeNameTxt.setColumns(10);
		
		JButton button = new JButton("\u67E5\u8BE2");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sxTypeSearchActionPerformed(e);
			}
			
		});
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "\u8868\u5355\u64CD\u4F5C", TitledBorder.LEADING, TitledBorder.TOP, null, null));

		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
					.addGap(49)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(panel, Alignment.LEADING, 0, 0, Short.MAX_VALUE)
						.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
							.addComponent(label)
							.addGap(18)
							.addComponent(s_sxTypeNameTxt, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)
							.addGap(27)
							.addComponent(button, GroupLayout.PREFERRED_SIZE, 106, GroupLayout.PREFERRED_SIZE))
						.addComponent(scrollPane, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 382, Short.MAX_VALUE))
					.addContainerGap(43, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
					.addGap(39)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label)
						.addComponent(s_sxTypeNameTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(button))
					.addGap(18)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 104, GroupLayout.PREFERRED_SIZE)
					.addGap(36)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 195, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(18, Short.MAX_VALUE))
		);
		
		JLabel lblNewLabel = new JLabel("编号");
		
		idTxt = new JTextField();
		idTxt.setEditable(false);
		idTxt.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("生鲜类别名称");
		
		sxTypeNameTxt = new JTextField();
		sxTypeNameTxt.setColumns(10);
		
		JLabel label_1 = new JLabel("描述");
		
		sxTypeDescTxt = new JTextArea();
		
		JButton btnNewButton = new JButton("修改");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sxTypeUpdateActionEvent(e);
			}
		});
		
		JButton btnNewButton_1 = new JButton("删除");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sxTypeDeleteActionEvent(e);
			}
		});
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(lblNewLabel)
									.addGap(18)
									.addComponent(idTxt, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
									.addGap(38)
									.addComponent(lblNewLabel_1)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(sxTypeNameTxt, GroupLayout.PREFERRED_SIZE, 104, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(label_1)
									.addGap(18)
									.addComponent(sxTypeDescTxt, GroupLayout.PREFERRED_SIZE, 303, GroupLayout.PREFERRED_SIZE))))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(16)
							.addComponent(btnNewButton)
							.addGap(57)
							.addComponent(btnNewButton_1)))
					.addContainerGap(54, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(idTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_1)
						.addComponent(sxTypeNameTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_1)
						.addComponent(sxTypeDescTxt, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton)
						.addComponent(btnNewButton_1))
					.addGap(20))
		);
		panel.setLayout(gl_panel);

		

		sxTypeTable = new JTable();
		sxTypeTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				sxTypeTableMousePressed(e);
			}
		});

		sxTypeTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u7F16\u53F7", "\u751F\u9C9C\u7C7B\u522B\u540D\u79F0", "\u751F\u9C9C\u7C7B\u522B\u63CF\u8FF0"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});

		sxTypeTable.getColumnModel().getColumn(1).setPreferredWidth(133);
		sxTypeTable.getColumnModel().getColumn(2).setPreferredWidth(213);
		scrollPane.setViewportView(sxTypeTable);

		getContentPane().setLayout(groupLayout);

		

		this.fillTable(new SxType());



	}
	/**
	 * 生鲜类别删除事件处理
	 * @param e
	 */

	private void sxTypeDeleteActionEvent(ActionEvent evt) {
		String id=idTxt.getText();
		if(StringUtil.isEmpty(id)) {
			JOptionPane.showMessageDialog(null,"请选择要删除的记录");
			return ;
		}
		int n=JOptionPane.showConfirmDialog(null, "确定要删除该记录吗?");
		if(n==0) {
			Connection con=null;
			try {
				con=dbUtil.getConnection();
				int deleteNum=sxTypeDao.delete(con, id);
				if(deleteNum==1) {
					JOptionPane.showMessageDialog(null,"删除成功");
					this.resetValue();
					this.fillTable(new SxType());
				}else {
					JOptionPane.showMessageDialog(null,"删除失败");
				}
			}catch(Exception e) {
				e.printStackTrace();
			}finally {
				try {
					dbUtil.closeCon(con);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	
	/**
	 * 生鲜类别修改事件处理
	 * @param evt
	 */
	private void sxTypeUpdateActionEvent(ActionEvent evt) {
		String id=idTxt.getText();
		String sxTypeName=sxTypeNameTxt.getText();
		String sxTypeDesc=sxTypeDescTxt.getText();
		if(StringUtil.isEmpty(id)) {
			JOptionPane.showMessageDialog(null,"请选择要修改的记录");
			return ;
		}
		if(StringUtil.isEmpty(sxTypeName)) {
			JOptionPane.showMessageDialog(null,"生鲜类别名称不能为空");
			return ;
		}
		SxType sxType =new SxType(Integer.parseInt(id),sxTypeName,sxTypeDesc);
		Connection con=null;
		try {
			con=dbUtil.getConnection();
			int modifyNum=sxTypeDao.update(con, sxType);
			if(modifyNum==1) {
				JOptionPane.showMessageDialog(null,"修改成功");
				this.resetValue();
				this.fillTable(new SxType());
			}else {
				JOptionPane.showMessageDialog(null,"修改失败");
			}
		}catch(Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null,"修改失败");
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
	 * 表格行点击事件处理
	 * @param e
	 */
	private void sxTypeTableMousePressed(MouseEvent evt) {
		int row=sxTypeTable.getSelectedRow();
		idTxt.setText((String)sxTypeTable.getValueAt(row,0));
		sxTypeNameTxt.setText((String)sxTypeTable.getValueAt(row,1));
		sxTypeDescTxt.setText((String)sxTypeTable.getValueAt(row,2));
	}



	/**
	 * 生鲜类别搜索事件处理
	 * @param evt
	 */

	private void sxTypeSearchActionPerformed(ActionEvent evt) {
		String s_sxTypeName=this.s_sxTypeNameTxt.getText();
		SxType sxType=new SxType();
		sxType.setSxTypeName(s_sxTypeName);
		this.fillTable(sxType);
		
	}



	/**
	 * 初始化表格
	 * @param sxType
	 */

	

	private void fillTable(SxType sxType) {
		DefaultTableModel dtm=(DefaultTableModel) sxTypeTable.getModel();
		dtm.setRowCount(0);//设置成0行
		Connection con=null;

		try {
			con=dbUtil.getConnection();
			ResultSet rs=sxTypeDao.list(con,sxType);
			while(rs.next()) {
				Vector v=new Vector();
				v.add(rs.getString("id"));
				v.add(rs.getString("sxTypeName"));
				v.add(rs.getString("sxTypeDesc"));
				dtm.addRow(v);
			}
		}catch(Exception e) {
			e.printStackTrace();
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
	 * 重置表单
	 */
	private void resetValue() {
		this.idTxt.setText("");
		this.sxTypeNameTxt.setText("");
		this.sxTypeDescTxt.setText("");
	}
	
}