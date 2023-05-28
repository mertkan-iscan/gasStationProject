
public class Manager extends Person
{
	int jobYear;
	int managerExtra = 200;
	
	
	
	Manager(String name, String surname, int jobYear)
	{
		super(name,surname);
		this.jobYear = jobYear;
	}

	public double calculate() 
	{
		return -(salary + managerExtra + (jobYear * 50));
	}
}
