package hackerrank.problems;

import java.util.ArrayList;
import java.util.List;

public class PlusMinus implements Problem {
    public PlusMinus() {
        super();
    }

    public void execute() {
        
        int[] arr = {-1, -1, 0, 1, 1};
        
        System.out.println("The function is of the format: void plusMinus(int[] arr); arr :");
        
        for (int i : arr) {
            System.out.print(i + ", ");
        }
        System.out.print("\n");
        
        this.plusMinus(arr);
        
        System.out.print("\n");
    }
    
    public void plusMinus(int[] arr) {
        
        double pos_counter = 0, zero_counter = 0, neg_counter = 0, total_counter = 0;
        
        for (int i : arr) {
            if (i > 0) pos_counter++;
            else if (i < 0) neg_counter++;
            else zero_counter++;
            total_counter++;
        }
        
        System.out.printf("%.6f\n%.6f\n%.6f", pos_counter / total_counter, neg_counter / total_counter, zero_counter / total_counter);
    }
}