
public class FuelService extends Service {
	
	double litersBought;
	
	FuelService(String carPlate,double litersBought) {
		super(carPlate);
		this.litersBought = litersBought;
	}
	
	void displayServiceInfo() {
		super.displayServiceInfo();
		System.out.printf("\n"+"Bought liters "+litersBought);
		
	}
	double makeTransaction(double calculatedPrice) {
		super.makeTransaction(calculatedPrice);
		return calculatedPrice;
	}
	

}
