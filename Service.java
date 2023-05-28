import java.util.Comparator;

public abstract class Service implements Profitable, Comparable<Service>
{
	
	String carPlate;
	double revenue;
	
	Service(String carPlate)
	{
		this.carPlate = carPlate;
	}
	
	void displayServiceInfo() 
	{
		System.out.println(" ");
		System.out.println("Car Plate is "+ carPlate);
		System.out.println("The revenue from this service is " + revenue);
	}
	
	double makeTransaction(double calculatedPrice) 
	{
		revenue = calculatedPrice;
		return revenue;
	}
	
	public int compareTo(Service o)
	{
		return ((int)(this.revenue - o.revenue));
	}
} 

class PlateCompare implements Comparator<Service>
{
    public int compare(Service car1, Service car2)
    {
        return car1.carPlate.compareTo(car2.carPlate);
    }
}
