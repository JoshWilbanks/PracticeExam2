import java.util.ArrayList;
import java.util.Scanner;

public class Demo
{

   static final float COMMERCIAL_PROPERTY_TAX_PER_ACRE = 2000f;
   static final float COMMERCIAL_PROPERTY_TAX_UNDER_4000_FT = 1f;
   static final float COMMMERCIAL_PROPERTY_TAX_OVER_OR_4000_FT = 1.5f;
   
   static final float RESIDENTIAL_PROPERTY_TAX_PER_ACRE = 500f;
   static final float RESIDENTIAL_PROPERTY_TAX_UNDER_2000_FT = .5f;
   static final float RESIDENTIAL_PROPERTY_TAX_OVER_OR_2000_FT = .75f;
   
   static final String title = "\t\tTax Calculator Demo\n";
   
   
   static Scanner keyboard = new Scanner(System.in);

   public static void main(String[] args)
   {
      ArrayList<ParcelWithTax> parcels = new ArrayList<ParcelWithTax>();
      boolean continueLooping;;
      
      //loop until user says to stop
      do
      {
         //variables for new parcel / building
         float parcelSize, buildingSize, tax;
         ZoningType parcelType;
         String buildingAddress;
         
         //get user input for parcel size
         do
         {
            System.out.print("\nPlease enter the size of the land (in acres): ");
            parcelSize = keyboard.nextFloat();
            if(parcelSize < 0) System.out.print("\nError! The size of the land cannot be less than 0.");
         }
         while(parcelSize < 0);
         
         
         //get user input for land zoning type
         parcelType = getZoningType();
         
         //get user input for building size
         do
         {
            System.out.print("\nPlease enter the size of the building (in square feet): ");
            buildingSize = keyboard.nextFloat();
            if(buildingSize < 0) System.out.print("\nError! The size of the building cannot be less than 0.");
         }
         while(buildingSize < 0);
         
         //get user input for building address
         keyboard.nextLine(); //eat an enter press
         System.out.print("\nPlease enter the address of the building: ");
         buildingAddress = keyboard.nextLine();
         
         //calculate tax for a given land and building
         tax = calculateTax(parcelSize, parcelType, buildingSize);
         
         //create parcel with new building and add it to the parcels arraylist
         parcels.add(new ParcelWithTax(parcelSize, tax, parcelType, new Building(buildingSize, buildingAddress)));
         

         //display tax
         System.out.printf("\nThe tax calculated based on the information entered is: $%,.2f", tax);
         
         //prompt user to for another entry
         continueLooping = getLoop();
         
      }
      while (continueLooping);
      
      //display all the information for each parcel
      System.out.println();
      System.out.println("\nTotal entry amount: " + parcels.size() + "\n");
      
      float totalTax = 0;
      
      for(int i = 0; i < parcels.size(); i++)
      {
         System.out.println(parcels.get(i).toString() + "\n");
         totalTax += parcels.get(i).getTax();
      }
      
      System.out.printf("\nTotal Tax Calculated: $%,.2f", totalTax);
      
   }
   
   
   //prompt user for land's zoning type and validate
   static ZoningType getZoningType()
   {
      int typeInt = ZoningType.values().length - 1;
      System.out.println("Zoning Types: ");
      System.out.println("\t1. Commercial");
      System.out.println("\t2. Residential");
      
      //loop until valid
      do
      {
         System.out.print("Please enter your land's zoning type: ");
         typeInt = keyboard.nextInt();
         if(typeInt <= 0 || typeInt > ZoningType.values().length - 1) System.out.println("\nError! Please enter only 1 or 2 as corrisponding to the menu options above.");
      }
      while(typeInt <= 0 || typeInt > ZoningType.values().length - 1);
      
      //-1 because array starts count at 0
      return ZoningType.values()[typeInt - 1];
   }
   
      
   //calculate the tax for a given land and building
   static float calculateTax(float parcelSize, ZoningType parcelType, float buildingSize)
   {
      float tax = 0;
      switch(parcelType)
      {
         case Commercial:
            tax += COMMERCIAL_PROPERTY_TAX_PER_ACRE * parcelSize;
            if (buildingSize < 4000) tax += COMMERCIAL_PROPERTY_TAX_UNDER_4000_FT * buildingSize;
            else tax += COMMMERCIAL_PROPERTY_TAX_OVER_OR_4000_FT * buildingSize;
            break;
         case Residential:
            tax += RESIDENTIAL_PROPERTY_TAX_PER_ACRE * parcelSize;
            if (buildingSize < 2000) tax += RESIDENTIAL_PROPERTY_TAX_UNDER_2000_FT * buildingSize;
            else tax += RESIDENTIAL_PROPERTY_TAX_OVER_OR_2000_FT * buildingSize;
            break;
         case Unknown:
            System.out.println("Error in calculating tax: Parcel Type Unknown.");
            break;      
      }
   
      return tax;
   

   }
   
   //prompt user to loop again
   static boolean getLoop()
   {
      boolean loop = false;
      
      System.out.print("\nWould you like to add another entry (Y/N)? ");
      if(keyboard.nextLine().toUpperCase().charAt(0) == 'Y') loop = true;
      return loop;
   
   
   }
      
}


