
public class CinemaTester01 {

	public static void main(String[] args) {
		//Creating a Film Object
		Film01 newFilm = new Film01("Frozen", "Chris Buck", 2013);
		
		//Creating a Viewing Blueprint
		Viewing01 timetable = new Viewing01();
		timetable.setFilm(newFilm);
		timetable.setDate(2013);
		//String [] types = {"Adult", "Child", "Student"};
		//timetable.setTicketType(types);
		
		Ticket ticket1 = new Ticket("student", 5.0);
		Ticket ticket2 = new Ticket("adult", 8);
		Ticket ticket3 = new Ticket("adult", 8);
		Ticket ticket4 = new Ticket ("student", 5);
		
		Ticket[] tArray = {ticket1, ticket2, ticket3, ticket4};
		timetable.ticketArray = tArray;
		
		
		System.out.println(newFilm.getfilmTitle()+" was directed by "+newFilm.getDirector()+" and was released in "+
							newFilm.getYear()+".\n"+
							"There are 3 ticket types for viewing this movie at the cinema; "+ //timetable.getTicketType(0)
							//+ ", "+timetable.getTicketType(1)+" and "//+timetable.getTicketType(2)+
							" The current ticket price is ");
		
		//=================================================================================================================
		
		timetable.film.setfilmTitle("Frozen 2");
		timetable.film.setDirector("Jim Buck");
		timetable.film.setYear(2014);
		
		
		System.out.println("\n=============Question 2=====================\n");
		System.out.println(timetable.film.getfilmTitle() + "("+ timetable.film.getYear()+")");
		System.out.println(timetable.film.getDirector());
		
		//===============================================================================================================
		double sum = 0.0;
		double total = 0.0;
		
		for(int i = 0; i < timetable.ticketArray.length; i++)
		{
			sum = timetable.ticketArray[i].gettprice();
			total += sum;
			sum = 0.0;
		}
		System.out.println(total);

	}

}
