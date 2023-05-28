
public class FuelService extends Service 
{
	
	double litersBought;
	
	FuelService(String carPlate,double litersBought) 
	{
		super(carPlate);
		this.litersBought = litersBought;
	}
	
	void displayServiceInfo() 
	{
		super.displayServiceInfo();
		System.out.println("Bought liters "+ litersBought);
		
	}
	
	double makeTransaction(double calculatedPrice) 
	{
		super.makeTransaction(calculatedPrice);
		return calculatedPrice;
	}
	
	public double calculate()
	{
		return 0;
	}

}
