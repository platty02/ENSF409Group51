
/**
@author Kolby Lalonde 
UCID: 30115568
@version 1.4 April, 11, 2022
@since 1.0 March, 25, 2022
**/

package edu.ucalgary.ensf409;

import java.util.*;
// Terminal Command //
// javac edu/ucalgary/ensf409/Hamper.java

// Hamper Class Description 
/*
The Hamper class is designed to .......
*/

// javac -cp .:lib/mysql-connector-java-8.0.23.jar edu/ucalgary/ensf409/GUI.java

// java -cp .:lib/mysql-connector-java-8.0.23.jar edu/ucalgary/ensf409/GUI

public class Hamper{

    private final int TOTAL_NET_CALORIES;
    private final int TOTAL_GRAIN_CALORIES;
    private final int TOTAL_FRUITVEGGIE_CALORIES;
    private final int TOTAL_PROTIEN_CALORIES;
    private final int TOTAL_OTHER_CALORIES;
    private final int[] CLIENTAMOUNTS;
    private Item[] items;
    private ArrayList<String[]> possibleCombos = new ArrayList<String[]>();
    private ArrayList<Integer> possibleCombosExtra = new ArrayList<Integer>();

    public Hamper(int[] clientAmount, AdultMale AdultMales, AdultFemale AdultFemales, ChildOver8 ChildO8, ChildUnder8 ChildU8){
        this.CLIENTAMOUNTS = clientAmount;
        // creating variables to hold the intermediate values for each category as each client type is called
        int net = 0;
        int grain = 0;
        int fruitVeggie = 0;
        int protein = 0;
        int other = 0;

        // Calling each client to get the total net calories across all clients
        net += AdultMales.getCalories() * clientAmount[0];
        net += AdultFemales.getCalories() * clientAmount[1];
        net += ChildO8.getCalories() * clientAmount[2];
        net += ChildU8.getCalories() * clientAmount[3];

        // Setting the total net calories for the hamper
        this.TOTAL_NET_CALORIES = net * 7;

        // Calling each client to get the total grain calories across all clients
        grain += AdultMales.getCalories() * ((double)AdultMales.getWholeGrains() / 100) * clientAmount[0];
        grain += AdultFemales.getCalories() * ((double)AdultFemales.getWholeGrains() / 100) * clientAmount[1];
        grain += ChildO8.getCalories() * ((double)ChildO8.getWholeGrains() / 100) * clientAmount[2];
        grain += ChildU8.getCalories() * ((double)ChildU8.getWholeGrains() / 100) * clientAmount[3];

        // Setting the total grain calories for the hamper
        this.TOTAL_GRAIN_CALORIES = grain * 7;

        // Calling each client to get the total fruit veggie calories across all clients
        fruitVeggie += AdultMales.getCalories() * ((double)AdultMales.getFruitsVeggies() / 100) * clientAmount[0];
        fruitVeggie += AdultFemales.getCalories() * ((double)AdultFemales.getFruitsVeggies() / 100) * clientAmount[1];
        fruitVeggie += ChildO8.getCalories() * ((double)ChildO8.getFruitsVeggies() / 100) * clientAmount[2];
        fruitVeggie += ChildU8.getCalories() * ((double)ChildU8.getFruitsVeggies() / 100) * clientAmount[3];

        // Setting the total fruit veggie calories for the hamper
        this.TOTAL_FRUITVEGGIE_CALORIES = fruitVeggie * 7;

        // Calling each client to get the total protein calories across all clients
        protein += AdultMales.getCalories() * ((double)AdultMales.getProtein() / 100) * clientAmount[0];
        protein += AdultFemales.getCalories() * ((double)AdultFemales.getProtein() / 100) * clientAmount[1];
        protein += ChildO8.getCalories() * ((double)ChildO8.getProtein() / 100) * clientAmount[2];
        protein += ChildU8.getCalories() * ((double)ChildU8.getProtein() / 100) * clientAmount[3];

        // Setting the total protein calories for the hamper
        this.TOTAL_PROTIEN_CALORIES = protein * 7;

        // Calling each client to get the total other calories across all clients
        other += AdultMales.getCalories() * ((double)AdultMales.getOther() / 100) * clientAmount[0];
        other += AdultFemales.getCalories() * ((double)AdultFemales.getOther() / 100) * clientAmount[1];
        other += ChildO8.getCalories() * ((double)ChildO8.getOther() / 100) * clientAmount[2];
        other += ChildU8.getCalories() * ((double)ChildU8.getOther() / 100) * clientAmount[3];

        // Setting the total other calories for the hamper
        this.TOTAL_OTHER_CALORIES = other * 7;
    }

    public String[] calculateOptimalHamper(AvailibleFood avaliableFoods) throws UnavailableResourcesException{

        ArrayList <Item> foodOptions = avaliableFoods.returnList();

        int amount = foodOptions.size();

        String[] data = new String[amount];

        for (int num = 0; num <= amount; num++){  
            combinations(avaliableFoods, data, 0, amount - 1, 0, num);
        }
        
        String[] myOptimalHamper = returnOptimalHamper(avaliableFoods);

        if (myOptimalHamper[0].equals("SHORT")){
            throw new UnavailableResourcesException(myOptimalHamper);
        }
        
        return myOptimalHamper;
    }

    public void combinations(AvailibleFood avaliableFoods, String[] data, int start, int end, int index, int num) {

        ArrayList <Item> inventory = avaliableFoods.returnList();

        int counter = 0;
        if (index == num && num != 0) {
            int totalGrain = 0;
            int totalFV = 0;
            int totalProtein = 0;
            int totalOther = 0;
            int totalCalories = 0;
            for(int j = 0; j < num; j++){
                int x = 0;
                while(!inventory.get(x).getID().equals(data[j])){
                    x++;
                }
                totalGrain += ((double)inventory.get(x).getGrainContent() / 100) * inventory.get(x).getCalories();
                totalFV += ((double)inventory.get(x).getFruitContent() / 100) * inventory.get(x).getCalories();
                totalProtein += ((double)inventory.get(x).getProteinContent() / 100) * inventory.get(x).getCalories();
                totalOther += ((double)inventory.get(x).getOtherContent() / 100) * inventory.get(x).getCalories();
                totalCalories += inventory.get(x).getCalories();

            }
            checkValid(data, num, totalGrain, totalFV, totalProtein, totalOther, totalCalories);
        }
 
        for (int i = start; i <= end && ((end - i + 1) >= (num - index)); i++) {
            data[index] = inventory.get(i).getID();
            combinations(avaliableFoods, data, i + 1, end, index + 1, num);
        }   
    }

    public void checkValid(String[] data, int num, int grain, int fruitVeggies, int protein, int other, int calories){

        if(grain >= this.TOTAL_GRAIN_CALORIES && fruitVeggies >= this.TOTAL_FRUITVEGGIE_CALORIES){
            if(protein>= this.TOTAL_PROTIEN_CALORIES && other >= this.TOTAL_OTHER_CALORIES){
                if(calories >= this.TOTAL_NET_CALORIES){
                    String [] combo = new String[num];
                    for (int j = 0; j < num; j++){
                        combo[j] = data[j];
                    }
                    int extra = (grain - this.TOTAL_GRAIN_CALORIES );
                    extra += (fruitVeggies - this.TOTAL_FRUITVEGGIE_CALORIES);
                    extra += (protein - this.TOTAL_PROTIEN_CALORIES );
                    extra += (other - this.TOTAL_OTHER_CALORIES);
                    extra += (calories - this.TOTAL_NET_CALORIES);
                    this.possibleCombos.add(combo);
                    this.possibleCombosExtra.add(extra);
        
                }
            }
        }
    }

    public String[] returnOptimalHamper(AvailibleFood avaliableFoods){

        if(this.possibleCombosExtra.size() == 0){
            String[] shortageReport = new String[6];
            shortageReport = calculateShortage(avaliableFoods);
            return shortageReport;
        }
        
        int minAccess = this.possibleCombosExtra.get(0);
        int index = 0;
        for(int i = 0; i < this.possibleCombosExtra.size(); i++){
            if(minAccess > this.possibleCombosExtra.get(i)){
                minAccess = this.possibleCombosExtra.get(i);
                index = i;
            }
        }

        return this.possibleCombos.get(index);
    }


    public String[] calculateShortage(AvailibleFood avaliableFoods){

        String[] shortageReport = new String[6];
        ArrayList <Item> inventory = avaliableFoods.returnList();

        int totalGrain = 0;
        int totalFV = 0;
        int totalProtein = 0;
        int totalOther = 0;
        int totalCalories = 0;

        for(int i = 0; i < inventory.size(); i++){
            totalGrain += ((double)inventory.get(i).getGrainContent() / 100) * inventory.get(i).getCalories();
            totalFV += ((double)inventory.get(i).getFruitContent() / 100) * inventory.get(i).getCalories();
            totalProtein += ((double)inventory.get(i).getProteinContent() / 100) * inventory.get(i).getCalories();
            totalOther += ((double)inventory.get(i).getOtherContent() / 100) * inventory.get(i).getCalories();
            totalCalories += inventory.get(i).getCalories();
        }

        if(totalGrain < this.TOTAL_GRAIN_CALORIES){
            shortageReport[1] = String.valueOf(this.TOTAL_GRAIN_CALORIES - totalGrain);
        }
        if(totalFV < this.TOTAL_FRUITVEGGIE_CALORIES){
            shortageReport[2] = String.valueOf(this.TOTAL_FRUITVEGGIE_CALORIES - totalFV);
        }
        if(totalProtein < this.TOTAL_PROTIEN_CALORIES){
            shortageReport[3] = String.valueOf(this.TOTAL_PROTIEN_CALORIES - totalProtein);
        }
        if(totalOther < this.TOTAL_OTHER_CALORIES){
            shortageReport[4] = String.valueOf(this.TOTAL_OTHER_CALORIES - totalOther);
        }
        if(totalCalories < this.TOTAL_NET_CALORIES){
            shortageReport[5] = String.valueOf(this.TOTAL_NET_CALORIES - totalCalories);
        }
        shortageReport[0] = "SHORT";

        return shortageReport;
    }

    //setter for items
    public void setItems(Item[] items){
        this.items = items;
    }

    //getter for items.
    public Item[] getItems(){
        return this.items;
    }

    //getter for clientAmounts.
    public int[] getCientAmounts(){
        return this.CLIENTAMOUNTS;
    }

    public int getNumOfClientsAt(int index)
    {
        return this.CLIENTAMOUNTS[index];
    }
    /*
    public String getNumOfClientsAt(int index)
    {
        if(index == 0)
        {
            return this.CLIENTAMOUNTS[index] + " Adult Male";
        }
        else if(index == 1)
        {
            return this.CLIENTAMOUNTS[index] + " Adult Female";
        }
        else if(index == 2)
        {
            return this.CLIENTAMOUNTS[index] + " Child over 8";
        }
        else if(index == 3)
        {
            return this.CLIENTAMOUNTS[index] + " Child under 8";
        }
        else{ return ""; }
    }*/
}
