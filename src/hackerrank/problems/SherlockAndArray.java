package hackerrank.problems;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class SherlockAndArray implements Problem {
    public SherlockAndArray() {
        super();
    }

    public void execute() {
        List<Integer> arr = new ArrayList<Integer>();
        arr.add(1); arr.add(1); arr.add(2); arr.add(2);
        
        System.out.println("The function is of the format: String balancedSums(List<Integer> arr); ar : ");
        
        for (int i : arr) System.out.print(i + ", ");
        
        System.out.println("\nAnswer: " + this.balancedSums(arr));
    }
    
    public String balancedSums(List<Integer> arr) {
        ListIterator<Integer> left = arr.listIterator(), right = arr.listIterator(arr.size());
        int left_sum = 0, right_sum = 0;
        
        // Base cases
        if (arr.size() <= 1) return "YES";
        if (arr.size() == 2 && arr.contains(0)) return "YES";
        
        while (left.nextIndex() != right.previousIndex()) {
            // 3 Cases: left is greater, right is greater, both are equal
            if (left_sum > right_sum) { // Left is larger
                right_sum += right.previous();
            }
            else if (left_sum < right_sum) { // Right is larger
                left_sum += left.next();
            }
            else { // Neither larger, determine which side grows less.
                int left_temp = left.next(), right_temp = right.previous();
                if (left_temp >= right_temp) {
                    right_sum += right_temp;
                    left.previous();
                }
                else {
                    left_sum += left_temp;
                    right.next();
                }
            }
        }
        
        return left_sum == right_sum ? "YES" : "NO";
    }
}
