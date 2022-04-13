/**
author: Carlos Morera Pinilla and Jacob Adeyemo
version: 1.2
since: 1.0
*/
package edu.ucalgary.ensf409;

public class ChildUnder8 extends ClientDailyNeeds
{
	//Private fields:
	private final int CLIENT_ID = 3;
	
	//Constructor:
	public ChildUnder8(String[][] dailyNeeds) throws Exception
	{
        super(Integer.parseInt(dailyNeeds[2][2]),
					Integer.parseInt(dailyNeeds[2][3]),
					Integer.parseInt(dailyNeeds[2][4]),
					Integer.parseInt(dailyNeeds[2][5]),
					Integer.parseInt(dailyNeeds[2][6]));
	}

}
