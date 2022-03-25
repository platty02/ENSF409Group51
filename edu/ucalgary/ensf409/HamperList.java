package edu.ucalgary.ensf409;
import java.util.*;

public class HamperList
{
	//Private Fields:
	private ArrayList<Hamper> hamperArray;
	private int numberOfHampers;
	
	//Constructor:
	public HamperList(int numberOfHampers)
	{
		this.hamperArray = new ArrayList<Hamper>();
		this.numberOfHampers = numberOfHampers;
	}
	public void setHamperCount(int numberOfHampers)
	{
		this.numberOfHampers = numberOfHampers
	}
	public int getHamperCount()
	{
		return this.numberOfHampers;
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