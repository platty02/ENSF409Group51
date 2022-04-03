//ENSF409 FINAL PROJECT GROUP 51
//AvailableFood.java
//version: 1.0
//from: 1.0
package edu.ucalgary.ensf409;
import java.util.*;

//keeps an inventory of available items at the
//time that the data base is accessed.
public class AvailibleFood {
    private ArrayList<Item> foodInventory = null;
    //constructor.
    public AvailibleFood(String[][] dataTable){
        foodInventory = new ArrayList<Item>();
        //walk through the given data table, adding items
        //for each inidivdual String array.
        for(int i =0; i < dataTable.length;i++){
            //grabs fields for this specific item, then appends an item
            //to the end of the list.
            String name = dataTable[i][0];
            String itemID = dataTable[i][1];
            int grain = Integer.parseInt(dataTable[i][2]);
            int fruit = Integer.parseInt(dataTable[i][3]);
            int protein = Integer.parseInt(dataTable[i][4]);
            int other = Integer.parseInt(dataTable[i][5]);
            int calories = Integer.parseInt(dataTable[i][6]);
            foodInventory.add(new Item(name,itemID,grain,fruit,protein,other,calories));
        }
    }

    //add an item to the array list.
    public void addItem(Item food){
        this.foodInventory.add(food);
    }

    //remove an item from the array list and return it.
    public Item remove(String itemID){
        //walk through the list until we find the element, then remove
        //and return it.
        Item toReturn = null;
        for(int i =0; i < foodInventory.size(); i++){
            Item temp = foodInventory.get(i);
            if(temp.getID().compareTo(itemID) == 0){
                toReturn = temp;
                foodInventory.remove(i);
                break;
            }
        }
        return toReturn;
    }

    //return the entire arrayList
    public ArrayList<Item> returnList(){
        return this.foodInventory;
    }
}
