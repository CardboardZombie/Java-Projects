
public class StudentTester {

	public static void main(String[] args) {
		
		//Creating student object
		String[] moduletypes = {"CSC1011", "CSC1999", "ACC1234"};
		int[] modulemarktypes = {-1, -1, -1}; 
		
		
		Student student1 = new Student ("Tom Brown", 40134222, 1, moduletypes, modulemarktypes);
		
				
				
		System.out.println(student1.getname() + " " +student1.getstudentNumber()
				+ " "+ "is currently studying " + student1.getmoduleCode(0)+", "
				+ student1.getmoduleCode(1) + "and "+ student1.getmoduleCode(2) +" at Level" + student1.getlevel() );
		

	}

}
