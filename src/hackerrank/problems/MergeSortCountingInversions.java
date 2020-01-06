package hackerrank.problems;

public class MergeSortCountingInversions implements Problem {
    public MergeSortCountingInversions() {
        super();
    }

    public void execute() {
        int[] arr1 = {2, 4, 1};
        int[] arr2 = {1, 1, 1, 2, 2};
        int[] arr3 = {2, 1, 3, 1, 2};
        int[] arr4 = {7, 5, 3, 1};
        
        System.out.println(countInversions(arr1) + " " + countInversions(arr2) + " " + countInversions(arr3) + " " + countInversions(arr4));
    }
    
    public static long countInversions(int[] arr) {
        long inversions = mergeSort(arr, arr.length);
        
        return inversions;
    }
    
    public static long mergeSort(int[] a, int n) {
        long inversions = 0L;
        
        if (n < 2) {
            return 0L;
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
        inversions += mergeSort(l, mid);
        inversions += mergeSort(r, n - mid);
        
        inversions += merge(a, l, r, mid, n - mid);
        
        return inversions;
    }
    
    public static long merge(
      int[] a, int[] l, int[] r, int left, int right) {
        long inversions = 0;
        int i = 0, j = 0, k = 0;
        while (i < left && j < right) {
            if (l[i] <= r[j]) {
                a[k++] = l[i++];
            }
            else {
                inversions += l.length - i;
                a[k++] = r[j++];
            }
        }
        while (i < left) {
            a[k++] = l[i++];
        }
        while (j < right) {
            a[k++] = r[j++];
        }
        return inversions;
    }
}
