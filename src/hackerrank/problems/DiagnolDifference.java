package hackerrank.problems;

import java.util.ArrayList;
import java.util.List;

public class DiagnolDifference implements Problem {
    public DiagnolDifference() {
        super();
    }

    public void execute() {
        
        List<List<Integer>> matrix = new ArrayList<List<Integer>>();
        matrix.add(new ArrayList<Integer>());
        matrix.add(new ArrayList<Integer>());
        matrix.add(new ArrayList<Integer>());
        
        matrix.get(0).add(1); matrix.get(0).add(2); matrix.get(0).add(3);
        matrix.get(1).add(4); matrix.get(1).add(5); matrix.get(1).add(6);
        matrix.get(2).add(7); matrix.get(2).add(8); matrix.get(2).add(9);
        
        System.out.println("The function is of the format: int diagnolDifference(List<List<Integer>> arr); arr : /n");
        
        for (List<Integer> list : matrix) {
            for (int i : list) System.out.print(i + ", ");
            System.out.print("\n");
        }
        
        System.out.println("\nAnswer: " + this.diagnolDifference(matrix));
    }
    
    public int diagnolDifference(List<List<Integer>> arr) {
        int diagnol_one = 0;
        int diagnol_two = 0;
        
        for (int i = 0; i < arr.size(); i++) {
            diagnol_one += arr.get(i).get(i);
        }
        
        for (int i = 0; i < arr.size(); i++) {
            diagnol_two += arr.get(i).get(arr.size() - 1 - i);
        }
        
        return Math.abs(diagnol_one - diagnol_two);
    }
}