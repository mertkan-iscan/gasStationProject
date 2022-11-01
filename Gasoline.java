
public class Gasoline {
	String origin;
	double pricePerLiter;
	double totalLiters;

	
	public Gasoline(String origin, double pricePerLiter, double totalLiters) {
		this.origin = origin;
		this.pricePerLiter = pricePerLiter;
		this.totalLiters = totalLiters;
	}
	public void displayGasolineInformation()
	{
		System.out.printf("%s","\n");
		System.out.println("The origin is:" + origin);
		System.out.printf("price per liter is:%s\n",pricePerLiter);
		System.out.printf("Total liters of this gasoline is:%s\n",totalLiters+"\n");
	}
}
