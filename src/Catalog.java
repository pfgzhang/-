import java.util.ArrayList;
import java.util.Iterator;
import java.lang.Iterable;
public class Catalog implements Iterable<Product> {
	private ArrayList<Product> products;
	
	public Catalog(){
		products = new ArrayList();
	}
	
	public ArrayList<Product> getproducts() {
		return products;
	}
	
	public void addProduct(Product product) {
		products.add(product);
	}
	

	public Iterator<Product> iterator(){
		return products.iterator();
	}

	public Product getProduct(String code) {
		Product b = null;
		Iterator<Product> productlist = iterator();
		while (productlist.hasNext()) {
			Product c = productlist.next();
			String a = c.getCode();
			if (code.equals(a)) {
				b = c;
			}
		}
		return b;
	}
	
	public int getNumberOfProducts() {
		return products.size();
	}
}
