import java.util.Iterator;

class HTMLSalesFormatter implements SalesFormatter{
	private static HTMLSalesFormatter singletonInstance;
	
	private HTMLSalesFormatter() {}
	
	public static HTMLSalesFormatter getSingletonInstance() {
		if(singletonInstance == null) {
			singletonInstance = new HTMLSalesFormatter();
		}
		return singletonInstance;
	}
	
	public String formatSales(Sales sales) {
		String ordern = "\n"+"   <html>"+"\n"+"  <body>"+"\n"+"    <center>"+"<h2>"+"Orders"+"</h2>"+"</center>"+"\n";
		int i = 1;
		Iterator<Order> orders = sales.iterator();
		while(orders.hasNext()) {
			Order order = orders.next();
			ordern = ordern +"     <hr>"+"\n"+"     <h4>Total = "+order.getTotalCost()+"</h4>"+"\n";
			Iterator<OrderItem> orderitems = order.iterator();
			
			while(orderitems.hasNext()) {
				OrderItem orderitem = orderitems.next();
				Product product = orderitem.getProduct();
				ordern =ordern+"      <p>"+"\n"
						+"        <b>code:</b> "+product.getCode()+"<br>"+"\n"+"        <b>quantity:</b> "
						+orderitem.getQuantity()+"<br>"+"\n"+"        <b>price:</b> "+product.getPrice()+"\n"+"      </p>"+"\n";
			}
			i = i +1;
		}
		ordern =ordern+" </body>"+"\n"+"</html>";
		return ordern;
	}
}
