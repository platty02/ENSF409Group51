
/**
@author Kolby Lalonde 
UCID: 30115568
@version 1.5.1 April, 12, 2022
@since 1.0 March, 25, 2022
**/

package edu.ucalgary.ensf409;

import java.util.*;
import java.lang.Math;

// Terminal Command //
// javac edu/ucalgary/ensf409/Hamper.java

// Hamper Class Description 
/*
The Hamper class is designed to .......
*/

// javac -cp .:lib/mysql-connector-java-8.0.23.jar edu/ucalgary/ensf409/GUI.java

// java -cp .:lib/mysql-connector-java-8.0.23.jar edu/ucalgary/ensf409/GUI

public class Hamper{

    // Hamper member variables
    private final double TOTAL_NET_CALORIES;
    private final double TOTAL_GRAIN_CALORIES;
    private final double TOTAL_FRUITVEGGIE_CALORIES;
    private final double TOTAL_PROTIEN_CALORIES;
    private final double TOTAL_OTHER_CALORIES;
    private final int[] CLIENTAMOUNTS;
    private Item[] items;
    private ArrayList<String[]> possibleCombos = new ArrayList<String[]>();
    private ArrayList<Double> possibleCombosExtra = new ArrayList<Double>();

    // Constructor
    public Hamper(int[] clientAmount, AdultMale AdultMales, AdultFemale AdultFemales, ChildOver8 ChildO8, ChildUnder8 ChildU8){
        
        // Setting client amount array
        this.CLIENTAMOUNTS = clientAmount;
        
        // creating variables to hold the intermediate values for each category as each client type is called
        double net = 0;
        double grain = 0;
        double fruitVeggie = 0;
        double protein = 0;
        double other = 0;

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

    // Method to return the optimal hamper combination from the available food items
    public String[] calculateOptimalHamper(AvailibleFood availableFoods){

        // Extracting the list of available foods
        ArrayList <Item> foodOptions = availableFoods.returnList();

        // Extracting the total number of foods
        int amount = foodOptions.size();

        // Creating an empty string array the size of amount
        String[] data = new String[amount];

        // Interate through the combinations helper method to call all different number of possible hampers
        for (int num = 0; num <= amount; num++){  
            combinations(availableFoods, data, 0, amount - 1, 0, num);
        }
        
        // Calling helper method to return the string array containing item id's in the optimal hamper
        String[] myOptimalHamper = returnOptimalHamper(availableFoods);

        // Check if the requirements for each category were satisfied
        //if (myOptimalHamper[0].equals("SHORT")){
            //throw new UnavailableResourcesException(myOptimalHamper);   // Throw the unavailable resource exception
        //}
        
        return myOptimalHamper;
    }

    // Helper Method to check all combinations of a certain amount of items in a hamper
    public void combinations(AvailibleFood avaliableFoods, String[] data, int start, int end, int index, int num) {

        // Extracting the list of available foods
        ArrayList <Item> inventory = avaliableFoods.returnList();

        // Check if num equals index
        int counter = 0;
        if (index == num && num != 0) {
            
            // Intermediate category tracker variables
            double totalGrain = 0;
            double totalFV = 0;
            double totalProtein = 0;
            double totalOther = 0;
            double totalCalories = 0;

            // Loop through all items in this specific combination
            for(int j = 0; j < num; j++){
                int x = 0;
                while(!inventory.get(x).getID().equals(data[j])){    // loop to find specific item in combination
                    x++;
                }
                totalGrain += ((double)inventory.get(x).getGrainContent() / 100) * inventory.get(x).getCalories();
                totalFV += ((double)inventory.get(x).getFruitContent() / 100) * inventory.get(x).getCalories();
                totalProtein += ((double)inventory.get(x).getProteinContent() / 100) * inventory.get(x).getCalories();
                totalOther += ((double)inventory.get(x).getOtherContent() / 100) * inventory.get(x).getCalories();
                totalCalories += inventory.get(x).getCalories();

            }

            // Call helper method to see if this combination is valid and meets all requiremnts
            checkValid(data, num, totalGrain, totalFV, totalProtein, totalOther, totalCalories);
        }
 
        // loop through all the possible combinations of this number (variable "num") of
        for (int i = start; i <= end && ((end - i + 1) >= (num - index)); i++) {
            data[index] = inventory.get(i).getID();                         // Add item id to the data string array
            combinations(avaliableFoods, data, i + 1, end, index + 1, num); // Recursive call to combination
        }   
    }

    // Helper method to check if the combination is valid and meets all requirements while also tracking the extra
    public void checkValid(String[] data, int num, double grain, double fruitVeggies, double protein, double other, double calories){

        if(grain >= this.TOTAL_GRAIN_CALORIES && fruitVeggies >= this.TOTAL_FRUITVEGGIE_CALORIES){  // Check if grain and fruit/veg requirements meet
            if(protein>= this.TOTAL_PROTIEN_CALORIES && other >= this.TOTAL_OTHER_CALORIES){        // Check if protein and other requirements meet
                if(calories >= this.TOTAL_NET_CALORIES){                                            // Check if net calorie requirements meet
                    String [] combo = new String[num];
                    for (int j = 0; j < num; j++){       // Creating the id combo string array
                        combo[j] = data[j];
                    }
                    double extra = (grain - this.TOTAL_GRAIN_CALORIES );              // Calculating grain extra calories
                    extra += (fruitVeggies - this.TOTAL_FRUITVEGGIE_CALORIES);     // Calculating fruit and veggies extra calories
                    extra += (protein - this.TOTAL_PROTIEN_CALORIES );             // Calculating protien extra calories
                    extra += (other - this.TOTAL_OTHER_CALORIES);                  // Calculating other extra calories
                    this.possibleCombos.add(combo);                         // Recording that combination of items is possible
                    this.possibleCombosExtra.add(extra);                    // Recording the total extra the total extra of the combination
        
                }
            }
        }
    }

    // Helper methopd to find a singular optimal hamper
    public String[] returnOptimalHamper(AvailibleFood avaliableFoods){

        // If no possible combinations have been found
        if(this.possibleCombosExtra.size() == 0){
            String[] shortageReport = new String[6];
            shortageReport = calculateShortage(avaliableFoods);  // call calculate shortage helper method
            return shortageReport;
        }
        
        double minAccess = this.possibleCombosExtra.get(0);
        int index = 0;

        // Loop through all the possible combinations a save the combination with the least amount extra
        for(int i = 0; i < this.possibleCombosExtra.size(); i++){
            if(minAccess > this.possibleCombosExtra.get(i)){
                minAccess = this.possibleCombosExtra.get(i);
                index = i;
            }
        }

        return this.possibleCombos.get(index); 
    }

    // Helper method to calculate the shortage of the food in the database to satisfy the order
    public String[] calculateShortage(AvailibleFood avaliableFoods){

        String[] shortageReport = new String[6];
        ArrayList <Item> inventory = avaliableFoods.returnList();

        // Intermediate category tracker variables
        double totalGrain = 0;
        double totalFV = 0;
        double totalProtein = 0;
        double totalOther = 0;
        double totalCalories = 0;

        // Loop through the entire database inventory
        for(int i = 0; i < inventory.size(); i++){
            totalGrain += ((double)inventory.get(i).getGrainContent() / 100) * inventory.get(i).getCalories();
            totalFV += ((double)inventory.get(i).getFruitContent() / 100) * inventory.get(i).getCalories();
            totalProtein += ((double)inventory.get(i).getProteinContent() / 100) * inventory.get(i).getCalories();
            totalOther += ((double)inventory.get(i).getOtherContent() / 100) * inventory.get(i).getCalories();
            totalCalories += inventory.get(i).getCalories();
        }

        // Check if the requirements were meet or not in each category and save the shortage values
        if(totalGrain < this.TOTAL_GRAIN_CALORIES){
            shortageReport[1] = String.valueOf((int)Math.ceil(this.TOTAL_GRAIN_CALORIES - totalGrain));
        }
        if(totalFV < this.TOTAL_FRUITVEGGIE_CALORIES){
            shortageReport[2] = String.valueOf((int)Math.ceil(this.TOTAL_FRUITVEGGIE_CALORIES - totalFV));
        }
        if(totalProtein < this.TOTAL_PROTIEN_CALORIES){
            shortageReport[3] = String.valueOf((int)Math.ceil(this.TOTAL_PROTIEN_CALORIES - totalProtein));
        }
        if(totalOther < this.TOTAL_OTHER_CALORIES){
            shortageReport[4] = String.valueOf((int)Math.ceil(this.TOTAL_OTHER_CALORIES - totalOther));
        }
        if(totalCalories < this.TOTAL_NET_CALORIES){
            shortageReport[5] = String.valueOf((int)Math.ceil(this.TOTAL_NET_CALORIES - totalCalories));
        }
        shortageReport[0] = "SHORT";    // Keyword in first index to indicate there is a shortage

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

    //getter for a certian client amount
    public int getNumOfClientsAt(int index)
    {
        return this.CLIENTAMOUNTS[index];
    }
}
