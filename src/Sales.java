import java.util.ArrayList;
import java.util.Iterator;
import java.lang.Iterable;
public class Sales implements Iterable<Order> {
	private ArrayList<Order> orders;
	
	public Sales() {
		orders = new ArrayList();
	}
	
	public void addOrder(Order order) {
		orders.add(order);
	}
	
	public Iterator<Order> iterator(){
		return orders.iterator();
	}
	
	public int getNumberOfOrders() {
		return orders.size();
	}
	
	public ArrayList<Order> getorders() {
		return orders;
	}
}
