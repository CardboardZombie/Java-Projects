import java.text.NumberFormat;


public class Ticket {
	
	private String ticketName;
	private double ticketPrice;
	
	//constructors
	public Ticket()
	{
		ticketName = "";
		ticketPrice = 0.0;
	}
	
	//overloaded constructurs
	public Ticket(String name, double tPrice){
		
		ticketName = name;
		ticketPrice = tPrice;
	}
	
	//getters
	public String getticketname()
	{
		return ticketName;
	}
	
	public double gettprice()
	{
		return ticketPrice;
	}
	
	//setters
	public void settPrice(double thePrice){
		this.ticketPrice = thePrice;
	}
	//----------------------------------------------------------------------
	public String getFormattedPrice()
	{
		NumberFormat currency = NumberFormat.getCurrencyInstance();
		return currency.format(ticketPrice);
	}
	
	public void setticketName(String thename)
	{
		this.ticketName = thename; 
	}

}
