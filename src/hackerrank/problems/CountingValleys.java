package hackerrank.problems;

import java.util.Hashtable;
import java.util.concurrent.atomic.AtomicInteger;

public class CountingValleys implements Problem {
    public CountingValleys() {
        super();
    }

    public void execute() {
        
        int num_steps = 8;
        String steps = "UDDDUDUU";
        
        System.out.println("The function is of the format: int countingValleys(int n, String s); n: " + num_steps + ", s: " + steps);

        System.out.println("\nAnswer: " + this.countingValleys(num_steps, steps));
    }
    
    public int countingValleys(int n, String s) {
        int altitude = 0, valley_counter = 0;
        for (int i = 0; i < n; i++) {
            if (altitude == -1 && s.charAt(i) == 'U') {valley_counter++; altitude++;}
            else if (s.charAt(i) == 'U') altitude++;
            else altitude--;
        }
        return valley_counter;
    }
}
