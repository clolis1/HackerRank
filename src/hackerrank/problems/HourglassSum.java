package hackerrank.problems;

public class HourglassSum implements Problem {
    public HourglassSum() {
        super();
    }

    public void execute() {
        
        int[][] arr = { {-9, -9, -9,  1,  1,  1},
                        { 0, -9,  0,  4,  3,  2},
                        {-9, -9, -9,  1,  2,  3},
                        { 0,  0,  8,  6,  6,  0},
                        { 0,  0,  0, -2,  0,  0},
                        { 0,  0,  1,  2,  4,  0}  };
        
        System.out.println("The function is of the format: int hourglassSum(int[][] arr); arr: \n");
        
        for (int[] e : arr) {
            for (int i : e) System.out.print(i + " ");
            System.out.print('\n');
        }
        
        System.out.println("\nAnswer: " + this.hourglassSum(arr));
    }
    
    public int hourglassSum(int[][] arr) {
        int greatest_sum = -63; // smallest possible value
        
        for (int i = 1; i < arr.length - 1; i++) {
            for (int j = 1; j < arr[i].length - 1; j++) {
                int sum = arr[i-1][j-1] + arr[i-1][j] + arr[i-1][j+1] + arr[i][j] + arr[i+1][j-1] + arr[i+1][j] + arr[i+1][j+1];
                if (sum > greatest_sum) greatest_sum = sum;
            }
        }
        
        return greatest_sum;
    }
}
