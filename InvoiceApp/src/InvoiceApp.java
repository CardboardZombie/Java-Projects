import java.util.Scanner;

public class InvoiceApp {

	public static void main(String[] args) {
		//Welcome the User to the Program
		System.out.println("Welcome to the Invoice Calculator");
		System.out.println();
		
		//Create a Scanner object to accept keyboard input
		Scanner sc = new Scanner(System.in);
		
		//Perform the invoice calculations until choice isn't equal to "y" or "Y"
		String choice = "y";
		while(choice.equalsIgnoreCase(choice))
		{
			//Get the invoice subtotal from the user
			System.out.print("Enter Subtotal:\t");
			double subtotal = sc.nextDouble();
			
			//Calculate the discount amount and total
			double discountPercent = 0.0;
			if(subtotal >= 200)
				discountPercent = .2;
			else if(subtotal >= 10)
				discountPercent = .1;
			else
				discountPercent = 0.0;
			
			double discountAmount = subtotal * discountPercent;
			double total = subtotal - discountAmount;
			
			//Display the discount amount and total
			String message = "Discount percent: "+ discountPercent +"\n"
					+"Discount amount: "+ discountAmount +"\n"
					+"Invoice total: €"+ total +"\n";
			System.out.println(message);
			
			//See if the user wants to continue
			System.out.print("Continue? (y/n): ");
			choice = sc.next();
			System.out.println();
		}
		//Closes the Scanner as the App is finished.
		sc.close();
	}
}
