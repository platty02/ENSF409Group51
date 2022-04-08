
/**
@author Kolby Lalonde 
UCID: 30115568
@version 1.2 April, 8, 2022
@since 1.0 March, 25, 2022
**/

package edu.ucalgary.ensf409;

// Terminal Command //
// javac edu/ucalgary/ensf409/Hamper.java

// Hamper Class Description 
/*
The Hamper class is designed to .......
*/

public class Hamper{

    private final int TOTAL_NET_CALORIES;
    private final int TOTAL_GRAIN_CALORIES;
    private final int TOTAL_FRUITVEGGIE_CALORIES;
    private final int TOTAL_PROTIEN_CALORIES;
    private final int TOTAL_OTHER_CALORIES;
    private ArrayList<String[]> possibleCombos = new ArrayList<String[]>();
    private ArrayList<Integer> possibleCombosAccess = new ArrayList<Integer>();

    public void Hamper(int[] clientAmount, AdultMale AdultMales, AdultFemale AdultFemales, ChildOver8 ChildO8, ChildUnder8 ChildU8){

        // creating variables to hold the intermediate values for each category as each client type is called
        int net = 0;
        int grain = 0;
        int fruitVeggie = 0;
        int protien = 0;
        int other = 0;

        // Calling each client to get the total net calories across all clients
        net += AdultMales.getCalories() * clientAmount[0];
        net += AdultFemales.getCalories() * clientAmount[1];
        net += ChildO8.getCalories() * clientAmount[2];
        net += ChildU8.getCalories() * clientAmount[3];

        // Setting the total net calories for the hamper
        this.TOTAL_NET_CALORIES = net;

        // Calling each client to get the total grain calories across all clients
        grain += AdultMales.getCalories() * (AdultMales.getWholeGrains() / 100) * clientAmount[0];
        grain += AdultFemales.getCalories() * (AdultFemales.getWholeGrains() / 100) * clientAmount[1];
        grain += ChildO8.getCalories() * (ChildO8.getWholeGrains() / 100) * clientAmount[2];
        grain += ChildU8.getCalories() * (ChildU8.getWholeGrains() / 100) * clientAmount[3];

        // Setting the total grain calories for the hamper
        this.TOTAL_GRAIN_CALORIES = grain;

        // Calling each client to get the total fruit veggie calories across all clients
        fruitVeggie += AdultMales.getCalories() * (AdultMales.getFruitsVeggies() / 100) * clientAmount[0];
        fruitVeggie += AdultFemales.getCalories() * (AdultFemales.getFruitsVeggies() / 100) * clientAmount[1];
        fruitVeggie += ChildO8.getCalories() * (ChildO8.getFruitsVeggies() / 100) * clientAmount[2];
        fruitVeggie += ChildU8.getCalories() * (ChildU8.getFruitsVeggies() / 100) * clientAmount[3];

        // Setting the total fruit veggie calories for the hamper
        this.TOTAL_FRUITVEGGIE_CALORIES = fruitVeggie;

        // Calling each client to get the total protein calories across all clients
        protein += AdultMales.getCalories() * (AdultMales.getProtein() / 100) * clientAmount[0];
        protein += AdultFemales.getCalories() * (AdultFemales.getProtein() / 100) * clientAmount[1];
        protein += (ChildO8.getProtein() / 100) * clientAmount[2];
        protein += (ChildU8.getProtein() / 100) * clientAmount[3];

        // Setting the total protein calories for the hamper
        this.TOTAL_PROTIEN_CALORIES = protein;

        // Calling each client to get the total other calories across all clients
        other += AdultMales.getCalories() * (AdultMales.getOther() / 100) * clientAmount[0];
        other += AdultFemales.getCalories() * (AdultFemales.getOther() / 100) * clientAmount[1];
        other += ChildO8.getCalories() * (ChildO8.getOther() / 100) * clientAmount[2];
        other += ChildU8.getCalories() * (ChildU8.getOther() / 100) * clientAmount[3];

        // Setting the total other calories for the hamper
        this.TOTAL_OTHER_CALORIES = other;
    }

    public String[] calculateOptimalHamper(AvaliableFood avaliableFoods){

        ArrayList <Item> foodOptions = avaliableFoods.returnList();

        int amount = foodOptions.size();

        Item[] data = new Item[amount];

        for (int num = 0; num <= amount; num++){  
            combinations(avaliableFoods, data, 0, amount - 1, 0, num);
        }

        String[] myOptimalHamper = returnOptimalHamper();

        return myOptimalHAmper;

    }

    public void combinations(AvaliableFood avaliableFoods, Item[] data, int start, int end, int index, int num) {

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
                while(inventory.get(i).getID() != data[x]){
                    x++;
                }
                totalGrain += inventory.get(x).getGrainContent();
                totalFV += inventory.get(x).getFruitContent();
                totalProtein += inventory.get(x).getProteinContent();
                totalOther += inventory.get(x).getOtherContent();
                totalCalories += inventory.get(x).getCalories();
            }
            checkValid(data, totalGrain, totalFV, totalProtein, totalOther, totalCalories);
        }
 
        for (int i = start; i <= end && ((end - i + 1) >= (num - index)); i++) {
            data[index] = inventory.get(i).getID();
            combinations(avaliableFoods, data, i + 1, end, index + 1, num);
        }   
    }

    public void checkValid(String[] data, int grain, int fruitVeggies, int protien, int other, int calories){

        if(grain >= this.TOTAL_GRAIN_CALORIES && grain < (2 * this.TOTAL_GRAIN_CALORIES)){
            if(fruitVeggies >= this.TOTAL_FRUITVEGGIE_CALORIES && fruitVeggies < (2 * this.TOTAL_FRUITVEGGIE_CALORIES)){
                if(protien >= this.TOTAL_PROTIEN_CALORIES && protien < (2 * this.TOTAL_PROTIEN_CALORIES)){
                    if(other >= this.TOTAL_OTHER_CALORIES && other < (2 * this.TOTAL_OTHER_CALORIES)){
                        if(calories >= this.TOTAL_NET_CALORIES && calories < (2 * this.TOTAL_NET_CALORIES)){
                            int access = (grain - this.TOTAL_GRAIN_CALORIES );
                            access += (fruitVeggies - this.TOTAL_FRUITVEGGIE_CALORIES);
                            access += (protien - this.TOTAL_PROTIEN_CALORIES );
                            access += (other - this.TOTAL_OTHER_CALORIES);
                            access += (calories - this.TOTAL_NET_CALORIES);
                            this.possibleCombos.add(data);
                            this.possibleCombosAccess.add(access);
                        }
                    }
                }
            }
        }
    }

    public String[] returnOptimalHamper(){

        if(this.possibleCombosAccess.size() == 0){
            // through exception here! no hamers found !!!!!!!!!!!!
        }
        
        int minAccess = this.possibleCombosAccess.get(0);
        int index = 0;
        for(int i = 0; i < this.possibleCombosAccess.size(); i++){
            if(minAccess > this.possibleCombosAccess.get(i)){
                minAccess = this.possibleCombosAccess.get(i);
                index = i;
            }
        }

        return this.possibleCombos.get(index);
    }

}
