package service;

import java.util.List;
import domain.GoodsElements;

/**
 * 定义服务层需要的接口
 * @author tzh666
 *
 */
public interface GoodsServiceDef {
	
	//用户通过商品信息向库中添加商品
	public boolean insert(GoodsElements good) throws Exception;
	
	//用户查看库中所有商品
	public List<GoodsElements> listALL() throws Exception;
	
	//用户通过商品id搜索商品
	public List<GoodsElements> listByID(String id) throws Exception;
	
	//用户通过名字搜索商品
	public List<GoodsElements> listByName(String name) throws Exception;
	
	//用户通过价格范围搜索商品
	public List<GoodsElements> listByPrice(double price1,double price2) throws Exception;
	
	//用户通过id删除商品
	public boolean delete(String id) throws Exception;
	
	//用户通过id修改商品名称
	public boolean updateNameByID(String id, String name) throws Exception;
	
	//用户通过制定id修改商品数量
	public boolean updateStorage(String id, int purchase) throws Exception;

}
