package hackerrank.problems;

import java.util.Arrays;

public class MaxMin implements Problem {
    public MaxMin() {
        super();
    }

    public void execute() {
        int k1 = 3, k2 = 4, k3 = 2;
        int[] arr1 = {10, 100, 300, 200, 1000, 20, 30}, arr2 = {1, 2, 3, 4, 10, 20, 30, 40, 100, 200},
            arr3 = {1, 2, 1, 2, 1};
        
        System.out.println(maxMin(k1, arr1) + " " + maxMin(k2, arr2) + " " + maxMin(k3, arr3));
    }
    
    public static int maxMin(int k, int[] arr) {
        Arrays.sort(arr);
        int minDif = arr[k - 1] - arr[0];
        for (int i = 0; i + k - 1 < arr.length; i++) {
            minDif = arr[i + k - 1] - arr[i] < minDif ? arr[i + k - 1] - arr[i] : minDif;
        }
        
        return minDif;
    }
}
