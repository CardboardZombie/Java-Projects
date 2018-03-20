
public class Viewing01 {
	
	public Film01 film;
	private int date;
	private int time;
	
	public Ticket[] ticketArray;
	
	//Constructor
	public Viewing01()
	{
		film = new Film01(); 
		date = 0;
		time = 0;
		ticketArray = new Ticket[4];
	}
	
	//Getters
	public Film01 getFilm()
	{
		return film;
	}
	
	public int getDate()
	{
		return date;
	}
	
	public int getTime()
	{
		return time;
	}
		
	
	public String getTicketType(int number)
	{
		return ticketArray[number].getticketname();
	}
	public String getTicketPrice(int number)
	{
		return ticketArray[number].getFormattedPrice();
	}
	
	//Setters
	
	public void setFilm(Film01 theFilm){
		this.film = theFilm;
	}
	
	public void setDate(int theDate){
		this.date = theDate;
	}
	
	public void setTime(int theTime){
		this.time = theTime;
	}
	public void setTicketArray(Ticket[] tArray)
	{
		this.ticketArray = tArray;
	}
}
