package domain;
/**
 * 实体层——确定商品各信息
 * @author tzh666
 *
 */
public class GoodsElements {
		
	private String id;
	private String name;
	private double price;
    private int storage;	    
	    
    public String getId() {
	    return id;
	}
   
    public void setId(String id) {
    	this.id = id;
    }
    
    public String getName() {
    	return name;
    }
	    
    public void setName(String name) {
    	this.name = name;
    }
	    
    public double getPrice() {
    	return price;
    }
	    
    public void setPrice(double price) {
    	this.price = price;
    }
    
    public int getStorage() {
    	return storage;
    }
	    
    public void setStorage(int storage) {
    	this.storage = storage;
    }
	
}
