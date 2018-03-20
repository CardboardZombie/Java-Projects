import java.text.NumberFormat;
public class LineItem 
{
	private Product product;
	private int quantity;
	private double total;
	
	public LineItem()
	{
		this.product = new Product();
		this.quantity = 0;
		this.total = 0;
	}
	public LineItem(Product product, int quantity)
	{
		this.product = product;
		this.quantity = quantity;
	}
	
	public Product getProduct()
	{
		return product;
	}
	public void setProduct(Product p)
	{
		this.product = p;
	}
	public int getQuantity()
	{
		return quantity;
	}
	public void setQuantity(int q)
	{
		this.quantity = q;
	}
	public double getTotal()
	{
		this.calculateTotal();
		return total;
	}
	private double calculateTotal()
	{
		total = quantity * product.getPrice();
		return total;
	}
	public String getFormattedTotal()
	{
		NumberFormat currency = NumberFormat.getCurrencyInstance();
		return currency.format(this.getTotal());
	}
}
