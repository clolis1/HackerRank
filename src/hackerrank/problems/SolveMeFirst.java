package hackerrank.problems;

public class SolveMeFirst implements Problem {
    public SolveMeFirst() {
        super();
    }

    public void execute() {
        final int A = 2;
        final int B = 3;
        
        System.out.println("The function is of the format: int solveMeFirst(int a, int b); a : " + A + ", b: " + B);
        
        System.out.println("\nAnswer: " + this.solveMeFirst(A, B));
    }
    
    public int solveMeFirst(int a, int b) {
        return a + b;
    }
}
