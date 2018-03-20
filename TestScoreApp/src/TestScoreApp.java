import java.util.Scanner;

public class TestScoreApp {

	public static void main(String[] args) {
		//Display operational messages
		System.out.println("Please enter test scores that range from 0 to 100.");
		System.out.println("To end the program enter 999.");
		System.out.println(); 
		
		//Initialize the variables and create the Scanner Obj
		double scoreTotal = 0.0;
		int testScore = 0;
		int scoreCount = 0;
		Scanner sc = new Scanner(System.in);
		
		//Get a series of test scores from the user
		while(testScore != 999)
		{
			//Get the input from the user
			System.out.print("Enter Score: ");
			testScore = sc.nextInt();
			
			//Accumulate score count and score total
			if(testScore <= 100)
			{
				scoreCount = scoreCount + 1;
				scoreTotal = scoreTotal + testScore;
			}
			else
				System.out.println("Invalid Entry, not counted");
		}
		
		//Display the score count, score total and average score
		double averageScore = scoreTotal / scoreCount;
		String message = "\n"
				+ "Score count:\t"+ scoreCount +"\n"
				+ "Score total:\t"+ scoreTotal +"\n"
				+ "Average score:\t"+ averageScore +"\n";
		System.out.println(message);
		sc.close();
	}
}
