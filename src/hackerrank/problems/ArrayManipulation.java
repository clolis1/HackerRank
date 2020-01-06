package hackerrank.problems;

public class ArrayManipulation implements Problem{
    public ArrayManipulation() {
        super();
    }
    
    public void execute() {
        
        int n1 = 10, n2 = 5, n3 = 10;
        
        int[][] arr1 = { {1, 5, 3},
                         {4, 8, 7},
                         {6, 9, 1} };
        
        int[][] arr2 = { {1, 2, 100},
                         {2, 5, 100},
                         {3, 4, 100} };
        
        int[][] arr3 = { {2, 6, 8},
                         {3, 5, 7},
                         {1, 8, 1},
                         {5, 9, 15} };
        
        System.out.print("The function is of the format: int arrayManipulation(int n, int[][] queries); ");
        
        System.out.println("Answer: " + this.arrayManipulation(n1, arr1) + ", " + this.arrayManipulation(n2, arr2) + ", " + this.arrayManipulation(n3, arr3));
    }
    
    public long arrayManipulation(int n, int[][] queries) {
        long[] array = new long[n + 1];
        
        for (int[] arr : queries) {
            array[arr[0] - 1] += arr[2];
            array[arr[1]] -= arr[2];
        }
        
        long max = 0, temp = 0;
        for (int i = 0; i < array.length; i++) {
            temp += array[i];
            if (temp > max) max = temp;
        }
/**        
        System.out.println();
        for (long i : array) {
            System.out.print(i + " ");
        }
        System.out.println();
*/        
        return max;
    }
}
