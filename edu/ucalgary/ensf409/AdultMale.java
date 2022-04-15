/**
@author Kolby Lalonde, James Platt, Carlos Morera Pinilla, Jacob Adeyemo
version: 1.2.1
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
		super(Integer.parseInt(dailyNeeds[0][2]),
					Integer.parseInt(dailyNeeds[0][3]),
					Integer.parseInt(dailyNeeds[0][4]),
					Integer.parseInt(dailyNeeds[0][5]),
					Integer.parseInt(dailyNeeds[0][6]));
	}
}
