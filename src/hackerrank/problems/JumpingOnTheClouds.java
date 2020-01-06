package hackerrank.problems;

public class JumpingOnTheClouds implements Problem {
    public JumpingOnTheClouds() {
        super();
    }

    public void execute() {
        
        int[] clouds = {0,0,1,0,0,1,0};
        
        System.out.println("The function is of the format: int jumpingOnClouds(int[] c); c: [");
        for (int i : clouds) System.out.print(i + ", ");
        System.out.print("]");

        System.out.println("\nAnswer: " + this.jumpingOnClouds(clouds));
    }
    
    public int jumpingOnClouds(int[] c) {
        int jump_counter = 0, i = 0;
        while (i < c.length - 2) {
            i += c[i+2] == 1 ? 1 : 2;
            jump_counter++;
        }
        if (i != c.length - 1) jump_counter++;
        return jump_counter;
    }
}
