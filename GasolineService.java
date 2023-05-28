
public class GasolineService extends FuelService
{
	
	boolean hasCoupon;
	double discountRatio =0.1;
	
	
	public GasolineService(String carPlate,
			double litersBought,boolean hasCoupon) 
	{
		super(carPlate, litersBought);
		this.hasCoupon = hasCoupon;
	}

	void displayServiceInfo() 
	{
		System.out.println("gasoline service ...");
		super.displayServiceInfo();
		System.out.println("Has 10% discount coupon: " + hasCoupon);
		System.out.println(" ");
	}
	
	public double makeTransaction(double averageGasPrice) 
	{
		double calculatedGasPrice;
		
		
		if(hasCoupon==true) 
		{
			calculatedGasPrice = averageGasPrice * litersBought * discountRatio;
		}
		else 
		{
			calculatedGasPrice = averageGasPrice * litersBought;
		}
		
		super.makeTransaction(calculatedGasPrice);
		return calculatedGasPrice;
	}
	
	public double calculate()
	{
		return revenue;
	}
}
