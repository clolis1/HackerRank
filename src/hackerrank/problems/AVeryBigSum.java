package hackerrank.problems;

public class AVeryBigSum implements Problem {
    public AVeryBigSum() {
        super();
    }

    public void execute() {
        
        long[] ar = {1000000001, 1000000002, 1000000003, 1000000004, 1000000005};
        
        System.out.println("The function is of the format: long aVeryBigSum(long[] ar); ar : ");
        
        for (long i : ar) System.out.print(i + ", ");
        
        System.out.println("\nAnswer: " + this.aVeryBigSum(ar));
    }
    
    public long aVeryBigSum(long[] ar) {
        long sum = 0;
        for (long i : ar) sum += i;
        
        return sum;
    }
}