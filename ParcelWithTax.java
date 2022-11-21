
class ParcelWithTax extends Parcel
{
   //additional field
   float tax;
   
      
   //constructors
   public ParcelWithTax()
   {
      super();
      tax = 0;
   }

   public ParcelWithTax(float price, float tax, ZoningType type, Building building)
   {
      super(price, type, building);
      this.tax = tax;
   
   }
   
   //getter and setter for tax
   public float getTax() { return tax; }
   public boolean setTax(float tax)
   {
      if(tax > 0)
      {
         this.tax = tax;
         return true;
      }
      
      return false;
   }
   
   //toString override
   public String toString()
   {
      String str = super.toString();
      str += "Tax Amount: $" + tax;
      return str;
   }

}
