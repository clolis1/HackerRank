package hackerrank.problems;

public class AlternatingCharacters implements Problem {
    public AlternatingCharacters() {
        super();
    }

    public void execute() {
        String s1 = "AAAA", s2 = "BBBBB", s3 = "ABABABAB", s4 = "BABABA", s5 = "AAABBB";
        
        System.out.println(alternatingCharacters(s1) + " " + alternatingCharacters(s2) + " " + 
                           alternatingCharacters(s3) + " " + alternatingCharacters(s4) + " " + 
                           alternatingCharacters(s5));
    }
    
    public static int alternatingCharacters(String s) {
        if (s.length() == 0 || s.length() == 1) return 0;
        char previous = s.charAt(0);
        int counter = 0;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == previous) counter++;
            previous = s.charAt(i);
        }
        return counter;
    }
}
