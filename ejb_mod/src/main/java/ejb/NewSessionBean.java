package ejb;

import java.util.Random;
import javax.ejb.Stateful;

/**
 *
 * @author eyvind
 */
@Stateful
public class NewSessionBean implements NewSessionBeanLocal {

    Random rand;
    int rightNumber;
    int numberOfTries;
    boolean first=true;


    // typisk "business"-metod, eftersom den innehåller logiken och algoritmen för det hela.
    //ska genom högerklicka -- insert code -- add business method
    @Override
    public String determineResult(int guess) {
        if(first)
        {
            rand = new Random();
            rightNumber = rand.nextInt(1000);
            numberOfTries = 0;
            first=false;
        }
        numberOfTries++;
        String message = "";
        if (guess == rightNumber) {
            message="You win! The number was "+rightNumber+". It took you "+numberOfTries+ " times.";
            first=true;
        } else if (guess < rightNumber) {
            message="Your number is too low. You have now tried "+numberOfTries+ " times.";
        } else if (guess > rightNumber) {
            message="Your number is too high.You have now tried "+numberOfTries+ " times.";
        }

        return message;
    }

}