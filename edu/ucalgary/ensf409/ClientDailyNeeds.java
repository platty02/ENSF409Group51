/**
author Kolby Lalonde, James Platt, Carlos Morera Pinilla, Jacob Adeyemo
version: 1.4
since: 1.0
*/

package edu.ucalgary.ensf409;

public class ClientDailyNeeds
{
	//Private fields:
	private final int WHOLEGRAINS;
	private final int FRUITVEGGIES;
	private final int PROTEIN;
	private final int OTHER;
	private final int CALORIES;
	
	//Constructor: Takes in a number of different calorie values as arguments, and creates a profile for that client type,
	//storing the calories associated with the client type
	public ClientDailyNeeds(int grain, int fruitVeg, int protein, int other, int calories) throws IllegalArgumentException
	{
		if(grain < 0 || fruitVeg < 0 || protein < 0 || other < 0 || calories < 0)
		{
			throw new IllegalArgumentException("ClientDailyNeeds Constructor recieved a negative value for one of it's arguments!");
		}
		this.WHOLEGRAINS = grain;
		this.FRUITVEGGIES = fruitVeg;
		this.PROTEIN = protein;
		this.OTHER = other;
		this.CALORIES = calories;
	}
	//Getters, they are all final fields.
	public int getWholeGrains()
	{
		return this.WHOLEGRAINS;
	}
	public int getFruitsVeggies()
	{
		return this.FRUITVEGGIES;
	}
	public int getProtein()
	{
		return this.PROTEIN;
	}
	public int getOther()
	{
		return this.OTHER;
	}
	public int getCalories()
	{
		return this.CALORIES;
	}
}	

