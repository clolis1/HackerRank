package hackerrank.problems;

import java.util.Arrays;
import java.util.Hashtable;
import java.util.concurrent.atomic.AtomicInteger;

public class SherlockAndAnagrams implements Problem {
    public SherlockAndAnagrams() {
        super();
    }

    public void execute() {
        
        String s1 = "abba", s2 = "abcd", s3 = "ifailukqq", s4 = "kkkk", s5 = "cdcd";
        
        System.out.print("The function is of the format: int sherlockAndAnagrams(String s);\n");
        
        System.out.println(this.sherlockAndAnagrams(s1) + " " + this.sherlockAndAnagrams(s2) + " " +
                           this.sherlockAndAnagrams(s3) + " " + this.sherlockAndAnagrams(s4) + " " +
                           this.sherlockAndAnagrams(s5));
    }
    
    public int sherlockAndAnagrams(String s) {
        Hashtable<String, Integer> substrings = new Hashtable<String, Integer>();
        
        for (int i = 1; i < s.length(); i++) {
            for (int j = 0; j <= s.length() - i; j++) {
                char[] temp = s.substring(j, j + i).toLowerCase().toCharArray();
                Arrays.sort(temp);
                String temp_s = new String(temp);
                if (substrings.containsKey(temp_s)) substrings.put(temp_s, substrings.get(temp_s) + 1);
                else substrings.put(temp_s, new Integer(1));
            }
        }
        
        AtomicInteger anagrams = new AtomicInteger(0);
        
        substrings.forEach((key, val) -> {
            int temp = val.intValue(), anagram_counter = 1;
            System.out.println("key is " + key + ", val is " + val);
            while (temp > 1) {
                anagrams.addAndGet(anagram_counter);
                anagram_counter++;
                temp--;
            }
        });
        
        return anagrams.get();
    }
}
