package hackerrank.problems;

public class Staircase implements Problem {
    public Staircase() {
        super();
    }

    public void execute() {
        
        int n = 6;
        
        System.out.println("The function is of the format: void staircase(int n); n : 6");
        
        this.staircase(n);
    }
    
    public void staircase(int n) {
        for (int i = 1; i <= n; i++) {
            int counter = n - i;
            String line = "";
            while (counter > 0) {
                line += " ";
                counter--;
            }
            counter = i;
            while (counter > 0) {
                line += "#";
                counter--;
            }
            System.out.println(line);
        }
    }
}
