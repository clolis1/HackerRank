package hackerrank.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Hashtable;
import java.util.List;

public class FrequencyQueries implements Problem {
    public FrequencyQueries() {
        super();
    }

    public void execute() {
        int[][] queries1 = {{1, 1}, {2, 2}, {3, 2}, {1, 1}, {1, 1}, {2, 1}, {3, 2}};
        
        int[][] queries2 = {{1, 5}, {1, 6}, {3, 2}, {1, 10}, {1, 10}, {1, 6}, {2, 5}, {3, 2}};
        
        int[][] queries3 = {{3, 4}, {2, 1003}, {1, 16}, {3, 1}};
        
        int[][] queries4 = {{1, 3}, {2, 3}, {3, 2}, {1, 4}, {1, 5}, {1, 5}, {1, 4}, {3, 2}, {2, 4}, {3, 2}};
        
        System.out.print("The function is of the format: List<Integer> freqQuery(int[][] queries);\n");
        
        System.out.println(this.freqQuery(queries1) + " " + this.freqQuery(queries2) + " " + this.freqQuery(queries3) + " " + this.freqQuery(queries4));
    }
    
    public List<Integer> freqQuery(int[][] queries) {
        Hashtable<Integer, Integer> values = new Hashtable<Integer, Integer>();
        Hashtable<Integer, Integer> frequencies = new Hashtable<Integer, Integer>();
        ArrayList<Integer> results = new ArrayList<Integer>();
        
        for (int i = 0; i < queries.length; i++) {
            int temp = queries[i][1];
            Integer count = values.getOrDefault(temp, 0);
            Integer freq = frequencies.getOrDefault(count, 0);
            if (queries[i][0] == 1) {
                values.put(temp, count + 1);
                
                frequencies.put(count, freq > 0 ? freq - 1 : 0);
                frequencies.put(count + 1, frequencies.getOrDefault(count + 1, 0) + 1);
            }
            else if (count > 0 && queries[i][0] == 2) {
                values.put(temp, count - 1);
                
                frequencies.put(count, freq > 0 ? freq - 1 : 0);
                frequencies.put(count - 1, frequencies.getOrDefault(count - 1, 0) + 1);
            }
            else if (queries[i][0] == 3){
                results.add(frequencies.getOrDefault(temp, 0) > 0 ? 1 : 0);
            }
        }
        
        return results;
    }
}
