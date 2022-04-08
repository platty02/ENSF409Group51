/**
author: Carlos Morera Pinilla and Jaboc Adeyemo
version: 1.2
since: 1.0
*/
package edu.ucalgary.ensf409;

public class AdultFemale extends ClientDailyNeeds
{
	//Private fields:
	private final int CLIENT_ID = 2;
	
	//Constructor:
	public AdultFemale(String[][] dailyNeeds) throws Exception
	{ 
		super(Integer.parseInt(dailyNeeds[CLIENTID - 1][2]),
				Integer.parseInt(dailyNeeds[CLIENTID - 1][3]),
				Integer.parseInt(dailyNeeds[CLIENTID - 1][4]),
				Integer.parseInt(dailyNeeds[CLIENTID - 1][5]);
	}

}
