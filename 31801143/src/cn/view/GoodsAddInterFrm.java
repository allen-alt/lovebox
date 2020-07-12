package cn.view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;

import cn.dao.GoodsDao;
import cn.dao.SxTypeDao;
import cn.model.Goods;
import cn.model.SxType;
import cn.util.DbUtil;
import cn.util.StringUtil;

public class GoodsAddInterFrm extends JInternalFrame {
	private JTextField goodsNameTxt;
	private JTextField priceTxt;
	private JTextField vippriceTxt;
	private JTextField amountTxt;
	private JTextField guigeTxt;
	private JComboBox goodsTypeJcb;
	private JTextArea goodsDescTxt;
	
	
	private DbUtil dbUtil=new DbUtil();
	private SxTypeDao sxTypeDao=new SxTypeDao();
	private GoodsDao goodsDao=new GoodsDao();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GoodsAddInterFrm frame = new GoodsAddInterFrm();
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
	public GoodsAddInterFrm() {
		setClosable(true);
		setIconifiable(true);
		setTitle("商品添加");
		setBounds(100, 100, 481, 474);
		
		JLabel lblNewLabel = new JLabel("商品名称");
		
		goodsNameTxt = new JTextField();
		goodsNameTxt.setColumns(10);
		
		JLabel label = new JLabel("商品价格");
		
		priceTxt = new JTextField();
		priceTxt.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("商品vip价格");
		
		vippriceTxt = new JTextField();
		vippriceTxt.setColumns(10);
		
		JLabel label_1 = new JLabel("商品数量");
		
		amountTxt = new JTextField();
		amountTxt.setColumns(10);
		
		JLabel label_2 = new JLabel("商品规格");
		
		guigeTxt = new JTextField();
		guigeTxt.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("商品详情");
		
		goodsDescTxt = new JTextArea();
		
		JLabel label_3 = new JLabel("商品类别");
		
		goodsTypeJcb = new JComboBox();
		
		JButton btnNewButton = new JButton("添加");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				goodsAddActionPerformed(e);
			}
		});
		
		JButton button = new JButton("重置");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resetValueActionPerformed(e);
			}
		});
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(24)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNewLabel)
								.addComponent(label))
							.addGap(30)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addComponent(goodsNameTxt, 0, 0, Short.MAX_VALUE)
								.addComponent(priceTxt, GroupLayout.DEFAULT_SIZE, 98, Short.MAX_VALUE))
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(55)
									.addComponent(label_3))
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(46)
									.addComponent(goodsTypeJcb, GroupLayout.PREFERRED_SIZE, 151, GroupLayout.PREFERRED_SIZE))))
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
									.addComponent(lblNewLabel_1)
									.addComponent(label_1)
									.addComponent(label_2)
									.addComponent(lblNewLabel_2))
								.addComponent(btnNewButton))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(goodsDescTxt, GroupLayout.PREFERRED_SIZE, 165, GroupLayout.PREFERRED_SIZE)
								.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
									.addComponent(guigeTxt, Alignment.LEADING, 0, 0, Short.MAX_VALUE)
									.addComponent(amountTxt, Alignment.LEADING, 0, 0, Short.MAX_VALUE)
									.addComponent(vippriceTxt, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE))
								.addComponent(button))))
					.addContainerGap(56, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(36)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(goodsNameTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_3))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(label)
								.addComponent(priceTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNewLabel_1)
								.addComponent(vippriceTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(label_1)
								.addComponent(amountTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(label_2)
								.addComponent(guigeTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addComponent(goodsTypeJcb, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(42)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(goodsDescTxt, GroupLayout.PREFERRED_SIZE, 94, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_2))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(button)
						.addComponent(btnNewButton))
					.addContainerGap(19, Short.MAX_VALUE))
		);
		getContentPane().setLayout(groupLayout);
		
		fillGoodsType();

	}
	
	/*
	 * 重置事件处理
	 */
	private void resetValueActionPerformed(ActionEvent e) {
		this.resetValue();
		
	}

	/**
	 * 商品添加事件处理
	 * @param evt
	 */
	private void goodsAddActionPerformed(ActionEvent evt) {
		String goodsName = this.goodsNameTxt.getText();
		String price=this.priceTxt.getText();
		String vipprice=this.vippriceTxt.getText();
		String amount=this.amountTxt.getText();
		String guige=this.guigeTxt.getText();
		String goodsDesc=this.goodsDescTxt.getText();
		
		if(StringUtil.isEmpty(goodsName)) {
			JOptionPane.showMessageDialog(null, "商品类别名称不能为空!");
			return ;
		}
		if(StringUtil.isEmpty(price)) {
			JOptionPane.showMessageDialog(null, "商品价格不能为空!");
			return ;
		}
		if(StringUtil.isEmpty(vipprice)) {
			JOptionPane.showMessageDialog(null, "商品vip价格不能为空!");
			return ;
		}
		if(StringUtil.isEmpty(amount)) {
			JOptionPane.showMessageDialog(null, "商品数量不能为空!");
			return ;
		}
		if(StringUtil.isEmpty(vipprice)) {
			JOptionPane.showMessageDialog(null, "商品规格不能为空!");
			return ;
		}
		
		SxType sxType=(SxType)goodsTypeJcb.getSelectedItem();
		int goodsTypeId=sxType.getId();
		
		Goods goods=new Goods(goodsName, Float.parseFloat(price), Float.parseFloat(vipprice), Integer.parseInt(amount), guige, goodsDesc,
				goodsTypeId);
		Connection con=null;
		try {
			con=dbUtil.getConnection();
			int addNum=goodsDao.add(con,goods);
			if(addNum==1) {
				JOptionPane.showMessageDialog(null, "商品添加成功!");
				resetValue();
			}else {
				JOptionPane.showMessageDialog(null, "商品添加失败!");
			}
		}catch(Exception e){
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "商品添加失败!");
		}finally {
			try {
				dbUtil.closeCon(con);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	/*
	 * 重置表单
	 */
	private void resetValue() {
		this.goodsNameTxt.setText("");
		this.priceTxt.setText("");
		this.vippriceTxt.setText("");
		this.amountTxt.setText("");
		this.guigeTxt.setText("");
		this.goodsDescTxt.setText("");
		if(this.goodsTypeJcb.getItemCount()>0) {
			this.goodsTypeJcb.setSelectedIndex(0);
		}
		
	}
	

	/**
	 * 初始化商品类别(生鲜类别)下拉框
	 */
	private void fillGoodsType() {
		Connection con=null;
		SxType sxType=null;
		try {
			con=dbUtil.getConnection();
			ResultSet rs=sxTypeDao.list(con, new SxType());
			while(rs.next()) {
				sxType=new SxType();
				sxType.setId(rs.getInt("id"));
				sxType.setSxTypeName(rs.getString("sxTypeName"));
				this.goodsTypeJcb.addItem(sxType);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			
		}
	}
	
}
