
public class Student {
	
	private String name;
	private int studentNumber;
	private int level;
	private String[] moduleCode;
	private int[] moduleMark; 
	
	//Constructor 
	public Student()
	{
		name = "";
		studentNumber = -1;
		level = -1;
		moduleCode = new String[3]; 
		moduleMark = new int[3];	
	}
	
	//overloaded constructor
	public Student(String stName, int stNumber, int stLevel, String[] stModuleCode, int[] stModuleMark)
	{
		name = stName;
		studentNumber = stNumber;
		level = stLevel;
		moduleCode = stModuleCode;
		moduleMark = stModuleMark;
	}
	
	//Getters
	public String getname()
	{
		return name;
	}
	
	public int getstudentNumber()
	{
		return studentNumber;
	}
	
	public int getlevel()
	{
		return level;
	}
	
	public String getmoduleCode(int position)
	{
		return moduleCode[position];
	}
	
	public int getmoduleMark(int number)
	{
		return moduleMark[number]; 
	}
	
	//setters
	
	public void setname (String thename){
		this.name = thename;
	}
	
	public void setstudentNumber (int thestudentNumber){
		this.level = thestudentNumber;
	}
	
	public void setlevel (int thelevel){
		this.level = thelevel;
	}
	
	public void setmoduleCode (String[] themoduleCode){
		this.moduleCode = themoduleCode;
	}
	
	public void setmoduleMark (int[] themoduleMark){
		this.moduleMark = themoduleMark;
	}
	
	
	
	
	
	

}
