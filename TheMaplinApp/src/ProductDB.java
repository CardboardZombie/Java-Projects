

public class ProductDB 
{
	public static Product getProduct(String productCode)
	{
		/* In a more realistic application, this code would
		 * get the data for the product from a file or database
		 * For now, this code just uses if/else statements
		 * to return the correct product data
		 */
		/*
		 *==========================================================================================================
		//Create the Product Object
		Product p = new Product();
		
		//Fill the Product object with data
		p.setCode(productCode);
		if(productCode.equalsIgnoreCase("A36NY"))
		{
			p.setDescription("Corsair Carbide Series SPEC-03 Gaming Case");
			p.setPrice(54.99);
		}
		else if(productCode.equalsIgnoreCase("A94NJ"))
		{
			p.setDescription("Aftershock Quad Core AMD Motherboard and Processor Bundle");
			p.setPrice(299.99);
		}
		else if(productCode.equalsIgnoreCase("N34NU"))
		{
			p.setDescription("Corsair 600W ATX PC Power Supply");
			p.setPrice(69.99);
		}
		else if(productCode.equalsIgnoreCase("A51NB"))
		{
			p.setDescription("ASUS GeForce 760 2GB High Performance Graphics Card");
			p.setPrice(239.99);
		}
		else if(productCode.equalsIgnoreCase("A14QU"))
		{
			p.setDescription("WD 2TB 3.5\" Hard Drive");
			p.setPrice(84.99);
		}
		else if(productCode.equalsIgnoreCase("A36LX"))
		{
			p.setDescription("BenQ 21.5\" Monitor");
			p.setPrice(109.99);
		}
		else if(productCode.equalsIgnoreCase("N69JX"))
		{
			p.setDescription("Maplin Mini Wireless Deskset");
			p.setPrice(14.99);
		}
		else if(productCode.equalsIgnoreCase("A96NA"))
		{
			p.setDescription("Microsoft Windows 8.1 64 Bit DVD");
			p.setPrice(79.99);
		}
		else
		{
			p.setDescription("Unkown");
		}
		return p;
		
	*/
		//===========================================================================================================
		Product p = null;
		if(productCode.equalsIgnoreCase("R45PI") ||
			productCode.equalsIgnoreCase("R46PI") ||
			productCode.equalsIgnoreCase("A36LX"))
		{
			Book b = new Book();
			if(productCode.equalsIgnoreCase("R45PI"))
			{
				b.setCode(productCode);
				b.setDescription("The User Guide for the Raspberry Pi");
				b.setPrice(16.99);
				b.setAuthor("Gareth Halfacree");
			}
			else if(productCode.equalsIgnoreCase("R46PI"))
			{
				b.setCode(productCode);
				b.setDescription("Learn Raspberry Pi in 10 Easy Steps");
				b.setPrice(10.99);
				b.setAuthor("Neil Gaiman");
			}
			else if(productCode.equalsIgnoreCase("A96NA"))
			{
				b.setCode(productCode);
				b.setDescription("Getting Started with Python");
				b.setPrice(14.99);
				b.setAuthor("Gareth Halfacree");
			}
			p = b; // set Product variable equal to the Book object
		}
		else if (productCode.equalsIgnoreCase("A96NA"))
		{
			Software s = new Software();
			s.setCode("A96NA");
			s.setDescription("The Official Raspberry Pi Starter Kit");
			s.setPrice(79.99);
			s.setVersion("B Model");
			p = s; // set Product variable equal to the Software object
		}
		return p;
	}

}