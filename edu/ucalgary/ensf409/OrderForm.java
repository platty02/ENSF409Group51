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
		this.br = new BufferedReader(new FileReader(writeOrderForm()));
		
	}	
	//Writes the Order Form to the file
	public File writeOrderForm(String fileName)
	{
		try
		{
			this.bw = new BufferedWriter(new FileWriter(fileName + ".txt"));
			this.bw.write("JJCK Food Bank.......\n");
			this.bw.write("Hamper Order Form\n\n");
			this.bw.write("Name: \n");
			this.bw.write("Date: \n\n");
			this.bw.write("Original Request: \n");
			
			for(int i = 0; i < this.REPORT.length; i++)
			{
				this.bw.write(this.REPORT.get(i) + "\n");
			}
			
			return fileName + ".txt";
			
		}
		catch(IOException e)
		{
			System.err.println("Writing to the OrderForm file failed in getFormattedForm()!");
			System.exit(1);
		}
	}
}
