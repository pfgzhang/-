
public class OrderItem {
	private int quantity;
	private Product product;
	
	public OrderItem(Product initialProduct,
					 int initialQuantity) {
		product = initialProduct;
		quantity = initialQuantity;
	}
	public Product getProduct() {
		return product;
	}
	
	public int getQuantity() {
		return quantity;
	}
	
	public void setQuantity(int newQuantity) {
		quantity = newQuantity;
	}
	
	public double getValue() {
		return quantity*product.getPrice();//?????
	}
	
	public String toString() {
		return quantity + " " + product.getCode() + " " + product.getPrice();
	}
}
