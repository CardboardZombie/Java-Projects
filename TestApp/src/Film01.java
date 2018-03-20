
public class Film01 {

	private String filmTitle;
	private String director;
	private int year;
	
	//The constructor
	public Film01()
	{
		filmTitle = "";
		director = "";
		year = 0;
	}
	//Overloaded Constructor
	public Film01(String title, String direct, int yr)
	{
		filmTitle = title;
		director = direct;
		year = yr;
	}
	//Getters
	public String getfilmTitle()
	{
		return filmTitle;
	}
	
	public String getDirector()
	{
		return director;
	}
	
	public int getYear()
	{
		 return year;
	}
	//Setters
	public void setfilmTitle(String theFilmTitle){
		this.filmTitle = theFilmTitle;
	}
	
	public void setDirector(String theDirector){
		this.director = theDirector; 
	}
	
	public void setYear(int theyear){
		this.year = theyear; 
	}
	
	
}
