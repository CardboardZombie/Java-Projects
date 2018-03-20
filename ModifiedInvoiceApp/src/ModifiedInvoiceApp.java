import java.util.Scanner;
import java.math.*;
import java.text.NumberFormat;

public class ModifiedInvoiceApp {

	public static void main(String[] args) {
		//Welcome the User to the Program
		System.out.println("Welcome to the Invoice Calculator 2.0");
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
			
			//Convert subtotal and discount percent to BigDecimal
			BigDecimal decimalSubtotal = new BigDecimal (Double.toString(subtotal));
			decimalSubtotal = decimalSubtotal.setScale(2, RoundingMode.HALF_UP);
			BigDecimal decimalDiscountPercent = new BigDecimal(Double.toString(discountPercent));

			//Calculate Discount Amount
			BigDecimal discountAmount = decimalSubtotal.multiply(decimalDiscountPercent);
			discountAmount = discountAmount.setScale(2, RoundingMode.HALF_UP);
			
			//Calculate total before Tax, Sales Tax, and total
			BigDecimal totalBeforeTax = decimalSubtotal.subtract(discountAmount);
			BigDecimal salesTaxPercent = new BigDecimal(".05");
			BigDecimal salesTax = salesTaxPercent.multiply(totalBeforeTax);
			salesTax = salesTax.setScale(2, RoundingMode.HALF_UP);
			BigDecimal total = totalBeforeTax.add(salesTax);
			
			//Format and display the results
			NumberFormat currency = NumberFormat.getCurrencyInstance();
			NumberFormat percentage = NumberFormat.getPercentInstance();
			
			//Display the discount amount and total
			String message = "Discount percent: "+ percentage.format(discountPercent) +"\n"
					+"Discount amount: "+ currency.format(discountAmount) +"\n"
					+"Total before tax: "+currency.format(totalBeforeTax)+"\n"
					+"Sales tax:\t"+currency.format(salesTax)+"\n"
					+"Invoice total: "+ currency.format(total) +"\n";
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
