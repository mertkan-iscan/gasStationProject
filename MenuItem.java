public enum MenuItem
	{
		M1("1. Create a new station"),
		M2("2. Add gasoline to a station inventory"),
		M3("3. Add diesel to a station inventory"),
		M4("4. Display a station inventory"),
		M5("5. Sell gasoline to customer"),
		M6("6. Sell diesel to customer"),
		M7("7. Sell car wash"),
		M8("8. Display sold services so far"),
		M9("9. Add personnel/manager to a station"),
		M10("10. Calculate net profit of a station"),
		M11("11. Display sold services (sorted by plate)"),
		M12("0. Exit");
	
	
		private String description;

		MenuItem()
        {
            this.description = this.name();
        }

        MenuItem(String name)
        {
            this.description = name;
        }
        
        public String toString()
        {
            return description; 
        }
        
        public static void printMenu() 
        {
        while(true)
        {
			MenuItem[] menu = MenuItem.values();
		    for(MenuItem m: menu)
		    {
		        System.out.printf("%s%n" , m);
		    }
		    break;
		   }
        }
	}