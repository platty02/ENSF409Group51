/**
@author Kolby Lalonde, James Platt, Carlos Morera Pinilla, Jacob Adeyemo
UCID: 30130627
@version 1.9.1 April, 15, 2022
@since 1.0 April, 5, 2022
**/
package edu.ucalgary.ensf409;
import java.util.*;
import java.sql.*;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.*;
import java.awt.event.*;
import java.awt.FlowLayout;

public class GUI extends JFrame implements ActionListener, MouseListener{
    private static AdultMale AdultMale;
    private static AdultFemale AdultFemale;
    private static ChildOver8 ChildOver8;
    private static ChildUnder8 ChildUnder8;
    private static DataStorage data;
    private static AvailibleFood food;
    private HamperList order;
    private String numAdultMale;
    private String numAdultFemale;
    private String numChildOver8;
    private String numChildUnder8;
    private JTextArea instructions;
    private JLabel maleLabel;
    private JLabel femaleLabel;
    private JLabel childUnderLabel;
    private JLabel cOverLabel;
    private JTextField mInput;
    private JTextField fInput;
    private JTextField cOInput;
    private JTextField cUInput;
    private JButton submit;
    private JButton addHamper;
    private JButton orderInfo;
    private JButton clearOrder;
    /*
    Main() - this is where our entire program starts, creates a connection to the dataBase,
    grabs the tables, then creates our AvailableFood, and ClientNeeds classes.
    Then initializes the gui.
    */
    /*
    This is where the program will be ran from. To run the program, first compile this file using
    the javac command and include the mysql-connector-8.0.23.jar file as part of the path.
    this file should be stored in a library forlder within the working directory. Then to run the program
    run the GUI class using the same .jar file.
    */
    public static void main(String args[]){
        //connecting to the dataBase
        data = new DataStorage("jdbc:mysql://localhost/FOOD_INVENTORY");
        data.initializeConnection();
        data.setAvaliableFoodTable("AVAILABLE_FOOD", data.numberOfFoodItems("AVAILABLE_FOOD") );
        data.setDailyClientNeedsTable("DAILY_ClIENT_NEEDS");
        data.close();
        try{    
            //setting Client needs classes.
            AdultMale = new AdultMale(data.getDailyClientNeedsTable());
            AdultFemale = new AdultFemale(data.getDailyClientNeedsTable());
            ChildOver8 = new ChildOver8(data.getDailyClientNeedsTable());
            ChildUnder8 = new ChildUnder8(data.getDailyClientNeedsTable());
            food = new AvailibleFood(data.getAvaliableFoodTable());
        }
        catch(Exception e){
            throw new IllegalAccessError();
        }
        EventQueue.invokeLater(() -> {
            new GUI().setVisible(true);
        });
        
    }
    /*
    GUI() constructor - creates a JFrame, sets everything up including the size of the window, default behavier, etc.
    */
    public GUI(){
        //create window and setup order.
        super("Create a order");
        setupGUI();
        setSize(500,500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   
        this.order = new HamperList();
    }
    /*
    setupFood() - this is used to reset the AvailibleFoods object and ClientNeeds object. It's used
    when the the avialibleFood object dosen't reflect the items in the dataBase. (used when an order fails
    due to shortages in the database.)
    */
    private void setupFood(){
        try{    
            //settup availible food.
            data = new DataStorage("jdbc:mysql://localhost/FOOD_INVENTORY");
            data.initializeConnection();
            data.setAvaliableFoodTable("AVAILABLE_FOOD", data.numberOfFoodItems("AVAILABLE_FOOD") );
            data.setDailyClientNeedsTable("DAILY_ClIENT_NEEDS");
            AdultMale = new AdultMale(data.getDailyClientNeedsTable());
            AdultFemale = new AdultFemale(data.getDailyClientNeedsTable());
            ChildOver8 = new ChildOver8(data.getDailyClientNeedsTable());
            ChildUnder8 = new ChildUnder8(data.getDailyClientNeedsTable());
            food = new AvailibleFood(data.getAvaliableFoodTable());
            food = new AvailibleFood(data.getAvaliableFoodTable());
            data.close();
        }
        catch(Exception e){
            throw new IllegalAccessError();
        }
    }
    /*
    setupGUI() - setups the general format and look of the GUI window. sets text fields, labels, buttons, etc, 
    then adds them to their respective panels, and sets the format.
    */
    private void setupGUI(){
        //setting labels. // To use this program, add the number of family members for your first hamper, then click add. Follow the same procedure for each hamper you like to add to the order. Then press info to confrim that your hampers have been inputed correctly, and click submit to place the order.
        instructions = new JTextArea("Welcome to group 51' ENSF409 Final project. To use this program, add the number of family members for your first hamper, then click add. Follow the same procedure for    each hamper you like to add to the order. Then press info to confrim that your hampers have been inputed correctly, and click submit to place the order.", 5 ,43);
        instructions.setLineWrap(true);
        maleLabel = new JLabel("Number of males in digit form:");
        femaleLabel = new JLabel("Number of females in digit form:");
        childUnderLabel = new JLabel("Number of children under 8 in digit form:");
        cOverLabel = new JLabel("Number of children over 8 in digit form:");

        //setting test fields.
        mInput = new JTextField("eg 3");
        fInput = new JTextField("eg 2");
        cOInput = new JTextField("eg 1");
        cUInput = new JTextField("eg 0");

        //setting listeners.
        mInput.addMouseListener(this);
        fInput.addMouseListener(this);
        cOInput.addMouseListener(this);
        cUInput.addMouseListener(this);

        //creating the buttons seen on the bottom
        submit = new JButton("Submit");
        submit.addActionListener(this);

        addHamper = new JButton("Add");
        addHamper.addActionListener(this);

        orderInfo = new JButton("Info");
        orderInfo.addActionListener(this);

        clearOrder = new JButton("Clear");
        clearOrder.addActionListener(this);
        //setting panels
        JPanel header = new JPanel();
        header.setLayout(new FlowLayout());

        JPanel infoPanel = new JPanel();
        infoPanel.setLayout(new FlowLayout());

        JPanel submitPanel = new JPanel();
        submitPanel.setLayout(new FlowLayout());
        //adding elements to the panels.
        header.add(instructions);
        infoPanel.add(maleLabel);
		infoPanel.add(mInput);
		infoPanel.add(femaleLabel);
        infoPanel.add(fInput);
		infoPanel.add(childUnderLabel);
		infoPanel.add(cUInput);
		infoPanel.add(cOverLabel);
        infoPanel.add(cOInput);
        submitPanel.add(submit);
        submitPanel.add(addHamper);
        submitPanel.add(orderInfo);
        submitPanel.add(clearOrder);

        this.add(header, BorderLayout.NORTH);
        this.add(infoPanel, BorderLayout.CENTER);
        this.add(submitPanel, BorderLayout.PAGE_END);
    }
    /*
    checkInput() - used to double check that the input given by the user to the GUI is valid,
    making sure that they only used numerical digits 0-9.
    */
    private boolean checkInput(){
        boolean valid = true;
        //if any of the fields are empty, invalid.
        if(numAdultMale.equals("") || numAdultFemale.equals("") || numChildOver8.equals("") || numChildUnder8.equals(""))
            valid = false;
        //check for each field that only characters 0-9 are used.
        //else, invalid.
        for(int i =0; i < numAdultMale.length();i++){
            if(numAdultMale.charAt(i) > 57 || numAdultMale.charAt(i) < 48)
                valid = false;
        }
        for(int i =0; i < numAdultFemale.length();i++){
            if(numAdultFemale.charAt(i) > 57 || numAdultFemale.charAt(i) < 48)
                valid = false;
        }
        for(int i =0; i < numChildOver8.length();i++){
            if(numChildOver8.charAt(i) > 57 || numChildOver8.charAt(i) < 48)
                valid = false;
        }
        for(int i =0; i < numChildUnder8.length();i++){
            if(numChildUnder8.charAt(i) > 57 || numChildUnder8.charAt(i) < 48)
                valid = false;
        }
        //returns true if valid, false otherwise.
        return valid;
    }
    /*  
    mouseClicked() - event used to notify the program when the user clicks on a text field.
    when that happens, the text field should be cleared.
    */
    public void mouseClicked(MouseEvent event){
        
        if(event.getSource().equals(mInput))
            mInput.setText("");

        if(event.getSource().equals(fInput))
             fInput.setText("");

        if(event.getSource().equals(cOInput))
            cOInput.setText("");

        if(event.getSource().equals(cUInput))
            cUInput.setText("");
                
    }
    /*
    mouseEntered(), mouseExited(), mousePressed(), mouseReleased()
    we didn't want anything to happend when these events occur, so
    they don't do anything, but still needed to be implemented for the Mouselistener class.
    */
    public void mouseEntered(MouseEvent event){
        
    }

    public void mouseExited(MouseEvent event){
        
    }

    public void mousePressed(MouseEvent event){
        
    }

    public void mouseReleased(MouseEvent event){
        
    }
    /*
    actionPerformed() - This is where our program reacts to the user clicking one of our four buttons.
    if they press submit, the current order in the program is submitted and proccess, resources withstanding. 
    add adds a new hamper to the current order being setup. info brings up a alert with the number of hampers on the
    current order. Clear clears the current order, starting everything fresh without submitting anything.
    */
    public void actionPerformed(ActionEvent event){
        if(event.getSource() == submit ){
            //this is where the calculate order stuff will go.
            try{
                this.order.calculateOrder(food);
                ArrayList<Hamper> temp = order.getHamperArray();
                String[] orderIDs = new String[temp.size()];
                //remove items from the data base.
                try{    
                    //loop through all hampers
                    for(int i =0; i < temp.size(); i++){
                        orderIDs[i] = new String("");
                        //loop through all items in each hamper.
                        for(int j =0; j < temp.get(i).getItems().length; j++){
                            //delete each item.
                            orderIDs[i] += temp.get(i).getItems()[j].getID();
                            if(j != temp.get(i).getItems().length -1)
                                orderIDs[i] += ",";
                            data.delete(temp.get(i).getItems()[j].getID());
                        }
                    }
                }
                catch(Exception e){
                    throw new IllegalAccessError();
                }
                //output the ideal combos.
                for(int i =0; i < orderIDs.length; i++){
                    JOptionPane.showMessageDialog(this, "Hamper " + (i+1) + " food ID's are: " + orderIDs[i]);
                }
            }
            catch(UnavailableResourcesException e){
                //a shortage has been found, walk through hamperList to find which one is short.
                this.setupFood();
                JOptionPane.showMessageDialog(this, "Your order could not be completed.");
                JOptionPane.showMessageDialog(this, "The dataBase is short the following calories for Hamper "+ this.order.returnNumShortages());
                JOptionPane.showMessageDialog(this, "Grain: " + this.order.returnShortages()[1] + " FruitVeg: " + this.order.returnShortages()[2] + " Protein: " + this.order.returnShortages()[3] + " Other: " + this.order.returnShortages()[4]);
            }
            this.order = new HamperList();
        }
        else if(event.getSource() == addHamper){
            //take in the inputes from the text fileds
            numAdultMale = mInput.getText().trim();
            numAdultFemale = fInput.getText().trim();
            numChildOver8 = cOInput.getText().trim();
            numChildUnder8 = cUInput.getText().trim();
            int[] numToAdd = new int[4];
            if(checkInput() == true){
                numToAdd[0] = Integer.parseInt(numAdultMale);
                numToAdd[1] = Integer.parseInt(numAdultFemale);
                numToAdd[2] = Integer.parseInt(numChildOver8);
                numToAdd[3] = Integer.parseInt(numChildUnder8);
                //take a input and add a Hamper to the hamper list.
                this.order.addToHamper(new Hamper(numToAdd, AdultMale, AdultFemale, ChildOver8, ChildUnder8));
                //reset input fields.
                mInput.setText("");
                fInput.setText("");
                cOInput.setText("");
                cUInput.setText("");
                JOptionPane.showMessageDialog(this, "the inputs have been accepted.");
            }
            else{
                JOptionPane.showMessageDialog(this, "The inputs are invalid. Please only use 0-9.");
            }
        }
        else if(event.getSource() == orderInfo){
            //show number of hampers stored in hamper list.
            JOptionPane.showMessageDialog(this, "Your order contains the following number of hamppers: " + order.getHamperCount());
        }
        else if(event.getSource() == clearOrder){
            //reset the hamperList incase the user made a mistake.
            this.order = new HamperList();
            JOptionPane.showMessageDialog(this, "All hampers have been removed from Order.");
        }
    }
}

