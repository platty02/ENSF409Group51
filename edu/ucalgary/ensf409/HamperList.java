/**
author: Carlos Morera Pinilla and James Platt
version: 1.6
since: 1.0
*/
package edu.ucalgary.ensf409;
import java.util.*;
import java.io.*;
/*
HamperList() - Used to hold hampers that are on a order, and do the required work surrounding
each order.
*/
public class HamperList
{
	//Private Fields:
	private ArrayList<Hamper> hamperArray;
	private String[] shortages = null;
	private int numOfShortage = -1;
	
	//Constructor creates the HamperList and resets the Hamper Count.
	public HamperList()
	{
		this.hamperArray = new ArrayList<Hamper>();
		this.numberOfHampers = 0;
	}
	
	//Retrieves the Hamper ArrayList and returns it.
	public ArrayList<Hamper> getHamperArray()
	{
		return this.hamperArray;
	}
	//retunrs the number of hampers currently stored in the HamperList.
	public int getHamperCount()
	{
		return this.hamperArray.size();
	}
	//Adds a given Hmaper to the HamperList.
	public void addToHamper(Hamper hamper)
	{
		this.hamperArray.add(hamper);
		
	}
	//Removes a given hamper from the Hmaperlist.
	public void takeFromHamper(Hamper hamper)
	{
		this.hamperArray.remove(hamper);
		
	}
	//Clears the Hamperlist so that it hase no items.
	public void clearHamperArray()
	{
		this.hamperArray.clear();
	}
	//Returns the array of Shortages.
	public String[] returnShortages(){
		return this.shortages;
	}
	//returns the hamper number for which the order can't be completed.
	public int returnNumShortages(){
		return this.numOfShortage;
	}
	/*
	calculateOrder() - calcualtes the optimal hampers for each hamper contained in the hamperList, inOrder.
	if at any point the optimal hamper cannot be caluclated for the current hamper, a UnavailableResourcesException
	will be thrown and the shortages will be stored in shortages, aswell as the hamper that caused the error in numOfShortage
	*/
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
				for(int k =0; k < this.shortages.length; k++){
					if(this.shortages[k] == null)
						this.shortages[k] = new String("0");
				}
				this.numOfShortage = i + 1;
				throw new UnavailableResourcesException(this.shortages);
			}
		}
		//now write to file using OrderForm.
		OrderForm writeOrder = new OrderForm(this.hamperArray);
		writeOrder.writeOrderForm();

	}

}
