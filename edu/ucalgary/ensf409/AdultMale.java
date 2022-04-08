/**
author: Carlos Morera Pinilla and Jaboc Adeyemo
version: 1.1
since: 1.0
*/
package edu.ucalgary.ensf409;

public class AdultMale extends ClientDailyNeeds
{
	//Private fields:
	private final int CLIENT_ID = 1;
	
	//Constructor:
	public AdultMale(String[][] dailyNeeds) throws Exception
	{
		super(Integer.parseInt(dailyNeeds[CLIENTID - 1][1]),
				Integer.parseInt(dailyNeeds[CLIENTID - 1][2]),
				Integer.parseInt(dailyNeeds[CLIENTID - 1][3]),
				Integer.parseInt(dailyNeeds[CLIENTID - 1][4]),
				Integer.parseInt(dailyNeeds[CLIENTID - 1][5]));
		
	}
}
