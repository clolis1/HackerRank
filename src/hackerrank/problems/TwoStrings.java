package hackerrank.problems;

import java.util.ArrayList;

public class TwoStrings implements Problem {
    public TwoStrings() {
        super();
    }

    public void execute() {
        
        String s1 = "hello", s2 = "world", s3 = "hi";
        
        System.out.print("The function is of the format: String twoStrings(String s1, String s2);\n");
        
        System.out.println(this.twoStrings(s1, s2) + " " + this.twoStrings(s3, s2));
    }
    
    public String twoStrings(String s1, String s2) {
        ArrayList<Character> alphabet = new ArrayList<Character>();
        
        String temp1 = s1, temp2 = s2;
        if (s1.length() > s2.length()) {
            temp1 = s2;
            temp2 = s1;
        }
        
        for (int i = 0; i < temp1.length(); i++) {
            Character c = new Character(temp1.charAt(i));
            if (!alphabet.contains(c)) alphabet.add(c);
        }
        
        for (int i = 0; i < temp2.length(); i++) {
            Character c = new Character(temp2.charAt(i));
            if (alphabet.contains(c)) return "YES";
        }
        
        return "NO";
    }
}
