/**
author: Carlos Morera Pinilla and Jacob Adeyemo and James Platt
version: 1.4
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
	
	//Constructor:
	public OrderForm(ArrayList<Hamper> reportInfo)
	{
		this.REPORT = reportInfo;
	}
	//Retrives a formatted String of the Order Form taken from the collection of Hampers in HamperList.
	public void writeOrderForm(){
        try{
            FileWriter writeOrder = new FileWriter(new File("Order.txt"));
            writeOrder.write("Example Food Banks\nFood Order Form\n\nName:\nDate:\n\nOriginal Request\n");
            for(int i =0; i < REPORT.size(); i++){
                writeOrder.write("Hamper " + i + ": ");
                String toWrite = new String();
                if(REPORT.get(i).getNumOfClientsAt(0) > 0){
                    toWrite += (REPORT.get(i).getNumOfClientsAt(0) + " Adult Male," );
                }
                if(REPORT.get(i).getNumOfClientsAt(1) > 0){
                    toWrite += (REPORT.get(i).getNumOfClientsAt(1) + " Adult Female," );
                }
                if(REPORT.get(i).getNumOfClientsAt(2) > 0){
                    toWrite += (REPORT.get(i).getNumOfClientsAt(2) + " Child Over 8," );
                }
                if(REPORT.get(i).getNumOfClientsAt(3) > 0){
                    toWrite += (REPORT.get(i).getNumOfClientsAt(3) + " Child Under 8," );
                }
                toWrite = toWrite.substring(0, toWrite.length() -1);
                writeOrder.write(toWrite + "\n");   
            }
            writeOrder.write("\n");
            for(int i =0; i < REPORT.size(); i++){
                writeOrder.write("Hamper " + i + " Items:\n");
                for(int k =0; k < REPORT.get(i).getItems().length; k++){
                    writeOrder.write(String.format("%-3s\t\t%s", REPORT.get(i).getItems()[k].getID(),REPORT.get(i).getItems()[k].getName()));
                    if(k != REPORT.get(i).getItems().length -1)
                        writeOrder.write("\n");
                }
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
/**
@author: Carlos Morera Pinilla and Jacob Adeyemo
@version: 1.4
@since: 1.0
*/
/*
package edu.ucalgary.ensf409;
import java.io.*;
public class OrderForm
{
	//Private fields:
	private final HamperList REPORT;
	private BufferedReader br;
	private BufferedWriter bw;
	
	 //Constructor:
	public OrderForm(HamperList reportInfo)
	{
		this.REPORT = reportInfo;
	}
	//Retrives a formatted String of the Order Form taken from the collection of Hampers in HamperList.
	public String getFormattedForm()
	{
		String formattedString = new String();
		try
		{
			this.br = new BufferedReader(new FileReader("orderForm.txt"));
			String s = new String();
			while((s = br.readLine()) != null)
			{
				//Read each line
				formattedString += s;
			}
		}
		catch(IOException e)
		{
			System.err.println("orderForm.txt could not be read, it may not exist yet!");
			System.exit(1);
		}
		//Attempt to close the input file and return the String.
		finally
		{
			try
			{
				this.br.close();
			}
			catch(IOException e)
			{
				System.err.println("orderForm.txt after being read could not be closed!");
				System.exit(1);
			}
		}
		return formattedString;
	}	
	//Writes the Order Form to the file
	public void writeOrderForm()
	{
		try
		{
			int k = 0;
			this.bw = new BufferedWriter(new FileWriter("orderForm.txt"));
			this.bw.write("JJCK Food Bank.......\n");
			this.bw.write("Hamper Order Form\n\n");
			this.bw.write("Name: \n");
			this.bw.write("Date: \n\n");
			this.bw.write("Original Request: \n");
			//Writes to the file, all client types involved in each Hamper.
			for(int i = 0; i < this.REPORT.getHamperCount(); i++)
			{
				this.bw.write("Hamper " + (i + 1) + ": ");
				while(k < 4)
				{
					if(this.REPORT.getHamperArray().get(i).getNumOfClientsAt(k) != 0)
					{
						this.bw.write(this.REPORT.getHamperArray().get(i).getNumOfClientsAt(k) + ", ");
					}
					k++;
				}
				this.bw.write("\n");
			}
			//Writes all items in the Hamper.
			for(int i = 0; i < this.REPORT.getHamperCount(); i++)
			{
				this.bw.write("Hamper " + (i + 1) + " Items:\n");
				this.bw.write(this.REPORT.get(i) + "\n");
			}
		}
		catch(IOException e)
		{
			System.err.println("orderForm.txt could not be written to!");
			System.exit(1);
		}
		//Attempt to close the output file.
		finally
		{
			try
			{
				this.bw.close();
			}
			catch(IOException e)
			{
				System.err.println("orderForm.txt could not be closed!");
				System.exit(1);
			}
		}
	}
}*/