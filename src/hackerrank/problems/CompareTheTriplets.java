package hackerrank.problems;

import java.util.LinkedList;
import java.util.List;

public class CompareTheTriplets implements Problem {
    public CompareTheTriplets() {
        super();
    }

    public void execute() {
        
        final LinkedList<Integer> A = new LinkedList<Integer>();
        A.add(0, 1);
        A.add(1, 2);
        A.add(2, 3);
        final LinkedList<Integer> B = new LinkedList<Integer>();
        B.add(0, 3);
        B.add(1, 2);
        B.add(2, 1);
        
        System.out.println("The function is of the format:  List<Integer> compareTriplets(List<Integer> a, List<Integer> b); a : ");
        
        for (int i : A) System.out.print(i + ", ");
        System.out.print(" b : ");
        for (int i : B) System.out.print(i + ", ");
        
        System.out.println("\nAnswer: " + this.compareTriplets(A, B));
    }
    
    public List<Integer> compareTriplets(List<Integer> a, List<Integer> b) {
        List<Integer> list = new LinkedList<Integer>();
        
        int a_points = 0;
        int b_points = 0;
        
        for (int i = 0; i < 3; i++) {
            if (a.get(i) >  b.get(i)) a_points++;
            else if (a.get(i) < b.get(i)) b_points++;
        }
        
        list.add(0, a_points);
        list.add(1, b_points);
        
        return list;
    }
}