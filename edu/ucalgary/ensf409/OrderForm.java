/**
@author: Carlos Morera Pinilla and Jacob Adeyemo
@version: 1.4
@since: 1.0
*/


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
		try
		{
			this.br = new BufferedReader(new FileReader("orderForm.txt"));
			String s = new String();
			String formattedString = new String();
			while((s = br.readLine()) != null)
			{
				//Read each line
				formattedString += s;
			}
			return formattedString;
		}
		catch(IOException e)
		{
			System.err.println("orderForm.txt could not be read, it may not exist yet!");
			System.exit(1);
		}
		//Attempt to close the input file.
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
					if(Hamper.getNumOfClientsAt(k) != 0)
					{
						this.bw.write(Hamper.getNumOfClientsAt(k) + ", ");
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
}
