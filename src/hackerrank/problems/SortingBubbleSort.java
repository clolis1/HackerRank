package hackerrank.problems;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

public class SortingBubbleSort implements Problem {
    public SortingBubbleSort() {
        super();
    }

    public void execute() {
        int[] a1 = {1, 2, 3};
        int[] a2 = {3, 2, 1};
        
        this.countSwaps(a1);
        this.countSwaps(a2);
    }
    
    public void countSwaps(int[] a) {
        int n = a.length;
        int numSwaps = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - 1; j++) {
                if (a[j] > a[j + 1]) {
                    int temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                    numSwaps++;
                }
            }
        }
        System.out.println("Array is sorted in " + numSwaps + " swaps.");
        System.out.println("First Element: " + a[0]);
        System.out.println("Last Element: " + a[n - 1]);
    }
}
