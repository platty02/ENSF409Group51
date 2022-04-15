//ENSF409 FINAL PROJECT GROUP 51
//@author Kolby Lalonde James Platt Carlos Morrea Jacob Adeyemo
//Item.java
//version: 1.2
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
    public Item(String name, String itemID, int grain, int fruitVeg, int protein, int other, int calories) throws IllegalArgumentException{
        //checks all input variables for validity. name and itemID should not be null,
        //all calorie values should be greater than or equal to 0.
        boolean valid = true;
        if(name == null|| itemID == null){
            valid = false;
        }
        else if(grain < 0 || fruitVeg < 0 || protein < 0 || other < 0 || calories < 0 ){
            valid = false;
        }
        //if the varialbles are valid, set the private variables.
        if(valid == true){
            this.itemID = new String(itemID);
            this.name = new String(name);
            this.grainContent = grain;
            this.fruitVegContent = fruitVeg;
            this.proteinContent = protein;
            this.other = other;
            this.calories = calories;
        }
        //else throw exception.
        else{
            throw new IllegalArgumentException();
        }
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
