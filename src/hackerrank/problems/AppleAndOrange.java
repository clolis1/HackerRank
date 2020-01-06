package hackerrank.problems;

public class AppleAndOrange implements Problem {
    public AppleAndOrange() {
        super();
    }

    public void execute() {
        
        int s = 7, t = 10, a = 4, b = 12;
        int[] apples = {2, 3, -4}, oranges = {3, -2, -4};
        
        System.out.println("The function is of the format: void countApplesAndOranges(int s, int t, int a, int b, int[] apples, int[] oranges);");
        System.out.print("s : " + s + ", t: " + t + ", a: " + a + ", b: " + b + ", apples: [");
        
        for (int i : apples) System.out.print(i + ", ");
        System.out.print("], oranges: [");
        
        for (int i : oranges) System.out.print(i + ", ");
        
        System.out.print("]\n");
        this.countApplesAndOranges(s, t, a, b, apples, oranges);
    }
    
    public void countApplesAndOranges(int s, int t, int a, int b, int[] apples, int[] oranges) {
        int[] apples_location = new int[apples.length], oranges_location = new int[oranges.length];
        for (int i = 0; i < apples.length; i++) {
            apples_location[i] = a + apples[i];
        }
        for (int i = 0; i < oranges.length; i++) {
            oranges_location[i] = b + oranges[i];
        }
        
        int apple_counter = 0, orange_counter = 0;
        
        for (int i : apples_location) if (i >= s && i <= t) apple_counter++;
        for (int i : oranges_location) if (i >= s && i <= t) orange_counter++;
        
        System.out.println(apple_counter + "\n" + orange_counter);
    }
}
