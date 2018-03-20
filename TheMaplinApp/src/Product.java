import java.text.NumberFormat;

public class Product 
{
	private String code;
	private String description;
	private double price;
	protected static int count = 0;		// a protected static variable
	
	public Product()
	{
		code = "";
		description = "";
		price = 0;
	}
	public String getCode()
	{
		return code;
	}
	public void setCode(String code)
	{
		this.code = code;
	}
	public String getDescription()
	{
		return description;
	}
	public void setDescription(String description)
	{
		this.description = description;
	}
	public double getPrice()
	{
		return price;
	}
	public void setPrice(double thePrice)
	{
		this.price = thePrice;
	}
	public String getFormattedPrice()
	{
		NumberFormat currency = NumberFormat.getCurrencyInstance();
		return currency.format(price);
	}
	
	public String toString()		//Override the toString method
	{
		String message =
			"Code:			" + code + "\n" +
			"Description:	" + description + "\n" +
			"Price: 		" + this.getFormattedPrice() + "\n";
		return message;
	}
	
	public static int getCount()	// create public access for the 
	{								// count variable.
		return count;
	}
	
}
