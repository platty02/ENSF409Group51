//ENSF409 FINAL PROJECT GROUP 51
//Item.java
//version: 1.0
//from: 1.0
package edu.ucalgary.ensf409;

//Item objects are used to store information
//about each food item in the data base.
public class Item {
    //class variables.
    private String itemID = null;
    private String name = null;
    private int grainContent = 0;
    private int fruitVegContent = 0;
    private int proteinContent = 0;
    private int other = 0;
    private int calories = 0;
    
    //constructor.
    //Constructor was changed to include itemID and name as variables,
    //this will need to be relflected in the uml. 2022-03-25
    public Item(int grain, int fruitVeg, int protein, int other, int calories, String itemID, String name){
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

    //grainContent setter
    public void setGrainContent(int grainContent){
        this.grainContent = grainContent;
    }

    //fruitVegContent setter
    public void setFruitVegContent(int fruitVegContent){
        this.fruitVegContent = fruitVegContent;
    }

    //protein content setter
    public void setProteinContent(int proteinContent){
        this.proteinContent = proteinContent;
    }

    //other setter
    public void setOther(int other){
        this.other = other;
    }

    //setter for calories.
    public void setCalories(int calories){
        this.calories = calories;
    }
}