package hackerrank.problems;

public class Kangaroo implements Problem {
    public Kangaroo() {
        super();
    }

    public void execute() {
        
        int x1 = 1, v1 = 2, x2 = 2, v2 = 1;
        
        System.out.println("The function is of the format: String kangaroo(int x1, int v1, int x2, int v2); x1: " + x1 + ", v1: " + v1 + ", x2: " + x2 + ", v2: " + v2);

        System.out.println("\nAnswer: " + this.kangaroo(x1, v1, x2, v2));
    }
    
    public String kangaroo(int x1, int v1, int x2, int v2) {
        if (x1 == x2) return "YES";
        
        if (v2 > v1) {
            while (x1 > x2) {
                x1 += v1;
                x2 += v2;
                if (x1 == x2) return "YES";
                else if (x2 > x1) return "NO";
            }
        }
        else if (v1 > v2) {
            while (x2 > x1) {
                x1 += v1;
                x2 += v2;
                if (x1 == x2) return "YES";
                else if (x1 > x2) return "NO";
            }
        }
        else {
            return "NO";
        }
        return "NO";
    }
}
