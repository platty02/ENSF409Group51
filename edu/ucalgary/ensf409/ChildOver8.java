/**
author: Carlos Morera Pinilla and Jaboc Adeyemo
version: 1.1
since: 1.0
*/
package edu.ucalgary.ensf409;

public class ChildOver8 extends ClientDailyNeeds
{
	//Private fields:
	private final int CLIENT_ID = 4;
	
	//Constructor:
	public ChildOver8(String[][] dailyNeeds) throws Exception
	{
		if (dailyNeeds == null) {
			throw new NullPointerException();
		}

		else {
			for (int i = 0; i < dailyNeeds.length; i++) {
				FoodContent(Integer.parseInt(dailyNeeds[CLIENTID - 1][1]),
						Integer.parseInt(dailyNeeds[CLIENTID - 1][2]),
						Integer.parseInt(dailyNeeds[CLIENTID - 1][3]),
						Integer.parseInt(dailyNeeds[CLIENTID - 1][4]),
						Integer.parseInt(dailyNeeds[CLIENTID - 1][5]));
			}
		}
	}
}
