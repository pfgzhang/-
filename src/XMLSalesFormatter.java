import java.util.Iterator;
class XMLSalesFormatter implements SalesFormatter{
	private static XMLSalesFormatter singletonInstance;
	
	private XMLSalesFormatter()  {}
	
	public static XMLSalesFormatter getSingletoninstance() {
		if(singletonInstance == null) {
			singletonInstance = new XMLSalesFormatter();
		}
		return singletonInstance;
	}
	
	public String formatSales(Sales sales) {
		String ordern = "<Sales>"+"\n";
		int i = 1;
		Iterator<Order> orders = sales.iterator();
		while(orders.hasNext()) {
			Order order = orders.next();
			ordern = ordern +"  <Order total="+ "\""+order.getTotalCost()+"\""+">"+"\n";
			Iterator<OrderItem> orderitems = order.iterator();
			while(orderitems.hasNext()) {
				OrderItem orderitem = orderitems.next();
				Product product = orderitem.getProduct();
				ordern = ordern +"    <OrderItem quantity="
						+"\""+orderitem.getQuantity()+"\""+"price="+"\""+product.getPrice()+"\""
						+">"+"\""+product.getCode()+"\""+"</OrderItem>"+"\n";
			i = i +1;
			}
			ordern = ordern +"  </Order>"+"\n";
		}
		ordern =ordern +  "</Sales>";
		return ordern;
	}
}
