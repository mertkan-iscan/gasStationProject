
public abstract class Person implements Profitable
{
	String name;
	String surname;
	double salary = 100;
	
	Person(String name, String surname)
	{
		this.name = name;
		this.surname = surname;
	}
	void displayInformation() 
	{
		System.out.println();
		System.out.println();
		System.out.println();
	}
}
