/**
author: Carlos Morera Pinilla
version: 1.3
since: 1.0
*/
package edu.ucalgary.ensf409;
import java.util.*;

public class HamperList
{
	//Private Fields:
	private ArrayList<Hamper> hamperArray;
	private int numberOfHampers;
	
	//Constructor creates the HamperList and resets the Hamper Count.
	public HamperList()
	{
		this.hamperArray = new ArrayList<Hamper>();
		this.numberOfHampers = 0;
	}
	public void setHamperCount(int numberOfHampers)
	{
		this.numberOfHampers = numberOfHampers;
	}
	public int getHamperCount()
	{
		return this.hamperArray.size();
	}
	public void addToHamper(Hamper hamper)
	{
		this.hamperArray.add(hamper);
	}
	public void takeFromHamper(Hamper hamper)
	{
		this.hamperArray.remove(hamper);
	}
}
