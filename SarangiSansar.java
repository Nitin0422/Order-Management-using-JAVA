import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.Border;   
import java.util.ArrayList;
/** 
 * This class generates GUI for the program and contains the main method.
 *
 * @author (Nitin Tandukar)
 * @version (July 2022)
 */
public class SarangiSansar implements ActionListener
{
    /**
        Declaring all the components used in the GUI 
    **/
    JFrame frame;
    JLabel title, instrumentName, numOfDays, customerName, customerPhone, customerPAN, rentDate, discount, sellDate, instrumentName0, price, charge, forReturn, instrumentName1, returnDate;
    JTextField tfInsName, tfNumOfDays, tfCustomerName, tfCustomerPhone, tfCustomerPAN, tfDiscount, tfInsName0, tfPrice, tfCharge, tfInsName1;
    JToggleButton mode;
    JButton btPromptRentPanel, btPromptSellPanel, btPromptAddToRentPanel, btPromptAddToSellPanel, btDisplay, btClear, btRentInstrument, btSellInstrument, btAddInsToRent, btAddInsToSell, btReturnInstrument; 
    JLayeredPane rentSellPane, addInsPane;
    JPanel rentPanel, sellPanel, addToRentPanel, addToSellPanel, returnPanel;
    JComboBox <String> rentDay, rentMonth, rentYear, sellDay, sellMonth, sellYear, returnDay, returnMonth, returnYear;
    
    Border textfields = BorderFactory.createEmptyBorder(5, 10, 5, 10);// top, left, bottom right
    //Used Fonts
    Font topic = new Font("Segoe UI Historic", Font.BOLD, 20);
    Font subTopic = new Font("Segoe UI Historic", Font.BOLD, 17);
    /*Used Colors For buttons */
    Color btDefault = new Color(206, 32, 41);
    Color btSelected = new Color(156, 2, 2);
    // For dark mode   
    Color darkBackground = new Color(41, 37, 37);
    Color darkPanel = new Color(45, 45, 45);
    Color darkTf1 = new Color(131, 131, 131);
    Color darkTf2 = new Color(176, 176, 176);
    Color darkTf3 = new Color(165, 165, 165);   
    Color darkTf4 = new Color(154, 154, 154);
    //For Light Mode
    Color lightBackground = new Color(217, 212, 212);
    Color lightPanel = new Color(227, 224, 224);
    Color lightTf1 = new Color(195, 190, 190);
    Color lightTf2 = new Color(203, 199, 199);
    Color lightTf3 = new Color(212, 209, 209);
    
    //Declaring sizes of tf
    int tfHeight = 35;
    
    //Declaring logo of  app
    ImageIcon logo = new ImageIcon("LOGO.jpg");
    
    //Declaring an arraylist to add instruments
    ArrayList <Instrument> inventory = new ArrayList<Instrument>();
    
    /**Construction creation**/
    SarangiSansar()
    {        
        frame = new JFrame("SarangiSansar.exe");
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1200, 800);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setIconImage(logo.getImage());
        
        
        //creating heading
        title = new JLabel("Sarangi Sansar", JLabel.RIGHT);
        title.setFont(new Font("Yu Gothic",Font.PLAIN, 42));
        title.setBounds(450, 15, 300, 70);
        
        //creating togglebutton for dark and light mode
        mode = new JToggleButton("Lights On", false);
        mode.setFont(topic);
        mode.setFocusable(false);
        mode.setBorder(null);
        mode.setBounds(1000, 15, 150, 40);
        mode.addActionListener(this);
        
        /** For left section of the GUI **/
        //Creating buttons for rent and sale headers
        btPromptRentPanel = new JButton("To Rent the Instrument");
        btPromptRentPanel.setFont(topic);
        btPromptRentPanel.setBounds(60, 90, 230, tfHeight);
        btPromptRentPanel.setFocusable(false);
        btPromptRentPanel.setForeground(Color.white);
        btPromptRentPanel.setBackground(btSelected);
        btPromptRentPanel.setBorder(null);
        btPromptRentPanel.addActionListener(this);
        
        btPromptSellPanel = new JButton("To Sell the Instrument");
        btPromptSellPanel.setFont(topic);
        btPromptSellPanel.setBounds(305, 90, 230, tfHeight);
        btPromptSellPanel.setFocusable(false);
        btPromptSellPanel.setBackground(btDefault);
        btPromptSellPanel.setForeground(Color.white);
        btPromptSellPanel.setBorder(null);
        btPromptSellPanel.addActionListener(this);
        
        //Creating the layeredpane of sell and rent panel
        rentSellPane = new JLayeredPane();
        rentSellPane.setBounds(60, 135, 580, 560);
        
        //Rent panel
        rentPanel = new JPanel();
        rentPanel.setBounds(0, 0, 580, 560);
        rentPanel.setLayout(null);
        
        //Creating sell panel
        sellPanel = new JPanel();
        sellPanel.setBounds(0, 0, 580, 560);
        sellPanel.setLayout(null);
        
        //  creation of labels and text Feilds for rent and sell panel
        instrumentName = new JLabel("Instrument Name");
        instrumentName.setFont(subTopic);
        
        tfInsName = new JTextField();
        tfInsName.setFont(subTopic);
        tfInsName.setBorder(textfields);
        
        numOfDays = new JLabel("Number Of Days");
        numOfDays.setFont(subTopic);
        
        tfNumOfDays = new JTextField();
        tfNumOfDays.setFont(subTopic);
        tfNumOfDays.setBorder(textfields);
        tfNumOfDays.setText("0");
        
        customerName = new JLabel("Customer Name");
        customerName.setFont(subTopic);
        
        tfCustomerName = new JTextField();
        tfCustomerName.setFont(subTopic);
        tfCustomerName.setBorder(textfields);
        
        customerPhone = new JLabel("Customer Phone");
        customerPhone.setFont(subTopic);
        
        tfCustomerPhone = new JTextField();
        tfCustomerPhone.setFont(subTopic);
        tfCustomerPhone.setBorder(textfields);
        
        customerPAN = new JLabel("Customer PAN");
        customerPAN.setFont(subTopic);
        
        tfCustomerPAN = new JTextField();
        tfCustomerPAN.setFont(subTopic);
        tfCustomerPAN.setBorder(textfields);
        tfCustomerPAN.setText("0");
        
        rentDate = new JLabel("Rent Date");
        rentDate.setFont(subTopic);
        rentDate.setBounds(40, 332, 150, 25);
        
        /* 
            Declaring arrays of days months and year for comboboxes
        */
        String date[] = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"};
        String month[] = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
        String year[] = {"2022", "2023", "2024", "2025", "2026", "2027", "2028", "2029", "2030"};
        
        rentDay = new JComboBox<String>(date);
        rentDay.setBounds(200, 330, 83, tfHeight);
        rentDay.setFont(subTopic);
        rentDay.setFocusable(false);
        
        rentMonth = new JComboBox<String>(month);
        rentMonth.setBounds(305, 330, 100, tfHeight);
        rentMonth.setFont(subTopic);
        rentMonth.setFocusable(false);
        
        rentYear = new JComboBox<String>(year);
        rentYear.setBounds(430, 330, 100, tfHeight);
        rentYear.setFont(subTopic);
        rentYear.setFocusable(false);
        
        returnDate = new JLabel("Return Date");
        returnDate.setFont(subTopic);
        returnDate.setBounds(40, 392, 150, 25);
        
        returnDay = new JComboBox<String>(date);
        returnDay.setBounds(200, 390, 83, tfHeight);
        returnDay.setFont(subTopic);
        returnDay.setFocusable(false);
        
        returnMonth = new JComboBox<String>(month);
        returnMonth.setBounds(305, 390, 100, tfHeight);
        returnMonth.setFont(subTopic);
        returnMonth.setFocusable(false);
        
        returnYear = new JComboBox<String>(year);
        returnYear.setBounds(430, 390, 100, tfHeight);
        returnYear.setFont(subTopic);
        returnYear.setFocusable(false);
        
        btDisplay = new JButton("Display");
        btDisplay.setBounds(40, 460, 100, tfHeight);
        btDisplay.setFont(subTopic);
        btDisplay.setFocusable(false);
        btDisplay.setBorder(null);
        btDisplay.setBackground(btDefault);
        btDisplay.setForeground(Color.white);
        btDisplay.addActionListener(this);
        
        btRentInstrument = new JButton("Rent the instrument");
        btRentInstrument.setBounds(160, 460, 250, tfHeight);
        btRentInstrument.setFont(subTopic);
        btRentInstrument.setFocusable(false);
        btRentInstrument.setBorder(null);
        btRentInstrument.setBackground(btDefault);
        btRentInstrument.setForeground(Color.white);
        btRentInstrument.addActionListener(this);
                
        btClear = new JButton("Clear");
        btClear.setBounds(440, 460, 100, tfHeight);
        btClear.setFont(subTopic);
        btClear.setFocusable(false);
        btClear.setBorder(null);
        btClear.setBackground(btDefault);
        btClear.setForeground(Color.white);
        btClear.addActionListener(this);
        
        discount = new JLabel("Discount Percent");
        discount.setFont(subTopic);
        discount.setBounds(40, 132, 150, 25);
        
        tfDiscount = new JTextField();
        tfDiscount.setFont(subTopic);
        tfDiscount.setBounds(200, 130, 330, tfHeight);
        tfDiscount.setBorder(textfields);
        
        sellDate = new JLabel("Sell Date");
        sellDate.setFont(subTopic);
        sellDate.setBounds(40, 372, 150, 25);
        
        sellDay = new JComboBox<String>(date);
        sellDay.setBounds(200, 370, 83, tfHeight);
        sellDay.setFont(subTopic);
        sellDay.setFocusable(false);
        
        sellMonth = new JComboBox<String>(month);
        sellMonth.setBounds(305, 370, 100, tfHeight);
        sellMonth.setFont(subTopic);
        sellMonth.setFocusable(false);
        
        sellYear = new JComboBox<String>(year);
        sellYear.setBounds(430, 370, 100, tfHeight);
        sellYear.setFont(subTopic);
        sellYear.setFocusable(false);
        
        btSellInstrument = new JButton("Sell the instrument");
        btSellInstrument.setBounds(160, 460, 250, tfHeight);
        btSellInstrument.setFont(subTopic);
        btSellInstrument.setFocusable(false);
        btSellInstrument.setBorder(null);
        btSellInstrument.setBackground(btDefault);
        btSellInstrument.setForeground(Color.white);
        btSellInstrument.addActionListener(this);
        
        //  adding components to rent panel for default state
        addCompToRentPanel();
        
        //adding panels to layered pane
        rentSellPane.add(rentPanel);
        
        /** For top right section of GUI **/
        
        //Creating buttons for add to rent and sell panels
        btPromptAddToRentPanel = new JButton("Add To Rent");
        btPromptAddToRentPanel.setFont(topic);
        btPromptAddToRentPanel.setFocusable(false);
        btPromptAddToRentPanel.setBounds(710, 135, 180, tfHeight);
        btPromptAddToRentPanel.setBackground(btSelected);
        btPromptAddToRentPanel.setForeground(Color.white);
        btPromptAddToRentPanel.setBorder(null);
        btPromptAddToRentPanel.addActionListener(this);
        
        btPromptAddToSellPanel = new JButton("Add To Sale");
        btPromptAddToSellPanel.setFont(topic);
        btPromptAddToSellPanel.setFocusable(false);
        btPromptAddToSellPanel.setBounds(910, 135, 180, tfHeight);
        btPromptAddToSellPanel.setBackground(btDefault);
        btPromptAddToSellPanel.setForeground(Color.white);
        btPromptAddToSellPanel.setBorder(null);
        btPromptAddToSellPanel.addActionListener(this);
        
        //Creating add to rent or sell layered pane
        addInsPane = new JLayeredPane();
        addInsPane.setBounds(710, 185, 420, 200);
        
        //Creating add to rent panel
        addToRentPanel = new JPanel();
        addToRentPanel.setLayout(null);
        addToRentPanel.setBounds(0, 0, 420, 200);
        
        //Creating add to sell panel
        addToSellPanel = new JPanel();
        addToSellPanel.setLayout(null);
        addToSellPanel.setBounds(0, 0, 420, 200);
        
        //Creating components for both add to rent and add to sell panels.
        instrumentName0 = new JLabel("Instrument Name");
        instrumentName0.setFont(subTopic);
        instrumentName0.setBounds(20, 15, 150, 25);
        
        tfInsName0 = new JTextField();
        tfInsName0.setFont(subTopic);
        tfInsName0.setBounds(190, 15, 200, tfHeight);
        tfInsName0.setBorder(textfields);
        
        charge = new JLabel("Charge Per Day");
        charge.setFont(subTopic);
        charge.setBounds(20, 78, 150, 25);
        
        tfCharge = new JTextField();
        tfCharge.setFont(subTopic);
        tfCharge.setBounds(190, 80, 200, tfHeight);
        tfCharge.setText("0");
        tfCharge.setBorder(textfields);
        
        btAddInsToRent = new JButton("Add Instrument To Rent");
        btAddInsToRent.setBounds(70, 130, 300, tfHeight);
        btAddInsToRent.setFont(subTopic);
        btAddInsToRent.setFocusable(false);
        btAddInsToRent.setBorder(null);
        btAddInsToRent.setBackground(btDefault);
        btAddInsToRent.setForeground(Color.white);
        btAddInsToRent.addActionListener(this);
        
        price = new JLabel("Price of Instrument");
        price.setFont(subTopic);
        price.setBounds(20, 78, 160, 25);
        
        tfPrice = new JTextField();
        tfPrice.setFont(subTopic);
        tfPrice.setBounds(190, 80, 200, tfHeight);
        tfPrice.setText("0.0");
        tfPrice.setBorder(textfields);
        
        btAddInsToSell = new JButton("Add Instrument To Sell");
        btAddInsToSell.setBounds(70, 130, 300, tfHeight);
        btAddInsToSell.setFont(subTopic);
        btAddInsToSell.setFocusable(false);
        btAddInsToSell.setBorder(null);
        btAddInsToSell.setBackground(btDefault);
        btAddInsToSell.setForeground(Color.white); 
        btAddInsToSell.addActionListener(this);
         
        //Adding components to rent panel for default case
        addToRentPanel.add(instrumentName0);
        addToRentPanel.add(tfInsName0);
        addToRentPanel.add(charge);
        addToRentPanel.add(tfCharge);
        addToRentPanel.add(btAddInsToRent);
        
        
        // Adding panel to add instrument pane for default case
        addInsPane.add(addToRentPanel);
        
        /** For bottom right section of GUI **/
        forReturn = new JLabel("For Return", JLabel.CENTER);
        forReturn.setFont(topic);
        forReturn.setOpaque(true);
        forReturn.setBackground(btSelected);
        forReturn.setForeground(Color.white); 
        forReturn.setBounds(710, 425, 150, tfHeight);
        
        //Creating return panel
        returnPanel = new JPanel();
        returnPanel.setBounds(710, 475, 420, 170);
        returnPanel.setLayout(null);
        
        //Creating and adding components for return panel
        instrumentName1 = new JLabel("Instrument Name");
        instrumentName1.setFont(subTopic);
        instrumentName1.setBounds(20, 35, 150, 25);
        
        tfInsName1 = new JTextField();
        tfInsName1.setFont(subTopic);
        tfInsName1.setBounds(190, 35, 200, tfHeight);
        tfInsName1.setBorder(textfields);
        
        btReturnInstrument = new JButton("Return the instrument");
        btReturnInstrument.setBounds(70, 100, 300, tfHeight);
        btReturnInstrument.setFont(subTopic);
        btReturnInstrument.setFocusable(false);
        btReturnInstrument.setBorder(null);
        btReturnInstrument.setBackground(btDefault);
        btReturnInstrument.setForeground(Color.white);
        btReturnInstrument.addActionListener(this);
        
        returnPanel.add(instrumentName1);
        returnPanel.add(tfInsName1);
        returnPanel.add(btReturnInstrument);
        
        //adding components to frame
        frame.add(title);
        frame.add(mode);
        frame.add(btPromptRentPanel);
        frame.add(btPromptSellPanel);
        frame.add(rentSellPane);
        frame.add(btPromptAddToRentPanel);
        frame.add(btPromptAddToSellPanel);
        frame.add(addInsPane);
        frame.add(forReturn);
        frame.add(returnPanel);
        frame.setVisible(true);

        activateLightMode();//Default mode
    }
    
    
    //Method to invoke darkmode
    void activateDarkMode()
    {
        /**
            Colors for frame and top section
        **/
        frame.getContentPane().setBackground(new Color(41, 37, 37));
        title.setForeground(Color.white);
        mode.setText("Lights On");
        mode.setBackground(darkPanel);
        mode.setForeground(Color.white);
        /**
            Colors for left section of the GUI
        **/
        rentPanel.setBackground(darkPanel);
        sellPanel.setBackground(darkPanel);
        instrumentName.setForeground(Color.white);
        tfInsName.setBackground(darkTf1);
        numOfDays.setForeground(Color.white);
        tfNumOfDays.setBackground(darkTf1);
        customerName.setForeground(Color.white);
        tfCustomerName.setBackground(darkTf2);
        customerPhone.setForeground(Color.white);
        tfCustomerPhone.setBackground(darkTf3);
        customerPAN.setForeground(Color.white);
        tfCustomerPAN.setBackground(darkTf4);
        rentDate.setForeground(Color.white);
        rentDay.setForeground(Color.black);
        rentDay.setBackground(darkTf1);
        rentMonth.setForeground(Color.black);
        rentMonth.setBackground(darkTf1);
        rentYear.setForeground(Color.black);
        rentYear.setBackground(darkTf1);
        discount.setForeground(Color.white);
        tfDiscount.setBackground(darkTf1);
        sellDate.setForeground(Color.white);
        sellDay.setForeground(Color.black);
        sellDay.setBackground(darkTf1);
        sellMonth.setForeground(Color.black);
        sellMonth.setBackground(darkTf1);
        sellYear.setForeground(Color.black);
        sellYear.setBackground(darkTf1);
        /**
            Colors for top right section of GUI
        **/
        addToRentPanel.setBackground(darkPanel);
        addToSellPanel.setBackground(darkPanel);
        instrumentName0.setForeground(Color.white);
        tfInsName0.setBackground(darkTf2);
        charge.setForeground(Color.white);
        tfCharge.setBackground(darkTf3);
        price.setForeground(Color.white);
        tfPrice.setBackground(darkTf3);
        /**
            Colors for bottom right section of GUI
        **/
        returnPanel.setBackground(darkPanel);
        instrumentName1.setForeground(Color.white);
        tfInsName1.setBackground(darkTf2);
        returnDate.setForeground(Color.white);
        returnDate.setForeground(Color.white);
        returnDay.setForeground(Color.black);
        returnDay.setBackground(darkTf3);
        returnMonth.setForeground(Color.black);
        returnMonth.setBackground(darkTf3);
        returnYear.setForeground(Color.black);
        returnYear.setBackground(darkTf3);
    }
    
    //Method to invoke lightmode
    void activateLightMode()
    {
        /**
            Colors for frame and top section
        **/
        frame.getContentPane().setBackground(lightBackground);
        title.setForeground(Color.black);
        mode.setText("Lights Off");
        mode.setBackground(lightPanel);
        mode.setForeground(Color.black);
        /**
            Colors for left section
        **/
        rentPanel.setBackground(lightPanel);
        sellPanel.setBackground(lightPanel);
        instrumentName.setForeground(Color.black);
        tfInsName.setBackground(lightTf1);
        numOfDays.setForeground(Color.black);
        tfNumOfDays.setBackground(lightTf2);
        customerName.setForeground(Color.black);
        tfCustomerName.setBackground(lightTf2);
        customerPhone.setForeground(Color.black);
        tfCustomerPhone.setBackground(lightTf3);
        customerPAN.setForeground(Color.black);
        tfCustomerPAN.setBackground(lightTf2);
        rentDate.setForeground(Color.black);
        rentDay.setForeground(Color.black);
        rentDay.setBackground(lightTf1);
        rentMonth.setForeground(Color.black);
        rentMonth.setBackground(lightTf1);
        rentYear.setForeground(Color.black);
        rentYear.setBackground(lightTf1);
        discount.setForeground(Color.black);
        tfDiscount.setBackground(lightTf2);
        sellDate.setForeground(Color.black);
        sellDay.setForeground(Color.black);
        sellDay.setBackground(lightTf1);
        sellMonth.setForeground(Color.black);
        sellMonth.setBackground(lightTf1);
        sellYear.setForeground(Color.black);
        sellYear.setBackground(lightTf1);
        /**
            Colors for frame and top right section
        **/
        addToRentPanel.setBackground(lightPanel);
        addToSellPanel.setBackground(lightPanel);
        instrumentName0.setForeground(Color.black);
        tfInsName0.setBackground(lightTf2);
        charge.setForeground(Color.black);
        tfCharge.setBackground(lightTf3);
        price.setForeground(Color.black);
        tfPrice.setBackground(lightTf3);
        /**
            Colors for bottom right section of GUI
        **/
        returnPanel.setBackground(lightPanel);
        instrumentName1.setForeground(Color.black);
        tfInsName1.setBackground(lightTf2);
        returnDate.setForeground(Color.black);
        returnDay.setForeground(Color.black);
        returnDay.setBackground(lightTf3);
        returnMonth.setForeground(Color.black);
        returnMonth.setBackground(lightTf3);
        returnYear.setForeground(Color.black);
        returnYear.setBackground(lightTf3);
    }
    
    //Method to add components to rentPanel
    void addCompToRentPanel()
    {
        rentPanel.add(instrumentName);
        rentPanel.add(tfInsName);
        rentPanel.add(numOfDays);
        rentPanel.add(tfNumOfDays);
        rentPanel.add(customerName);
        rentPanel.add(tfCustomerName);
        rentPanel.add(customerPhone);
        rentPanel.add(tfCustomerPhone);
        rentPanel.add(customerPAN);
        rentPanel.add(tfCustomerPAN);
        rentPanel.add(rentDate);
        rentPanel.add(rentDay);
        rentPanel.add(rentMonth);
        rentPanel.add(rentYear);
        rentPanel.add(returnDate);
        rentPanel.add(returnDay);
        rentPanel.add(returnMonth);
        rentPanel.add(returnYear);
        rentPanel.add(btDisplay);
        rentPanel.add(btRentInstrument);
        rentPanel.add(btClear);
        instrumentName.setBounds(40, 32, 150, 25);
        tfInsName.setBounds(200, 30, 330, tfHeight);
        numOfDays.setBounds(40, 92, 150, 25);
        tfNumOfDays.setBounds(200, 90, 330, tfHeight);
        customerName.setBounds(40, 152, 150, 25);
        tfCustomerName.setBounds(200, 150, 330, tfHeight);
        customerPhone.setBounds(40, 212, 150, 25);
        tfCustomerPhone.setBounds(200, 210, 330, tfHeight);
        customerPAN.setBounds(40, 272, 150, 25);
        tfCustomerPAN.setBounds(200, 270, 330, tfHeight);
    }
    
    //Method to add components to SELLPanel
    void addCompToSellPanel()
    {
        sellPanel.add(instrumentName);
        sellPanel.add(tfInsName);
        sellPanel.add(discount);
        sellPanel.add(tfDiscount);
        sellPanel.add(customerName);
        sellPanel.add(tfCustomerName);
        sellPanel.add(customerPhone);
        sellPanel.add(tfCustomerPhone);
        sellPanel.add(customerPAN);
        sellPanel.add(tfCustomerPAN);
        sellPanel.add(sellDate);
        sellPanel.add(sellDay);
        sellPanel.add(sellMonth);
        sellPanel.add(sellYear);
        sellPanel.add(btDisplay);
        sellPanel.add(btSellInstrument);
        sellPanel.add(btClear);
        tfInsName.setBounds(200, 70, 330, tfHeight);
        instrumentName.setBounds(40, 72, 150, 25);  
        customerName.setBounds(40, 192, 150, 25);
        tfCustomerName.setBounds(200, 190, 330, tfHeight);
        customerPhone.setBounds(40, 252, 150, 25);
        tfCustomerPhone.setBounds(200, 250, 330, tfHeight);
        customerPAN.setBounds(40, 312, 150, 25);
        tfCustomerPAN.setBounds(200, 310, 330, tfHeight);
        
    }
    
     //Creating a method to clear the form
    void clearForm()
    {
        tfInsName.setText("");
        tfNumOfDays.setText("0");
        tfCustomerName.setText("");
        tfCustomerPhone.setText("");
        tfCustomerPAN.setText("0");
        tfDiscount.setText("");
        tfInsName0.setText("");
        tfPrice.setText("0.0");
        tfCharge.setText("0");
        tfInsName1.setText("");
        rentDay.setSelectedItem("1");
        rentMonth.setSelectedItem("Jan");
        rentYear.setSelectedItem("2021");
        sellDay.setSelectedItem("1");
        sellMonth.setSelectedItem("Jan");
        sellYear.setSelectedItem("2021");
        returnDay.setSelectedItem("1");
        returnMonth.setSelectedItem("Jan");
        returnYear.setSelectedItem("2021");
    }
    
    //Overiding method actionPerformed
    public void actionPerformed(ActionEvent e)
    {
        /**
            EVENTS THAT DEALS WITH AESTHETICS
        **/
        /*
        When mode button is clicked:
        if the button is in on state, light mode is selected else dark mode is selected.
        light mode is selected by calling the method activateLightMode and dark mode is selected by calling activateDarkMode method.
        */
        if(e.getSource() == mode)
        {
            if(mode.isSelected())
            {
                activateLightMode();
            }
            else
            {
                activateDarkMode();
            }
        }
        
        /*
            When to rent the instrument is clicked:
            the layeredpane in the section is emptied and rent panel is added to the pane.
        */
        else if(e.getSource() == btPromptRentPanel)
        {
            rentSellPane.removeAll();
            rentSellPane.add(rentPanel);
            //Selected color
            btPromptRentPanel.setBackground(btSelected);
            //NotSelected color
            btPromptSellPanel.setBackground(btDefault);
            //Emptying sell panel as we are moving out of it
            sellPanel.removeAll();
            //  adding components to rent panel
            addCompToRentPanel();
        }
        
        /*
            When to sell the instrument is clicked:
            the layeredpane in the section is emptied and sell panel is added to the pane.
        */
        else if(e.getSource() == btPromptSellPanel)
        {
            rentSellPane.removeAll();
            rentSellPane.add(sellPanel);
            //Selected color
            btPromptSellPanel.setBackground(btSelected);
            //NotSelected color
            btPromptRentPanel.setBackground(btDefault);
            //Emptying rent panel as we are moving out of it
            rentPanel.removeAll();
            //  adding components to rent panel
            addCompToSellPanel();
        }
       
        /*
            When add to rent button is clicked the pane is removed and add to rent panel is added.    
        */ 
        else if(e.getSource() == btPromptAddToRentPanel)
        {
            addInsPane.removeAll();
            addInsPane.add(addToRentPanel);
            //Selected color
            btPromptAddToRentPanel.setBackground(btSelected);
            //NotSelected color
            btPromptAddToSellPanel.setBackground(btDefault);
            //Emptying addTosell panel as we are moving out of it
            addToSellPanel.removeAll();
            //Filling in components to add to rent panel
            addToRentPanel.add(instrumentName0);
            addToRentPanel.add(tfInsName0);
            addToRentPanel.add(charge);
            addToRentPanel.add(tfCharge);
            addToRentPanel.add(btAddInsToRent);
        }
       
         /*
            When add to sell button is clicked the pane is removed and add to sell panel is added.    
        */ 
        else if(e.getSource() == btPromptAddToSellPanel)
        {
            addInsPane.removeAll();
            addInsPane.add(addToSellPanel);
            //Selected color
            btPromptAddToSellPanel.setBackground(btSelected);
            //NotSelected color
            btPromptAddToRentPanel.setBackground(btDefault);
            //Emptying addTorent panel as we are moving out of it
            addToRentPanel.removeAll();
            //Filling in components to add to rent panel
            addToSellPanel.add(instrumentName0);
            addToSellPanel.add(tfInsName0);
            addToSellPanel.add(price);
            addToSellPanel.add(tfPrice);
            addToSellPanel.add(btAddInsToSell);
        }
       /**
            EVENT HANDLING TO ADD FUNCTIONALITY TO GUI
        **/
       /*
           When addtorent button is clicked:
           * values of textfeilds from instrument name and charge is extracted.
           * exception is handled and users input is validated 
           * the instrument added hence is then checked if it already exists in the Arraylist
           * if it exists the user is notified and if not it is added to the arraylist.
        */
        else if(e.getSource() == btAddInsToRent)
        {
            //User inputs are stored in the variables declared in Pascal casing
            String InstrumentName = tfInsName0.getText().toUpperCase();//extracting instrument name
            int Charge = 0;
            boolean exceptionThrown = false;
            boolean isAdded = false;
            /* Exception handling */
            try
            {           
                Charge = Integer.parseInt(tfCharge.getText()); // extracting charge per day  
            }
            catch(NumberFormatException a)
            {
                JOptionPane.showMessageDialog(frame, "Please enter a number in charge field!", "Invalid input", JOptionPane.ERROR_MESSAGE);
                exceptionThrown = true;
            }
            //if exception is not caught 
            if(!exceptionThrown)
            {
                if(InstrumentName.equals("") || Charge == 0) // checking for user validation
                {
                    JOptionPane.showMessageDialog(frame, "Please fill the empty fields!","ERROR", JOptionPane.ERROR_MESSAGE);    
                }               
                else
                {
                    if(!inventory.isEmpty())// if arraylist is not empty
                    {
                        for(Instrument fromInventory:inventory)
                        {
                            if(fromInventory.getInstrumentName().equals(InstrumentName))//if the instrument already exists in the arraylist
                            {
                                JOptionPane.showMessageDialog(frame, "This instrument has already been added!", "DUPLICATION", JOptionPane.ERROR_MESSAGE);
                                isAdded = true;
                                break; // break out of the loop if the instrument is already added.
                            }
                        }
                    }
                    if(!isAdded)  //if the instrument is unique, it is added to the arraylist             
                    {
                        InstrumentToRent instrument = new InstrumentToRent(InstrumentName, Charge);   
                        inventory.add(instrument);
                        JOptionPane.showMessageDialog(frame, InstrumentName + " has been added for rent", "Instrument added!", JOptionPane.INFORMATION_MESSAGE);
                        clearForm();
                    }
                }
            }
        }
      
        /*
           When addtosell button is clicked:
           * values of textfeilds from instrument name and price is extracted.
           * exception is handled and users input is validated 
           * the instrument added hence is then checked if it already exists in the Arraylist
           * if it exists the user is notified and if not it is added to the arraylist.
        */
        else if(e.getSource() == btAddInsToSell)
        {
            String InstrumentName = tfInsName0.getText().toUpperCase();//extracting instrument name
            float Price = 0f;
            boolean exceptionThrown = false;
            int errorCode = 0;
            try
            {           
                Price = Float.parseFloat(tfPrice.getText()); // extracting charge per day  
            }
            catch(NumberFormatException a)
            {
                JOptionPane.showMessageDialog(frame, "Please enter a number in Price field!", "Invalid input", JOptionPane.ERROR_MESSAGE);
                exceptionThrown = true;
            }
            if(!exceptionThrown)
            {
                if(InstrumentName.equals("") || Price == 0) // checking for user validation
                {
                    JOptionPane.showMessageDialog(frame, "Please fill the empty fields!", "ERROR", JOptionPane.ERROR_MESSAGE);   
                    errorCode = 1;
                }  
                else if(!inventory.isEmpty())// if arraylist is not empty
                {
                    for(Instrument fromInventory:inventory)
                    {
                        if(fromInventory.getInstrumentName().equals(InstrumentName))//if the instrument already exists in the arraylist
                        {
                            JOptionPane.showMessageDialog(frame, "This instrument has already been added!", "DUPLICATION", JOptionPane.ERROR_MESSAGE);
                            errorCode = 1;
                            break; // break out of the loop if the instrument is already added.
                        }
                    }
                }
                if(errorCode == 0)  //if the instrument is unique, it is added to the arraylist             
                {
                    InstrumentToSell instrument = new InstrumentToSell(InstrumentName, Price);   
                    inventory.add(instrument);
                    JOptionPane.showMessageDialog(frame, InstrumentName + " has been added for sale","Instrument added", JOptionPane.INFORMATION_MESSAGE);
                    clearForm();
                }
            }
        }
        
        /*When rent the instrument button is pressed:
         * Inputs of the user is extracted.
         * Exception is handled
         * User input is validated.
         * If everything is valid, instrument is checked if it is available for rent
         * Then it is downcasted and rentInstrument is called. 
         * if not available for rent, appropriate message is sent.
        */
        else if(e.getSource() == btRentInstrument)
        {
            // inputs taken from the user are stored in variables written in Pascal case.
            boolean exceptionThrown = false;
            String InstrumentName = ""; 
            String CustomerName = "";
            String CustomerPhone = "";
            int CustomerPAN = 0;
            String RentDay = rentDay.getSelectedItem().toString();
            String RentMonth = rentMonth.getSelectedItem().toString();
            String RentYear = rentYear.getSelectedItem().toString();            
            String ReturnDay = returnDay.getSelectedItem().toString();
            String ReturnMonth = returnMonth.getSelectedItem().toString();
            String ReturnYear = returnYear.getSelectedItem().toString();
            int NumOfDays = 0;
            String RentDate = RentDay + "/" + RentMonth + "/" + RentYear;
            String ReturnDate = ReturnDay + "/" + ReturnMonth + "/" + ReturnYear;
            //Exception handling
            try
            {
                InstrumentName = tfInsName.getText().toUpperCase();
                CustomerName = tfCustomerName.getText();     
                CustomerPhone = tfCustomerPhone.getText();
                CustomerPAN = Integer.parseInt(tfCustomerPAN.getText());
                NumOfDays = Integer.parseInt(tfNumOfDays.getText());
            }
            catch(NumberFormatException c)
            {
                JOptionPane.showMessageDialog(frame, "Please provide integer values in Customer PAN and number of days!!", "Invalid input", JOptionPane.ERROR_MESSAGE);
                exceptionThrown = true;
            }
            if(!exceptionThrown)
            {
                if(InstrumentName.equals("") || CustomerName.equals("") || CustomerPhone.equals("") || CustomerPAN == 0 || NumOfDays == 0)
                {
                    JOptionPane.showMessageDialog(frame, "Please enter the empty fields!!", "ERROR", JOptionPane.ERROR_MESSAGE); 
                }
                else
                {
                    boolean listedForRent = false;          
                    for(Instrument fromInventory : inventory)
                    {
                        if(fromInventory instanceof InstrumentToRent)
                        {
                            InstrumentToRent ins = (InstrumentToRent)fromInventory;
                            if(ins.getInstrumentName().equals(InstrumentName))
                            {
                                listedForRent = true;
                                if(ins.getIsRented())
                                {
                                    JOptionPane.showMessageDialog(frame, "Instrument " + InstrumentName + " is already rented! Please check the terminal for furthur detials!", "Already rented!", JOptionPane.ERROR_MESSAGE);
                                    int charge = ins.getChargePerDay();
                                    ins.rentInstrument(CustomerName, CustomerPhone, CustomerPAN, RentDate, ReturnDate, NumOfDays);
                                    clearForm();
                                    break;
                                }
                                else
                                {
                                    int charge = ins.getChargePerDay();
                                    JOptionPane.showMessageDialog(frame, "Instrument Name: " + InstrumentName + "    Charge Per Day: " + charge + "  Please check the terminal for furthur detials!", "Instrument rented", JOptionPane.INFORMATION_MESSAGE);
                                    ins.rentInstrument(CustomerName, CustomerPhone, CustomerPAN, RentDate, ReturnDate, NumOfDays);
                                    clearForm();
                                    break;
                                }
                            }
                        }
                    }
                    if(!listedForRent)
                    {
                        JOptionPane.showMessageDialog(frame, "Instrument " + InstrumentName + " does not exist in our store!", "Invalid name", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        }
        
        /*When sell the instrument button is pressed:
         * Inputs of the user is extracted.
         * Exception is handled
         * User input is validated.
         * If everything is valid, instrument is checked if it is available for sale
         * Then it is downcasted and sellInstrument is called. 
         * if not available for rent, appropriate message is sent.
        */
        else if(e.getSource() == btSellInstrument)
        {
            //Inputs are stored in variables written in Pascal case.
            boolean exceptionThrown = false;
            String InstrumentName = ""; 
            String CustomerName = "";
            String CustomerPhone = "";
            int CustomerPAN = 0;
            String SellDay = sellDay.getSelectedItem().toString();
            String SellMonth = sellMonth.getSelectedItem().toString();
            String SellYear = sellYear.getSelectedItem().toString();            
            float Discount = 0f;
            String SellDate = SellDay + "/" + SellMonth + "/" + SellYear;
            //Exception Handling
            try
            {
                InstrumentName = tfInsName.getText().toUpperCase();
                CustomerName = tfCustomerName.getText();     
                CustomerPhone = tfCustomerPhone.getText();
                CustomerPAN = Integer.parseInt(tfCustomerPAN.getText());
                Discount = Float.parseFloat(tfDiscount.getText());
            }
            catch(NumberFormatException c)
            {
                JOptionPane.showMessageDialog(frame, "Please provide integer values in Customer PAN and Price.  Please check the terminal for furthur detials!", "Invalid input", JOptionPane.ERROR_MESSAGE);
                exceptionThrown = true;
            }
            if(!exceptionThrown)
            {
                if(InstrumentName.equals("") || CustomerName.equals("") || CustomerPhone.equals("") || CustomerPAN == 0 || Discount == 0)
                {
                    JOptionPane.showMessageDialog(frame, "Please enter the empty fields!!", "ERROR", JOptionPane.ERROR_MESSAGE); 
                }
                else
                {
                    boolean listedForSale = false;
                    for(Instrument fromInventory : inventory)
                    {
                        if(fromInventory instanceof InstrumentToSell)
                        {
                            InstrumentToSell ins = (InstrumentToSell)fromInventory;
                            if(ins.getInstrumentName().equals(InstrumentName))
                            {
                                listedForSale = true;
                                if(ins.getIsSold())
                                {
                                    JOptionPane.showMessageDialog(frame, "The instrument " + InstrumentName + "is already sold !!  Please check the terminal for furthur detials!", "Already Sold ", JOptionPane.ERROR_MESSAGE);
                                    float Price = ins.getPrice();
                                    ins.sellInstrment(CustomerName, CustomerPhone, CustomerPAN, SellDate, Discount);
                                    clearForm();
                                    break;
                                }
                                else
                                {
                                    float Price = ins.getPrice();
                                    JOptionPane.showMessageDialog(frame, "Instrument Name: " + InstrumentName + " Price of the Instrument: " + Price + "   Please check the terminal for furthur detials!", "Instrument sold!", JOptionPane.INFORMATION_MESSAGE);
                                    ins.sellInstrment(CustomerName, CustomerPhone, CustomerPAN, SellDate, Discount);
                                    clearForm();
                                    break;
                                }
                            }
                        }
                    }
                    if(!listedForSale)
                    {
                        JOptionPane.showMessageDialog(frame, "Instrument " + InstrumentName + " is not added for sale!", "Invalid name!", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }    
        }
        
        /* When return instrument is clicked
         * instrumentname is taken from the user in the GUI
         * user input is validated
         * then the instrument is checked if it exists in the arraylist
         * then the instrument is downcasted as instrument to rent and returnInstrument method is called. 
        */
        else if(e.getSource() == btReturnInstrument)
        {
            String InstrumentName = tfInsName1.getText().toUpperCase();
            boolean InstrumentFound = false;
            if(InstrumentName.equals(""))
            {
                JOptionPane.showMessageDialog(frame, "Enter instrument name!!!","ERROR", JOptionPane.ERROR_MESSAGE);
            }
            else
            {
                for(Instrument fromInventory : inventory)
                {
                    if(fromInventory.getInstrumentName().equals(InstrumentName))
                    {
                        if(fromInventory instanceof InstrumentToRent)
                        {
                            InstrumentToRent ins = (InstrumentToRent)fromInventory;
                            ins.returnInstrument();
                            InstrumentFound = true;
                            JOptionPane.showMessageDialog(frame, InstrumentName + " has been returned.", "Thank you", JOptionPane.INFORMATION_MESSAGE);
                            clearForm();
                            break;
                        }
                    }
                }
                if(!InstrumentFound)
                {
                    JOptionPane.showMessageDialog(frame, "The instrument is not listed in this store.", "ERROR",JOptionPane.ERROR_MESSAGE);
                    clearForm();
                }
            }
        }
               
       /* When display button is pressed
        * Instrument name is taken and checked if it exists in the arraylist
        * If found instance of instrument is checked and respective display method is called.          
        */
        else if(e.getSource() == btDisplay)
        {
                for(Instrument fromInventory : inventory)
                {
                    if(fromInventory instanceof InstrumentToRent)
                    {
                        InstrumentToRent ins = (InstrumentToRent)fromInventory;
                        System.out.println("Instrument For Rent: ");
                        ins.display();
                    }
                    else
                    {
                        InstrumentToSell ins = (InstrumentToSell)fromInventory;
                        System.out.println("Instrument For Sale: ");
                        ins.display();
                    }
                }   
                JOptionPane.showMessageDialog(frame, "Check terminal for more information ", "INFO", JOptionPane.INFORMATION_MESSAGE);
        }
       
        //Clear button is pressed.
        else 
        {
            clearForm(); 
        }    
    }
   
    //Creating the main method
    public static void main(String args[])
    {
        new SarangiSansar(); //Calling constructor
    }
}
