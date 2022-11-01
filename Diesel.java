
public class Diesel {
	String origin;
	double pricePerLiter;
	double totalLiters;

	
	public Diesel(String origin, double pricePerLiter, double totalLiters) {
		this.origin = origin;
		this.pricePerLiter = pricePerLiter;
		this.totalLiters = totalLiters;
	}
	public void displayDieselInformation()
	{
		System.out.printf("%s","\n");
		System.out.println("The origin is:" + origin);
		System.out.printf("price per liter is:%s\n",pricePerLiter);
		System.out.printf("Total liters of this diesel is:%s\n",totalLiters+"\n");
	}
}
