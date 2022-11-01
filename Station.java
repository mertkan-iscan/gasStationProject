import java.util.Scanner;


public class Station {
	
	private String name;
	private int ID;
	private int gasCount = 0;
	private int dieselCount = 0;
	
	int serviceArrayCount=0;
	
	double totalGasolineInStation;
	double totalDieselInStation;
	
	double totalGasolineMoneyInStation;
	double totalDieselMoneyInStation;
	
	double averageGasolinePrice;
	double averageDieselPrice;
	
	
	
	Gasoline[] gasolineArray = new Gasoline[100];
	Diesel[] dieselArray = new Diesel[100];
	Service[] serviceArray = new Service[100];
	
	
	
	public Station(String name, int ID) {
		this.name = name;
		this.ID = ID;
	}
	public Integer getID() {
		return ID;
	}

	public static Station createStation() {
		
		Scanner myScanner=new Scanner(System.in);
		
		System.out.printf("%s\n","Enter name");
		String name=myScanner.nextLine();
		
		System.out.printf("%s\n","Enter id");
		int ID=myScanner.nextInt();
		
		
		Station newStation = new Station(name,ID);

		return newStation;
	}
	
	public static void findStationAndAddGasoline(Station[] stationArray) {
		Scanner myScanner2=new Scanner(System.in);
		
		System.out.printf("%s\n","Enter ID for search");
		int ID=myScanner2.nextInt();
		
		int flag = 0;
		
		for(int i=0;i<stationArray.length;i++) {
			
			if(stationArray[i]==null) {
				flag = 0;
			break;
			}
			
			if(stationArray[i].getID()==ID ) {
				
				flag = 1;
				
				Scanner myScanner=new Scanner(System.in);
				
				System.out.printf("%s\n","Please enter the origin of gasoline");
				String origin=myScanner.nextLine();
				
				System.out.printf("%s\n","Enter Please enter the price per liter use , instead of .");
				double pricePerLiter=myScanner.nextDouble();
				
				System.out.printf("%s\n","Please enter the total shipment volume in liter");
				double totalLiters=myScanner.nextDouble();
			
				
				Gasoline newGasoline = new Gasoline(origin,pricePerLiter,totalLiters);
			
				(stationArray[i]).gasolineArray[(stationArray[i]).gasCount]= newGasoline;
				((stationArray[i]).gasCount)++;
				
				
				 for(int z=0;z<(stationArray[i]).gasCount;z++) {
					 
					 (stationArray[i]).totalGasolineInStation = 
							 (stationArray[i]).totalGasolineInStation + ((stationArray[i]).gasolineArray[z]).totalLiters;
					 
					 (stationArray[i]).totalGasolineMoneyInStation = 
							 (stationArray[i]).totalGasolineMoneyInStation + (((stationArray[i]).gasolineArray[z]).totalLiters*((stationArray[i]).gasolineArray[z]).pricePerLiter);
					 
				 }
				 
				 (stationArray[i]).averageGasolinePrice = 
						 (stationArray[i]).totalGasolineMoneyInStation/(stationArray[i]).totalGasolineInStation;
				
				break;
				
				}
			}
		
			if(flag==0) {
				System.out.printf("%s\n","No station found with the given ID!");
				
		}
	}
	
	public static void findStationAndAddDiesel(Station[] stationArray) {
		Scanner myScanner2=new Scanner(System.in);
		
		System.out.printf("%s\n","Enter ID for search");
		int ID=myScanner2.nextInt();
		
		int flag = 0;
		
		for(int i=0;i<stationArray.length;i++) {
			
			if(stationArray[i]==null) {
				flag = 0;
			break;
			}
			
			if(stationArray[i].getID()==ID ) {
				
				flag = 1;
				
				Scanner myScanner=new Scanner(System.in);
				
				System.out.printf("%s\n","Please enter the origin of diesel");
				String origin=myScanner.nextLine();
				
				System.out.printf("%s\n","Enter Please enter the price per liter use , instead of .");
				Double pricePerLiter=myScanner.nextDouble();
				
				System.out.printf("%s\n","Please enter the total shipment volume in liter");
				Double totalLiters=myScanner.nextDouble();
				
		
				
				
				Diesel newDiesel = new Diesel(origin,pricePerLiter,totalLiters);
				
				(stationArray[i]).dieselArray[(stationArray[i]).dieselCount]= newDiesel;
				((stationArray[i]).dieselCount)++;
				
				
				for(int z=0;z<(stationArray[i]).dieselCount;z++) {
					 
					(stationArray[i]).totalDieselInStation = 
							(stationArray[i]).totalDieselInStation + ((stationArray[i]).dieselArray[z]).totalLiters;
					
					(stationArray[i]).totalDieselMoneyInStation = 
							(stationArray[i]).totalDieselMoneyInStation + (((stationArray[i]).dieselArray[z]).totalLiters*((stationArray[i]).dieselArray[z]).pricePerLiter);
					 
				 }
				
				(stationArray[i]).averageDieselPrice = 
						(stationArray[i]).totalDieselMoneyInStation/(stationArray[i]).totalDieselInStation;

				break;
				
				}
			}
		
			if(flag==0) {
				System.out.printf("%s\n","No station found with the given ID!");
				
		}
	}
	
	public static void displayStationInventory(Station[] stationArray)	{
		
		
		Scanner myScanner2=new Scanner(System.in);
		
		System.out.printf("%s\n","Enter ID for search");
		int ID=myScanner2.nextInt();
		
		int flag = 0;
		
		for(int i=0;i<stationArray.length;i++) {
			
			if(stationArray[i]==null) {
				flag = 0;
				System.out.printf("%s\n","error 1");
				
			break;
			}
			
			if(stationArray[i].getID()==ID ) {
				flag = 1;

				for(int j=0;j<(stationArray[i]).dieselCount;j++) {
					System.out.printf("Diesel... ");
					(stationArray[i]).dieselArray[j].displayDieselInformation();
				}
				
				System.out.printf("The total diesel liters in Station "+ "#"+stationArray[i].getID()+" "+stationArray[i].totalDieselInStation+"\n");
				System.out.printf("The average diesel price in Station " + "#"+stationArray[i].getID()+" "+(stationArray[i]).averageDieselPrice+"\n");
				
				for(int z=0;z<(stationArray[i]).gasCount;z++) {
					System.out.printf("Gasoline... ");
					(stationArray[i]).gasolineArray[z].displayGasolineInformation();
				}
				
				System.out.printf("The total gasoline liters in Station "+ "#"+stationArray[i].getID()+" "+stationArray[i].totalGasolineInStation+"\n");
				System.out.printf("The average gasoline price in Station " + "#"+stationArray[i].getID()+" "+((stationArray[i]).averageGasolinePrice)+"\n");
				
				break;
			}
		}
		
		if(flag==0) {
			System.out.printf("%s\n","No station found with the given ID!");
			
		}
	}
	
	public static void sellGasoline(Station[] stationArray) {
		
		Scanner myScanner3=new Scanner(System.in);
		
		System.out.printf("%s\n","Enter ID for search");
		
		int ID=myScanner3.nextInt();
		int flag2 = 0;
		
		
		for(int i=0;i<stationArray.length;i++) {
			if(stationArray[i]==null) {
				flag2 = 0;
				System.out.printf("%s\n","error 1");
				
			break;
			}
			
			if(stationArray[i].getID()==ID ) {
				flag2 = 1;
				Scanner myScanner4=new Scanner(System.in);
				System.out.printf("%s\n","enter carPlate  ");
				String carPlate=myScanner4.nextLine();
				System.out.printf("%s\n","Please enter if you have a coupon (y/n):  ");
				String hasCouponCoundition=myScanner4.nextLine();
				System.out.printf("%s\n","enter litersBought  ");
				double litersBought=myScanner4.nextDouble();
				
				
				if(litersBought>stationArray[i].totalGasolineInStation) {
					System.out.print("Not enough gasoline in the station! ");
					break;
				}
				
				
				boolean hasCoupon;
				if(hasCouponCoundition.equals("y"))
					hasCoupon = true;
				else {
					hasCoupon = false;
				}
				
				Service gasSer = new GasolineService(carPlate,litersBought,hasCoupon);

				gasSer.makeTransaction((stationArray[i]).averageGasolinePrice);
				(stationArray[i]).serviceArray[(stationArray[i]).serviceArrayCount] = gasSer;
				
				(stationArray[i]).serviceArrayCount++;
				
				stationArray[i].totalGasolineInStation = stationArray[i].totalGasolineInStation - litersBought;
				
				break;
			}
			
			if(flag2==0) {
				System.out.printf("%s\n","No station found with the given ID!");
				
			}
			
			
		}
		
	}
	
	
	public static void sellDiesel(Station[] stationArray) {
		
		Scanner myScanner3=new Scanner(System.in);
		System.out.printf("%s\n","Enter ID for search");
		int ID=myScanner3.nextInt();
		
		
		int flag3 = 0;
		
		
		for(int i=0;i<stationArray.length;i++) {
			if(stationArray[i]==null) {
				flag3 = 0;
				System.out.printf("%s\n","error 1");
				
			break;
			}
			
			if(stationArray[i].getID()==ID ) {
				Scanner myScanner4=new Scanner(System.in);
				flag3 = 1;
				
				
				
				System.out.printf("%s\n","enter carPlate  ");
				String carPlate=myScanner4.nextLine();

				System.out.printf("%s\n","antifreeze ? (y/n):  ");
				String discountedAntiFreezeCoundition=myScanner4.nextLine();
				
				
				int discountedAntiFreezeCount = 0;
				boolean discountedAntiFreeze;
				if(discountedAntiFreezeCoundition.equals("y")) {
					discountedAntiFreeze = true;
					System.out.printf("%s\n","how many do u want  ");
					discountedAntiFreezeCount=myScanner4.nextInt();
				}
				else 
					discountedAntiFreeze=false;
				
				
				System.out.printf("%s\n","enter litersBought  ");
				int litersBought=myScanner4.nextInt();
				
				if(litersBought>stationArray[i].totalDieselInStation) {
					System.out.printf("%s\n","Not enough gasoline in the station! ");
					break;
				}
				
					
					
				Service dieselSer = new DieselService(carPlate,litersBought,discountedAntiFreeze,discountedAntiFreezeCount);

				dieselSer.makeTransaction((stationArray[i]).averageDieselPrice);
				(stationArray[i]).serviceArray[(stationArray[i]).serviceArrayCount] = dieselSer;
				
				(stationArray[i]).serviceArrayCount++;
				
				
				stationArray[i].totalGasolineInStation = stationArray[i].totalGasolineInStation - litersBought;
				}
				break;
			}
			
			if(flag3==0) {
				System.out.printf("%s\n","No station found with the given ID!");
			}
		}
	
	 
	 
	public static void displayServices(Station[] stationArray) {
		
		
		Scanner myScanner2=new Scanner(System.in);
		
		System.out.printf("%s\n","Enter ID for search");
		int ID=myScanner2.nextInt();
		
		int flag = 0;
		
		for(int i=0;i<stationArray.length;i++) {
			
			if(stationArray[i]==null) {
				flag = 0;
				System.out.printf("%s\n","station array is empty");
				break;
			}
			
			if(stationArray[i].getID()==ID ) {
				flag = 1;

				for(int j=0;j<(stationArray[i]).serviceArrayCount;j++) {

					(stationArray[i]).serviceArray[j].displayServiceInfo();
				}

				
				
				break;
			}
		}
		
		if(flag==0) {
			System.out.printf("%s\n","No station found with the given ID!");
			
		}	
	}
}



































