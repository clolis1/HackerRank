package hackerrank.problems;

public class MinimumSwaps2 implements Problem {
    public MinimumSwaps2() {
        super();
    }

    public void execute() {
        
        int[] arr1 = {4, 3, 1, 2};
        int[] arr2 = {2, 3, 4, 1, 5};
        int[] arr3 = {1, 3, 5, 2, 4, 6, 7};
        
        System.out.print("The function is of the format: int hourglassSum(int[] arr); arr1: [");
        
        for (int i : arr1) System.out.print(i + ", ");
        System.out.print("]; arr2 : [");
        for (int i : arr2) System.out.print(i + ", ");
        System.out.print("]; arr3 : [");
        for (int i : arr3) System.out.print(i + ", ");
        System.out.print("]\n");
        
        System.out.println("Answer: " + this.minimumSwaps2(arr1) + ", " + this.minimumSwaps2(arr2) + ", " + this.minimumSwaps2(arr3));
    }
    
    public int minimumSwaps2(int[] arr) {
        int swap_count = 0;
        for (int i = 0; i < arr.length; i++) {
            while (i + 1 < arr.length && arr[i] - 1 == i) i++;
            int j = arr[i];
            while (j != i + 1) {
                int temp = arr[j - 1];
                arr[j - 1] = j;
                j = temp;
                swap_count++;
            }
        }
        return swap_count;
    }
}
