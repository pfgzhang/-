import java.util.ArrayList;
import java.util.Iterator;
import java.lang.Iterable;
public class Order implements Iterable<OrderItem> {
	private ArrayList<OrderItem> items;
	
	public Order() {
		items = new ArrayList();
	}
	
	public void addItem(OrderItem orderItem) {
		items.add(orderItem);
	}
	
	public void removeItem(OrderItem orderItem) {
		items.remove(orderItem);
	}
	
	public Iterator<OrderItem> iterator(){
		return items.iterator();
	}
	
	public OrderItem getItem(Product product) {
		OrderItem b =null;
		Iterator<OrderItem> orderitem = iterator();
		while(orderitem.hasNext()) {
			OrderItem a = orderitem.next();
			if (product.equals(a.getProduct())) {
				b = a;
			}
		}
		return b;
	}
	
	public int getNumberOfItems(){
		return items.size();
	}
	
	public double getTotalCost() {
		double a = 0;
		Iterator<OrderItem> orderitem = iterator();
		while(orderitem.hasNext()) {
			a += orderitem.next().getValue();
		}
		return a;
	}
		/*for(OrderItem orderitem: items){
			a += orderitem.getValue();
		}
		return a;
	}*/
}
