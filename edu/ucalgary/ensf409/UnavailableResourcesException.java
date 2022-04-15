

/**
@author Kolby Lalonde James Platt Carlos Morrea Jacob Adeyemo
@version 1.1 April, 11, 2022
@since 1.0 April, 11, 2022
**/

package edu.ucalgary.ensf409;
import java.lang.Exception;

// javac edu/ucalgary/ensf409/UnavailableResourcesException.java

public class UnavailableResourcesException extends Exception {
    
    public UnavailableResourcesException(String[] shortageReport){
        super("Unavailable Resources To Fulfill Order");

        if(shortageReport[1] != null){
            System.out.println("Shortage of " + shortageReport[1] + " grain calories!");
        }
        if(shortageReport[2] != null){
            System.out.println("Shortage of " + shortageReport[2] + " fruit/veggies calories!");
        }
        if(shortageReport[3] != null){
            System.out.println("Shortage of " + shortageReport[3] + " Protein calories!");
        }
        if(shortageReport[4] != null){
            System.out.println("Shortage of " + shortageReport[4] + " other calories!");
        }
        if(shortageReport[5] != null){
            System.out.println("Shortage of " + shortageReport[5] + " calories total!");
        }
    }
}
