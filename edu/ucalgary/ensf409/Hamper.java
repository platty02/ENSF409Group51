
/**
@author Kolby Lalonde 
UCID: 30115568
Tutorial Section: T06
@version 1.0 March, 25, 2022
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
    private AvailableFood availableFood;        // Why?
    private Iteam[] iteams;                     // Why?

    public void Hamper(int AdultMales, int AdultFemales, int ChildO8, int ChildU8, ){

        // creating variables to hold the intermediate values for each category as each client type is called
        int net = 0;
        int grain = 0;
        int fruitVeggie = 0;
        int protien = 0;
        int other = 0;

        // Calling each client to get the total net calories across all clients
        net += AdultMale.getCalories() * AdultMales;
        net += AdultFemale.getCalories() * AdultFemales;
        net += ChildOver8.getCalories() * ChildO8;
        net += ChildUnder8.getCalories() * ChildU8;

        // Setting the total net calories for the hamper
        this.TOTAL_NET_CALORIES = net;

        // Calling each client to get the total grain calories across all clients
        grain += AdultMale.getCalories() * (AdultMale.getWholeGrains() / 100) * AdultMales;
        grain += AdultFemale.getCalories() * (AdultFemale.getWholeGrains() / 100) * AdultFemales;
        grain += ChildOver8.getCalories() * (ChildOver8.getWholeGrains() / 100) * ChildO8;
        grain += ChildUnder8.getCalories() * (ChildUnder8.getWholeGrains() / 100) * ChildU8;

        // Setting the total grain calories for the hamper
        this.TOTAL_GRAIN_CALORIES = grain;

        // Calling each client to get the total fruit veggie calories across all clients
        fruitVeggie += AdultMale.getCalories() * (AdultMale.getFruitsVeggies() / 100) * AdultMales;
        fruitVeggie += AdultFemale.getCalories() * (AdultFemale.getFruitsVeggies() / 100) * AdultFemales;
        fruitVeggie += ChildOver8.getCalories() * (ChildOver8.getFruitsVeggies() / 100) * ChildO8;
        fruitVeggie += ChildUnder8.getCalories() * (ChildUnder8.getFruitsVeggies() / 100) * ChildU8;

        // Setting the total fruit veggie calories for the hamper
        this.TOTAL_FRUITVEGGIE_CALORIES = fruitVeggie;

        // Calling each client to get the total protein calories across all clients
        protein += AdultMale.getCalories() * (AdultMale.getProtein() / 100) * AdultMales;
        protein += AdultFemale.getCalories() * (AdultFemale.getProtein() / 100) * AdultFemales;
        protein += (ChildOver8.getProtein() / 100) * ChildO8;
        protein += (ChildUnder8.getProtein() / 100) * ChildU8;

        // Setting the total protein calories for the hamper
        this.TOTAL_PROTIEN_CALORIES = protein;

        // Calling each client to get the total other calories across all clients
        other += AdultMale.getCalories() * (AdultMale.getOther() / 100) * AdultMales;
        other += AdultFemale.getCalories() * (AdultFemale.getOther() / 100) * AdultFemales;
        other += ChildOver8.getCalories() * (ChildOver8.getOther() / 100) * ChildO8;
        other += ChildUnder8.getCalories() * (ChildUnder8.getOther() / 100) * ChildU8;

        // Setting the total other calories for the hamper
        this.TOTAL_OTHER_CALORIES = other;
    }

    public Iteam[] calculateOptimalHamper(AvailableFood availableFood){

        // Work to be done here... :(

    }

    // Do we even need a million getters and setters???

}