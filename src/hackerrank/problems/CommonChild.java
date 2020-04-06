package hackerrank.problems;

public class CommonChild implements Problem {
    
    public CommonChild() {
        super();
    }

    public void execute() {
        String s1 = "ABCD", s2 = "ABDC", s3 = "HARRY", s4 = "SALLY", s5= "SHINCHAN", s6 = "NOHARAAA", s7 = "ABCDEF", s8 = "FBDAMN";
        
        System.out.println(commonChild(s1, s2) + " " + commonChild(s3, s4) + " " +
                           commonChild(s5, s6) + " " + commonChild(s7, s8));
    }
    
    public static int commonChild(String s1, String s2) {
        int[][] LCS = new int[s1.length() + 1][s2.length() + 1];
        
        for (int i = 0; i < s1.length(); i++) {
            for (int j = 0; j < s2.length(); j++) {
                if (s1.charAt(i) == s2.charAt(j)) LCS[i + 1][j + 1] = LCS[i][j] + 1;
                else LCS[i + 1][j + 1] = Math.max(LCS[i + 1][j], LCS[i][j + 1]);
            }
        }
        
        return LCS[s1.length()][s2.length()];
    }
}
