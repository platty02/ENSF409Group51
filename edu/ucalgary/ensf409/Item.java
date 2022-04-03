//ENSF409 FINAL PROJECT GROUP 51
//Item.java
//version: 1.1
//from: 1.0 

package edu.ucalgary.ensf409;

//Item objects are used to store information
//about each food item in the data base.
public class Item {
    //class variables.
    private final String itemID;
    private final String name;
    private final int grainContent;
    private final int fruitVegContent;
    private final int proteinContent;
    private final int other;
    private final int calories;
    
    //constructor.
    //Constructor was changed to include itemID and name as variables,
    //this will need to be relflected in the uml. 2022-03-25
    public Item(String name, String itemID, int grain, int fruitVeg, int protein, int other, int calories){
        //set private variables.
        this.itemID = new String(itemID);
        this.name = new String(name);
        this.grainContent = grain;
        this.fruitVegContent = fruitVeg;
        this.proteinContent = protein;
        this.other = other;
        this.calories = calories;
    }

    //grain content getter
    public int getGrainContent(){
        return this.grainContent;
    }

    //fruit content getter
    public int getFruitContent(){
        return this.fruitVegContent;
    }

    //proteinContent getter
    public int getProteinContent(){
        return this.proteinContent;
    }
    
    //otherContent getter
    public int getOther(){
        return this.other;
    }

    //totalCalories getter
    public int getCalories(){
        return this.calories;
    }
    //itemID getter.
    public String getID(){
        return this.itemID;
    }
    //Item name getter.
    public String getName(){
        return this.name;
    }
}
