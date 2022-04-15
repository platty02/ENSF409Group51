/**
author: Carlos Morera Pinilla and Jacob Adeyemo and James Platt
version: 1.5
since: 1.0
*/


package edu.ucalgary.ensf409;
import java.io.*;
import java.util.*;
import java.io.FileWriter;
import java.io.IOException;
import java.io.File;
import java.io.FileNotFoundException;
public class OrderForm
{
	//Private fields:
	private final ArrayList<Hamper> REPORT;
	
	//Constructor: Fills the REPORT variable with list of Hampers.
	public OrderForm(ArrayList<Hamper> reportInfo)
	{
		this.REPORT = reportInfo;
	}
	//Creates a formatted order form using the order information stored in each hamper in REPORT. 
	//Then, writes this information to a text file namws Order.txt
	public void writeOrderForm(){
        try{
			//Create a text file using name Order and write the title Info
            FileWriter writeOrder = new FileWriter(new File("Order.txt"));
            writeOrder.write("Example Food Banks\nFood Order Form\n\nName:\nDate:\n\nOriginal Request\n");
			//For each Hamper in the list, write it's number in the list followed by the
			//number of client types.
            for(int i =0; i < REPORT.size(); i++){
				//hamper number
                writeOrder.write("Hamper " + (i+1) + ":");
                String toWrite = new String();
				//create String of Clients
                if(REPORT.get(i).getNumOfClientsAt(0) > 0){
                    toWrite += (" " + REPORT.get(i).getNumOfClientsAt(0) + " Adult Male," );
                }
                if(REPORT.get(i).getNumOfClientsAt(1) > 0){
                    toWrite += (" " + REPORT.get(i).getNumOfClientsAt(1) + " Adult Female," );
                }
                if(REPORT.get(i).getNumOfClientsAt(2) > 0){
                    toWrite += (" " + REPORT.get(i).getNumOfClientsAt(2) + " Child Over 8," );
                }
                if(REPORT.get(i).getNumOfClientsAt(3) > 0){
                    toWrite += (" " + REPORT.get(i).getNumOfClientsAt(3) + " Child Under 8," );
                }
				//write the Clients minus the extra comma
                toWrite = toWrite.substring(0, toWrite.length() -1);
                writeOrder.write(toWrite + "\n");   
            }
            writeOrder.write("\n");
			//now go through all hampers and write down their orders Item names and ItemID
            for(int i =0; i < REPORT.size(); i++){
				//hamper number
                writeOrder.write("Hamper " + (i + 1) + " Items:\n");
				//write hamper items.
                for(int k =0; k < REPORT.get(i).getItems().length; k++){
                    writeOrder.write(String.format("%-3s\t\t%s", REPORT.get(i).getItems()[k].getID(),REPORT.get(i).getItems()[k].getName()));
                    if(k != REPORT.get(i).getItems().length -1)
                        writeOrder.write("\n");
                }
				//if not the last hamper, add two line spacing.
                if(i != REPORT.size() -1){
                    writeOrder.write("\n");
                    writeOrder.write("\n");
                }
            }
            
            writeOrder.close();
        }
        catch(IOException e){
            //do some sort of error responese here?
        }
    }
}
