/**
author Kolby Lalonde, James Platt, Carlos Morera Pinilla, Jacob Adeyemo
version: 1.3.1
since: 1.0
*/
package edu.ucalgary.ensf409;

public class ChildUnder8 extends ClientDailyNeeds
{
	//Private fields:
	private final int CLIENT_ID = 4;
	
	//Constructor:
	public ChildUnder8(String[][] dailyNeeds) throws Exception
	{
        super(Integer.parseInt(dailyNeeds[3][2]),
					Integer.parseInt(dailyNeeds[3][3]),
					Integer.parseInt(dailyNeeds[3][4]),
					Integer.parseInt(dailyNeeds[3][5]),
					Integer.parseInt(dailyNeeds[3][6]));
	}

}
