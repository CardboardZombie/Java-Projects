import java.util.Scanner;
public class MainApp 
{

	public static void main(String[] args) 
	{
		//======================================== Version 1 =======================================================
		
		//Display a Welcome Message
		System.out.println("Welcome to the Maplin PC Building App");
		System.out.println();
		/*
		//Display 1 or more products
		Scanner sc = new Scanner(System.in);
		String choice = "y";
		while(choice.equalsIgnoreCase("y"))
		{
			//Get input from the user
			System.out.print("Enter product code: ");
			String productCode = sc.next();				//read the product code
			sc.nextLine();								//discard any other data entered on the line
			
			//Get the Product object
			Product product = ProductDB.getProduct(productCode);
			
			//Display the output
			System.out.println();
			System.out.println("================================ SELECTED PRODUCT ================================");
			System.out.println("Description:	" + product.getDescription());
			System.out.println("Price:		" + product.getFormattedPrice());
			System.out.println();
			
			//See if the user wants to continue
			System.out.println("Continue? (y/n): ");
			choice = sc.nextLine();
			System.out.println();
			
		}
		sc.close();
		*/
		//==========================================================================================================
		//Test new inheritance classes
		
		/*Book b = new Book();
		b.setCode("R46PI");
		b.setDescription("The User Guide for the Raspberry Pi");
		b.setPrice(16.99);
		b.setAuthor("Gareth Halfacree");
		
		Software s = new Software();
		s.setCode("R45PI");
		s.setDescription("The Official Raspberry Pi Starter Kit");
		s.setPrice(79.99);
		s.setVersion("B Model");
		
		Product p;
		p = b;
		System.out.println(p.toString()); //calls toString from the Book class
		p = s;
		System.out.println(p.toString()); //calls toString from the Software class
		
		*/
		//========================================LineItemApp=======================================================
		/*Scanner sc = new Scanner(System.in);
		String choice = "y";
		while(choice.equalsIgnoreCase("y"))
		{
			//get input from the user
			String productCode = Validator.getString(sc, "Enter product code:	");
			int quantity = Validator.getInt(sc, "Enter quantity:	", 0, 1000);
			
			//get the Product object
			Product product = ProductDB.getProduct(productCode);
			LineItem lineItem = new LineItem(product, quantity);
			
			//display the output
			System.out.println();
			System.out.println("LINE ITEM");
			System.out.println("Code:		" + product.getCode());
			System.out.println("Description:	" + product.getDescription());
			System.out.println("Price:		" + product.getFormattedPrice());
			System.out.println("Quantity:	" + lineItem.getQuantity());
			System.out.println("Total:		" + lineItem.getFormattedTotal() + "\n");
			
			//See if the user wants to continue
			choice = Validator.getString(sc, "Continue? (y/n): ");
			System.out.println();
		} */
		//==========================================================================================================
		//======================================= ProductApp Inheritance ===========================================
		Scanner sc = new Scanner(System.in);
		String choice = "y";
		while(choice.equalsIgnoreCase("y"))
		{
			//get input from the user
			String productCode = Validator.getString(sc, "Enter product code:	");
			
			//get the Product object
			Product p = ProductDB.getProduct(productCode);
			
			//display the output
			System.out.println();
			if(p != null)
				System.out.println(p);
			else
				System.out.println("No product matches this product code.\n");
			
			System.out.println("Product count: " + Product.getCount() + "\n");
			
			//See if the user wants to continue
			choice = Validator.getString(sc, "Continue? (y/n): ");
			System.out.println();
		}
		
		
		
		
	}

}
