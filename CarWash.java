
public class CarWash extends Service
{
	final static double basePrice = 10;
	
	
	CarWash(String carPlate) 
	{
		super(carPlate);
		revenue = basePrice;
	}

	void displayServiceInfo()
	{
		System.out.println(" ");
		System.out.println("car wash...");
		super.displayServiceInfo();
		System.out.println(" ");
	}
	
	public double calculate()
	{
		return basePrice;
	}
}
