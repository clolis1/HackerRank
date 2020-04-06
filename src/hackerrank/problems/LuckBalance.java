package hackerrank.problems;

import hackerrank.util.Machine;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LuckBalance implements Problem {
    public LuckBalance() {
        super();
    }

    public void execute() {
        int k1 = 2, k2 = 3;
        
        int[][] contests1 = { {5, 1}, {4, 1}, {1, 0} },
            contests2 = { {5, 1}, {2, 1}, {1, 1}, {8, 1}, {10, 0}, {5, 0} };
        
        System.out.println(luckBalance(k1, contests1) + " " + luckBalance(k2, contests2));
    }
    
    public static int luckBalance(int k, int[][] contests) {
        int luck = 0, counter = 0;
        for (int[] arr : contests) {
            if (arr[1] == 0) luck += arr[0];
            else counter++;
        }
        int[] important_contests = new int[counter];
        counter = 0;
        for (int[] arr : contests) {
            if (arr[1] == 1) {
                important_contests[counter] = arr[0];
                counter++;
            }
        }
        int length = important_contests.length;
        Arrays.sort(important_contests);
        for (int i = 0; i < length; i++) luck += i < length - k ? 0 - important_contests[i] : important_contests[i];
        return luck;
    }
}
