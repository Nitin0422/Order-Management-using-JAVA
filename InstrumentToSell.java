
/**
 * Write a description of class InstrumentToSell here.
 *
 * @author (Nitin Tandukar)
 * @version (March 2022)
 */
public class InstrumentToSell extends Instrument // this class inherits the Instrument class.
{
    //private keyword used for encapsulation.
    private float Price;
    private String SellDate;            
    private float DiscountPercent;
    private boolean IsSold;
    
    //constructor creation 
    
    InstrumentToSell(String InstrumentName, float Price)
    {
        super(InstrumentName);
        this.Price = Price;
        this.SellDate = "";
        this.DiscountPercent = 0.0f;
        this.IsSold = false;
        
    }
    //getters methods
    public float getPrice()
    {
        return this.Price;
    }
    
    public String getSellDate()
    {
        return this.SellDate;
    }
    public float getDiscountPercent()
    {
        return this.DiscountPercent;
    }
    public boolean getIsSold()
    {
        return this.IsSold;
    }
    //setters method
    public void setPrice(float Price)
    {
        if(IsSold == false)
        {
            this.Price = Price;
        }
        else
        {
            System.out.println("This instrument is already sold !!!");
        }
    }
    public void setSellDate(String SellDate)
    {
        this.SellDate = SellDate;
    }
    public void setDiscountPercent(float DiscountPercent)
    {
        this.DiscountPercent = DiscountPercent;
    }
    public void setIsSold(boolean IsSold)
    {
        this.IsSold = IsSold;
    }
    //This method is used to sell Instrument if available.
    public void sellInstrment(String CustomerName, String CustomerPhoneNumber, int Customer_PAN, String SellDate, float DiscountPercent)
    {
        if(IsSold == true)
        {
            System.out.println("Hello!");
            System.out.println("Customer Name: " + getCustomerName());
            System.out.println("CustomerPhoneNumber: " + getCustomerPhoneNumber());
            System.out.println("Customer PAN Number: " + getCustomer_PAN());
            System.out.println("Sorry this instrument is already sold!!!");        
        }
        else
        {
            super.setCustomerName(CustomerName);
            super.setCustomerPhoneNumber(CustomerPhoneNumber);
            super.setCustomer_PAN(Customer_PAN);
            this.SellDate = SellDate;
            this.DiscountPercent = DiscountPercent;
            this.IsSold = true;
            float Discount = (this.DiscountPercent / 100) * Price;
            Price = Price - Discount;  
            System.out.println("Hello!");
            System.out.println("Customer Name: " + getCustomerName());
            System.out.println("CustomerPhoneNumber: " + getCustomerPhoneNumber());
            System.out.println("Customer PAN Number: " + getCustomer_PAN());
            System.out.println("Your total is : " + Price);
        }
    }
    //This method is used to check availability of Instrument and to see details of Instruments and Customers.
    public void display()
    {
        super.display();
        if(IsSold == true)
        {
            System.out.println("The sold date is: " + SellDate);
        }
        else
        {
            System.out.println("This Instrument is available for sales.");
        }
    }
    
}