package service;

import java.util.List;
import dao.GoodsDAOImp;
import domain.GoodsElements;
/**
 * 实现服务层需要的接口
 * @author tzh666
 *
 */
public class GoodsServiceImp implements GoodsServiceDef {
	
	GoodsDAOImp daoImp;

	public GoodsServiceImp() {
		daoImp = new GoodsDAOImp();
	}

	@Override
	public boolean insert(GoodsElements good) throws Exception {
		return daoImp.doCreate(good);
	}

	@Override
	public List<GoodsElements> listALL() throws Exception {
		return daoImp.findAll();
	}

	@Override
	public List<GoodsElements> listByID(String id) throws Exception {
		return daoImp.findById(id);
	}

	@Override
	public List<GoodsElements> listByName(String name) throws Exception {
		return daoImp.findByName(name);
	}

	@Override
	public List<GoodsElements> listByPrice(double price1, double price2) throws Exception {
		return daoImp.findByPrice(price1, price2);
	}

	@Override
	public boolean delete(String id) throws Exception {
		return daoImp.doRemove(id);
	}

	@Override
	public boolean updateNameByID(String id,String name) throws Exception {
		return daoImp.doUpdateName(id,name);
	}

	@Override
	public boolean updateStorage(String id, int purchase) throws Exception {
		List<GoodsElements> good = daoImp.findById(id);
		if(good.get(0).getStorage() >= purchase) {
			return daoImp.doUpdateStorage(id, good.get(0).getStorage() - purchase);
		}
		else 
			return false;
	}

}

