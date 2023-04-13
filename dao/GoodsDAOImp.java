package dao;
import java.sql.*;
import java.util.*;
import domain.GoodsElements;

/**
 * ʵ�ֶ���Ľӿ�
 * @author tzh666
 *
 */
public class GoodsDAOImp implements GoodsDAODef{
	
	private Connection conn; //��Ҫ����Connection�������
    private Statement stmt;  //��Ҫ����Statement�������
    
    //����MySQL
	public GoodsDAOImp() {
		try {
            Class.forName("com.mysql.cj.jdbc.Driver");
          conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/tzhjava?useSSL=true&characterEncoding=utf-8&serverTimezone=GMT","root","tzh12345678");
          //conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/tzhjava?serverTimezone=UTC","root","tzh12345678");
         // conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/tzhjava?user=root&password=tzh12345678");
           
            System.out.println("���ݿ����ӳɹ���");
		} catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

	}  
	
	//ִ�����ݿ� ���� ����
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

	//ִ�����ݿ� ѡ�� ����
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
		List<GoodsElements> all = new ArrayList<>(); //List���ͼ���
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

	//ִ�����ݿ� ɾ�� ����
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

	//ִ�����ݿ� ���� ����
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
