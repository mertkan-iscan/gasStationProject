
public class DieselService extends FuelService{
	
	boolean discountedAntiFreeze;
	
	int discountedAntiFreezeCount;
	
	double discountedAntiFreezePrice=25;
	
	public DieselService(String carPlate,double litersBought,boolean discountedAntiFreeze,int discountedAntiFreezeCount) {
		super(carPlate, litersBought);
		this.discountedAntiFreeze = discountedAntiFreeze;
		this.discountedAntiFreezeCount=discountedAntiFreezeCount;
	}
	
	void displayServiceInfo() {
		System.out.printf("\n"+"diesel service ..."+"\n");
		super.displayServiceInfo();
		System.out.printf("\n"+"discounted anti-freeze count "+ discountedAntiFreezeCount+"\n");
		
	}
	double makeTransaction(double averageDieselPrice) {
		double calculatedDieselPrice = 
				averageDieselPrice * litersBought + discountedAntiFreezePrice * discountedAntiFreezeCount;
		super.makeTransaction(calculatedDieselPrice);
		return calculatedDieselPrice;
	}

}
