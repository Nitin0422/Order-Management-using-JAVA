
/**
 * Write a description of class InstrumentToRent here.
 *
 * @author (Nitin Tandukar)
 * @version (March 2022)
 */
public class InstrumentToRent extends Instrument // This class inherits the Instrument class.
{
    // private keyword used for encapsulation.   
    private int ChargePerDay;
    private String DateOfRent;
    private String DateOfReturn;
    private int NumOfDays;
    private boolean IsRented;
    
    // Constructor creation
    
    public InstrumentToRent(String InstrumentName, int ChargePerDay)
    {
         super(InstrumentName); //calls Constructor from parent class.
         this.ChargePerDay = ChargePerDay;
         this.DateOfRent = "";
         this.DateOfReturn = "";
         this.NumOfDays = 0;
         this.IsRented = false;
         
    }
    
    //setters  method
    
    public void setChargePerDay(int ChargePerDay)
    {
        this.ChargePerDay = ChargePerDay; 
    }
    public void setDateOfRent(String DateOfRent)
    {
        this.DateOfRent = DateOfRent;
    }
    public void setDateOfReturn(String DateOfReturn)
    {
        this.DateOfReturn = DateOfReturn;
    }
    public void setNumOfDays(int NumOfDays)
    {
        this.NumOfDays = NumOfDays;
    }
    public void setIsRented(boolean IsRented)
    {
        this.IsRented = IsRented;
    }
    
    // getters method
    public int getChargePerDay()
    {
        return this.ChargePerDay;
    }
    public String getDateOfReturn()
    {
        return this.DateOfReturn;
    }
    public String getDateOfRent()
    {
        return this.DateOfRent;
    }
    public int getNumOfDays()
    {
        return this.NumOfDays;
    }
    public boolean getIsRented()
    {
        return this.IsRented;
    }
    
    // Method to rent instruments.
    public void rentInstrument(String CustomerName, String PhoneNumber, int Customer_PAN, String DateOfRent, String DateOfReturn, int NumOfDays)
    {
        if(this.IsRented == true) // If the instrument is not rented a sorry message will pop in the console.
        {
            System.out.println("Hello: ");
            System.out.println("Customer Name: " + CustomerName );
            System.out.println("Phone Number: " + PhoneNumber);
            System.out.println("PAN: " + Customer_PAN);
            System.out.println("Sorry! This instrument is not available for rent....");
            
        }
        else //if the instrument is not rented, customer details will be displayed.
        {
            super.setCustomerName(CustomerName);
            super.setCustomerPhoneNumber(PhoneNumber);
            super.setCustomer_PAN(Customer_PAN);
            this.DateOfRent = DateOfRent;
            this.DateOfReturn = DateOfReturn;
            this.NumOfDays = NumOfDays;
            this.IsRented = true;
            System.out.println("Hello: ");
            System.out.println("Customer Name: " + CustomerName );
            System.out.println("Phone Number: " + PhoneNumber);
            System.out.println("PAN: " + Customer_PAN);
            System.out.println("Your total charge is: " + this.ChargePerDay * this.NumOfDays);
        }
    }
    // This method is called to return instrument to the store.
    public void returnInstrument()
    {
        if(this.IsRented == false) // Checks if the instrument was rented or not
        {
            System.out.println("This instrument is not  rented to anybody.");
        }
        else // if the instrument was rented, it is returned and all customer details is reset to make it available to rent for others.
        {
            super.setCustomerName("");
            super.setCustomerPhoneNumber("");
            setDateOfRent("");
            setDateOfReturn("");
            setNumOfDays(0);
            super.setCustomer_PAN(0);
            setIsRented(false);
            System.out.println("Thanks for returning the Instrument");
        }
    }
    //display method having same signature as display method in parent class.
    public void display() // This method is called to check the availability of the instrument.
    {
        super.display();
        if (this.IsRented == true)
        {
            System.out.println("This instrument is already rented and the dates of rent and return are:");
            System.out.println("Rented Date: " + this.DateOfRent);
            System.out.println("Return Date: " + this.DateOfReturn);
        }
        else
        {
            System.out.println("This Instrument is available for rent...");
        }
    }
}
