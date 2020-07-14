package cn.edu.sdut.bill.swing;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import java.util.List;
import java.util.Vector;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import cn.edu.sdut.bill.dao.BillDao;
import cn.edu.sdut.bill.entity.Bill;
import cn.edu.sdut.comm.CommonUtils;
import cn.edu.sdut.comm.prorperties.factory.BeanFactory;
import cn.edu.sdut.goods.entity.Goods;
import cn.edu.sdut.user.Com;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Font;
import javax.swing.ImageIcon;

public class BillJframe extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BillJframe frame = new BillJframe();
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
	public BillJframe() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(BillJframe.class.getResource("/images/title.gif")));
		setTitle("订单列表");
		setBounds(100, 100, 1253, 435);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JScrollPane scrollPane = new JScrollPane();
		
		JLabel label = new JLabel("订单编号：");
		label.setFont(new Font("幼圆", Font.PLAIN, 16));
		
		billText = new JTextField();
		billText.setEnabled(false);
		billText.setColumns(10);
		
		JButton button = new JButton("删除订单");
		button.setIcon(new ImageIcon(BillJframe.class.getResource("/images/qingkong.png")));
		button.setFont(new Font("幼圆", Font.PLAIN, 15));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				deleteBill(e);
			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 1197, Short.MAX_VALUE)
							.addContainerGap())
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(label)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(billText, GroupLayout.PREFERRED_SIZE, 134, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(button)
							.addGap(537))))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(19)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 248, GroupLayout.PREFERRED_SIZE)
					.addGap(48)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(label)
						.addComponent(billText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(button))
					.addContainerGap(36, Short.MAX_VALUE))
		);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				selectOne(e);
			}
		});
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u8BA2\u5355\u7F16\u53F7", "\u5546\u54C1\u540D\u79F0", "\u5546\u54C1\u5355\u4EF7", "\u8D2D\u4E70\u6570\u91CF", "\u8BA2\u5355\u603B\u4EF7", "\u624B\u673A\u53F7\u7801", "\u6536\u8D27\u5730\u5740", "\u8BA2\u5355\u65F6\u95F4", "\u914D\u9001\u65B9\u5F0F"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, true, false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		scrollPane.setViewportView(table);
		contentPane.setLayout(gl_contentPane);
		this.setLocationRelativeTo(null);
		Bill bill = new Bill();
		bill.setUserid(Com.userid);
//		bill.setUserid(2);
		getBill(bill);
		//文字居中
		DefaultTableCellRenderer r = new DefaultTableCellRenderer();
		r.setHorizontalAlignment(JLabel.CENTER);
		this.table.setDefaultRenderer(Object.class,r);
	}
	
	
	
	protected void deleteBill(ActionEvent e) {
		Integer billid = Integer.valueOf(this.billText.getText());
		int row = bdao.deleteBill(billid);
		if(row>0)
		{
			JOptionPane.showMessageDialog(this, "删除成功！");
			Bill bill = new Bill();
			bill.setUserid(Com.userid);
			getBill(bill);
		}
		else
		{
			JOptionPane.showMessageDialog(this, "删除失败！");
		}
		
	}

	protected void selectOne(MouseEvent e) {
		int row = this.table.getSelectedRow();
		int billid = (Integer)this.table.getValueAt(row, 0);
		Bill bill = bdao.queryOneBill(billid);
		this.billText.setText(String.valueOf(bill.getBillid()));
	}

	private void getBill(Bill bill) {
		List<Bill> list = bdao.queryAllBill(bill);
//		System.out.println(list);
		DefaultTableModel model = (DefaultTableModel) this.table.getModel();
		model.setRowCount(0);
		if(list.size()>0)
		{
			for (Bill g : list) {
				Vector<Object> vector = new Vector<Object>();
				vector.add(g.getBillid());
				vector.add(g.getBuygoodsname());
				vector.add(g.getBuygoodsprice());
				vector.add(g.getBuygoodsnum());
				vector.add(g.getBilltotalprice());
				vector.add(g.getTel());
				vector.add(g.getAddress());
				vector.add(g.getBilltime());
				if(g.getSendtype()==1)
				{
					vector.add("到店自取");
				}
				else if(g.getSendtype()==2)
				{
					vector.add("快递邮寄");
				}
				vector.add(g.getSendtype());
				model.addRow(vector);
			}
		}
		else
		{
			JOptionPane.showMessageDialog(this, "没有查询到相关记录！");
		}
	}
	private BillDao bdao = BeanFactory.getInstance(CommonUtils.BillInfo.BILLDAO);
	private JTable table;
	private JTextField billText;
	
}
