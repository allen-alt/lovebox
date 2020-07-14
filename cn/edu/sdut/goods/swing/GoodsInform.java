package cn.edu.sdut.goods.swing;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import cn.edu.sdut.bill.dao.BillDao;
import cn.edu.sdut.bill.entity.Bill;
import cn.edu.sdut.comm.CommonUtils;
import cn.edu.sdut.comm.prorperties.factory.BeanFactory;
import cn.edu.sdut.goods.dao.goodsDao;
import cn.edu.sdut.goods.entity.Goods;
import cn.edu.sdut.user.Com;
import cn.edu.sdut.user.dao.UserDao;
import cn.edu.sdut.user.entity.Tbuser;

import java.awt.Toolkit;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Date;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Font;

public class GoodsInform extends JFrame {

	private JPanel contentPane;
	private JTextField goodsNameT;
	private JTextField goodsPT;
	private JTextField goodsNumT;
	private JTextField billPT;
	private JTextField uernameT;
	private JTextField addressT;
	private JTextField TelT;
	private JRadioButton selfRb,expressRB;
	private final ButtonGroup buttonGroup = new ButtonGroup();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GoodsInform frame = new GoodsInform();
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
	public GoodsInform() {
		setTitle("确认购买");
		setIconImage(Toolkit.getDefaultToolkit().getImage(GoodsInform.class.getResource("/images/title.gif")));
		setBounds(100, 100, 552, 423);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel label = new JLabel("商品名称：");
		label.setFont(new Font("幼圆", Font.PLAIN, 15));
		
		JLabel label_1 = new JLabel("商品单价：");
		label_1.setFont(new Font("幼圆", Font.PLAIN, 15));
		
		JLabel label_2 = new JLabel("购买数量：");
		label_2.setFont(new Font("幼圆", Font.PLAIN, 15));
		
		JLabel label_3 = new JLabel("订单总价：");
		label_3.setFont(new Font("幼圆", Font.PLAIN, 15));
		
		goodsNameT = new JTextField();
		goodsNameT.setEnabled(false);
		goodsNameT.setColumns(10);
		
		goodsPT = new JTextField();
		goodsPT.setEnabled(false);
		goodsPT.setColumns(10);
		
		goodsNumT = new JTextField();
		goodsNumT.setEnabled(false);
		goodsNumT.setColumns(10);
		
		billPT = new JTextField();
		billPT.setEnabled(false);
		billPT.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("购买用户：");
		lblNewLabel.setFont(new Font("幼圆", Font.PLAIN, 15));
		
		JLabel label_4 = new JLabel("收货地址：");
		label_4.setFont(new Font("幼圆", Font.PLAIN, 15));
		
		JLabel label_5 = new JLabel("电话号码：");
		label_5.setFont(new Font("幼圆", Font.PLAIN, 15));
		
		JLabel label_6 = new JLabel("配送方式：");
		label_6.setFont(new Font("幼圆", Font.PLAIN, 15));
		
		uernameT = new JTextField();
		uernameT.setEnabled(false);
		uernameT.setColumns(10);
		
		addressT = new JTextField();
		addressT.setColumns(10);
		
		TelT = new JTextField();
		TelT.setColumns(10);
		
		selfRb = new JRadioButton("到店自取");
		selfRb.setFont(new Font("幼圆", Font.PLAIN, 15));
		buttonGroup.add(selfRb);
		
		expressRB = new JRadioButton("快递邮寄");
		expressRB.setFont(new Font("幼圆", Font.PLAIN, 15));
		buttonGroup.add(expressRB);
		
		JButton button = new JButton("确定购买");
		button.setFont(new Font("幼圆", Font.PLAIN, 15));
		button.setIcon(new ImageIcon(GoodsInform.class.getResource("/images/tic.png")));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				OK(e);
			}
		});
		
		JButton button_1 = new JButton("放弃购买");
		button_1.setFont(new Font("幼圆", Font.PLAIN, 15));
		button_1.setIcon(new ImageIcon(GoodsInform.class.getResource("/images/de.png")));
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				exit(e);
			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(39)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(label)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(goodsNameT, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(label_1)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(goodsPT, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(label_2)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(goodsNumT, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(label_3)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(button)
								.addComponent(billPT, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
					.addGap(27)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(label_5)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(TelT, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(label_4)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(addressT, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblNewLabel)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(uernameT, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(label_6)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(expressRB)
								.addComponent(selfRb)))
						.addComponent(button_1))
					.addContainerGap(56, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(55)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(label)
						.addComponent(goodsNameT, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel)
						.addComponent(uernameT, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(32)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_1)
						.addComponent(goodsPT, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_4)
						.addComponent(addressT, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(32)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_2)
						.addComponent(goodsNumT, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_5)
						.addComponent(TelT, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(29)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_3)
						.addComponent(billPT, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_6)
						.addComponent(selfRb))
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(expressRB))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(67)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(button)
								.addComponent(button_1))))
					.addContainerGap(138, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
		this.setLocationRelativeTo(null);
//		Tbuser user = dao.selectUserById(Com.userid);
		Tbuser user = dao.selectUserById(2);
		getBuyInfo(user);
		this.selfRb.setSelected(true);
	}
	
	
	protected void exit(ActionEvent e) {
		this.dispose();
	}

	protected void OK(ActionEvent e) {
		String goodsname = this.goodsNameT.getText();
		Double goodsprice = Double.valueOf(this.goodsPT.getText());
		Integer buynum = Integer.valueOf(this.goodsNumT.getText());
		Double billprice = Double.valueOf(this.billPT.getText());
		String address = this.addressT.getText();
		String tel = this.TelT.getText();
		Integer send = 01;
		if(this.selfRb.isSelected())
		{
			send = 01;
		}
		else if(this.expressRB.isSelected())
		{
			send = 02;
			if(address.isEmpty())
			{
				JOptionPane.showMessageDialog(this, "请输入收货地址");
				return ;
			}
		}
		if(tel.isEmpty())
		{
			JOptionPane.showMessageDialog(this, "请输入手机号码");
			return ;
		}
//		JOptionPane.showMessageDialog(this, send);
		
		Bill bill = new Bill();
		bill.setUserid(Com.userid);
		bill.setBuygoodsname(goodsname);
		bill.setBuygoodsprice(goodsprice);
		bill.setBuygoodsnum(buynum);
		bill.setBilltotalprice(billprice);
		if(send==1)
		{
			bill.setAddress("无");
		}
		else if(send==2)
		{
			bill.setAddress(address);
		}
		bill.setTel(tel);
		bill.setSendtype(send);
		bill.setBilltime(new Date());
//		System.out.println(bill);
		int row = bdao.addBill(bill);
		Goods goods = new Goods();
		goods.setGoodsid(Com.goodsid);
		Goods good = gdao.queryGoodsById(Com.goodsid);
		Integer num = good.getNum();
		Integer num1 = num - buynum;
		goods.setNum(num1);
		int row1 = gdao.updateGoods(goods);
		if(row>0&&row>0)
		{
			JOptionPane.showMessageDialog(this, "购买成功");
		}
		else
		{
			JOptionPane.showMessageDialog(this, "购买失败");
		}
		this.dispose();
	}

	private void getBuyInfo(Tbuser user)
	{
		this.goodsNameT.setText(Com.goodsname);
		this.goodsPT.setText(String.valueOf(Com.goodsprice));
		this.goodsNumT.setText(String.valueOf(Com.buynum));
		Double p = Com.goodsprice * Com.buynum;
		this.billPT.setText(String.valueOf(p));
		this.uernameT.setText(user.getUsername());
		this.addressT.setText(user.getAddress());
		this.TelT.setText(user.getTel());
		
	}
	
	private UserDao dao = BeanFactory.getInstance(CommonUtils.UserInfo.USERDAO);
	
	private BillDao bdao = BeanFactory.getInstance(CommonUtils.BillInfo.BILLDAO);
	
	private goodsDao gdao = BeanFactory.getInstance(CommonUtils.GoodsInfo.GOODSDAO);
	
	
	
	
	
}
