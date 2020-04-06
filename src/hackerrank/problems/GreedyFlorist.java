package hackerrank.problems;

import java.util.Arrays;

public class GreedyFlorist implements Problem {
    public GreedyFlorist() {
        super();
    }

    public void execute() {
        int k1 = 3, k2 = 3, k3 = 2, k4 = 3;
        
        int[] c1 = {1, 2, 3, 4}, c2 = {2, 5, 6}, c3 = {2, 5, 6}, c4 = {1, 3, 5, 7, 9};
        
        System.out.println(getMinimumCost(k1, c1) + " " + getMinimumCost(k2, c2) + " " + 
                           getMinimumCost(k3, c3) + " " + getMinimumCost(k4, c4));
    }
    
    public static int getMinimumCost(int k, int[] c) {
        Arrays.sort(c);
        int total = 0;
        int k_counter = 1;
        int multiplier = 1;
        
        for (int i = c.length - 1; i >= 0; i--) {
            total += c[i] * multiplier;
            if (k_counter == k) {
                k_counter = 1;
                multiplier++;
            }
            else k_counter++;
        }
        
        return total;
    }
}
