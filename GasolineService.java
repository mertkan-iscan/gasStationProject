
public class GasolineService extends FuelService{
	
	boolean hasCoupon;
	double discountRatio =0.1;
	
	public GasolineService(String carPlate,double litersBought,boolean hasCoupon) {
		super(carPlate, litersBought);
		this.hasCoupon = hasCoupon;
		
		
	}

	void displayServiceInfo() {
		System.out.printf("\n"+"gasoline service ..."+"\n");
		super.displayServiceInfo();
		System.out.print("\n"+"Has 10% discount coupon: "+ hasCoupon +"\n");
	}
	
	double makeTransaction(double averageGasPrice) {
		double calculatedGasPrice;
		if(hasCoupon==true) {
			calculatedGasPrice = averageGasPrice * litersBought * discountRatio;
		}
		else {
			calculatedGasPrice = averageGasPrice * litersBought;
		}
		super.makeTransaction(calculatedGasPrice);
		return calculatedGasPrice;
	}
}
