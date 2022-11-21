

public class Parcel
{
   static int count;
   int id;
   float size;
   ZoningType type;
   Building building;

   //constructors
   public Parcel()
   {
      count++;
      id = count;
      size = 0;
      type = ZoningType.Unknown;
      building = new Building();
      
   }
   
   public Parcel(float size, ZoningType type, Building building)
   {
      count++;
      id = count;
      this.size = size;
      this.type = type; 
      this.building = building.Copy();
   }
   
   
   //copy (deep)
   public Parcel Copy()
   {
      return new Parcel(size, type, building);
   }
   
   //getters
   public int getId() { return id; }
   public float getSize() { return size; }
   public ZoningType getType() { return type; }
   public Building getBuilding() { return building.Copy(); }
   
   
   //setters
   public boolean setSize(float size)
   {
      if (size >= 0) 
      {
         this.size = size;
         return true;
      }
      
      return false;
   }
   
   public void setZoningType(ZoningType type) { this.type = type; }
   
   public void setBuilding(Building building) { this.building = building.Copy(); }
   
   //to string method
   public String toString()
   {
      String str = "";
      str += "ID: " + id + "\n";
      str += "Size: " + size + "\n";
      str += "Zoning Type: " + type + "\n";
      str += "Building: \n";
      str += "\tSize: "  + building.getSize() + "\n";
      str += "\tAddress: " + building.getAddress() + "\n";
      return str;
   }
}
