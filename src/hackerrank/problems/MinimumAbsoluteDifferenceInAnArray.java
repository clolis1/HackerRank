package hackerrank.problems;

import java.util.HashSet;

public class MinimumAbsoluteDifferenceInAnArray implements Problem {
    public MinimumAbsoluteDifferenceInAnArray() {
        super();
    }

    public void execute() {
        int[] arr1 = {3, -7, 0},
              arr2 = {-59, -36, -13, 1, -53, -92, -2, -96, -54, 75},
              arr3 = {1, -3, 71, 68, 17};
        
        System.out.println(minimumAbsoluteDifference(arr1) + " " + minimumAbsoluteDifference(arr2) + " " + 
                           minimumAbsoluteDifference(arr3));
    }
    
    public static int minimumAbsoluteDifference(int[] arr) {
        mergeSort(arr, arr.length);
        int min_dif = Math.abs(arr[0] - arr[1]);
        for (Integer i = 0; i < arr.length - 1; i++) min_dif = Math.min(Math.abs(arr[i] - arr[i + 1]), min_dif);
        return min_dif;
    }
    
    public static void mergeSort(int[] a, int n) {
        if (n < 2) {
            return;
        }
        int mid = n / 2;
        int[] l = new int[mid];
        int[] r = new int[n - mid];
     
        for (int i = 0; i < mid; i++) {
            l[i] = a[i];
        }
        for (int i = mid; i < n; i++) {
            r[i - mid] = a[i];
        }
        mergeSort(l, mid);
        mergeSort(r, n - mid);
     
        merge(a, l, r, mid, n - mid);
    }
    
    public static void merge(
      int[] a, int[] l, int[] r, int left, int right) {
      
        int i = 0, j = 0, k = 0;
        while (i < left && j < right) {
            if (l[i] <= r[j]) {
                a[k++] = l[i++];
            }
            else {
                a[k++] = r[j++];
            }
        }
        while (i < left) {
            a[k++] = l[i++];
        }
        while (j < right) {
            a[k++] = r[j++];
        }
    }
}
