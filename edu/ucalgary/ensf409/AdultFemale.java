/**
@author Kolby Lalonde, James Platt, Carlos Morera Pinilla, Jacob Adeyemo
version: 1.2.1
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
        
		super(Integer.parseInt(dailyNeeds[1][2]),
					Integer.parseInt(dailyNeeds[1][3]),
					Integer.parseInt(dailyNeeds[1][4]),
					Integer.parseInt(dailyNeeds[1][5]),
					Integer.parseInt(dailyNeeds[1][6]));
	}

}
