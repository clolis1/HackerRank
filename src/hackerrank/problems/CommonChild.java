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
        return 0;
    }
}
