//Learning Java from the ground up
import java.util.Scanner;
/* Author: Tadhg Deeney
 * Purpose: To calculate the subtotal from the user
 * 			Then, calculate the Discount amount total
 * 			and display these values on the console.
 * Date: 13/01/15
 */

//Main App declaration
public class TestApp // The class declaration. Public is an access modifier that controls the scope.
{
	public static void main (String[] args)
	{															//begin Main Method
		System.out.println("Welcome to Maplin Electronics.");
		
		//getting input from the user
		Scanner sc = new Scanner(System.in);
		System.out.println("What are you buying?	");
		String product = sc.nextLine();					//or next() can be used for one word answers
		System.out.println("How much do you have?	");
		int cashDollar = sc.nextInt();					//used for whole numbers
		System.out.println("Enter subtotal:	");
		double subtotal = sc.nextDouble();
		sc.close();
		
		System.out.println("You have "+cashDollar+ " euro to pay for "+product+".\n");
		//calculate discount amount and total
		double discountPercent = .25;
		double discountAmount = subtotal * discountPercent;
		double invoiceTotal = subtotal - discountAmount;
		
		//presenting the answer in a proper format
		String message = "Staff Discount: 	"+discountPercent+ "\n"
						+"Discounted Amount:	"+discountAmount+ "\n"
						+"Purchase Total:		"+invoiceTotal+ "\n";
		System.out.println(message);
		
		double priceCheck = cashDollar - invoiceTotal;
		if(priceCheck > 0.0)									//boolean expression
		{														
			System.out.println("You have bought " +product+".");	//statement
			if(discountPercent == .25)
				System.out.println("At a \"friends & family of staff\" discounted rate!");
		}
		else
			System.out.println("You cannot afford it.");
		
		System.out.print("Have a nice day! :)");
		
		
		int i = 1;
		int sum = 0;
		//=====================================While Loops============================================
		System.out.print("\n"+i+"\n");
		while (i < 5)
		{
			sum += 1;
			i = i+1;
		}
		System.out.print("\n"+sum+"\n");
		//============================================================================================
		//Switch
		/*switch(productID)
		 * {
		 * 		case 1:
		 * 			productDescription = "Hammer";
		 * 			break;
		 * 
		 * 		case 2:
		 * 			productDescription = "Harddrive";
		 * 			break;
		 * 
		 * 		default:
		 * 			productDescription = "Product not found";
		 * 			break;
		 * }
		 * 
		 */
	}														//end Main Method
	
}
