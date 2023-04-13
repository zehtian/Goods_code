package dao;
import java.sql.*;
import java.util.*;
import domain.GoodsElements;

/**
 * 实现定义的接口
 * @author tzh666
 *
 */
public class GoodsDAOImp implements GoodsDAODef{
	
	private Connection conn; //需要利用Connection对象操作
    private Statement stmt;  //需要利用Statement对象操作
    
    //连接MySQL
	public GoodsDAOImp() {
		try {
            Class.forName("com.mysql.cj.jdbc.Driver");
          conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/tzhjava?useSSL=true&characterEncoding=utf-8&serverTimezone=GMT","root","tzh12345678");
          //conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/tzhjava?serverTimezone=UTC","root","tzh12345678");
         // conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/tzhjava?user=root&password=tzh12345678");
           
            System.out.println("数据库连接成功！");
		} catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

	}  
	
	//执行数据库 插入 操作
	@Override
	public boolean doCreate(GoodsElements good) throws Exception {
		
		String sql = "INSERT INTO tzhshop VALUES (" + "'" + good.getId() + "'," + "'" + good.getName() + "'," + good.getPrice() + "," + good.getStorage() + ")";
		
		stmt = conn.createStatement();
		int result = stmt.executeUpdate(sql);
		if(result > 0)
			return true;
		else
			return false;
	}

	//执行数据库 选择 操作
	@Override
	public List<GoodsElements> findAll() throws Exception {
		List<GoodsElements> all = new ArrayList<>();
        String sql = "SELECT id,name,price,storage FROM tzhshop";
        stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        while(rs.next()) {
        	GoodsElements good = new GoodsElements();
            good.setId(rs.getString(1));
            good.setName(rs.getString(2));
            good.setPrice(rs.getDouble(3));
            good.setStorage(rs.getInt(4));
            all.add(good);
        }
        return all;
	}

	@Override
	public List<GoodsElements> findById(String id) throws Exception {
		List<GoodsElements> all = new ArrayList<>();
		GoodsElements good = null;
        String sql = "SELECT id,name,price,storage FROM tzhshop WHERE id = '" + id + "'";
        stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        if(rs.next()) {
            good = new GoodsElements();
            good.setId(rs.getString(1));
            good.setName(rs.getString(2));
            good.setPrice(rs.getDouble(3));
            good.setStorage(rs.getInt(4));
            all.add(good);
            return all;
        }
        return null;
	}

	@Override
	public List<GoodsElements> findByName(String name) throws Exception {
		List<GoodsElements> all = new ArrayList<>(); //List泛型集合
        String sql = "SELECT id,name,price,storage FROM tzhshop WHERE name = '" + name + "'";
        stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        while(rs.next()) {
        	GoodsElements good = new GoodsElements();
            good.setId(rs.getString(1));
            good.setName(rs.getString(2));
            good.setPrice(rs.getDouble(3));
            good.setStorage(rs.getInt(4));
            all.add(good);
        }
        return all;
	}

	@Override
	public List<GoodsElements> findByPrice(double price1, double price2) throws Exception {
		List<GoodsElements> all = new ArrayList<>();
        String sql = "SELECT id,name,price,storage FROM tzhshop WHERE price >= " + price1 + " and price <= " + price2;
        stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        while(rs.next()) {
        	GoodsElements good = new GoodsElements();
            good.setId(rs.getString(1));
            good.setName(rs.getString(2));
            good.setPrice(rs.getDouble(3));
            good.setStorage(rs.getInt(4));
            all.add(good);
        }
        return all;
	}

	//执行数据库 删除 操作
	@Override
	public boolean doRemove(String id) throws Exception {
		String sql = "DELETE FROM tzhshop where id = '" + id + "'";
		stmt = conn.createStatement();
		int result = stmt.executeUpdate(sql);
		if(result > 0)
			return true;
		else
			return false;
	}

	//执行数据库 更新 操作
	@Override
	public boolean doUpdateName(String id, String name) throws Exception {
		String sql = "UPDATE tzhshop SET name = '" + name + "' WHERE id = '" + id + "'";
		stmt = conn.createStatement();
		int result = stmt.executeUpdate(sql);
		if(result > 0)
			return true;
		else
			return false;
	}

	@Override
	public boolean doUpdateStorage(String id, int storage) throws Exception {
		String sql = "UPDATE tzhshop SET storage = " + storage + " WHERE id = '" + id + "'";
		stmt = conn.createStatement();
		int result = stmt.executeUpdate(sql);
		if(result > 0)
			return true;
		else
			return false;		
	}

}
