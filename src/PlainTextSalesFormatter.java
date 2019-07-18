import java.util.Iterator;

class PlainTextSalesFormatter implements SalesFormatter{
	private static PlainTextSalesFormatter singletonInstance;
	
	private PlainTextSalesFormatter() {}
	
	static PlainTextSalesFormatter getSingletonInstance() {
		if (singletonInstance == null) {
			singletonInstance = new PlainTextSalesFormatter();
		}
		return singletonInstance;
	}
	public String formatSales(Sales sales) {
		String ordern = ""+"\n";
		int i = 1;
		Iterator<Order> orders = sales.iterator();
		while(orders.hasNext()) {
			ordern = ordern + "--------------------"+"\n"+"Order"+" "+i+"\n"+"\n";
			Order order = orders.next();
			Iterator<OrderItem> orderitems = order.iterator();
			while(orderitems.hasNext()) {
				OrderItem orderitem = orderitems.next();
				Product product = orderitem.getProduct();
				ordern =ordern + orderitem.getQuantity()+" "+product.getCode()+" "+product.getPrice()+"\n";
			}
			ordern = ordern + "\n"+"Total = "+order.getTotalCost()+"\n";
			i = i +1;
		}
		return ordern;
	}

}
