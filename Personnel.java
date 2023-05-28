
public class Personnel extends Person
{
	int jobCount;

	
	Personnel(String name, String surname, int jobCount)
	{
		super(name,surname);
		this.jobCount = jobCount;
	}
	
	void incJobCount() 
	{
		jobCount++;
	}
	
	public double calculate()
	{
		return -(salary + (jobCount * 1.5));
	}
}
