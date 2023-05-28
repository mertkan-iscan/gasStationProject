
public class DieselService extends FuelService
{
	
	boolean discountedAntiFreeze;
	int discountedAntiFreezeCount;
	double discountedAntiFreezePrice=25;
	
	
	public DieselService(String carPlate,double litersBought,
			boolean discountedAntiFreeze,int discountedAntiFreezeCount) 
	{
		super(carPlate, litersBought);
		this.discountedAntiFreeze = discountedAntiFreeze;
		this.discountedAntiFreezeCount=discountedAntiFreezeCount;
	}
	
	void displayServiceInfo() 
	{
		System.out.println("diesel service ...");
		super.displayServiceInfo();
		System.out.println("discounted anti-freeze count " + discountedAntiFreezeCount);
		System.out.println(" ");
		
	}
	
	public double makeTransaction(double averageDieselPrice) 
	{
		double calculatedDieselPrice = 
				averageDieselPrice * litersBought + discountedAntiFreezePrice * discountedAntiFreezeCount;
		
		super.makeTransaction(calculatedDieselPrice);
		return calculatedDieselPrice;
	}
	
	public double calculate()
	{
		return revenue;
	}
}
