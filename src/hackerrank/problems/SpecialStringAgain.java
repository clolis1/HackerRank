package hackerrank.problems;

public class SpecialStringAgain implements Problem {
    public SpecialStringAgain() {
        super();
    }

    public void execute() {
        String s1 = "mnonopoo", s2 = "asasd", s3 = "abcbaba", s4 = "aaaa", s5= "ccbc";
        
        System.out.println(substrCount(s1.length(), s1) + " " + substrCount(s2.length(), s2) + " " +
                           substrCount(s3.length(), s3) + " " + substrCount(s4.length(), s4) + " " +
                           substrCount(s5.length(), s5));
    }
    
    public static long substrCount(int n, String s) {
        long counter = 0;
        for (int i = 0; i < n; i++) {
            counter++;
            char letter = s.charAt(i);
            int substr_length = 1;
            for (int j = 1; i + j < n; j++) {
                if (s.charAt(i + j) == letter) {
                    counter++;
                    substr_length++;
                }
                else if (i + j + substr_length < n){
                    boolean palindrome = true;
                    for (int k = 1; k <= substr_length; k++) {
                        if (s.charAt(i + j + k) != letter) {
                            palindrome = false;
                            break;
                        }
                    }
                    if (palindrome) counter++;
                    break;
                }
                else break;
            }
        }
        return counter;
    }
}
