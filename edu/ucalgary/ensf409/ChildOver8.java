/**
author Kolby Lalonde James Platt Carlos Morrea Jacob Adeyemo
version: 1.3
since: 1.0
*/
package edu.ucalgary.ensf409;

public class ChildOver8 extends ClientDailyNeeds
{
	//Private fields:
	private final int CLIENT_ID = 3;
	
	//Constructor:
	public ChildOver8(String[][] dailyNeeds) throws Exception
	{
		super(Integer.parseInt(dailyNeeds[2][2]),
					Integer.parseInt(dailyNeeds[2][3]),
					Integer.parseInt(dailyNeeds[2][4]),
					Integer.parseInt(dailyNeeds[2][5]),
					Integer.parseInt(dailyNeeds[2][6]));
	}
}
