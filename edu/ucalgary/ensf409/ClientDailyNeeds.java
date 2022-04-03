/**
author: Carlos Morera Pinilla
version: 1.2
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
	
	//Constructor:
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
	public void getWholeGrains()
	{
		return this.WHOLEGRAINS;
	}
	public void getFruitVeggies()
	{
		return this.WHOLEGRAINS;
	}
	public void getProtein()
	{
		return this.PROTEIN;
	}
	public void getOther()
	{
		return this.OTHER;
	}
	public void getCalories()
	{
		return this.CALORIES;
	}
}	

