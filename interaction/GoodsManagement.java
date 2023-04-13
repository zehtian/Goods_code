package interaction;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.List;
import domain.GoodsElements;
import service.GoodsServiceImp;

/**
 * 交互层——用户管理界面设计
 * @author tzh666
 *
 */

public class GoodsManagement extends Frame implements WindowListener,ActionListener{
	private static final long serialVersionUID = 1L;

	static GoodsManagement mainframe;
	GoodsServiceImp service = new GoodsServiceImp();
	
	Button addBtn;
	Button searchBtn;
	Button deleteBtn;
	Button purchaseBtn;
	Button changenameBtn;
	
	TextField idValue;
	TextField nameValue;
	TextField priceValue;
	TextField storageValue;
	
	TextField idValue2;
	TextField nameValue2;
	TextField priceValue21,priceValue22;
	
	TextField idValue3;
	
	TextField idValue4;
	TextField purchaseNumber;
	
	TextField idValue5;
	TextField changenameNumber;
	
	TextArea searchResult;
	
	public GoodsManagement() {
		
		setSize(500,600);
		this.addWindowListener(this);
		this.setLayout(new GridLayout(3,2));
		
		Panel panel1 = new Panel(new GridLayout(5,1));
		Panel panel11 = new Panel(new FlowLayout());
		Panel panel12 = new Panel(new FlowLayout());
		Panel panel13 = new Panel(new FlowLayout());
		Panel panel14 = new Panel(new FlowLayout());
		
		/*********新增商品栏**********/
		Label id = new Label("I      D:");
		idValue = new TextField(20);
		panel11.add(id);
		panel11.add(idValue);
		panel1.add(panel11);
		
		Label name = new Label("名 称:");
		nameValue = new TextField(20);
		panel12.add(name);
		panel12.add(nameValue);
		panel1.add(panel12);		
		
		Label price = new Label("价  格:");
		priceValue = new TextField(20);
		panel13.add(price);
		panel13.add(priceValue);
		panel1.add(panel13);		
		
		Label storage = new Label("库  存:");
		storageValue = new TextField(20);
		panel14.add(storage);
		panel14.add(storageValue);
		panel1.add(panel14);		
		
		addBtn = new Button("添加");
		addBtn.addActionListener(this);
		panel1.add(addBtn);
		this.add(panel1);
		
		
		/*********购买商品栏**********/
        Panel panel4 = new Panel(new FlowLayout());
		
		panel4.add(new Label("I      D:"));
		idValue4 = new TextField(20);
		panel4.add(idValue4);
		panel4.add(new Label("数 量:"));
		purchaseNumber = new TextField(20);
		panel4.add(purchaseNumber);
		
		purchaseBtn = new Button("购买");
		purchaseBtn.addActionListener(this);
		panel4.add(purchaseBtn);
		
		this.add(panel4);
		
		/*********查看商品栏**********/
		Panel panel2 = new Panel(new GridLayout(5,1));
		Panel panel21 = new Panel(new FlowLayout());
		Panel panel22 = new Panel(new FlowLayout());
		Panel panel23 = new Panel(new FlowLayout());
				
		Label id2 = new Label("I      D:");
		idValue2 = new TextField(20);
		panel21.add(id2);
		panel21.add(idValue2);
		panel2.add(panel21);
		
		Label name2 = new Label("名 称:");
		nameValue2 = new TextField(20);
		panel22.add(name2);
		panel22.add(nameValue2);
		panel2.add(panel22);		
		
		Label price2 = new Label("价  格:");
		priceValue21 = new TextField(5);
		priceValue22 = new TextField(5);
		panel23.add(price2);
		panel23.add(priceValue21);
		panel23.add(new Label("--"));
		panel23.add(priceValue22);
		panel2.add(panel23);		
		
		searchBtn = new Button("查询");
		searchBtn.addActionListener(this);
		panel2.add(searchBtn);
		
		this.add(panel2);
		
		/*********删除商品栏**********/
		Panel panel3 = new Panel(new FlowLayout());
		panel3.add(new Label("I      D:"));
		idValue3 = new TextField(20);
		panel3.add(idValue3);
		deleteBtn = new Button("删除");
		deleteBtn.addActionListener(this);
		panel3.add(deleteBtn);
		
		this.add(panel3);
		
		/*********显示商品栏**********/
		searchResult = new TextArea();
		this.add(searchResult);
		
		/*********修改商品栏**********/
        Panel panel5 = new Panel(new FlowLayout());
		
		panel5.add(new Label("I      D:"));
		idValue5 = new TextField(20);
		panel5.add(idValue5);
		panel5.add(new Label("名 称:"));
		changenameNumber = new TextField(20);
		panel5.add(changenameNumber);
		
		changenameBtn = new Button("更改");
		changenameBtn.addActionListener(this);
		panel5.add(changenameBtn);
		
		this.add(panel5);
		
     
		setVisible(true);
	}
	
	public static void main(String args[]) {
		mainframe = new GoodsManagement();
	}

	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosing(WindowEvent e) {
		System.exit(0);
		
	}

	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent event) {

		//用户点击添加商品按钮
		if(event.getSource() == addBtn) {
            //实体化该商品并确认信息
			GoodsElements good = new GoodsElements();
			good.setId(idValue.getText());
			good.setName(nameValue.getText());
			good.setPrice(Double.valueOf(priceValue.getText()).doubleValue());
			good.setStorage(Integer.valueOf(storageValue.getText()).intValue());
			try {
				if(service.listByID(good.getId()) != null) {
					System.out.println("记录已存在");
					return;
				}else {
					//插入商品
					service.insert(good);
				}
			}catch(Exception e) {
				System.out.println("插入新商品失败！");
			}
			System.out.println("成功插入新商品！");
		}
		
		//用户点击搜索商品按钮
		if(event.getSource() == searchBtn) {
			searchResult.setText("");
			List<GoodsElements> goodInfo = null;
			
			//未输入——为查找所有商品
			if(idValue2.getText().equals("") && nameValue2.getText().equals("") && priceValue21.getText().equals("") && priceValue22.getText().equals("")) {
				try {
					goodInfo = service.listALL();
				}catch(Exception e) {e.printStackTrace();}

				if(null != goodInfo) {
				for(int i = 0; i < goodInfo.size();i++){
					GoodsElements good = goodInfo.get(i);
					searchResult.append(good.getId()+ "," + good.getName() + "," + good.getPrice() + "," + good.getStorage() + "\r\n");
					}
				}
				return;
			}
			
			//输入了id值——调用按id查找方法
			if(!(idValue2.getText().equals(""))) {
				try {
					goodInfo = service.listByID(idValue2.getText());
				}catch(Exception e) {e.printStackTrace();}

				if(null != goodInfo) {
				for(int i = 0; i < goodInfo.size();i++){
					GoodsElements good = goodInfo.get(i);
					searchResult.append(good.getId()+ "," + good.getName() + "," + good.getPrice() + "," + good.getStorage() + "\r\n");
					}
				}
				return;
			}
			
			//输入了名称——调用按名称查找方法
			if(!(nameValue2.getText().equals(""))) {
				try {
					goodInfo = service.listByName(nameValue2.getText());
				}catch(Exception e) {e.printStackTrace();}

				if(null != goodInfo) {
				for(int i = 0; i < goodInfo.size();i++){
					GoodsElements good = goodInfo.get(i);
					searchResult.append(good.getId()+ "," + good.getName() + "," + good.getPrice() + "," + good.getStorage() + "\r\n");
					}
				}
				return;
			}
			
			//输入了两个价格——调用按价格查找方法
			if(!(priceValue21.getText().equals("")) && !(priceValue22.getText().equals(""))) {
				try {
					goodInfo = service.listByPrice(Double.valueOf(priceValue21.getText()).doubleValue(), Double.valueOf(priceValue22.getText()).doubleValue());
				}catch(Exception e){
					e.printStackTrace();
					}
				if(null != goodInfo) {
				for(int i = 0; i < goodInfo.size();i++){
					GoodsElements good = goodInfo.get(i);
					searchResult.append(good.getId()+ "," + good.getName() + "," + good.getPrice() + "," + good.getStorage() + "\r\n");
					}
				}
				return;
			}
		}
		
		//用户按下删除按钮
		if(event.getSource() == deleteBtn) {	
			
			try {
				boolean result = service.delete(idValue3.getText());

				if(result){
					System.out.println("记录已删除");
					return;
				}else {
					System.out.println("删除失败");
				}
			}catch(Exception e) {
				System.out.println("删除失败");
			}	
		}
		
		//用户按下购买按钮
		if(event.getSource() == purchaseBtn) {
			
			try {
				boolean result = service.updateStorage(idValue4.getText(), Integer.valueOf(purchaseNumber.getText()).intValue());

				if(result){
					System.out.println("库存数量已修改");
					return;
				}else {
					System.out.println("库存数量修改失败");
				}
			}catch(Exception e) {
				System.out.println("库存数量修改失败");
			}			
		}
		
		//用户按下修改按钮
        if(event.getSource() == changenameBtn) {
        
        	try {
				boolean result = service.updateNameByID(idValue5.getText(),changenameNumber.getText());

				if(result){
					System.out.println("物品名称已修改");
					return;
				}else {
					System.out.println("物品名称修改失败");
				}
			}catch(Exception e) {
				System.out.println("物品名称修改失败");
			}		
		}
	}

}
