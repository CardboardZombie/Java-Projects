
public class Book extends Product
{
	private String author;
	
	public Book()
	{
		super();			// call constructor of Product superclass
		author = "";
		count++;			//update the count variable in the Product superclass
	}
	
	public void setAuthor(String author)
	{
		this.author = author;
	}
	
	public String getAuthor()
	{
		return author;
	}
	public String toString()			// override the toString method
	{
		String message = 
				super.toString() + 		// call method of Product superclass
				"Author:		" + author + "\n";
		return message;
	}

}
