public class Building
{
   float size;
   String address;
   
   //constructors
   public Building()
   {
      size = 0;
      address = "Unknown";
   
   }
   
   public Building(float size, String address)
   {
      this.size = size;
      this.address = address;
   
   }
   
   //copy method
   public Building Copy()
   {
   
      return new Building(size, address);
   }
   
   //getters
   public float getSize() { return size; }
   public String getAddress() { return address; }
   
   //setters
   public boolean setSize(float size)
   {
      if(size >= 0)
      {
         this.size = size;
         return true;
      }
      
      return false;
   }
   
   public void setAddress(String address) { this.address = address; }
   
   //to string method
   public String toString()
   {
      String str = "";
      str += "Size: " + size + "\n";
      str += "Address: " + address + "\n";
      return str;
   }
}