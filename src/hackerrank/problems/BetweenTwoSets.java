package hackerrank.problems;

import hackerrank.util.ComplexMath;

import java.util.ArrayList;
import java.util.List;

public class BetweenTwoSets implements Problem {
    public BetweenTwoSets() {
        super();
    }

    public void execute() {
        
        List<Integer> a = new ArrayList<Integer>(), b = new ArrayList<Integer>();
        a.add(2); a.add(6); b.add(24); b.add(36);
        
        System.out.println("The function is of the format: int getTotalX(List<Integer> a, List<Integer> b); a: [");
        for (int i : a) System.out.print(i + ", ");
        System.out.print("], b : [");
        for (int i : b) System.out.print(i + ", ");

        System.out.println("]\nAnswer: " + this.getTotalX(a, b));
    }
    
    public int getTotalX(List<Integer> a, List<Integer> b) {
        int lcm = ComplexMath.findLCM(a), counter = 0, largest_b = 0;
        
        for (int i : b) if (i > largest_b) largest_b = i;
        
        for (int i = 1; i * lcm <= largest_b; i++) {
            boolean divisible = true;
            for (int j : b) if (j % (i * lcm) != 0) divisible = false;
            if (divisible) counter++;
        }
        
        return counter;
    }
}
