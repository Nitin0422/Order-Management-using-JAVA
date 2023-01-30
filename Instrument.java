
/**
 * Write a description of class Instrument here.
 *
 * @author (Nitin Tandukar)
 * @version (March 2022)
 */
public class Instrument 
{
    // private keyword used for encapsulation
    private static int InstrumentID;
    private String InstrumentName;
    private String CustomerName;
    private String CustomerPhoneNumber;
    private int Customer_PAN;
    
    public Instrument(String InstrumentName)
    {
        InstrumentID = ++InstrumentID;
        this.InstrumentName = InstrumentName;
        this.CustomerName = "";
        this.CustomerPhoneNumber = "";
        this.Customer_PAN = 0;
        
    }
    // Setter methods for all attributes.
    public void setInstrumentID(int InstrumentID)
    {
        this.InstrumentID = InstrumentID;     
    }
    public void setInstrumentName(String InstrumentName)
    {
        this.InstrumentName = InstrumentName;
    }
    public void setCustomerName(String CustomerName)
    {
        this.CustomerName = CustomerName;
    }
    public void setCustomerPhoneNumber(String CustomerPhoneNumber)
    {
        this.CustomerPhoneNumber = CustomerPhoneNumber;
    }
    public void setCustomer_PAN(int Customer_PAN)
    {
        this.Customer_PAN = Customer_PAN;
    }
   
    // getters method for all attributes
    public int getInstrumentID()
    {
        return this.InstrumentID;
    }
    public String getInstrumentName()
    {
        return this.InstrumentName;
    }
    public String getCustomerName()
    {
        return this.CustomerName;
    }
    public String getCustomerPhoneNumber()
    {
        return this.CustomerPhoneNumber;
    }
    public int getCustomer_PAN()
    {
        return this.Customer_PAN;
    }
    // Display method to display customer and instrument details.
    public void display()
    {
        System.out.println("Instrument ID: " + this.InstrumentID);
        System.out.println("Instrument Name: " + this.InstrumentName);
        if (!(CustomerName.equals("") && CustomerPhoneNumber.equals("") && Customer_PAN == 0))
        { 
        System.out.println("Customer Name: " + this.CustomerName);
        System.out.println("Customer Phone Number: " + this.CustomerPhoneNumber);
        System.out.println("Customer PAN Number: " + this.Customer_PAN);
        }
    }
}