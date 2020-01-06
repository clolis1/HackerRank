package hackerrank.problems;

public class MiniMaxSum implements Problem {
    public MiniMaxSum() {
        super();
    }

    public void execute() {
        final int[] arr = {1, 2, 3, 4, 5};
        
        System.out.println("The function is of the format: void miniMaxSum(int[] arr); arr : ");
        
        for (int i : arr) System.out.print(i + ", ");
        System.out.print("\n");
        this.miniMaxSum(arr);
    }
    
    public void miniMaxSum(int[] arr) {
        long sum = 0;
        int least = arr[0], greatest = arr[0];
        for (int i : arr) {
            sum += i;
            if (i < least) least = i;
            if (i > greatest) greatest = i;
        }
        
        System.out.println((sum - greatest) + " " + (sum - least));
    }
}