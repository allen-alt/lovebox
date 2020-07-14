package cn.edu.sdut.goods.swing;

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

import cn.edu.sdut.bill.entity.Bill;
import cn.edu.sdut.comm.CommonUtils;
import cn.edu.sdut.comm.prorperties.factory.BeanFactory;
import cn.edu.sdut.goods.dao.goodsDao;
import cn.edu.sdut.goods.entity.Goods;
import cn.edu.sdut.goodsType.dao.GoodsTypeDao;
import cn.edu.sdut.goodsType.entity.GoodsType;
import cn.edu.sdut.user.Com;

import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.TitledBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JComboBox;
import java.awt.Font;
import javax.swing.ImageIcon;

public class GoodsJframe extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JComboBox searchJCB;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GoodsJframe frame = new GoodsJframe();
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
	public GoodsJframe() {
		setTitle("商品列表");
		setIconImage(Toolkit.getDefaultToolkit().getImage(GoodsJframe.class.getResource("/images/title.gif")));
		setBounds(100, 100, 708, 549);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JScrollPane scrollPane = new JScrollPane();
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "\u67E5\u8BE2\u5546\u54C1", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "\u8D2D\u4E70\u5546\u54C1", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(panel_1, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 646, Short.MAX_VALUE)
						.addComponent(panel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 646, Short.MAX_VALUE)
						.addComponent(scrollPane, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 646, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 74, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 210, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 172, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(167, Short.MAX_VALUE))
		);
		
		JLabel label = new JLabel("商品名称：");
		label.setFont(new Font("幼圆", Font.PLAIN, 15));
		
		gnameT = new JTextField();
		gnameT.setEnabled(false);
		gnameT.setColumns(10);
		
		JLabel label_1 = new JLabel("商品单价：");
		label_1.setFont(new Font("幼圆", Font.PLAIN, 15));
		
		gpriceT = new JTextField();
		gpriceT.setEnabled(false);
		gpriceT.setColumns(10);
		
		JLabel lblKg = new JLabel("kg/元");
		lblKg.setFont(new Font("幼圆", Font.PLAIN, 15));
		
		JLabel label_2 = new JLabel("购买数量：");
		label_2.setFont(new Font("幼圆", Font.PLAIN, 15));
		
		gnumT = new JTextField();
		gnumT.setColumns(10);
		
		JLabel lblKg_1 = new JLabel("kg");
		lblKg_1.setFont(new Font("幼圆", Font.PLAIN, 15));
		
		JButton button_2 = new JButton("确认");
		button_2.setIcon(new ImageIcon(GoodsJframe.class.getResource("/images/tic.png")));
		button_2.setFont(new Font("幼圆", Font.PLAIN, 15));
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				OK(e);
			}
		});
		
		JButton button_3 = new JButton("关闭");
		button_3.setFont(new Font("幼圆", Font.PLAIN, 15));
		button_3.setIcon(new ImageIcon(GoodsJframe.class.getResource("/images/de.png")));
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				exitButton(e);
			}
		});
		
		JButton button_4 = new JButton("刷新");
		button_4.setFont(new Font("幼圆", Font.PLAIN, 15));
		button_4.setIcon(new ImageIcon(GoodsJframe.class.getResource("/images/refresh.png")));
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Update(e);
			}
		});
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(17)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addComponent(label)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(gnameT, GroupLayout.PREFERRED_SIZE, 119, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addComponent(label_2)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(gnumT, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblKg_1)))
					.addPreferredGap(ComponentPlacement.RELATED, 111, Short.MAX_VALUE)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addComponent(button_2)
						.addComponent(label_1))
					.addGap(18)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addComponent(gpriceT, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(lblKg))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(4)
							.addComponent(button_4)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(button_3)))
					.addGap(24))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(label)
						.addComponent(gnameT, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblKg)
						.addComponent(gpriceT, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_1))
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(28)
							.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
								.addComponent(label_2)
								.addComponent(gnumT, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblKg_1)))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(46)
							.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
								.addComponent(button_2)
								.addComponent(button_3)
								.addComponent(button_4))))
					.addContainerGap(35, Short.MAX_VALUE))
		);
		panel_1.setLayout(gl_panel_1);
		
		JLabel lblNewLabel = new JLabel("商品名称：");
		lblNewLabel.setFont(new Font("幼圆", Font.PLAIN, 15));
		
		goodsnameText = new JTextField();
		goodsnameText.setColumns(10);
		
		JButton button = new JButton("查询");
		button.setIcon(new ImageIcon(GoodsJframe.class.getResource("/images/cha.png")));
		button.setFont(new Font("幼圆", Font.PLAIN, 15));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selectByname(e);
			}
		});
		
		JButton button_1 = new JButton("清空");
		button_1.setIcon(new ImageIcon(GoodsJframe.class.getResource("/images/qingkong.png")));
		button_1.setFont(new Font("幼圆", Font.PLAIN, 15));
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resetButton(e);
			}
		});
		
		JLabel label_3 = new JLabel("分类：");
		label_3.setFont(new Font("幼圆", Font.PLAIN, 15));
		
		searchJCB = new JComboBox();
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(39)
					.addComponent(lblNewLabel)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(goodsnameText, GroupLayout.PREFERRED_SIZE, 136, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(button)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(button_1)
					.addGap(18)
					.addComponent(label_3)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(searchJCB, 0, 114, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(goodsnameText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(button)
						.addComponent(button_1)
						.addComponent(label_3)
						.addComponent(searchJCB, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		panel.setLayout(gl_panel);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				SelectOneGoods(e);
			}
		});
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u5546\u54C1\u7F16\u53F7", "\u5546\u54C1\u79CD\u7C7B", "\u5546\u54C1\u540D\u79F0", "\u5546\u54C1\u5355\u4EF7", "\u5546\u54C1\u5E93\u5B58"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		scrollPane.setViewportView(table);
		contentPane.setLayout(gl_contentPane);
		this.setLocationRelativeTo(null);
		//文字居中
		DefaultTableCellRenderer r = new DefaultTableCellRenderer();
		r.setHorizontalAlignment(JLabel.CENTER);
		this.table.setDefaultRenderer(Object.class,r);
		this.gettype("search");
		getGoods(null);
	}
	
	protected void Update(ActionEvent e) {
		this.getGoods(null);
	}

	protected void exitButton(ActionEvent e) {
		this.dispose();
		
	}

	protected void OK(ActionEvent e) {
		Com.goodsname=this.gnameT.getText();
		Com.goodsprice = Double.valueOf(this.gpriceT.getText());
		if(this.gnumT.getText().isEmpty())
		{
			JOptionPane.showMessageDialog(this, "购买数量不能为空！");
			return ;
		}
		if(Integer.valueOf(this.gnumT.getText())==0)
		{
			JOptionPane.showMessageDialog(this, "购买数量要大于0");
			return ;
		}
		if(Integer.valueOf(this.gnumT.getText())>Com.num)
		{
			JOptionPane.showMessageDialog(this, "库存不足，请减少购买量");
			return ;
		}
		Com.buynum = Integer.valueOf(this.gnumT.getText());
		new GoodsInform().setVisible(true);
	}

	protected void SelectOneGoods(MouseEvent e) {
		int row = this.table.getSelectedRow();
		int goodsid = (Integer)this.table.getValueAt(row, 0);
		Com.goodsid = goodsid;
		Goods goods = gdao.queryGoodsById(goodsid);
		this.gnameT.setText(goods.getGoodsname());
		this.gpriceT.setText(String.valueOf(goods.getPrice()));
		this.gnumT.setText("1");
		Com.num = goods.getNum();
	}

	protected void selectByname(ActionEvent e) {
		String text = this.goodsnameText.getText();
		GoodsType gtype = (GoodsType) this.searchJCB.getSelectedItem();
//		System.out.println(gtype);
		Goods goods = new Goods();
		goods.setGoodsname(text);
		goods.setCateid(gtype.getTypeid());
		this.getGoods(goods);
	}

	protected void resetButton(ActionEvent e) {
		this.goodsnameText.setText("");
		this.goodsnameText.requestFocus();
		this.searchJCB.setSelectedIndex(0);
		this.getGoods(null);
	}

	/**
	 * 
	 * 商品种类下拉列表
	 */
	private void gettype(String type)
	{
		List<GoodsType> list = tdao.queryAllType();
//		System.out.println(list);
		GoodsType g = new GoodsType();
		g.setTypename("--请选择--");
		this.searchJCB.addItem(g);
		for (GoodsType gtype : list) {
			if("search".equals(type))
			{
				this.searchJCB.addItem(gtype);
			}
			else
			{
				
			}
		}
		
	}
	
	//商品列表展示
	
	
	private void getGoods(Goods goods) {
		List<Goods> list = gdao.queryAllGoods(goods);
//		System.out.println(list);
		DefaultTableModel model = (DefaultTableModel) this.table.getModel();
		model.setRowCount(0);
		if(list.size()>0)
		{
			for (Goods g : list) {
				Vector<Object> vector = new Vector<Object>();
				vector.add(g.getGoodsid());
				GoodsType type = tdao.queryTypeById(g.getCateid());
				vector.add(type.getTypename());
				vector.add(g.getGoodsname());
				vector.add(g.getPrice());
				vector.add(g.getNum());
				model.addRow(vector);
			}
		}
		else
		{
			JOptionPane.showMessageDialog(this, "没有查询到相关记录！");
			getGoods(null);
		}
	}
	
	private goodsDao gdao =BeanFactory.getInstance(CommonUtils.GoodsInfo.GOODSDAO); 
	
	private GoodsTypeDao tdao = BeanFactory.getInstance(CommonUtils.GoodsTypeInfo.TYPEDAO);
	private JTextField goodsnameText;
	private JTextField gnameT;
	private JTextField gpriceT;
	private JTextField gnumT;
}




