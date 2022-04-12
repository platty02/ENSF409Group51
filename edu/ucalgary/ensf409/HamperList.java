/**
author: Carlos Morera Pinilla and James Platt
version: 1.4
since: 1.0
*/
package edu.ucalgary.ensf409;
import java.util.*;
import java.io.*;

public class HamperList
{
	//Private Fields:
	private ArrayList<Hamper> hamperArray;
	private int numberOfHampers;
	private String[] shortages = null;
	private int numOfShortage = -1;
	
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
	//Retrieves the Hamper ArrayList.
	public ArrayList<Hamper> getHamperArray()
	{
		return this.hamperArray;
	}
	
	public int getHamperCount()
	{
		return this.hamperArray.size();
	}
	public void addToHamper(Hamper hamper)
	{
		this.hamperArray.add(hamper);
		this.numberOfHampers++;
	}
	public void takeFromHamper(Hamper hamper)
	{
		this.hamperArray.remove(hamper);
		this.numberOfHampers--;
	}
	public void clearHamperArray()
	{
		this.hamperArray.clear();
	}
	public String[] returnShortages(){
		return this.shortages;
	}
	public int returnNumShortages(){
		return this.numOfShortage;
	}
	//public Class to calculate the optimal setup of food items.
	public void calculateOrder(AvailibleFood availibleFood)throws UnavailableResourcesException{
		for(int i =0; i < this.hamperArray.size(); i++){
			//get the optimal hamper in string format
			String[] foodInStrings = hamperArray.get(i).calculateOptimalHamper(availibleFood);
			//if a optimal hamper exists, store it as a ItemArray in the Hamper.
			if(foodInStrings != null && !foodInStrings[0].equals("SHORT")){	
				Item[] foodInItems = new Item[foodInStrings.length];
			
				for(int j =0; j < foodInItems.length; j++){
					foodInItems[j] = availibleFood.remove(foodInStrings[j]);
				}
				hamperArray.get(i).setItems(foodInItems);
			}
			//else no optimal hamper can be made, so insuffcient resources.
			else{
				this.shortages = foodInStrings;
				this.numOfShortage = i + 1;
				throw new UnavailableResourcesException(this.shortages);
			}
		}
		//now write to file using OrderForm.
		OrderForm writeOrder = new OrderForm(this.hamperArray);
		writeOrder.writeOrderForm();

	}

}
