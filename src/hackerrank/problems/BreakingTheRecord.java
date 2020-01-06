package hackerrank.problems;

public class BreakingTheRecord implements Problem {
    public BreakingTheRecord() {
        super();
    }

    public void execute() {
        
        int[] scores = {12, 24, 20, 24};
        
        System.out.println("The function is of the format: int getTotalX(List<Integer> a, List<Integer> b); scores: [");
        for (int i : scores) System.out.print(i + ", ");
        System.out.print("]");

        System.out.println("]\nAnswer: " + this.breakingRecords(scores)[0] + " " + this.breakingRecords(scores)[1]);
    }
    
    public int[] breakingRecords(int[] scores) {
        int[] base_case = {0,0};
        if (scores.length == 0 || scores.length == 1) return base_case;
        int min = scores[0], max = scores[0], min_counter = 0, max_counter = 0;
        
        for (int i : scores) {
            if (i < min) {
                min = i;
                min_counter++;
            }
            else if (i > max) {
                max = i;
                max_counter++;
            }
        }
        
        int[] breaks = {max_counter, min_counter};
        
        return breaks;
    }
}
