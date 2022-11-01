
public class Service {
	
	String carPlate;
	double revenue;
	
	Service(String carPlate,double revenue) {
		
		this.carPlate = carPlate;
		this.revenue = revenue;
	}
	
	Service(String carPlate) {
		
		this.carPlate = carPlate;
	}
	
	
	
	void displayServiceInfo() {
		System.out.printf("Car Plate is "+ carPlate+"\n");
		System.out.printf("The revenue from this service is "+revenue);
		
	}
	
	double makeTransaction(double calculatedPrice) {
			
	revenue = calculatedPrice;
	return revenue;
	}

}
