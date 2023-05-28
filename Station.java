import java.util.*;

public class Station 
{
	private String name;
	private int ID;
	private double profit = 0;
	
	private double totalGasolineInStation;
	private double totalDieselInStation;
	
	double totalGasolineMoneyInStation;
	double totalDieselMoneyInStation;

	private double averageGasolinePrice;
	private double averageDieselPrice;

	
	ArrayList<Gasoline> gasolineArray = new ArrayList<Gasoline>();
	ArrayList<Diesel> dieselArray = new ArrayList<Diesel>();
	ArrayList<Service> serviceArray = new ArrayList<Service>();
	ArrayList<Person> personArray = new ArrayList<Person>();
	ArrayList<Profitable> profitArray = new ArrayList<Profitable>();
	ArrayList<Double> profitSum = new ArrayList<Double>();
	
	public Station(String name, int ID)
	{
		this.name = name;
		this.ID = ID;
	}
	
	public Integer getID()
	{
		return ID;
	}

	public static Station createStation() 
	{
		Scanner myScanner=new Scanner(System.in);
		
		System.out.printf("%s\n","Enter name");
		String name=myScanner.nextLine();
		System.out.printf("%s\n","Enter id");
		int ID=myScanner.nextInt();
		
		Station newStation = new Station(name,ID);
		
		
		return newStation;
	}
	
	public static void findStationAndAddGasoline(ArrayList<Station> stationArray) 
	{
		Scanner idScanner=new Scanner(System.in);
		
		System.out.printf("%s\n","Enter ID for search");
		int ID=idScanner.nextInt();
		

		if(stationArray.size()!=0 )
	    {
			for (int i=0;i<stationArray.size();i++)  
	    	{
	    		if(stationArray.get(i).ID==ID)  
	    		{
					Scanner gasScanner=new Scanner(System.in);
					
					System.out.printf("%s\n","Please enter the origin ");
					String origin=gasScanner.nextLine();
					System.out.printf("%s\n","Enter Please enter the price per liter use , instead of .");
					Double pricePerLiter=gasScanner.nextDouble();
					System.out.printf("%s\n","Please enter the total shipment volume in liter");
					Double totalLiters=gasScanner.nextDouble();
	    			
	    			Gasoline newGasoline = new Gasoline(origin,pricePerLiter,totalLiters);
	    			stationArray.get(i).gasolineArray.add(newGasoline);
	    			
	    			
	    			for(int z=0;z<stationArray.get(i).gasolineArray.size();z++) 
	    			{
	    				stationArray.get(i).totalGasolineInStation = 
	    						stationArray.get(i).totalGasolineInStation + stationArray.get(i).gasolineArray.get(z).totalLiters;
						 
	    				stationArray.get(i).totalGasolineMoneyInStation = 
	    						stationArray.get(i).totalGasolineMoneyInStation + 
	    						stationArray.get(i).gasolineArray.get(z).totalLiters * stationArray.get(i).gasolineArray.get(z).pricePerLiter;
					}
	    			stationArray.get(i).averageGasolinePrice = 
							stationArray.get(i).totalGasolineMoneyInStation / stationArray.get(i).totalGasolineInStation;
	    			
	    			break;
	    		}
	    	}
	    }
	    else
	    	System.out.println("list is empty");
	}
	
	public static void findStationAndAddDiesel(ArrayList<Station> stationArray)
	{
		Scanner idScanner=new Scanner(System.in);
		
		System.out.printf("%s\n","Enter ID for search");
		int ID=idScanner.nextInt();
		
		
		if(stationArray.size()!= 0)
	    {
			for (int i=0;i<stationArray.size();i++) 
	    	{
	    		if(stationArray.get(i).ID==ID) 
	    		{
					Scanner diesScanner=new Scanner(System.in);
					
					System.out.printf("%s\n","Please enter the origin of ");
					String origin=diesScanner.nextLine();
					System.out.printf("%s\n","Enter Please enter the price per liter use , instead of .");
					Double pricePerLiter=diesScanner.nextDouble();
					System.out.printf("%s\n","Please enter the total shipment volume in liter");
					Double totalLiters=diesScanner.nextDouble();
	    			
					Diesel newDiesel = new Diesel(origin,pricePerLiter,totalLiters);
					stationArray.get(i).dieselArray.add(newDiesel);
	    			
					
					for(int z=0;z<stationArray.get(i).dieselArray.size();z++) 
	    			{
	    				stationArray.get(i).totalDieselInStation = 
	    						stationArray.get(i).totalDieselInStation + stationArray.get(i).dieselArray.get(z).totalLiters;
						
	    				stationArray.get(i).totalDieselMoneyInStation = 
	    						stationArray.get(i).totalDieselMoneyInStation + 
	    						stationArray.get(i).dieselArray.get(z).totalLiters * stationArray.get(i).dieselArray.get(z).pricePerLiter;
					}
					stationArray.get(i).averageDieselPrice = 
							stationArray.get(i).totalDieselMoneyInStation / stationArray.get(i).totalDieselInStation;
					
	    			break;
	    		}
	    	}
	    }
	    else
	    	System.out.println("list is empty");
	}

	public static void displayStationInventory(ArrayList<Station> stationArray)	
	{
		Scanner idScanner=new Scanner(System.in);
		
		System.out.printf("%s\n","Enter ID for search");
		int ID=idScanner.nextInt();
		
		if(stationArray.size()!=0 )
	    {
	    	for (int i=0;i<stationArray.size();i++)
	    	{
	    		if(stationArray.get(i).ID==ID) 
	    		{	
	    			System.out.println("Diesel... ");
	    			for(int j=0;j<stationArray.get(i).dieselArray.size();j++) 
	    			{
						stationArray.get(i).dieselArray.get(j).displayDieselInformation();
					}
					
					System.out.printf("The total diesel liters in Station " + "#" + 
					stationArray.get(i).getID() + " " + stationArray.get(i).totalDieselInStation +"\n");
					System.out.printf("The average diesel price in Station " + "#" +
					stationArray.get(i).getID()+ " " + stationArray.get(i).averageDieselPrice +"\n");
		
					
					
					System.out.println("Gasoline... ");
					for(int z=0;z<stationArray.get(i).gasolineArray.size();z++) 
					{
						stationArray.get(i).gasolineArray.get(z).displayGasolineInformation();
					}
					
					System.out.printf("The total gasoline liters in Station " + "#" +
					stationArray.get(i).getID() + " " + stationArray.get(i).totalGasolineInStation +"\n");
					System.out.printf("The average gasoline price in Station " + "#" +
					stationArray.get(i).getID() + " " + stationArray.get(i).averageGasolinePrice +"\n");
	    			
	    			break;
	    		}
	    	}	
	    }
	    else
	    	System.out.println("list is empty");
	}
	
	public static void sellGasoline(ArrayList<Station> stationArray)
	{
		Scanner idScanner=new Scanner(System.in);
		
		System.out.printf("%s\n","Enter ID for search");
		int ID=idScanner.nextInt();
		
		Iterator<Station> iterator = stationArray.iterator();
		
		if(stationArray.size()!=0 )
	    {
	    	while(iterator.hasNext()) 
	    	{
	    		Station itStation = (Station)iterator.next();
	    		//if((iterator.next()).ID==ID) 
	    		if(itStation.ID==ID)
	    		{
					Scanner myScanner4=new Scanner(System.in);
					
					System.out.printf("%s\n","enter carPlate  ");
					String carPlate=myScanner4.nextLine();
					System.out.printf("%s\n","Please enter if you have a coupon (y/n):  ");
					String hasCouponCoundition=myScanner4.nextLine();
					System.out.printf("%s\n","enter litersBought  ");
					double litersBought=myScanner4.nextDouble();
					
					
					if(litersBought>itStation.totalGasolineInStation) 
					{
						System.out.print("Not enough gasoline in the station! ");
						break;
					}
					
					
					boolean hasCoupon;
					if(hasCouponCoundition.equals("y"))
						hasCoupon = true;
					else 
						hasCoupon = false;
					
					
					Service gasSer = new GasolineService(carPlate,litersBought,hasCoupon);

					gasSer.makeTransaction(itStation.averageGasolinePrice);
					itStation.serviceArray.add(gasSer);
					itStation.profitArray.add(gasSer);
					
	
					itStation.totalGasolineInStation = itStation.totalGasolineInStation - litersBought;
					
	    			break;
	    		}
	    	}
	    }
	    else
	    	System.out.println("list is empty");
	}
	
	public static void sellDiesel(ArrayList<Station> stationArray)
	{
		Scanner idScanner=new Scanner(System.in);
		
		System.out.printf("%s\n","Enter ID for search");
		int ID=idScanner.nextInt();
		
		Iterator<Station> iterator = stationArray.iterator();
		
		if(stationArray.size()!=0 )
	    {
	    	while(iterator.hasNext()) 
	    	{
	    		Station itStation = (Station)iterator.next();
	    		//if((iterator.next()).ID==ID) 
	    		if(itStation.ID==ID)
	    		{
					Scanner myScanner4=new Scanner(System.in);
					
					System.out.printf("%s\n","enter carPlate  ");
					String carPlate=myScanner4.nextLine();
					System.out.printf("%s\n","antifreeze ? (y/n):  ");
					String discountCoundition=myScanner4.nextLine();
					
					int discountedAntiFreezeCount = 0;
					boolean discountedAntiFreeze;
					if(discountCoundition.equals("y"))
					{
						discountedAntiFreeze = true;
						System.out.printf("%s\n","how much do u want  ");
						discountedAntiFreezeCount=myScanner4.nextInt();
					}
					else 
						discountedAntiFreeze=false;
					
					
					System.out.printf("%s\n","enter litersBought  ");
					int litersBought=myScanner4.nextInt();
					
					if(litersBought>itStation.totalDieselInStation) 
					{
						System.out.printf("%s\n","Not enough gasoline in the station! ");
						break;
					}
					
					
					Service diesSer = new DieselService(carPlate,litersBought,discountedAntiFreeze,discountedAntiFreezeCount);

					diesSer.makeTransaction(itStation.averageGasolinePrice);
					itStation.serviceArray.add(diesSer);
					itStation.profitArray.add(diesSer);
	
					itStation.totalDieselInStation = itStation.totalDieselInStation - litersBought;
					
	    			break;
	    		}
	    	}
	    }
	    else
	    	System.out.println("list is empty");
	}

	public static void displayServices(ArrayList<Station> stationArray) 
	{
		Scanner idScanner=new Scanner(System.in);
		
		System.out.printf("%s\n","Enter ID for search");
		int ID=idScanner.nextInt();
		
		if(stationArray.size()!=0 )
	    {
	    	for (int i=0;i<stationArray.size();i++)
	    	{
	    		if(stationArray.get(i).ID==ID) 
	    		{
	    			System.out.println("Services... ");
	    			Collections.sort(stationArray.get(i).serviceArray);
	    			for(int j=0;j<stationArray.get(i).serviceArray.size();j++) 
	    			{
						stationArray.get(i).serviceArray.get(j).displayServiceInfo();
					}
	    			break;
	    		}
	    	}
	    }
	    else
	    	System.out.println("list is empty");
	}
	
	public static void sellCarWash(ArrayList<Station> stationArray) 
	{
		Scanner idScanner=new Scanner(System.in);
		
		System.out.printf("%s\n","Enter ID for search");
		int ID=idScanner.nextInt();
		
		Iterator<Station> iterator = stationArray.iterator();
		
		if(stationArray.size()!=0 )
	    {
	    	while(iterator.hasNext()) 
	    	{
	    		Station itStation = (Station)iterator.next();
	    		//if((iterator.next()).ID==ID) 
	    		if(itStation.ID==ID) 
	    		{
	    			Scanner plateScan = new Scanner(System.in);
	    			
	    			System.out.printf("%s\n","Please enter the plate ");
					String plate = plateScan.nextLine();
					
					
	    			CarWash newCarWash = new CarWash(plate);
	    			itStation.serviceArray.add(newCarWash);
	    			itStation.profitArray.add(newCarWash);
	    			
	    			break;
	    		}
	    	}
	    }
	    else
	    	System.out.println("list is empty");
	}
	
	public static void addPerson(ArrayList<Station> stationArray) 
	{
		Scanner objctChoice = new Scanner(System.in);
		Scanner idScanner=new Scanner(System.in);
		Scanner persScanner=new Scanner(System.in);
		
		
		System.out.printf("%s\n","enter personnel or manager ");
		String choice = objctChoice.nextLine();
		
		System.out.printf("%s\n","Enter ID for search");
		int ID=idScanner.nextInt();
		
		System.out.print("enter name  ");
    	String name=persScanner.nextLine();
    	System.out.print("enter surname  ");
    	String surname=persScanner.nextLine();
    	
    	if(stationArray.size()!=0 )
	    {
    		for (int i=0;i<stationArray.size();i++)
	    	{
	    		if(stationArray.get(i).ID==ID)
	    		{
	    			if(choice.equals("personnel")) 
	    			{
	    		    	System.out.print("enter jobCount  ");
	    		    	Integer jobCount=persScanner.nextInt();

	    		    	Person newPers = new Personnel(name, surname, jobCount);
	    		    	
	    		    	stationArray.get(i).personArray.add(newPers);
	    		    	stationArray.get(i).profitArray.add(newPers);
	    			}
	    			else if(choice.equals("manager"))
	    			{
	    				System.out.print("enter jobYear  ");
	    		    	Integer jobYear=persScanner.nextInt();
	    		    	
	    		    	Person newMan = new Manager(name, surname, jobYear);
	    		    	
	    		    	stationArray.get(i).personArray.add(newMan);
	    		    	stationArray.get(i).profitArray.add(newMan);
	    			}
	    			else
	    				System.out.println("enter valid input !!!");
	    			
	    			break;
	    		}
	    	}
	    }
	    else
	    	System.out.println("list is empty");
	}
	
	public static void calculateNetProfit(ArrayList<Station> stationArray)
	{
		Scanner idScanner=new Scanner(System.in);
		
		System.out.printf("%s\n","Enter ID for search");
		int ID=idScanner.nextInt();
		
		
		if(stationArray.size() != 0)
	    {
			for (int i=0; i<stationArray.size(); i++)
	    	{
	    		if(stationArray.get(i).ID==ID)
	    		{
	    			System.out.println("Calculating profit... ");
	    			for (int j=0; j<stationArray.get(i).profitArray.size(); j++)
	    			{
	    				stationArray.get(i).profit = stationArray.get(i).profit + 
	    						stationArray.get(i).profitArray.get(j).calculate();
	    				System.out.println(stationArray.get(i).profit);
	    			}
	    			System.out.println("Profit = " + stationArray.get(i).profit);
	    			break;
	    		}
	    	}
	    }
	    else
	    	System.out.println("list is empty");
	}

	public static void displayServices2(ArrayList<Station> stationArray) 
	{
		Scanner idScanner=new Scanner(System.in);
		
		System.out.printf("%s\n","Enter ID for search");
		int ID=idScanner.nextInt();
		
		if(stationArray.size()!=0 )
	    {
	    	for (int i=0;i<stationArray.size();i++)
	    	{
	    		if(stationArray.get(i).ID==ID) 
	    		{
	    			System.out.println("Services... ");
	    			
	    			PlateCompare plateCompare = new PlateCompare();
	    			Collections.sort(stationArray.get(i).serviceArray, plateCompare);
	    			
	    			
	    			for(int j=0;j<stationArray.get(i).serviceArray.size();j++) 
	    			{
						stationArray.get(i).serviceArray.get(j).displayServiceInfo();
					}
	    			break;
	    		}
	    	}
	    }
	    else
	    	System.out.println("list is empty");
	}
}
