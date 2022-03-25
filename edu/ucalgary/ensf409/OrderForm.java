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
	public String getFormattedForm()
	{
		try
		{
			
		}
		catch(IOException e)
		{
			System.err.println("Writing to the OrderForm file failed in getFormattedForm()!");
			System.exit(1);
		}
	}
}