package hackerrank.problems;

public class SimpleArraySum implements Problem {
    public SimpleArraySum() {
        super();
    }

    public void execute() {
        final int[] AR = {1, 2, 3};
        
        System.out.println("The function is of the format: int simpleArraySum(int[] ar); ar : ");
        
        for (int i : AR) System.out.print(i + ", ");
        
        System.out.println("\nAnswer: " + this.simpleArraySum(AR));
    }
    
    public int simpleArraySum(int[] ar) {
        int sum = 0;
        for (int i : ar) {
            sum += i;
        }
        
        return sum;
    }
}
