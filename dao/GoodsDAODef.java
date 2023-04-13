package dao;

import java.util.List;
import domain.GoodsElements;
/**
 * 定义需要的接口
 * @author tzh666
 *
 */
public interface GoodsDAODef {
	
	//创建商品
	public boolean doCreate(GoodsElements good) throws Exception;

	//查看所有商品
	public List<GoodsElements> findAll() throws Exception;
	
	//查询by Id
	public List<GoodsElements> findById(String id) throws Exception;
	
	//查询by name
	public List<GoodsElements> findByName(String name) throws Exception;
	
	//查询by price
	public List<GoodsElements> findByPrice(double price1, double price2) throws Exception;
	
	//删除by Id
	public boolean doRemove(String id) throws Exception;	
	
	//修改商品名by id
    public boolean doUpdateName(String id, String name) throws Exception;
    
    //修改库存by id
    public boolean doUpdateStorage(String id, int number) throws Exception;
    

}
