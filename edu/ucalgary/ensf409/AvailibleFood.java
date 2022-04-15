//ENSF409 FINAL PROJECT GROUP 51
//AvailableFood.java
//version: 1.4
//from: 1.0
package edu.ucalgary.ensf409;
import java.util.*;

//keeps an inventory of available items at the
//time that the data base is accessed.
public class AvailibleFood {
    private ArrayList<Item> foodInventory = null;
    /*
    AvailibleFood() - constructor that fills an arrayList with Item objects based
    on the given 2d array, dataTable.
    */
    public AvailibleFood(String[][] dataTable) throws IllegalArgumentException{
        boolean valid = true;
        String name = null;
        String itemID = null;
        int grain = 0;
        int fruit = 0;
        int protein = 0;
        int other = 0;
        int calories = 0;
        foodInventory = new ArrayList<Item>();
        //walk through the given data table, adding items
        //for each inidivdual String array.
        for(int i =0; i < dataTable.length;i++){
            if(dataTable[i] == null || dataTable[i][1] == null|| dataTable[i][0] == null){
                valid = false;
            }
            else{
                //grabs fields for this specific item, then appends an item
                //to the end of the list.
                name = dataTable[i][1];
                itemID = dataTable[i][0];
                grain = Integer.parseInt(dataTable[i][2]);
                fruit = Integer.parseInt(dataTable[i][3]);
                protein = Integer.parseInt(dataTable[i][4]);
                other = Integer.parseInt(dataTable[i][5]);
                calories = Integer.parseInt(dataTable[i][6]);
                //check if name, id and all other caloric values are valid.
           
                if(grain < 0 || fruit < 0 || protein < 0 || other < 0 || calories < 0 ){
                    valid = false;
                }
            
            }
            //if the values from the table are valid, then add a new item to the list. else,
            //throw error.
            if(valid == true)
                foodInventory.add(new Item(name,itemID,grain,fruit,protein,other,calories));
            else
                throw new IllegalArgumentException();
        }
    }

    //addItem() - add an item to the array list.
    public void addItem(Item food) throws IllegalArgumentException{
        if(food != null)    
            this.foodInventory.add(food);
        else 
            throw new IllegalArgumentException();
    }

    //remove() - remove an item from the array list and return it.
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
        if(toReturn == null)
            throw new IllegalArgumentException();
        return toReturn;
    }

    //returnList() - return the entire arrayList
    public ArrayList<Item> returnList(){
        return this.foodInventory;
    }
}
